
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


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Producto producto;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User usuario;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cliente cliente;


    public SalidaProducto() {
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

    public Producto getproducto() {
        return producto;
    }

    public void setproducto(Producto producto) {
        this.producto = producto;
    }

    public User getusuario() {
        return usuario;
    }

    public void setusuario(User usuario) {
        this.usuario = usuario;
    }

    public Cliente getcliente() {
        return cliente;
    }

    public void setcliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean equalsSalidaProducto(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalidaProducto salidaproducto = (SalidaProducto) o;
        return Objects.equals(id, salidaproducto.id) ||
                Objects.equals(fechadesalida, salidaproducto.fechadesalida);

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

