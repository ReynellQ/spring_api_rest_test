package com.project.market_test.persistence.repository;

import com.project.market_test.domain.dto.ProductoDTO;
import com.project.market_test.domain.repository.ProductoDTORepository;
import com.project.market_test.persistence.crud.ProductoCrud;
import com.project.market_test.persistence.entity.Producto;
import com.project.market_test.persistence.mapper.ProductoMapper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductoRepository implements ProductoDTORepository {
    @Autowired
    private ProductoCrud productoCrud;
    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public List<ProductoDTO> getAll() {
        return productoMapper.toDTOs((List<Producto>) productoCrud.findAll());
    }

    @Override
    public Optional<ProductoDTO> getProduct(long idProducto) {
        return productoCrud.findById(idProducto).map(producto -> productoMapper.toDTO(producto));
    }
}
