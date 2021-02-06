package com.control.almacen.pojo;

import com.control.almacen.entitys.AlmacenajeArea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ProductoIngreso implements Serializable {

    private static final long serialVersionUID = -8082616262893765499L;

//    private String codigo;
//    private String nombre;
//    private String description;
//    private Long cantidadInicial;
//    private Long catidadActual;
//    private String notas;
//    private Boolean activo;
//    private Date fechaIngreso;
//    private String clasificacion;
//    private List<AlmacenajeArea> areaAlmacenajeSystem = new ArrayList<AlmacenajeArea>();
//    private Date fechaUltimoIngreso;
//    private Long ultimaCantidadIngesada;
//    private Date fechaUltimaSalida;
//    private Long ultimaCantidadSalida;

    private Long id;
    private ProductoPojo producto;
    private String encargadoCodigo;
    private String ticket;

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
}
