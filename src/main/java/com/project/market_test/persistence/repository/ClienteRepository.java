package com.project.market_test.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.market_test.domain.dto.ClienteDTO;
import com.project.market_test.domain.repository.ClienteDTORepository;
import com.project.market_test.persistence.crud.ClienteCrud;
import com.project.market_test.persistence.entity.Cliente;
import com.project.market_test.persistence.mapper.ClienteMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository implements ClienteDTORepository {
    @Autowired
    private ClienteCrud clienteCrud;
    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public List<ClienteDTO> getAll() {
        return clienteMapper.toDTOs((List<Cliente>) clienteCrud.findAll());
    }

    @Override
    public Optional<ClienteDTO> getCliente(String idCliente) {
        return clienteCrud.findById(idCliente).map(cliente -> clienteMapper.toDTO(cliente));
    }

}
