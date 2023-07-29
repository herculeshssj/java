package br.com.hslife.concurso.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.hslife.concurso.service.ConcursoService;

@Component
public class BuscarConcursosTask {

    @Autowired
    ConcursoService concursoService;

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    @Scheduled(fixedDelay = 100000, initialDelay = 100000)
    public void buscarOportunidades() {
        System.out.println("Iniciando a busca pelas oportunidades... :: Hora local - " + dateTimeFormatter.format(LocalDateTime.now()));

        // Atualiza o cadastro de concursos
        List<String> linkConcursos = new ArrayList<>();
        linkConcursos.add("https://www.pciconcursos.com.br/concursos/");
        linkConcursos.add("https://www.pciconcursos.com.br/concursos/nacional/");
        linkConcursos.add("https://www.pciconcursos.com.br/concursos/sudeste/");
        linkConcursos.add("https://www.pciconcursos.com.br/concursos/sul/");
        linkConcursos.add("https://www.pciconcursos.com.br/concursos/norte/");
        linkConcursos.add("https://www.pciconcursos.com.br/concursos/nordeste/");
        linkConcursos.add("https://www.pciconcursos.com.br/concursos/centrooeste/");
        linkConcursos.add("https://www.pciconcursos.com.br/professores/");

        for (String link : linkConcursos) {
            concursoService.buscarConcursos(link);
        }

        // Arquivar oportunidades e concursos antigos
        concursoService.arquivarAntigos();

        System.out.println("Finalizado a busca pelas oportunidades... :: Hora local - " + dateTimeFormatter.format(LocalDateTime.now()));
    }
}
