package com.project.market_test.persistence.crud;

import com.project.market_test.persistence.entity.CompraProducto;
import com.project.market_test.persistence.entity.pk.CompraProductoPK;
import org.springframework.data.repository.CrudRepository;

public interface CompraProductoCrud extends CrudRepository<CompraProducto, CompraProductoPK> {
}
