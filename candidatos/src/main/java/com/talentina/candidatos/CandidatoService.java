package com.talentina.candidatos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository candidatoRepository;

    public Candidato guardar(Candidato candidato)
    {
        return candidatoRepository.save(candidato);
    }

    public List<Candidato> obtenerTodos()
    {
        return candidatoRepository.findAll();
    }

    public Optional<Candidato> filtrarPorId(Long id)
    {
        return candidatoRepository.findById(id);
    }

    /*public List<Candidato> filtrar(String nombre, Long experienciaMin, String skill)
    {
        return candidatoRepository.filtrar(nombre, experienciaMin, skill);
    }*/
}
