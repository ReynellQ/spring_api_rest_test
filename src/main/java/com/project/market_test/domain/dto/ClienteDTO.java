package com.project.market_test.domain.dto;

import java.util.HashMap;
import java.util.Map;

public class ClienteDTO implements AbstractDTO{
    private String idCliente;
    private String nombre;
    private String apellidos;
    private long celular;
    private String direccion;
    private String correoElectronico;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Map<String, String> showErrors(){
        Map<String, String> err = new HashMap<>();
        if(nombre == null || nombre.trim().equals(""))
            err.put("nombre","Required.");
        if(idCliente== null || idCliente.trim().equals(""))
            err.put("idCliente","Required.");
        if( apellidos == null || apellidos.trim().equals(""))
            err.put("apellidos","Required.");
        if(correoElectronico == null || correoElectronico.trim().equals(""))
            err.put("correoElectronico","Required.");
        return err;
    }
    @Override
    public boolean hasCorrectData() {
        return showErrors().isEmpty();
    }
}
