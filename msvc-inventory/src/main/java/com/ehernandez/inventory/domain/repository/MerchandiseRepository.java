package com.ehernandez.inventory.domain.repository;

import com.ehernandez.inventory.domain.MerchandiseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MerchandiseRepository {
    List<MerchandiseDTO> getAll();
    Optional<List<MerchandiseDTO>> getByUsuario(int usuarioId);
    Optional<List<MerchandiseDTO>> getFechaIngreso(LocalDate fechaIngreso);
    Optional<List<MerchandiseDTO>> getNombreProducto(String nombreProducto);
    Optional<List<MerchandiseDTO>> getNombreProductoOrFechaIngresoOrIdUsuario(String nameProduct, LocalDate fechaIngreso, int idUsuario);
    Optional<MerchandiseDTO> getMerchandise(int merchandiseId);
    MerchandiseDTO save(MerchandiseDTO product);
    void delete(int productId);
}
