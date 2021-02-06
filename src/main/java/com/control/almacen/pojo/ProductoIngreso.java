package com.control.almacen.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ProductoIngreso implements Serializable {

    private static final long serialVersionUID = -8082616262893765499L;

    private Long id;
    private String codigo;
    private String nombre;
    private String description;
    private Long cantidadInicial;
    private Long catidadActual;
    private String notas;
    private Boolean activo;
    private Date fechaIngreso;
    private String clasificacion;
    private List<AlmacenajeAreaPojo> areaAlmacenajeSystem = new ArrayList<>();
    private Date fechaUltimoIngreso;
    private Long ultimaCantidadIngesada;
    private Date fechaUltimaSalida;
    private Long ultimaCantidadSalida;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(Long cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public Long getCatidadActual() {
        return catidadActual;
    }

    public void setCatidadActual(Long catidadActual) {
        this.catidadActual = catidadActual;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public List<AlmacenajeAreaPojo> getAreaAlmacenajeSystem() {
        return areaAlmacenajeSystem;
    }

    public void setAreaAlmacenajeSystem(List<AlmacenajeAreaPojo> areaAlmacenajeSystem) {
        this.areaAlmacenajeSystem = areaAlmacenajeSystem;
    }

    public Date getFechaUltimoIngreso() {
        return fechaUltimoIngreso;
    }

    public void setFechaUltimoIngreso(Date fechaUltimoIngreso) {
        this.fechaUltimoIngreso = fechaUltimoIngreso;
    }

    public Long getUltimaCantidadIngesada() {
        return ultimaCantidadIngesada;
    }

    public void setUltimaCantidadIngesada(Long ultimaCantidadIngesada) {
        this.ultimaCantidadIngesada = ultimaCantidadIngesada;
    }

    public Date getFechaUltimaSalida() {
        return fechaUltimaSalida;
    }

    public void setFechaUltimaSalida(Date fechaUltimaSalida) {
        this.fechaUltimaSalida = fechaUltimaSalida;
    }

    public Long getUltimaCantidadSalida() {
        return ultimaCantidadSalida;
    }

    public void setUltimaCantidadSalida(Long ultimaCantidadSalida) {
        this.ultimaCantidadSalida = ultimaCantidadSalida;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoIngreso that = (ProductoIngreso) o;
        return Objects.equals(id, that.id) && Objects.equals(codigo, that.codigo) && Objects.equals(nombre, that.nombre) && Objects.equals(description, that.description) && Objects.equals(cantidadInicial, that.cantidadInicial) && Objects.equals(catidadActual, that.catidadActual) && Objects.equals(notas, that.notas) && Objects.equals(activo, that.activo) && Objects.equals(fechaIngreso, that.fechaIngreso) && Objects.equals(clasificacion, that.clasificacion) && Objects.equals(areaAlmacenajeSystem, that.areaAlmacenajeSystem) && Objects.equals(fechaUltimoIngreso, that.fechaUltimoIngreso) && Objects.equals(ultimaCantidadIngesada, that.ultimaCantidadIngesada) && Objects.equals(fechaUltimaSalida, that.fechaUltimaSalida) && Objects.equals(ultimaCantidadSalida, that.ultimaCantidadSalida) && Objects.equals(encargadoCodigo, that.encargadoCodigo) && Objects.equals(ticket, that.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, nombre, description, cantidadInicial, catidadActual, notas, activo, fechaIngreso, clasificacion, areaAlmacenajeSystem, fechaUltimoIngreso, ultimaCantidadIngesada, fechaUltimaSalida, ultimaCantidadSalida, encargadoCodigo, ticket);
    }


    @Override
    public String toString() {
        return "ProductoIngreso{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", description='" + description + '\'' +
                ", cantidadInicial=" + cantidadInicial +
                ", catidadActual=" + catidadActual +
                ", notas='" + notas + '\'' +
                ", activo=" + activo +
                ", fechaIngreso=" + fechaIngreso +
                ", clasificacion='" + clasificacion + '\'' +
                ", areaAlmacenajeSystem=" + areaAlmacenajeSystem +
                ", fechaUltimoIngreso=" + fechaUltimoIngreso +
                ", ultimaCantidadIngesada=" + ultimaCantidadIngesada +
                ", fechaUltimaSalida=" + fechaUltimaSalida +
                ", ultimaCantidadSalida=" + ultimaCantidadSalida +
                ", encargadoCodigo='" + encargadoCodigo + '\'' +
                ", ticket='" + ticket + '\'' +
                '}';
    }
}
