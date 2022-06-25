package com.project.market_test.persistence.mapper;

import com.project.market_test.domain.dto.CompraItemDTO;
import com.project.market_test.persistence.entity.CompraProducto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CompraItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "idProducto")
    })
    CompraItemDTO toDTO(CompraProducto compraProducto);

}
