package com.ehernandez.inventory.domain;

import com.ehernandez.inventory.persistence.entity.Usuario;

public class Position {
    private Integer idPosition;
    private String nombre;

    public Integer getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
