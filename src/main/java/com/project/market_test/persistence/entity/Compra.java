package com.project.market_test.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long idCompra;

    @Column(name = "id_cliente")
    private Long idCliente;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "producto")
    private List<CompraProducto> compraProducto;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private Character medioPago;

    private Character estado;



    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Character getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(Character medioPago) {
        this.medioPago = medioPago;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<CompraProducto> getCompraProducto() {
        return compraProducto;
    }

    public void setCompraProducto(List<CompraProducto> compraProducto) {
        this.compraProducto = compraProducto;
    }
}
