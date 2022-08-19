package com.ehernandez.inventory.domain.service;

import com.ehernandez.inventory.domain.MerchandiseDTO;
import com.ehernandez.inventory.domain.repository.MerchandiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MerchandiseService {

    @Autowired(required=true)
    private MerchandiseRepository merchandiseRepository;

    public List<MerchandiseDTO> getAll(){
        return merchandiseRepository.getAll();
    }

    public Optional<List<MerchandiseDTO>> getByUsuario(int usuarioId){
        return merchandiseRepository.getByUsuario(usuarioId);
    }

    public Optional<List<MerchandiseDTO>> getFechaIngreso(LocalDate fechaIngreso){
        return merchandiseRepository.getFechaIngreso(fechaIngreso);
    }

    public Optional<List<MerchandiseDTO>> getNombreProducto(String nombreProducto){
        return merchandiseRepository.getNombreProducto(nombreProducto);
    }

    public Optional<MerchandiseDTO> getMerchandise(int merchandiseId){
        return merchandiseRepository.getMerchandise(merchandiseId);
    }

    /*public Optional<Merchandise> getMerchandiseId(int productId){
        return merchandiseRepository.getProduct(productId);
    }*/

    public Optional<List<MerchandiseDTO>> getNombreProductoOrFechaIngresoOrIdUsuario(String nameProduct, LocalDate fechaIngreso, int idUsuario) {
        System.out.println("LLega al controller getNombreProductoOrFechaIngresoOrIdUsuario");
        return merchandiseRepository.getNombreProductoOrFechaIngresoOrIdUsuario(nameProduct, fechaIngreso, idUsuario);
    }

    public MerchandiseDTO save(MerchandiseDTO product){
        return merchandiseRepository.save(product);
    }

    public boolean delete(int productId){
        return getMerchandise(productId).map(product -> {
            merchandiseRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
