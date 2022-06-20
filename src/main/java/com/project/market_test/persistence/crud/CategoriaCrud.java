package com.project.market_test.persistence.crud;

import com.project.market_test.persistence.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaCrud extends CrudRepository<Categoria, Long> {
}
