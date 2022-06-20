package com.project.market_test.persistence.crud;

import com.project.market_test.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

public interface CompraCrud extends CrudRepository<Compra, Long> {
}
