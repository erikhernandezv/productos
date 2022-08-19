package com.ehernandez.inventory.persistence.mapper;

import com.ehernandez.inventory.domain.User;
import com.ehernandez.inventory.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "idUsuario", target = "idUsuario"),
            @Mapping(source = "nombres", target = "nombres"),
            @Mapping(source = "edad", target = "edad"),
            @Mapping(source = "idCargo", target = "idPosition"),
            @Mapping(source = "fecingreso", target = "fecingreso"),
            @Mapping(source = "cargo", target = "position"),
    })
    User toUser(Usuario usuario);

    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    //@Mapping(target = "mercancia", ignore = true)
    Usuario toUsuario(User user);
}