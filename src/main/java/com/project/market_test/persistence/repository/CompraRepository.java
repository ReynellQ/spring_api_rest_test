package com.project.market_test.persistence.repository;

import com.project.market_test.domain.dto.CompraDTO;
import com.project.market_test.domain.dto.CompraWithProductosDTO;
import com.project.market_test.domain.repository.CompraDTORepository;
import com.project.market_test.persistence.crud.CompraCrud;
import com.project.market_test.persistence.crud.CompraProductoCrud;
import com.project.market_test.persistence.entity.Compra;
import com.project.market_test.persistence.mapper.CompraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements CompraDTORepository {
    @Autowired
    private CompraCrud compraCrudRepository;
    @Autowired
    private CompraProductoCrud compraProductoCrud;

    @Autowired
    private CompraMapper mapper;

    @Override
    public List<CompraDTO> getAll() {
        return mapper.toDTOs((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<CompraDTO> getCompra(long idCompra) {
        return compraCrudRepository.findById(idCompra).map(compra -> mapper.toDTO(compra));
    }

    @Override
    public Optional<CompraDTO> getCompraWithItems(long idCompra) {
        return compraCrudRepository.findById(idCompra).map(compra -> mapper.toDTOWithProducts(compra));
    }

    @Override
    public CompraDTO save(CompraDTO compra) {
        return null;
    }

    @Override
    public CompraWithProductosDTO save(CompraWithProductosDTO compra) {
        Compra c = compraCrudRepository.save(mapper.toModel(compra));
        return null;
    }
}
