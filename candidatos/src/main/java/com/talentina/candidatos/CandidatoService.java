package com.talentina.candidatos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository candidatoRepository;

    public void cargarCandidato(Candidato candidato)
    {
        candidatoRepository.cargarCandidato(candidato);
    }

    public List<Candidato> findAll()
    {
        return candidatoRepository.findAll();
    }

    public Optional<Candidato> findById(Long id)
    {
        return candidatoRepository.findById(id);
    }

    public List<Candidato> filtrarPorExperiencia(Long experiencia)
    {
        return candidatoRepository.filtrarPorExperiencia(experiencia);
    }

    public List<Candidato> filtrar(String nombre, Long experienciaMin, String skill)
    {
        return candidatoRepository.filtrar(nombre, experienciaMin, skill);
    }
}
