package com.ehernandez.inventory.persistence;

import com.ehernandez.inventory.domain.MerchandiseDTO;
import com.ehernandez.inventory.domain.repository.MerchandiseRepository;
import com.ehernandez.inventory.persistence.crud.MercanciaCrudRepository;
import com.ehernandez.inventory.persistence.entity.Mercancia;
import com.ehernandez.inventory.persistence.mapper.MerchandiseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class MercanciaRepository implements MerchandiseRepository {

    @Autowired
    private MercanciaCrudRepository mercanciaCrudRepository;

    @Autowired
    private MerchandiseMapper merchandiseMapper;

    @Override
    public List<MerchandiseDTO> getAll() {
        return merchandiseMapper.toMerchandises((List<Mercancia>) mercanciaCrudRepository.findAll());
    }

    @Override
    public Optional<List<MerchandiseDTO>> getByUsuario(int usuarioId) {
        return mercanciaCrudRepository.findByIdUsuarioOrderByIdUsuarioAsc(usuarioId)
                .map(usuarios -> merchandiseMapper.toMerchandises(usuarios));
    }

    @Override
    public Optional<List<MerchandiseDTO>> getFechaIngreso(LocalDate fechaIngreso) {
        return mercanciaCrudRepository.findByFechaIngresoOrderByFechaIngresoDesc(fechaIngreso)
                .map(usuarios -> merchandiseMapper.toMerchandises(usuarios));
    }

    @Override
    public Optional<List<MerchandiseDTO>> getNombreProducto(String nombreProducto) {
        return mercanciaCrudRepository.findByNombreProductoOrderByNombreProductoAsc(nombreProducto)
                .map(usuarios -> merchandiseMapper.toMerchandises(usuarios));
    }

    @Override
    public Optional<List<MerchandiseDTO>> getNombreProductoOrFechaIngresoOrIdUsuario(String nameProduct, LocalDate fechaIngreso, int idUsuario) {
        return mercanciaCrudRepository.findByNombreProductoOrFechaIngresoOrIdUsuarioOrderByNombreProductoAsc(nameProduct, fechaIngreso, idUsuario)
                .map(usuarios -> merchandiseMapper.toMerchandises(usuarios));
    }

    @Override
    public Optional<MerchandiseDTO> getMerchandise(int merchandiseId) {
        return mercanciaCrudRepository.findById(merchandiseId).map(mercancia -> merchandiseMapper.toMerchandise(mercancia));
    }

    @Override
    public MerchandiseDTO save(MerchandiseDTO merchandiseDTO) {
        Mercancia mercancia = merchandiseMapper.toMercancia(merchandiseDTO);
        return merchandiseMapper.toMerchandise(mercanciaCrudRepository.save(mercancia));
    }

    @Override
    public void delete(int productId) {
        mercanciaCrudRepository.deleteById(productId);
    }
}
