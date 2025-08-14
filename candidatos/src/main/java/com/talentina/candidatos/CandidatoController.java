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
@RequestMapping("/candidatos")
public class CandidatoController {
    @Autowired
    private CandidatoService candidatoService;

    // endpoint para obtener TODOS los candidatos
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Candidato>> findAll()
    {
        List<Candidato> allCandidatos = candidatoService.findAll();
        return new ResponseEntity<>(allCandidatos, HttpStatus.OK);
    }

    // endpoint para obtener un candidato por ID
    @GetMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Candidato> findById(@PathVariable("id") Long id)
    {
        Optional<Candidato> candidato = candidatoService.findById(id);
        return candidato.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
