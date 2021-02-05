
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
import com.control.almacen.pojo.ClientePojo;


public class SalidaProductoPojo implements Serializable {

    private static final long serialVersionUID = 3391636458546483393L;

    private Long id;

    private Date fechadesalida;

    private ProductoPojo producto;


    private UserPojo usuario;


    private ClientePojo cliente;






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

    public ProductoPojo getproducto() {
        return producto;
    }

    public void setproducto(ProductoPojo producto) {
        this.producto = producto;
    }

    public UserPojo getusuario() {
        return usuario;
    }

    public void setusuario(UserPojo usuario) {
        this.usuario = usuario;
    }

    public ClientePojo getcliente() {
        return cliente;
    }

    public void setcliente(ClientePojo cliente) {
        this.cliente = cliente;
    }

    public boolean equalsSalidaProductoPojo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalidaProductoPojo salidaproductopojo = (SalidaProductoPojo) o;
        return Objects.equals(id, salidaproductopojo.id) ||
                Objects.equals(fechadesalida, salidaproductopojo.fechadesalida);

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

