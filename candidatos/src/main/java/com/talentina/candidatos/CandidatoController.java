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
    public Candidato crearCandidato(@RequestBody Candidato candidato) {
        return candidatoService.guardar(candidato);
    }

    // endpoint para obtener TODOS los candidatos
    @GetMapping("/candidatos")
    public List<Candidato> getAllCandidatos(){
        return candidatoService.obtenerTodos();
    }

    // endpoint para obtener un candidato por ID
    @GetMapping(path = "/candidato/{id}")
    public Candidato findById(@PathVariable Long id)
    {
        return candidatoService.filtrarPorId(id).orElse(null);
    }

    /*@GetMapping("/candidatos/filtrar")
    public List<Candidato> filtrar(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Long experienciaMin,
            @RequestParam(required = false) String skill) {

        return candidatoService.filtrar(nombre, experienciaMin, skill);
    }*/
}
