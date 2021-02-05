
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


    @Column(name = "notas", updatable = true, nullable = true, length = 200)
    private String notas;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Producto producto;


    public Edicion() { }


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

    public User getuser() {
        return user;
    }

    public void setuser(User user) {
        this.user = user;
    }

    public Producto getproducto() {
        return producto;
    }

    public void setproducto(Producto producto) {
        this.producto = producto;
    }

    public boolean equalsEdicion(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edicion edicion = (Edicion) o;
        return Objects.equals(id, edicion.id) ||
                Objects.equals(fechaEdicion, edicion.fechaEdicion) ||
                Objects.equals(notas, edicion.notas);

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

