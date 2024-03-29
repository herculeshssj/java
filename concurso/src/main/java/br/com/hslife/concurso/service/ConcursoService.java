package br.com.hslife.concurso.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hslife.concurso.entity.Concurso;
import br.com.hslife.concurso.repository.ConcursoRepository;

@Service
public class ConcursoService {
    
    @Autowired
    ConcursoRepository concursoRepository;

    /*
     * Busca os concursos registrados no link passado
     */
    public void buscarConcursos(String link) {
        try {

            Document doc = Jsoup.connect(link).get();

            Elements contents = doc.select(".ca");        

            for (Iterator<Element> i = contents.iterator(); i.hasNext(); ) {
                Element content = i.next();

                Concurso concurso = Concurso.builder()
                    .titulo(content.select("a").first().text())
                    .link(content.select("a").first().attr("href"))
                    .uf(content.select(".cc").text())
                    .descricao(content.select("a").first().attr("title"))
                    .vagasCargosSalarios(content.select(".cd").text())
                    .periodoInscricao(content.select(".ce").text())
                    .arquivado(false)
                    .dataCadastro(LocalDateTime.now())
                    .build();

                // Trata os campos nulos
                concurso.setDescricao(concurso.getDescricao() == null || concurso.getDescricao().isEmpty() ? "-" : concurso.getDescricao());
                concurso.setUf(concurso.getUf() == null || concurso.getUf().isEmpty() ? "BR" : concurso.getUf());

                // Gera o hash a partir das informações inseridas
                concurso.setHash(this.SHA256(concurso.toString()));

                // Verifica se já existe um concurso com o hash informado
                if (concursoRepository.buscarPorHash(concurso.getHash()) == null) {
                    concursoRepository.save(concurso);
                }
                

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        Arquiva os concursos antigos que foram cadastrados a mais de 30 dias.
    */
    public void arquivarAntigos() {
        LocalDateTime hoje = LocalDateTime.now();
        
        List<Concurso> listaConcursos = concursoRepository.buscarNaoArquivadosPorData(hoje.minusDays(30));

        listaConcursos.forEach(concurso -> {
            concurso.setArquivado(true);
            concursoRepository.save(concurso);
        });
    }

    /*
     * Retorna o texto criptografado em SHA-256
     */
    private String SHA256(String texto) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
            BigInteger hash = new BigInteger(1, md.digest(texto.getBytes()));
            sen = hash.toString(16);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return sen;
    }
}
