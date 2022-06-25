package com.project.market_test.domain.service;

import java.util.List;
import java.util.Optional;

import com.project.market_test.domain.exceptions.AlreadyCreatedException;
import com.project.market_test.domain.exceptions.DATABASE_TYPES;
import com.project.market_test.domain.exceptions.IncorrectDataException;
import com.project.market_test.domain.exceptions.RepositoryException;
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

    public Optional<ClienteDTO> getCliente(String idCliente) {
        return clienteDTORepository.getCliente(idCliente);
    }

    public ClienteDTO createCliente(ClienteDTO cliente) throws RepositoryException {
        if(!cliente.hasCorrectData())
            throw new IncorrectDataException(DATABASE_TYPES.CLIENTE, cliente.showErrors());
        if(getCliente(cliente.getIdCliente()).isPresent())
            throw new AlreadyCreatedException(DATABASE_TYPES.CLIENTE, cliente.getIdCliente());
        return clienteDTORepository.save(cliente);
    }
}
