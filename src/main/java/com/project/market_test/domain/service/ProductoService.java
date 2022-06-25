package com.project.market_test.domain.service;

import java.util.List;
import java.util.Optional;

import com.project.market_test.domain.dto.CategoriaDTO;
import com.project.market_test.domain.dto.ProductoWithIDDTIO;
import com.project.market_test.domain.exceptions.DATABASE_TYPES;
import com.project.market_test.domain.exceptions.DoesntFoundException;
import com.project.market_test.domain.exceptions.IncorrectDataException;
import com.project.market_test.domain.exceptions.RepositoryException;
import com.project.market_test.domain.repository.CategoriaDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.market_test.domain.dto.ProductoDTO;
import com.project.market_test.domain.repository.ProductoDTORepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoDTORepository productoDTORepository;
    @Autowired
    private CategoriaDTORepository categoriaDTORepository;

    public List<ProductoDTO> getAll() {
        return productoDTORepository.getAll();
    }

    public Optional<ProductoDTO> getProducto(long idProducto) {
        return productoDTORepository.getProduct(idProducto);
    }

    public ProductoDTO createProducto(ProductoDTO producto) throws RepositoryException {

        if(!producto.hasCorrectData())
            throw new IncorrectDataException(DATABASE_TYPES.PRODUCTO, producto.showErrors());
        Optional<CategoriaDTO> categoria = categoriaDTORepository.getCategoria(producto.getIdCategoria());
        if(categoria.isEmpty())
            throw new DoesntFoundException(DATABASE_TYPES.CATEGORIA, producto.getIdCategoria());
        ProductoDTO p = productoDTORepository.save(producto);
        p.setCategoria(categoria.get());
        return p;
    }

}
