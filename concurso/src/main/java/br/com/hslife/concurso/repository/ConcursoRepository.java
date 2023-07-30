package br.com.hslife.concurso.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hslife.concurso.entity.Concurso;

@Repository
public interface ConcursoRepository extends JpaRepository<Concurso, Long> {

    @Query("SELECT c FROM Concurso c WHERE c.hash = :hash")
    Concurso buscarPorHash(
        @Param("hash") String hash);

    @Query("SELECT c FROM Concurso c WHERE c.dataCadastro <= :dataCorte AND c.arquivado = false")
    List<Concurso> buscarNaoArquivadosPorData(
        @Param("dataCorte") LocalDateTime dataCorte);

    @Query("SELECT c FROM Concurso c WHERE c.uf = :uf")
    List<Concurso> buscarPorUF(
        @Param("uf") String uf
    );

    @Query("SELECT c FROM Concurso c WHERE c.titulo LIKE %:textoBusca% OR c.descricao LIKE %:textoBusca%")
    List<Concurso> buscarPorTituloOuDescricao(
        @Param("textoBusca") String textoBusca);

    @Query("SELECT DISTINCT c.uf FROM Concurso c ORDER BY 1 ASC")
    List<String> buscarUFs();
}
