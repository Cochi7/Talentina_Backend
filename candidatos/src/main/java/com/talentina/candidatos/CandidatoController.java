package com.talentina.candidatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class CandidatoController {
    @Autowired
    private CandidatoService productService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Candidato>> findAll(){
        List<Candidato> allProducts = CandidatoService.findAll();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Candidato> findById(@PathVariable("id") Long id){
        Optional<Candidato> candidato = CandidatoService.findById(id);
        return candidato.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
