package com.project.market_test.domain.repository;

import com.project.market_test.domain.dto.ProductoDTO;

import java.util.List;
import java.util.Optional;

public interface ProductoDTORepository {
    List<ProductoDTO> getAll();

    Optional<ProductoDTO> getProduct(long productId);

    ProductoDTO save(ProductoDTO producto);
}
