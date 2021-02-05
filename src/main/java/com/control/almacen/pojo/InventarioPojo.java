
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
import com.control.almacen.pojo.EntradaPojo;
import com.control.almacen.pojo.SalidaProductoPojo;


public class InventarioPojo implements Serializable {

    private static final long serialVersionUID = 906905681261506863L;

    private Long id;

    private String nombre;

    private Date fechaInventario;

    private List<ProductoPojo> productos = new ArrayList<>();

    private List<EntradaPojo> entrada = new ArrayList<>();

    private List<SalidaProductoPojo> salidas = new ArrayList<>();





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

    public List<ProductoPojo> getproductos() {
        return productos;
    }

    public void setproductos(List<ProductoPojo> productos) {
        this.productos = productos;
    }

    public List<EntradaPojo> getentrada() {
        return entrada;
    }

    public void setentrada(List<EntradaPojo> entrada) {
        this.entrada = entrada;
    }

    public List<SalidaProductoPojo> getsalidas() {
        return salidas;
    }

    public void setsalidas(List<SalidaProductoPojo> salidas) {
        this.salidas = salidas;
    }

    public boolean equalsInventarioPojo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventarioPojo inventariopojo = (InventarioPojo) o;
        return Objects.equals(id, inventariopojo.id) ||
                Objects.equals(nombre, inventariopojo.nombre) ||
                Objects.equals(fechaInventario, inventariopojo.fechaInventario);

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

