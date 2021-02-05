
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
import com.control.almacen.entitys.Entrada;
import com.control.almacen.entitys.SalidaProducto;


@Entity
@Table(name = "inventario")
public class Inventario implements Serializable {

    private static final long serialVersionUID = 177871673505601669L;

    @Id
    @GeneratedValue(generator = "sequence_mat_id_generator")
    @SequenceGenerator(name = "sequence_mat_id_generator", initialValue = 25, allocationSize = 1000)
    @Column(name = "id", updatable = true, nullable = false, length = 25)
    private Long id;

    @Column(name = "nombre", updatable = true, nullable = true, length = 200)
    private String nombre;

    @Column(name = "fechaInventario", updatable = true, nullable = true, length = 200)
    private Date fechaInventario;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Producto> productos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Entrada> entrada = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = false)
    private List<SalidaProducto> salidas = new ArrayList<>();


    public Inventario() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechainventario() {
        return fechaInventario;
    }

    public void setFechainventario(Date fechaInventario) {
        this.fechaInventario = fechaInventario;
    }

    public List<Producto> getproductos() {
        return productos;
    }

    public void setproductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Entrada> getentrada() {
        return entrada;
    }

    public void setentrada(List<Entrada> entrada) {
        this.entrada = entrada;
    }

    public List<SalidaProducto> getsalidas() {
        return salidas;
    }

    public void setsalidas(List<SalidaProducto> salidas) {
        this.salidas = salidas;
    }

    public boolean equalsInventario(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventario inventario = (Inventario) o;
        return Objects.equals(id, inventario.id) ||
                Objects.equals(nombre, inventario.nombre) ||
                Objects.equals(fechaInventario, inventario.fechaInventario);

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

