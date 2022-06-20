package com.project.market_test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.market_test.domain.dto.ClienteDTO;
import com.project.market_test.domain.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public ResponseEntity<List<ClienteDTO>> getAll() {
        return new ResponseEntity<>(clienteService.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getCompra(@PathVariable("id") String idCliente) {
        return clienteService.getCliente(idCliente)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.ACCEPTED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
