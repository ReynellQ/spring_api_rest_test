package com.project.market_test.domain.exceptions;


public class AlreadyCreatedException extends RepositoryException {
    public AlreadyCreatedException(DATABASE_TYPES type, Object id) {
        super(type.name() + " with id " + id.toString() +" already exists.", type);
    }

    @Override
    public Object getError() {
        return this.getMessage();
    }
}
