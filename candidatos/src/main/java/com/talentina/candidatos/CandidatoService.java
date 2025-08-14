package com.talentina.candidatos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository productRepository;

    public List<Candidato> findAll(){
        return productRepository.findAll();
    }

    public Optional<Candidato> findById(Long id){
        return productRepository.findById(id);
    }
}
