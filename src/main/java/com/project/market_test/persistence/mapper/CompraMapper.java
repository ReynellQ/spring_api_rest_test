package com.project.market_test.persistence.mapper;

import com.project.market_test.domain.dto.CompraDTO;
import com.project.market_test.domain.dto.CompraItemDTO;
import com.project.market_test.domain.dto.CompraWithProductosDTO;
import com.project.market_test.persistence.entity.Compra;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = CompraItemMapper.class)
public interface CompraMapper {
    @Named("A purchase")
    CompraDTO toDTO(Compra compra);
    @Named("A purchase")
    List<CompraDTO> toDTOs(List<Compra> compras);
    @Named("Purchase with items")
    CompraWithProductosDTO toDTOWithProducts(Compra compra);

    @InheritInverseConfiguration(name = "toDTO")
    @Mapping(target = "idCompra", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "compraProducto", ignore = true)
    Compra toModel(CompraDTO compraDTO);

    @InheritInverseConfiguration(name = "toDTOWithProducts")
    @Mapping(target = "idCompra", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    Compra toModelWithProducts(CompraWithProductosDTO compraDTO);
}
