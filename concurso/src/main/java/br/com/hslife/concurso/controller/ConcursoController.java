package br.com.hslife.concurso.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hslife.concurso.entity.Concurso;
import br.com.hslife.concurso.repository.ConcursoRepository;

@RestController
@RequestMapping("/concurso")
public class ConcursoController {

    /*
     * Tutorial para ajudar a criar um CRUD Rest API
     * https://www.bezkoder.com/spring-boot-jpa-crud-rest-api/
     */
    
    @Autowired
    ConcursoRepository concursoRepository;

    @GetMapping
    public ResponseEntity<List<Concurso>> buscarTodosConcursos() {
        try {
            List<Concurso> concursos = new ArrayList<Concurso>();
            concursoRepository.findAll().forEach(concursos::add);

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

    @GetMapping("/search")
    public ResponseEntity<List<Concurso>> buscarPorTituloOuDescricao(@RequestParam String textoBusca) {
        try {
            List<Concurso> concursos = new ArrayList<Concurso>();

            if (textoBusca == null) {
                concursoRepository.findAll().forEach(concursos::add);
            } else {
                concursoRepository.buscarPorTituloOuDescricao(textoBusca).forEach(concursos::add);
            }

            if (concursos.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(concursos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}