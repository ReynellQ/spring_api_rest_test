package com.project.market_test.persistence.mapper;

import com.project.market_test.domain.dto.ProductoDTO;
import com.project.market_test.domain.dto.ProductoWithIDDTIO;
import com.project.market_test.persistence.entity.Producto;

import java.util.List;

import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = { CategoriaMapper.class })
public interface ProductoMapper {
    @Named("Product without ID")
    ProductoDTO toDTO(Producto producto);
    @Named("Product without ID")
    List<ProductoDTO> toDTOs(List<Producto> productos);
    @Named("Product with ID")
    ProductoWithIDDTIO toDTOWithID(Producto producto);

    @InheritInverseConfiguration(name = "toDTO")
    @Mapping(target = "compraProductoList", ignore = true)
    @Mapping(target = "idProducto", ignore = true)
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toModel(ProductoDTO productoDTO);


    @InheritInverseConfiguration(name = "toDTOWithID")
    @Mapping(target = "compraProductoList", ignore = true)
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toModelWithID(ProductoWithIDDTIO productoDTO);
}
