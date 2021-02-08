package com.control.almacen.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "reconsiliacionProductos")
public class ReconsiliacionProductos implements Serializable {

    private static final long serialVersionUID = -1222681018741359875L;

    @Id
    @GeneratedValue(generator = "sequence_mat_id_generator")
    @SequenceGenerator(name = "sequence_mat_id_generator", initialValue = 25, allocationSize = 1000)
    @Column(name = "id", updatable = true, nullable = false, length = 25)
    private Long id;

    @Column(name = "codigo", updatable = true, nullable = true, length = 200)
    private String codigo;

    @Column(name = "nombre", updatable = true, nullable = true, length = 200)
    private String nombre;

    @Column(name = "description", updatable = true, nullable = true, length = 3000)
    private String description;

    @Column(name = "cantidadInicial", updatable = true, nullable = true)
    private Long cantidadInicial;

    @Column(name = "catidadActual", updatable = true, nullable = true)
    private Long catidadActual;

    @Column(name = "notas", updatable = true, nullable = true, length = 4000)
    private String notas;

    @Column(name = "activo", updatable = true, nullable = true)
    private Boolean activo;

    @Column(name = "fechaIngreso", updatable = true, nullable = true)
    private Date fechaIngreso;

    @Column(name = "clasificacion", updatable = true, nullable = true, length = 500)
    private String clasificacion;

    @Column(name = "fecha_Ultimo_Ingreso", updatable = true, nullable = true)
    private Date fechaUltimoIngreso;

    @Column(name = "ultima_Cantidad_Ingesada", updatable = true, nullable = true)
    private Long ultimaCantidadIngesada;

    @Column(name = "fecha_Ultima_Salida", updatable = true, nullable = true)
    private Date fechaUltimaSalida;

    @Column(name = "ultima_Cantidad_Salida", updatable = true, nullable = true)
    private Long ultimaCantidadSalida;

    @Column(name = "fecha", updatable = true, nullable = true, length = 200)
    private Date fecha;

    @Column(name = "ticket", updatable = true, nullable = true, length = 200)
    private String ticket;

    @Column(name = "codigoUser", updatable = true, nullable = true, length = 200)
    private String encargado;
    public ReconsiliacionProductos() {}

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = false)
    @JoinColumn(name = "id_ReconsiliacionProductos")
    private List<AlmacenajeArea> areaAlmacenajeSystem = new ArrayList<>();


    public ReconsiliacionProductos(Producto producto, Entrada entrada) {
            this.mapperProducto(producto);
            this.fecha = entrada.getFechaIngreso();
            this.ticket = entrada.getTicket();
            this.encargado = entrada.getEncargado();
        }


    public ReconsiliacionProductos(Producto producto, SalidaProducto salida) {
        this.mapperProducto(producto);
        this.fecha = salida.getFechadesalida();
        this.ticket = salida.getTicket();
        this.encargado = salida.getEncargado();
    }

    public ReconsiliacionProductos(Producto producto, Date fecha, String ticket, String encargado) {
        this.mapperProducto(producto);
        this.fecha = fecha;
        this.ticket = ticket;
        this.encargado = encargado;
    }

    public void mapperProducto (Producto producto) {
        this.codigo = producto.getCodigo();
        this.nombre = producto.getNombre();
        this.description = producto.getDescription();
        this.cantidadInicial = producto.getCantidadInicial();
        this.catidadActual = producto.getCatidadActual();
        this.notas = producto.getNotas();
        this.activo = producto.getActivo();
        this.fechaIngreso = producto.getFechaIngreso();
        this.clasificacion = producto.getClasificacion();
        this.areaAlmacenajeSystem = producto.getAreaAlmacenajeSystem();
        this.fechaUltimoIngreso = producto.getFechaUltimoIngreso();
        this.ultimaCantidadIngesada = producto.getUltimaCantidadIngesada();
        this.fechaUltimaSalida = producto.getFechaUltimaSalida();
        this.ultimaCantidadSalida = producto.getUltimaCantidadSalida();
    }



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

    public List<AlmacenajeArea> getAreaAlmacenajeSystem() {
        return areaAlmacenajeSystem;
    }

    public void setAreaAlmacenajeSystem(List<AlmacenajeArea> areaAlmacenajeSystem) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReconsiliacionProductos that = (ReconsiliacionProductos) o;
        return Objects.equals(id, that.id) && Objects.equals(codigo, that.codigo) && Objects.equals(nombre, that.nombre) && Objects.equals(description, that.description) && Objects.equals(cantidadInicial, that.cantidadInicial) && Objects.equals(catidadActual, that.catidadActual) && Objects.equals(notas, that.notas) && Objects.equals(activo, that.activo) && Objects.equals(fechaIngreso, that.fechaIngreso) && Objects.equals(clasificacion, that.clasificacion) && Objects.equals(areaAlmacenajeSystem, that.areaAlmacenajeSystem) && Objects.equals(fechaUltimoIngreso, that.fechaUltimoIngreso) && Objects.equals(ultimaCantidadIngesada, that.ultimaCantidadIngesada) && Objects.equals(fechaUltimaSalida, that.fechaUltimaSalida) && Objects.equals(ultimaCantidadSalida, that.ultimaCantidadSalida) && Objects.equals(fecha, that.fecha) && Objects.equals(ticket, that.ticket) && Objects.equals(encargado, that.encargado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, nombre, description, cantidadInicial, catidadActual, notas, activo, fechaIngreso, clasificacion, areaAlmacenajeSystem, fechaUltimoIngreso, ultimaCantidadIngesada, fechaUltimaSalida, ultimaCantidadSalida, fecha, ticket, encargado);
    }

    @Override
    public String toString() {
        return "ReconsiliacionProductos{" +
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
                ", fecha=" + fecha +
                ", ticket='" + ticket + '\'' +
                ", encargado='" + encargado + '\'' +
                '}';
    }
}
