package com.talentina.candidatos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidatoRepository {
    private final List<Candidato> candidatos;

    public CandidatoRepository(){
        this.candidatos = candidatos();
    }

    private List<Candidato> candidatos(){
        Candidato c1 = new Candidato();
        c1.setId(1L);
        c1.setName("Juan Manuel");
        Candidato c2 = new Candidato();
        c2.setId(2L);
        c2.setName("Sebastian");

        return List.of(c1,c2);
    }
    public List<Candidato> findAll(){
        return this.candidatos;
    }

    public Optional<Candidato> findById(Long id){
        Optional<Candidato> ret = Optional.empty();
        List<Candidato> filteredCandidatos = this.candidatos.stream().filter(p -> Objects.equals(p.getId(), id)).collect(Collectors.toList());
        if(!filteredCandidatos.isEmpty()){
            ret = Optional.of(filteredCandidatos.get(0));
        }
        return ret;
    }
}