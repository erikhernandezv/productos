package com.ehernandez.inventory.persistence.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name="tmercancias")
public class Mercancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmercancia")
    private Integer idMercancia;

    @Column(name = "nombreproducto", unique = true)
    @NotNull(message = "El nombre del producto es requerido")
    @Size(min = 0, max = 255)
    private String nombreProducto;

    @PositiveOrZero(message = "La cantidad debe ser positiva o cero")
    @Column(name = "cantidad")
    @Min(value = 0, message = "La cantidad minima debe ser 0")
    private Integer cantidad;

    @Column(name = "fechaingreso")
    @PastOrPresent(message = "La fecha de ingreso debe ser menor o igual a la actual")
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate fechaIngreso;

    @Column(name = "idusuario")
    private Integer idUsuario;

    public Mercancia(Integer idMercancia, String nombreProducto, Integer cantidad, LocalDate fechaIngreso, Integer idUsuario) {
        this.idMercancia = idMercancia;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.idUsuario = idUsuario;
    }

    public Mercancia() {
    }

    /**
     * @apiNote Clave foranea a la tabla usuario.
     */
    @ManyToOne
    @JoinColumn(name = "idusuario", insertable = false, updatable = false)
    private Usuario usuario;

    public Integer getIdMercancia() {
        return idMercancia;
    }

    public void setIdMercancia(Integer idMercancia) {
        this.idMercancia = idMercancia;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
