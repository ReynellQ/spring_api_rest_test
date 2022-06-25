package com.project.market_test.web.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.project.market_test.domain.exceptions.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ClienteDTO> getCliente(@PathVariable("id") String idCliente) {
        Optional<ClienteDTO> data = clienteService.getCliente(idCliente);
        if(data.isPresent())
            return new ResponseEntity<>(data.get(), HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<ResponseData> save(@RequestBody ClienteDTO cliente) {
        try{
            return new ResponseEntity<>(new ResponseData(true, clienteService.createCliente(cliente)), HttpStatus.CREATED);
        }catch (RepositoryException re){
            return new ResponseEntity<>(new ResponseData(false, re.getError()), HttpStatus.BAD_REQUEST);
        }
    }
}
