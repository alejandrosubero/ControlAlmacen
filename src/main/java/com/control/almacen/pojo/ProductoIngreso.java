package com.control.almacen.pojo;


import com.control.almacen.entitys.Cliente;

import java.io.Serializable;


public class ProductoIngreso implements Serializable {

    private static final long serialVersionUID = -8082616262893765499L;

    private Long id;
    private ProductoPojo producto;
    private String encargadoCodigo;
    private String ticket;
    private Boolean salida;
    private Cliente cliente;


    public ProductoIngreso() {}


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductoPojo getProducto() {
        return producto;
    }

    public void setProducto(ProductoPojo producto) {
        this.producto = producto;
    }

    public String getEncargadoCodigo() {
        return encargadoCodigo;
    }

    public void setEncargadoCodigo(String encargadoCodigo) {
        this.encargadoCodigo = encargadoCodigo;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Boolean getSalida() {
        return salida;
    }

    public void setSalida(Boolean salida) {
        this.salida = salida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
