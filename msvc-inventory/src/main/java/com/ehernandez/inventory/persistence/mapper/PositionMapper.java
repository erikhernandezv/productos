package com.ehernandez.inventory.persistence.mapper;

import com.ehernandez.inventory.domain.Position;
import com.ehernandez.inventory.persistence.entity.Cargo;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PositionMapper {
    @Mappings({
        @Mapping(source = "idCargo", target = "idPosition"),
        @Mapping(source = "nombre", target = "nombre"),
    })
    Position toCargo(Cargo cargo);

    @InheritInverseConfiguration
    //@Mapping(target = "usuarios", ignore = true)
    Cargo toPosition(Position position);
}
