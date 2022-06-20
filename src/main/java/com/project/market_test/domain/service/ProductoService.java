package com.project.market_test.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.market_test.domain.dto.ProductoDTO;
import com.project.market_test.domain.repository.ProductoDTORepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoDTORepository productoDTORepository;

    public List<ProductoDTO> getAll() {
        return productoDTORepository.getAll();
    }

    public Optional<ProductoDTO> getProducto(long idProducto) {
        return productoDTORepository.getProduct(idProducto);
    }

}
