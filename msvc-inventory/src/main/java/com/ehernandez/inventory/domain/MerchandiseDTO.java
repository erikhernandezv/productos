package com.ehernandez.inventory.domain;

import com.ehernandez.inventory.persistence.entity.Usuario;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class MerchandiseDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmercancia")
    private Integer idMercancia;

    @Column(name = "nombreproducto", unique = true)
    @NotNull(message = "El nombre del producto es requerido")
    @Size(min = 0, max = 255)
    private String nombreProducto;

    @Column(name = "cantidad")
    @PositiveOrZero(message = "La cantidad debe ser positiva o cero")
    @NotNull(message = "La cantidad debe diligenciarse")
    private Integer cantidad;

    @Column(name = "fechaingreso")
    @PastOrPresent(message = "La fecha de ingreso debe ser menor o igual a la actual")
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @NotNull(message = "Debe seleccionar una fecha de ingreso")
    private LocalDate fechaIngreso;

    @NotNull(message = "Debe seleccionar un usuario")
    private Integer idUsuario;
    private Usuario usuario;

    public MerchandiseDTO(Integer idMercancia, String nombreProducto, Integer cantidad, LocalDate fechaIngreso, Integer idUsuario) {
        this.idMercancia = idMercancia;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.idUsuario = idUsuario;
    }

    public MerchandiseDTO() {
    }

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
