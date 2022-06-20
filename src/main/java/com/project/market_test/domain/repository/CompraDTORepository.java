package com.project.market_test.domain.repository;

import com.project.market_test.domain.dto.CompraDTO;

import java.util.List;
import java.util.Optional;

public interface CompraDTORepository {
    List<CompraDTO> getAll();

    Optional<CompraDTO> getCompra(long idCompra);
}
