
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

import com.control.almacen.pojo.UserPojo;
import com.control.almacen.pojo.ProductoPojo;


public class EdicionPojo implements Serializable {

    private static final long serialVersionUID = -7452755048929886296L;

    private Long id;

    private Date fechaEdicion;

    private String notas;

    private UserPojo user;

    private ProductoPojo producto;

    public EdicionPojo (){ }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaedicion() {
        return fechaEdicion;
    }

    public void setFechaedicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public UserPojo getuser() {
        return user;
    }

    public void setuser(UserPojo user) {
        this.user = user;
    }

    public ProductoPojo getproducto() {
        return producto;
    }

    public void setproducto(ProductoPojo producto) {
        this.producto = producto;
    }


    public boolean equalsEdicionPojo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EdicionPojo edicionpojo = (EdicionPojo) o;
        return Objects.equals(id, edicionpojo.id) ||
                Objects.equals(fechaEdicion, edicionpojo.fechaEdicion) ||
                Objects.equals(notas, edicionpojo.notas);

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

