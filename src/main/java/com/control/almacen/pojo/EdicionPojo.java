
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


import java.io.Serializable;
import java.util.Objects;

import java.util.Date;

import com.control.almacen.entitys.Producto;
import com.control.almacen.entitys.User;



public class EdicionPojo implements Serializable {

    private static final long serialVersionUID = -7452755048929886296L;

    private Long id;
    private Date fechaEdicion;
    private boolean sacoproducto;
    private boolean incrementoProducto;
    private boolean editoNombre;
    private boolean desactivoProducto;
    private boolean modificoNota;
    private boolean modificoFechas;
    private String notas;
    private User user;
    private Producto producto;


    public EdicionPojo (){ }

    public EdicionPojo( boolean sacoproducto, boolean incrementoProducto, boolean editoNombre, boolean desactivoProducto, boolean modificoNota, boolean modificoFechas, String notas, User user, Producto producto) {
        this.fechaEdicion = new Date();
        this.sacoproducto = sacoproducto;
        this.incrementoProducto = incrementoProducto;
        this.editoNombre = editoNombre;
        this.desactivoProducto = desactivoProducto;
        this.modificoNota = modificoNota;
        this.modificoFechas = modificoFechas;
        this.notas = notas;
        this.user = user;
        this.producto = producto;
    }

    /*
     * ACCIONES QUE ENTRAN POR EDICION DE PRODUCTO:
     * Regas logicas de la edicion:
     *
     * 1) si se desacyiva el producto hay que hacer una reconciliacion y modificar el producto
     * 2) si saco o itrodusco productos del inventario hay que hacer la reconsiliacion de productos, una entrada o salida segun sea el caso, y modificar el producto. Y EN NOTA QUE FUE POR EDICION DE PRODUCTO
     * 3) si se edita el nombre hay que hacer una reconsiliacion y modificar el producto.
     * 4) si se modifican fechas del producto hay que hacer una reconciliacion y modificar el producto.
     * 5) si se modifica las notas del producto solo se guarda la edicion y se modifica el producto.
     *
     *
     * */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public boolean isSacoproducto() {
        return sacoproducto;
    }

    public void setSacoproducto(boolean sacoproducto) {
        this.sacoproducto = sacoproducto;
    }

    public boolean isIncrementoProducto() {
        return incrementoProducto;
    }

    public void setIncrementoProducto(boolean incrementoProducto) {
        this.incrementoProducto = incrementoProducto;
    }

    public boolean isEditoNombre() {
        return editoNombre;
    }

    public void setEditoNombre(boolean editoNombre) {
        this.editoNombre = editoNombre;
    }

    public boolean isDesactivoProducto() {
        return desactivoProducto;
    }

    public void setDesactivoProducto(boolean desactivoProducto) {
        this.desactivoProducto = desactivoProducto;
    }

    public boolean isModificoNota() {
        return modificoNota;
    }

    public void setModificoNota(boolean modificoNota) {
        this.modificoNota = modificoNota;
    }

    public boolean isModificoFechas() {
        return modificoFechas;
    }

    public void setModificoFechas(boolean modificoFechas) {
        this.modificoFechas = modificoFechas;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EdicionPojo that = (EdicionPojo) o;
        return sacoproducto == that.sacoproducto && incrementoProducto == that.incrementoProducto && editoNombre == that.editoNombre && desactivoProducto == that.desactivoProducto && modificoNota == that.modificoNota && modificoFechas == that.modificoFechas && Objects.equals(id, that.id) && Objects.equals(fechaEdicion, that.fechaEdicion) && Objects.equals(notas, that.notas) && Objects.equals(user, that.user) && Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaEdicion, sacoproducto, incrementoProducto, editoNombre, desactivoProducto, modificoNota, modificoFechas, notas, user, producto);
    }

    @Override
    public String toString() {
        return "EdicionPojo{" +
                "id=" + id +
                ", fechaEdicion=" + fechaEdicion +
                ", sacoproducto=" + sacoproducto +
                ", incrementoProducto=" + incrementoProducto +
                ", editoNombre=" + editoNombre +
                ", desactivoProducto=" + desactivoProducto +
                ", modificoNota=" + modificoNota +
                ", modificoFechas=" + modificoFechas +
                ", notas='" + notas + '\'' +
                ", user=" + user +
                ", producto=" + producto +
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

