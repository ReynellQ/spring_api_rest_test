package com.project.market_test.persistence.mapper;

import com.project.market_test.domain.dto.CompraDTO;
import com.project.market_test.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompraMapper {
    @Mappings({
            @Mapping(source = "idCliente", target = "idCliente"),
            @Mapping(source = "fecha", target = "fecha"),
            @Mapping(source = "medioPago", target = "medioPago"),
            @Mapping(source = "comentario", target = "comentario"),
            @Mapping(source = "estado", target = "estado"),
    })
    CompraDTO toDTO(Compra compra);

    List<CompraDTO> toDTOs(List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "idCompra", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "compraProducto", ignore = true)
    Compra toModel(CompraDTO compraDTO);
}
