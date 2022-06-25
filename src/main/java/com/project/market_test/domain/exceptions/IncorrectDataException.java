package com.project.market_test.domain.exceptions;


import java.util.List;
import java.util.Map;

public class IncorrectDataException extends RepositoryException {
    private Map<String, String> errors;
    public IncorrectDataException(DATABASE_TYPES type, Map<String, String> errors) {
        super(type.name() + " doesn't match data.", type);
        this.errors = errors;
    }


    @Override
    public Object getError() {
        return errors;
    }
}
