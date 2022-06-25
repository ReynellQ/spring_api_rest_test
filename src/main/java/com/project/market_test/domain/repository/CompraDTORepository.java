package com.project.market_test.domain.repository;

import com.project.market_test.domain.dto.CompraDTO;
import com.project.market_test.domain.dto.CompraWithProductosDTO;
import com.project.market_test.persistence.entity.Compra;

import java.util.List;
import java.util.Optional;

public interface CompraDTORepository {
    List<CompraDTO> getAll();

    Optional<CompraDTO> getCompra(long idCompra);
    Optional<CompraDTO> getCompraWithItems(long idCompra);
    CompraDTO save(CompraDTO compra);
    CompraWithProductosDTO save(CompraWithProductosDTO compra);
}
