package com.project.market_test.web.controller;

import java.util.List;

import com.project.market_test.domain.dto.CategoriaDTO;
import com.project.market_test.domain.dto.ProductoWithIDDTIO;
import com.project.market_test.domain.exceptions.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.market_test.domain.dto.ProductoDTO;
import com.project.market_test.domain.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public ResponseEntity<List<ProductoDTO>> getAll() {
        return new ResponseEntity<>(productoService.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getCompra(@PathVariable("id") long idProducto) {
        return productoService.getProducto(idProducto)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.ACCEPTED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<ResponseData> createProducto(@RequestBody ProductoDTO producto){
        try {
            return new ResponseEntity<>(new ResponseData(true, productoService.createProducto(producto)), HttpStatus.CREATED);
        } catch (RepositoryException re) {
            return new ResponseEntity<>(new ResponseData(false, re.getError()), HttpStatus.BAD_REQUEST);
        }
    }
}
