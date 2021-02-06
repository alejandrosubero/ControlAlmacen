
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

import com.control.almacen.pojo.ProductoPojo;
import com.control.almacen.pojo.UserPojo;


public class EntradaPojo implements Serializable {

    private static final long serialVersionUID = -3296027187019360365L;

    private Long id;
    private Long cantidadIngresada;
    private Date fechaIngreso;
    private String ticket;
    private Long idProductoEnBase;
    private String codigoProducto;
    private String nombreProducto;
    private Long catidadActual;
    private String encargado;
    private String nota;



    public EntradaPojo() { }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Long getCantidadIngresada() {
        return cantidadIngresada;
    }

    public void setCantidadIngresada(Long cantidadIngresada) {
        this.cantidadIngresada = cantidadIngresada;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }


    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Long getIdProductoEnBase() {
        return idProductoEnBase;
    }

    public void setIdProductoEnBase(Long idProductoEnBase) {
        this.idProductoEnBase = idProductoEnBase;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Long getCatidadActual() {
        return catidadActual;
    }

    public void setCatidadActual(Long catidadActual) {
        this.catidadActual = catidadActual;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntradaPojo that = (EntradaPojo) o;
        return Objects.equals(id, that.id) && Objects.equals(nota, that.nota) && Objects.equals(cantidadIngresada, that.cantidadIngresada) && Objects.equals(fechaIngreso, that.fechaIngreso) && Objects.equals(encargado, that.encargado) && Objects.equals(ticket, that.ticket) && Objects.equals(idProductoEnBase, that.idProductoEnBase) && Objects.equals(codigoProducto, that.codigoProducto) && Objects.equals(nombreProducto, that.nombreProducto) && Objects.equals(catidadActual, that.catidadActual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nota, cantidadIngresada, fechaIngreso, encargado, ticket, idProductoEnBase, codigoProducto, nombreProducto, catidadActual);
    }

    @Override
    public String toString() {
        return "EntradaPojo{" +
                "id=" + id +
                ", nota='" + nota + '\'' +
                ", cantidadIngresada=" + cantidadIngresada +
                ", fechaIngreso=" + fechaIngreso +
                ", encargado=" + encargado +
                ", ticket='" + ticket + '\'' +
                ", idProductoEnBase=" + idProductoEnBase +
                ", codigoProducto='" + codigoProducto + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", catidadActual=" + catidadActual +
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

