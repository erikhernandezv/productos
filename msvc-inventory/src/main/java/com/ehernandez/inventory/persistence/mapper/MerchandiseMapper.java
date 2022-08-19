package com.ehernandez.inventory.persistence.mapper;

import com.ehernandez.inventory.domain.MerchandiseDTO;
import com.ehernandez.inventory.persistence.entity.Mercancia;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface MerchandiseMapper {

    @Mappings({
        @Mapping(source = "idMercancia", target = "idMercancia"),
        @Mapping(source = "nombreProducto", target = "nombreProducto"),
        @Mapping(source = "cantidad", target = "cantidad"),
        @Mapping(source = "fechaIngreso", target = "fechaIngreso"),
        @Mapping(source = "idUsuario", target = "idUsuario"),
    })
    MerchandiseDTO toMerchandise(Mercancia mercancia);

    List<MerchandiseDTO> toMerchandises(List<Mercancia> mercancias);

    @InheritInverseConfiguration
    @Mapping(target = "usuario", ignore= true)
    Mercancia toMercancia(MerchandiseDTO merchandiseDTO);
}
