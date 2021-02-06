
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

import com.control.almacen.entitys.Producto;
import com.control.almacen.entitys.User;


@Entity
@Table(name = "entrada")
public class Entrada implements Serializable {

    private static final long serialVersionUID = -2597484344132328442L;

    @Id
    @GeneratedValue(generator = "sequence_mat_id_generator")
    @SequenceGenerator(name = "sequence_mat_id_generator", initialValue = 25, allocationSize = 1000)
    @Column(name = "id", updatable = true, nullable = false, length = 25)
    private Long id;

    @Column(name = "cantidad_Ingresada", updatable = true, nullable = true, length = 200)
    private Long cantidadIngresada;


    @Column(name = "fecha_Ingreso", updatable = true, nullable = true)
    private Date fechaIngreso;


    @Column(name = "ticket", updatable = true, nullable = true, length = 200)
    private String ticket;

    @Column(name = "idProductoEnBase", updatable = true, nullable = true, length = 2000)
    private Long idProductoEnBase;


    @Column(name = "codigo_Producto", updatable = true, nullable = true, length = 200)
    private String codigoProducto;


    @Column(name = "nombre_Producto", updatable = true, nullable = true, length = 200)
    private String nombreProducto;


    @Column(name = "catidadActual", updatable = true, nullable = true)
    private Long catidadActual;


    @Column(name = "codigoUser", updatable = true, nullable = true, length = 200)
    private String encargado;

    @Column(name = "nota", updatable = true, nullable = true, length = 200)
    private String nota;


    public Entrada() {
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

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
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
        Entrada entrada = (Entrada) o;
        return Objects.equals(id, entrada.id) && Objects.equals(cantidadIngresada, entrada.cantidadIngresada) && Objects.equals(fechaIngreso, entrada.fechaIngreso) && Objects.equals(encargado, entrada.encargado) && Objects.equals(nota, entrada.nota) && Objects.equals(ticket, entrada.ticket) && Objects.equals(idProductoEnBase, entrada.idProductoEnBase) && Objects.equals(codigoProducto, entrada.codigoProducto) && Objects.equals(nombreProducto, entrada.nombreProducto) && Objects.equals(catidadActual, entrada.catidadActual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidadIngresada, fechaIngreso, encargado, nota, ticket, idProductoEnBase, codigoProducto, nombreProducto, catidadActual);
    }


    @Override
    public String toString() {
        return "Entrada{" +
                "id=" + id +
                ", cantidadIngresada=" + cantidadIngresada +
                ", fechaIngreso=" + fechaIngreso +
                ", encargado=" + encargado +
                ", nota='" + nota + '\'' +
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

