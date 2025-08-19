package com.talentina.candidatos;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CandidatoRepository {
    private final List<Candidato> candidatos = new ArrayList<>();

    public Candidato cargarCandidato(Candidato candidato)
    {
        candidatos.add(candidato);
        return candidato;
    }

    public List<Candidato> findAll(){
        return candidatos;
    }

    // Candidato tipo de dato, candidato una instancia de la clase y candidatos es la lista
    public Optional<Candidato> findById(Long id) {
        Optional<Candidato> ret = Optional.empty(); // Arrancamos vacío

        for (Candidato candidato : this.candidatos) { // Recorremos la lista
            if (Objects.equals(candidato.getId(), id)) { // Comparamos id
                ret = Optional.of(candidato); // Si encontramos, lo envolvemos
                break; // Cortamos el loop, ya no hace falta seguir
            }
        }
        return ret; // Devolvemos el Optional (vacío o con algun valor)
    }
}