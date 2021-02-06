
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
import com.control.almacen.entitys.Cliente;


@Entity
@Table(name = "salidaproducto")
public class SalidaProducto implements Serializable {

    private static final long serialVersionUID = 7153563967952731487L;

    @Id
    @GeneratedValue(generator = "sequence_mat_id_generator")
    @SequenceGenerator(name = "sequence_mat_id_generator", initialValue = 25, allocationSize = 1000)
    @Column(name = "id", updatable = true, nullable = false, length = 25)
    private Long id;

    @Column(name = "fecha_de_salida", updatable = true, nullable = true, length = 200)
    private Date fechadesalida;

    @Column(name = "cantidad_de_salida", updatable = true, nullable = true, length = 200)
    private Long cantidadSalida;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cliente cliente;


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



    public SalidaProducto() {
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

    public Date getFechadesalida() {
        return fechadesalida;
    }

    public void setFechadesalida(Date fechadesalida) {
        this.fechadesalida = fechadesalida;
    }

    public Long getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(Long cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalidaProducto that = (SalidaProducto) o;
        return Objects.equals(id, that.id) && Objects.equals(fechadesalida, that.fechadesalida) && Objects.equals(cantidadSalida, that.cantidadSalida) && Objects.equals(cliente, that.cliente) && Objects.equals(ticket, that.ticket) && Objects.equals(idProductoEnBase, that.idProductoEnBase) && Objects.equals(codigoProducto, that.codigoProducto) && Objects.equals(nombreProducto, that.nombreProducto) && Objects.equals(catidadActual, that.catidadActual)  && Objects.equals(encargado, that.encargado) && Objects.equals(nota, that.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechadesalida, cantidadSalida, cliente, ticket, idProductoEnBase, codigoProducto, nombreProducto, catidadActual, encargado, nota);
    }

    @Override
    public String toString() {
        return "SalidaProducto{" +
                "id=" + id +
                ", fechadesalida=" + fechadesalida +
                ", cantidadSalida=" + cantidadSalida +
                ", cliente=" + cliente +
                ", ticket='" + ticket + '\'' +
                ", idProductoEnBase=" + idProductoEnBase +
                ", codigoProducto='" + codigoProducto + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", catidadActual=" + catidadActual +
                ", encargado='" + encargado + '\'' +
                ", nota='" + nota + '\'' +
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

