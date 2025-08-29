package com.talentina.candidatos;

import jakarta.persistence.*;

@Entity
@Table(name = "candidatos")  // nombre de la tabla en Postgres
public class Candidato {

    @Id
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String[] skills;
    private Long experiencia;
    private String educacion;
    private String estado;
    private String urLinkedin;
    private String experiencia1;
    private String experiencia2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public Long getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Long experiencia) {
        this.experiencia = experiencia;
    }

    public String getEducacion() { return educacion; }

    public void setEducacion(String educacion) {
        this.educacion = educacion;
    }

    public String getEstado() { return estado; }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUrLinkedin() { return urLinkedin; }

    public void setUrLinkedin(String urLinkedin) {
        this.urLinkedin = urLinkedin;
    }

    public String getExperiencia1() { return experiencia1; }

    public void setExperiencia1(String experiencia1) {
        this.experiencia1 = experiencia1;
    }

    public String getExperiencia2() { return experiencia2; }

    public void setExperiencia2(String experiencia2) {
        this.experiencia2 = experiencia2;
    }
}
