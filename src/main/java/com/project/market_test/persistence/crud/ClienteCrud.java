package com.project.market_test.persistence.crud;

import com.project.market_test.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrud extends CrudRepository<Cliente, String> {
}
