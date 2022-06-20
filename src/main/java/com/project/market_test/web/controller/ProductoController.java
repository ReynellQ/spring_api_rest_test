package com.project.market_test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
