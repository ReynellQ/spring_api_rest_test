package com.project.market_test.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.market_test.domain.dto.ClienteDTO;
import com.project.market_test.domain.repository.ClienteDTORepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteDTORepository clienteDTORepository;

    public List<ClienteDTO> getAll() {
        return clienteDTORepository.getAll();
    }

    public Optional<ClienteDTO> getCliente(long idCliente) {
        return clienteDTORepository.getCliente(idCliente);
    }

}
