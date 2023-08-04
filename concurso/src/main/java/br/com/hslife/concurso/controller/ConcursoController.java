package br.com.hslife.concurso.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hslife.concurso.entity.Concurso;
import br.com.hslife.concurso.repository.ConcursoRepository;

@RestController
public class ConcursoController {

    /*
     * Tutorial para ajudar a criar um CRUD Rest API
     * https://www.bezkoder.com/spring-boot-jpa-crud-rest-api/
     */
    
    @Autowired
    ConcursoRepository concursoRepository;

    @GetMapping("/")
    public ResponseEntity<List<Concurso>> buscarTodosConcursos() {
        try {
            List<Concurso> concursos = new ArrayList<Concurso>();
            concursoRepository.buscarTodosNaoArquivados().forEach(concursos::add);

            if (concursos.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(concursos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Concurso> buscarPorId(@PathVariable("id") Long id) {
        Optional<Concurso> concurso = concursoRepository.findById(id);

        if (concurso.isPresent()) {
            return new ResponseEntity<>(concurso.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/uf/{uf}")
    public ResponseEntity<List<Concurso>> buscarPorUF(@PathVariable("uf") String uf) {
        try {
            List<Concurso> concursos = new ArrayList<Concurso>();
            concursoRepository.buscarPorUF(uf).forEach(concursos::add);

            if (concursos.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(concursos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/uf")
    public ResponseEntity<List<String>> buscarUFs() {
        try {
            List<String> ufs = new ArrayList<String>();
            concursoRepository.buscarUFs().forEach(ufs::add);

            if (ufs.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(ufs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/novos")
    public ResponseEntity<Long> quantidadeNovosConcursos() {
        try {

            Long novosConcursos = concursoRepository.quantidadeNovosConcursos(LocalDateTime.now().minusHours(1));
            if (novosConcursos == null) {
                return new ResponseEntity<Long>(0l, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<Long>(novosConcursos, HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Concurso>> buscarPorTituloOuDescricao(
        @RequestParam(required = false) String textoBusca,
        @RequestParam(required = false) String uf) {
        try {
            List<Concurso> concursos = new ArrayList<Concurso>();

            if (textoBusca == null & uf == null) {
                concursoRepository.buscarTodosNaoArquivados().forEach(concursos::add);
            } else if (uf == null) {
                concursoRepository.buscarPorTituloOuDescricao(textoBusca).forEach(concursos::add);
            } else if (textoBusca == null) {
                concursoRepository.buscarPorUF(uf).forEach(concursos::add);
            } else {
                concursoRepository.buscarPorTituloDescricaoAndUF(textoBusca, uf).forEach(concursos::add);
            }

            if (concursos.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(concursos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/archive/{id}")
    public ResponseEntity<Concurso> arquivarConcurso(@PathVariable("id") Long id) {
        Optional<Concurso> concurso = concursoRepository.findById(id);

        if (concurso.isPresent()) {
            Concurso _concurso = concurso.get();
            _concurso.setArquivado(true);
            
            return new ResponseEntity<>(concursoRepository.save(_concurso), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}