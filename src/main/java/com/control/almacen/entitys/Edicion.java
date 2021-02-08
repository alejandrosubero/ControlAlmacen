
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
import java.util.Objects;

import java.util.Date;



@Entity
@Table(name = "edicion")
public class Edicion implements Serializable {

    private static final long serialVersionUID = 4551123173705930281L;

    @Id
    @GeneratedValue(generator = "sequence_mat_id_generator")
    @SequenceGenerator(name = "sequence_mat_id_generator", initialValue = 25, allocationSize = 1000)
    @Column(name = "id", updatable = true, nullable = false, length = 25)
    private Long id;

    @Column(name = "fechaEdicion", updatable = true, nullable = true, length = 200)
    private Date fechaEdicion;

    @Column(name = "sacoproducto", updatable = true, nullable = true, length = 200)
    private boolean sacoproducto;

    @Column(name = "IncrementoProducto", updatable = true, nullable = true, length = 200)
    private boolean incrementoProducto;

    @Column(name = "editoNombre", updatable = true, nullable = true, length = 200)
    private boolean editoNombre;

    @Column(name = "desactivoProducto", updatable = true, nullable = true, length = 200)
    private boolean desactivoProducto;

    @Column(name = "modificoNota", updatable = true, nullable = true, length = 200)
    private boolean modificoNota;

    @Column(name = "modificoFechas", updatable = true, nullable = true, length = 200)
    private boolean modificoFechas;

    @Column(name = "notas", updatable = true, nullable = true, length = 200)
    private String notas;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_EdicionProductos")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Producto")
    private Producto producto;


    public Edicion() { }

    public Edicion( boolean sacoproducto, boolean incrementoProducto, boolean editoNombre, boolean desactivoProducto, boolean modificoNota, boolean modificoFechas, String notas, User user, Producto producto) {
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
        Edicion edicion = (Edicion) o;
        return sacoproducto == edicion.sacoproducto && incrementoProducto == edicion.incrementoProducto && editoNombre == edicion.editoNombre && desactivoProducto == edicion.desactivoProducto && modificoNota == edicion.modificoNota && modificoFechas == edicion.modificoFechas && Objects.equals(id, edicion.id) && Objects.equals(fechaEdicion, edicion.fechaEdicion) && Objects.equals(notas, edicion.notas) && Objects.equals(user, edicion.user) && Objects.equals(producto, edicion.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaEdicion, sacoproducto, incrementoProducto, editoNombre, desactivoProducto, modificoNota, modificoFechas, notas, user, producto);
    }


    @Override
    public String toString() {
        return "Edicion{" +
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

