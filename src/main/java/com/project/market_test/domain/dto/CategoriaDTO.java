package com.project.market_test.domain.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriaDTO implements AbstractDTO{
    private String descripcion;
    private Boolean estado;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public boolean hasCorrectData() {
        if(descripcion == null || descripcion.trim().equals(""))
            return false;
        if(estado == null)
            return false;
        return true;
    }

    @Override
    public Map<String, String> showErrors() {
        Map <String, String> errors = new HashMap<>();
        if(descripcion == null || descripcion.trim().equals(""))
            errors.put("descripcion", "Required.");
        if(estado == null)
            errors.put("estado", "Required.");
        return errors;
    }
}
