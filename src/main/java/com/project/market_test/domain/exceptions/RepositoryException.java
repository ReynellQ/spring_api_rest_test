package com.project.market_test.domain.exceptions;

public abstract class RepositoryException extends Exception{
    private DATABASE_TYPES type;

    public RepositoryException(String message, DATABASE_TYPES type) {
        super(message);
        this.type = type;
    }

    public abstract Object getError();

}

