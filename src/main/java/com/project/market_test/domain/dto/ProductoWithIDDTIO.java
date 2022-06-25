package com.project.market_test.domain.dto;

public class ProductoWithIDDTIO extends ProductoDTO{
    private long idProducto;

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "ProductoWithIDDTIO{" +
                "idProducto=" + idProducto + ", "+
                super.toString() +
                '}';
    }
}
