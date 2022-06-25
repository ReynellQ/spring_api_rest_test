package com.project.market_test.domain.repository;

import java.util.List;
import java.util.Optional;

import com.project.market_test.domain.dto.CategoriaDTO;

public interface CategoriaDTORepository {
    List<CategoriaDTO> getAll();

    Optional<CategoriaDTO> getCategoria(long idCategoria);
    CategoriaDTO save(CategoriaDTO categoria);
}
