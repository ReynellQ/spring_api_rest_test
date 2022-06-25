package com.project.market_test.persistence.mapper;

import com.project.market_test.domain.dto.ClienteDTO;
import com.project.market_test.persistence.entity.Cliente;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    @Mappings({
    })
    ClienteDTO toDTO(Cliente cliente);

    List<ClienteDTO> toDTOs(List<Cliente> clientes);

    @InheritInverseConfiguration
    @Mapping(target = "compras", ignore = true)
    Cliente toModel(ClienteDTO clienteDTO);
}
