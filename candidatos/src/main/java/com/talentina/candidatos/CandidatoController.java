package com.talentina.candidatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CandidatoController {
    @Autowired
    private CandidatoService candidatoService;

    // endpoint para crear un candidato
    @PostMapping("/candidato")
    public String recibirCandidato(@RequestBody Candidato candidato) {
        candidatoService.cargarCandidato(candidato);
        return "Candidato agregado: " + candidato.getNombre();
    }

    // endpoint para obtener TODOS los candidatos
    @GetMapping("/candidatos")
    public List<Candidato> findAll(){
        return candidatoService.findAll();
    }

    // endpoint para obtener un candidato por ID
    @GetMapping(path = "/candidato/{id}")
    public Candidato findById(@PathVariable Long id)
    {
        return candidatoService.findById(id).orElse(null);
    }
}
