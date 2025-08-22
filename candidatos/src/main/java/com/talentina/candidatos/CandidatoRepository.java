package com.talentina.candidatos;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CandidatoRepository {
    private final List<Candidato> candidatos = new ArrayList<>();

    public void cargarCandidato(Candidato candidato)
    {
        candidatos.add(candidato);
    }

    public List<Candidato> findAll(){
        return candidatos;
    }

    // Candidato tipo de dato, candidato una instancia de la clase y candidatos es la lista
    public Optional<Candidato> findById(Long id) {
        Optional<Candidato> ret = Optional.empty(); // Arrancamos vacío

        for (Candidato candidato : this.candidatos) // Recorremos la lista
        {
            if (Objects.equals(candidato.getId(), id)) { // Comparamos id
                ret = Optional.of(candidato); // Si encontramos, lo guardamos
                break; // Cortamos el loop, ya no hace falta seguir
            }
        }
        return ret; // Devolvemos el Optional (vacío o con algun valor)
    }

    public List<Candidato> filtrarPorExperiencia(Long experiencia) {
        List<Candidato> resultado = new ArrayList<>();; // Arrancamos vacío

        for (Candidato candidato : this.candidatos) // Recorremos la lista
        {
            if (candidato.getExperiencia() >= experiencia) { // Filtramos segun la cantidad que se pasa por parametro
                resultado.add(candidato); // Si cumple la condicion lo guardamos en el array
            }
        }
        return resultado; // Devolvemos el array con los candidatos que cumplieron la condicion
    }

    public List<Candidato> filtrar(String nombre, Long experienciaMin, String skill) {
        List<Candidato> resultado = new ArrayList<>();

        for (Candidato c : findAll())
        {
            boolean coincide = true;
            boolean tieneSkill = false;

            if (nombre != null && !c.getNombre().equalsIgnoreCase(nombre)) {
                coincide = false;
            }
            if (experienciaMin != null && c.getExperiencia() < experienciaMin) {
                coincide = false;
            }
            if (skill != null && c.getSkills() != null) {
                for (String s : c.getSkills()) // Recorremos el vector de skills
                {
                    if (s != null && s.equalsIgnoreCase(skill)) {
                        tieneSkill = true;
                        break; // Si lo encuentra, corta el for
                    }
                }
                if (!tieneSkill) {
                    coincide = false;
                }
            }
            if (coincide) {
                resultado.add(c);
            }
        }
        return resultado;
    }

}