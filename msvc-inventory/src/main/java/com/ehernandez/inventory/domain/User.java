package com.ehernandez.inventory.domain;

import com.ehernandez.inventory.persistence.entity.Cargo;

import java.time.LocalDateTime;

public class User {

    private Integer idUsuario;
    private String nombres;
    private Integer edad;
    private Integer idPosition;
    private LocalDateTime fecingreso;
    private Cargo position;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    public LocalDateTime getFecingreso() {
        return fecingreso;
    }

    public void setFecingreso(LocalDateTime fecingreso) {
        this.fecingreso = fecingreso;
    }

    public Cargo getPosition() {
        return position;
    }

    public void setPosition(Cargo position) {
        this.position = position;
    }
}
