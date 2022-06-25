package com.project.market_test.domain.dto;

import java.util.List;

public class CompraWithProductosDTO extends CompraDTO{
    private List<CompraItemDTO> compraProducto;

    public List<CompraItemDTO> getCompraProducto() {
        return compraProducto;
    }

    public void setCompraProducto(List<CompraItemDTO> compraProducto) {
        this.compraProducto = compraProducto;
    }
}
