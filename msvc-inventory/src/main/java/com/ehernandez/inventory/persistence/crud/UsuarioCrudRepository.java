package com.ehernandez.inventory.persistence.crud;

import com.ehernandez.inventory.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface
UsuarioCrudRepository  extends CrudRepository<Usuario, Integer> {
    Optional<List<Usuario>> findByNombres(String names);
    Optional<List<Usuario>> findByIdCargo(int idCargo);
}
