package com.ehernandez.inventory.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="tusuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idUsuario;

    @Column(name = "nombres", unique = true)
    @Size(min = 3, max = 255)
    @NotNull(message = "Los nombres son requerido para el usuario")
    private String nombres;

    @PositiveOrZero(message = "La edad debe ser un numero positivo o cero")
    private Integer edad;

    @PastOrPresent(message = "La fecha de ingreso debe ser menor o igual a la actual")
    @Column(name = "fechaingreso")
    private LocalDateTime fecingreso;

    @Column(name = "idcargo")
    private Integer idCargo;

    /**
     * Relaciones entre entity
     */

    /*@OneToMany(mappedBy = "usuario")
    private List<Mercancia> mercancia;*/

    @ManyToOne
    @JoinColumn(name = "idcargo", insertable = false, updatable = false)
    private Cargo cargo;

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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public LocalDateTime getFecingreso() {
        return fecingreso;
    }

    public void setFecingreso(LocalDateTime fecingreso) {
        this.fecingreso = fecingreso;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    /*public List<Mercancia> getMercancia() {
        return mercancia;
    }

    public void setMercancia(List<Mercancia> mercancia) {
        this.mercancia = mercancia;
    }*/
}
