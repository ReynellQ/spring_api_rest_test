package com.project.market_test.persistence.mapper;

import com.project.market_test.domain.dto.ProductoDTO;
import com.project.market_test.persistence.entity.Producto;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { CategoriaMapper.class })
public interface ProductoMapper {
    @Mappings({
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "idCategoria", target = "idCategoria"),
            @Mapping(source = "precioVenta", target = "precioVenta"),
            @Mapping(source = "estado", target = "estado"),
            @Mapping(source = "categoria", target = "categoria"),
    })
    ProductoDTO toDTO(Producto producto);

    List<ProductoDTO> toDTOs(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "idProducto", ignore = true)
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toModel(ProductoDTO productoDTO);
}
