package com.talentina.candidatos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository candidatoRepository;

    public Candidato agregarCandidato(Candidato candidato)
    {
        return candidatoRepository.agregarCandidato(candidato);
    }

    public List<Candidato> findAll()
    {
        return candidatoRepository.findAll();
    }

    public Optional<Candidato> findById(Long id)
    {
        return candidatoRepository.findById(id);
    }
}
