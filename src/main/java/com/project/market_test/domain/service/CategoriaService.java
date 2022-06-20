package com.project.market_test.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.market_test.domain.dto.CategoriaDTO;
import com.project.market_test.domain.repository.CategoriaDTORepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaDTORepository categoriaDTORepository;

    public List<CategoriaDTO> getAll() {
        return categoriaDTORepository.getAll();
    }

    public Optional<CategoriaDTO> getCategoria(long idCategoria) {
        return categoriaDTORepository.getCategoria(idCategoria);
    }
}
