package com.ehernandez.inventory.persistence.crud;

import com.ehernandez.inventory.persistence.entity.Mercancia;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MercanciaCrudRepository  extends CrudRepository<Mercancia, Integer> {
    Optional<List<Mercancia>> findByFechaIngresoOrderByFechaIngresoDesc(LocalDate fechaIngreso);
    Optional<List<Mercancia>> findByNombreProductoOrderByNombreProductoAsc(String nameProduct);
    Optional<List<Mercancia>> findByIdUsuarioOrderByIdUsuarioAsc(int idUsuario);

    Optional<List<Mercancia>> findByNombreProductoOrFechaIngresoOrIdUsuarioOrderByNombreProductoAsc(String nameProduct, LocalDate fechaIngreso, int idUsuario);
}
