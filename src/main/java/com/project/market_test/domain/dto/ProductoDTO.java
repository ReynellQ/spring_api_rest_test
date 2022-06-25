package com.project.market_test.domain.dto;

import java.util.HashMap;
import java.util.Map;

public class ProductoDTO implements AbstractDTO{
    private String nombre;
    private int idCategoria;
    private double precioVenta;
    private int cantidadStock;
    private boolean estado;
    private CategoriaDTO categoria;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean hasCorrectData() {
        return showErrors().isEmpty();
    }

    @Override
    public Map<String, String> showErrors() {
        Map<String, String> errors = new HashMap<>();
        if(nombre == null || nombre.trim().equals(""))
            errors.put("nombre", "Required.");
        if(idCategoria <= 0)
            errors.put("idCategoria", "Invalid category.");
        if(precioVenta <= 0.0)
            errors.put("precioVenta", "Invalid price.");
        if(cantidadStock < 0)
            errors.put("cantidadStock", "Invalid amount of stock.");
        return errors;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "nombre='" + nombre + '\'' +
                ", idCategoria=" + idCategoria +
                ", precioVenta=" + precioVenta +
                ", cantidadStock=" + cantidadStock +
                ", estado=" + estado +
                ", categoria=" + categoria +
                '}';
    }
}
