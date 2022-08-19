package com.ehernandez.inventory.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="tcargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcargo")
    private Integer idCargo;

    @Column(unique = true)
    @Size(min = 3, max = 160)
    @NotNull(message = "El nombre del cargo no puede ser nulo")
    private String nombre;

    @OneToMany(mappedBy = "cargo")
    private List<Usuario> usuarios;

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
