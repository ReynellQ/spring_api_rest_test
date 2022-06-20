package com.project.market_test.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.market_test.domain.dto.CategoriaDTO;
import com.project.market_test.domain.repository.CategoriaDTORepository;
import com.project.market_test.persistence.crud.CategoriaCrud;
import com.project.market_test.persistence.entity.Categoria;
import com.project.market_test.persistence.mapper.CategoriaMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaRepository implements CategoriaDTORepository {
    @Autowired
    private CategoriaCrud categoriaCrud;
    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaDTO> getAll() {
        return categoriaMapper.toDTOs((List<Categoria>) categoriaCrud.findAll());
    }

    @Override
    public Optional<CategoriaDTO> getCategoria(long idCategoria) {
        return categoriaCrud.findById(idCategoria).map(categoria -> categoriaMapper.toDTO(categoria));
    }

}
