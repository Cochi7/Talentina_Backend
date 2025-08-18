package com.talentina.candidatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {
    @Autowired
    private CandidatoService candidatoService;

    // endpoint para crear un candidato
    @PostMapping(produces = "application/json")
    public Candidato create(@RequestBody Candidato candidato) {
        return candidatoService.agregarCandidato(candidato);
    }

    // endpoint para obtener TODOS los candidatos
    @GetMapping(produces = "application/json")
    public List<Candidato> findAll() {
        return candidatoService.findAll();
    }


    // endpoint para obtener un candidato por ID
    @GetMapping(path = "/{id}", produces = "application/json")
    public Candidato findById(@PathVariable Long id) {
        return candidatoService.findById(id).orElse(null);
    }
}
