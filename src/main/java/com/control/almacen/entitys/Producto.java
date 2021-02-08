
/*
Create on Sat Jan 30 15:23:00 ART 2021
*Copyright (C) 121.
@author alejandro
@author Hugo Luna
@author ANACODE AND IVANCODE
@since 11.0
@version1.0.0.0
@version  %I%, %G%
*<p>Description: control de  almacen </p>
*/

package com.control.almacen.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.Date;

import com.control.almacen.entitys.AlmacenajeArea;


@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 5461759808362820003L;

    @Id
    @GeneratedValue(generator = "sequence_mat_id_generator")
    @SequenceGenerator(name = "sequence_mat_id_generator", initialValue = 25, allocationSize = 1000)
    @Column(name = "id", updatable = true, nullable = false, length = 200)
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


    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = false)
    @JoinColumn(name = "id_Product")
    private List<AlmacenajeArea> areaAlmacenajeSystem = new ArrayList<>();


    public Producto() { }


    public void setAreaAlmacen(List<AlmacenajeArea> almacen){
        this.areaAlmacenajeSystem = almacen;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id) && Objects.equals(codigo, producto.codigo) && Objects.equals(nombre, producto.nombre) && Objects.equals(description, producto.description) && Objects.equals(cantidadInicial, producto.cantidadInicial) && Objects.equals(catidadActual, producto.catidadActual) && Objects.equals(notas, producto.notas) && Objects.equals(activo, producto.activo) && Objects.equals(fechaIngreso, producto.fechaIngreso) && Objects.equals(clasificacion, producto.clasificacion) && Objects.equals(areaAlmacenajeSystem, producto.areaAlmacenajeSystem) && Objects.equals(fechaUltimoIngreso, producto.fechaUltimoIngreso) && Objects.equals(ultimaCantidadIngesada, producto.ultimaCantidadIngesada) && Objects.equals(fechaUltimaSalida, producto.fechaUltimaSalida) && Objects.equals(ultimaCantidadSalida, producto.ultimaCantidadSalida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, nombre, description, cantidadInicial, catidadActual, notas, activo, fechaIngreso, clasificacion, areaAlmacenajeSystem, fechaUltimoIngreso, ultimaCantidadIngesada, fechaUltimaSalida, ultimaCantidadSalida);
    }

    @Override
    public String toString() {
        return "Producto{" +
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
                '}';
    }
}
 /*
 Copyright (C) 2008 Google Inc.
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

