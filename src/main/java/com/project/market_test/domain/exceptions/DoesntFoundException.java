package com.project.market_test.domain.exceptions;

public class DoesntFoundException extends RepositoryException {
    public DoesntFoundException(DATABASE_TYPES type, Object id) {
        super(type.name() + " with id " + id.toString() +" doesn't exists.", type);
    }

    @Override
    public Object getError() {
        return getMessage();
    }
}
