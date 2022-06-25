package com.project.market_test.web.controller;

import java.util.List;

import com.project.market_test.domain.exceptions.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.market_test.domain.dto.CategoriaDTO;
import com.project.market_test.domain.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public ResponseEntity<List<CategoriaDTO>> getAll() {
        return new ResponseEntity<>(categoriaService.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getCompra(@PathVariable("id") long idCategoria) {
        return categoriaService.getCategoria(idCategoria)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.ACCEPTED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/")
    public ResponseEntity<ResponseData> createCategoria(@RequestBody CategoriaDTO categoria){
        try {
            return new ResponseEntity<>(new ResponseData(true, categoriaService.createCategoria(categoria)), HttpStatus.CREATED);
        } catch (RepositoryException e) {
            return new ResponseEntity<>(new ResponseData(false, e.getError()), HttpStatus.BAD_REQUEST);
        }
    }

}
