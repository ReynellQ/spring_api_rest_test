package com.project.market_test.domain.service;

import com.project.market_test.domain.dto.CompraDTO;
import com.project.market_test.domain.dto.CompraWithProductosDTO;
import com.project.market_test.domain.exceptions.RepositoryException;
import com.project.market_test.domain.repository.CompraDTORepository;
import net.bytebuddy.jar.asm.commons.Remapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
    @Autowired
    private CompraDTORepository compraDTORepository;

    public List<CompraDTO> getAll() {
        return compraDTORepository.getAll();
    }

    public Optional<CompraDTO> getCompra(long idCompra) {
        return compraDTORepository.getCompra(idCompra);
    }

    public CompraWithProductosDTO createCompra(CompraWithProductosDTO compra) throws RepositoryException {
        return null;
    }

    public Optional<CompraDTO> getCompraProductos(long idCompra) {
        return compraDTORepository.getCompraWithItems(idCompra);
    }
}
