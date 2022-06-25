package com.project.market_test.web.controller;

import com.project.market_test.domain.dto.CompraDTO;
import com.project.market_test.domain.dto.CompraWithProductosDTO;
import com.project.market_test.domain.dto.ProductoDTO;
import com.project.market_test.domain.exceptions.RepositoryException;
import com.project.market_test.domain.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @GetMapping("/")
    public ResponseEntity<List<CompraDTO>> getAll() {
        return new ResponseEntity<>(compraService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraDTO> getCompra(@PathVariable("id") long idCompra) {
        return compraService.getCompra(idCompra)
                .map(compra -> new ResponseEntity<>(compra, HttpStatus.ACCEPTED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{id}/list")
    public ResponseEntity<CompraDTO> getCompraConProductos(@PathVariable("id") long idCompra) {
        return compraService.getCompraProductos(idCompra)
                .map(compra -> new ResponseEntity<>(compra, HttpStatus.ACCEPTED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<ResponseData> createCompra(@RequestBody CompraWithProductosDTO compra){
        try {
            return new ResponseEntity<>(new ResponseData(true, compraService.createCompra(compra)), HttpStatus.CREATED);
        } catch (RepositoryException re) {
            return new ResponseEntity<>(new ResponseData(false, re.getError()), HttpStatus.BAD_REQUEST);
        }
    }

}
