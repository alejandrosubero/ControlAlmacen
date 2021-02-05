
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

    private String nota;

    private Long cantidadIngresada;

    private String fechaIngreso;

    private ProductoPojo producto;


    private UserPojo encargado;






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

    public Long getCantidadingresada() {
        return cantidadIngresada;
    }

    public void setCantidadingresada(Long cantidadIngresada) {
        this.cantidadIngresada = cantidadIngresada;
    }

    public String getFechaingreso() {
        return fechaIngreso;
    }

    public void setFechaingreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public ProductoPojo getproducto() {
        return producto;
    }

    public void setproducto(ProductoPojo producto) {
        this.producto = producto;
    }

    public UserPojo getencargado() {
        return encargado;
    }

    public void setencargado(UserPojo encargado) {
        this.encargado = encargado;
    }

    public boolean equalsEntradaPojo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntradaPojo entradapojo = (EntradaPojo) o;
        return Objects.equals(id, entradapojo.id) ||
                Objects.equals(nota, entradapojo.nota) ||
                Objects.equals(cantidadIngresada, entradapojo.cantidadIngresada) ||
                Objects.equals(fechaIngreso, entradapojo.fechaIngreso);

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

