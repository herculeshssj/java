package net.mightysolutions.herculeshssj.oportunidade.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.openxava.jpa.XPersistence;
import org.springframework.stereotype.Repository;

import net.mightysolutions.herculeshssj.oportunidade.model.Concurso;

@Repository
public class ConcursoRepository {
    
    public void salvarConcursos(List<Concurso> concursos) throws Exception {
        concursos.forEach(concurso -> {

            try {

                // Caso não seja lançado uma exceção, significa que o concurso já foi cadastrado
                XPersistence.getManager()
                    .createQuery("SELECT c FROM Concurso c WHERE c.hash = :hash", Concurso.class)
                    .setParameter("hash", concurso.getHash())
                    .getSingleResult();

            } catch (NoResultException nr) {

                // Exceção lançada, efetua o cadastro do concurso
                XPersistence.getManager().persist(concurso);

            } catch (NonUniqueResultException nur) {
                // Não faz nada
                // TODO ver a possibilidade de exclui as entradas repetidas.
            } catch (Exception e) {
                // Lança a exceção para a camada de serviço
                throw e;
            } finally {
                XPersistence.commit();
            }

        });
    }

    public void arquivarConcurso(String id) {
        Concurso c = XPersistence.getManager().find(Concurso.class, id);
        c.setArquivado(true);
        XPersistence.getManager().merge(c);
        XPersistence.commit();
    }

    public List<Concurso> buscarNaoArquivadosPorData(LocalDateTime dataCorte) {
        return XPersistence.getManager()
            .createQuery("SELECT c FROM Concurso c WHERE c.dataCadastro <= :dataCorte AND c.arquivado = false", Concurso.class)
            .setParameter("dataCorte", dataCorte)
            .getResultList();
    }
}
