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
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "apellidos", target = "apellidos"),
            @Mapping(source = "celular", target = "celular"),
            @Mapping(source = "direccion", target = "direccion"),
            @Mapping(source = "correoElectronico", target = "correoElectronico"),
    })
    ClienteDTO toDTO(Cliente cliente);

    List<ClienteDTO> toDTOs(List<Cliente> clientes);

    @InheritInverseConfiguration
    @Mapping(target = "compras", ignore = true)
    @Mapping(target = "idCliente", ignore = true)
    Cliente toModel(ClienteDTO clienteDTO);
}
