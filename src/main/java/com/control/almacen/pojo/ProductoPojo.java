
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

package com.control.almacen.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.Date;

import com.control.almacen.pojo.AlmacenajeAreaPojo;


public class ProductoPojo implements Serializable {

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


    public ProductoPojo() { }


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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoPojo that = (ProductoPojo) o;
        return Objects.equals(id, that.id) && Objects.equals(codigo, that.codigo) && Objects.equals(nombre, that.nombre) && Objects.equals(description, that.description) && Objects.equals(cantidadInicial, that.cantidadInicial) && Objects.equals(catidadActual, that.catidadActual) && Objects.equals(notas, that.notas) && Objects.equals(activo, that.activo) && Objects.equals(fechaIngreso, that.fechaIngreso) && Objects.equals(clasificacion, that.clasificacion) && Objects.equals(areaAlmacenajeSystem, that.areaAlmacenajeSystem) && Objects.equals(fechaUltimoIngreso, that.fechaUltimoIngreso) && Objects.equals(ultimaCantidadIngesada, that.ultimaCantidadIngesada) && Objects.equals(fechaUltimaSalida, that.fechaUltimaSalida) && Objects.equals(ultimaCantidadSalida, that.ultimaCantidadSalida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, nombre, description, cantidadInicial, catidadActual, notas, activo, fechaIngreso, clasificacion, areaAlmacenajeSystem, fechaUltimoIngreso, ultimaCantidadIngesada, fechaUltimaSalida, ultimaCantidadSalida);
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

