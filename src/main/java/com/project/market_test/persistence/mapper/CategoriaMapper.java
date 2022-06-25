package com.project.market_test.persistence.mapper;

import com.project.market_test.domain.dto.CategoriaDTO;
import com.project.market_test.persistence.entity.Categoria;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    @Mappings({
            @Mapping(source = "descripcion", target = "descripcion"),
            @Mapping(source = "estado", target = "estado"),
    })
    CategoriaDTO toDTO(Categoria categoria);

    List<CategoriaDTO> toDTOs(List<Categoria> categorias);

    @InheritInverseConfiguration
    @Mapping(target = "idCategoria", ignore = true)
    @Mapping(target = "productos", ignore = true)
    Categoria toModel(CategoriaDTO category);
}
