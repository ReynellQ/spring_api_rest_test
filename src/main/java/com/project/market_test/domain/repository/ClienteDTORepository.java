package com.project.market_test.domain.repository;

import java.util.List;
import java.util.Optional;

import com.project.market_test.domain.dto.ClienteDTO;

public interface ClienteDTORepository {
    List<ClienteDTO> getAll();

    Optional<ClienteDTO> getCliente(long idCliente);
}
