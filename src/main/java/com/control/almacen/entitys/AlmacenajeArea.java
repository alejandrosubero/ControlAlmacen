
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


@Entity
@Table(name = "almacenajearea")
public class AlmacenajeArea implements Serializable {

    private static final long serialVersionUID = -2570499912108070899L;

    @Id
    @GeneratedValue(generator = "sequence_mat_id_generator")
    @SequenceGenerator(name = "sequence_mat_id_generator", initialValue = 25, allocationSize = 1000)
    @Column(name = "id", updatable = true, nullable = false, length = 25)
    private Long id;


    @Column(name = "area", updatable = true, nullable = true, length = 200)
    private String area;


    @Column(name = "seccion", updatable = true, nullable = true, length = 200)
    private String seccion;


    @Column(name = "subseccion", updatable = true, nullable = true, length = 200)
    private String subseccion;


    @Column(name = "activo", updatable = true, nullable = true, length = 200)
    private Boolean activo;


    @Column(name = "nota", updatable = true, nullable = true, length = 200)
    private String nota;



    public AlmacenajeArea() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getSubseccion() {
        return subseccion;
    }

    public void setSubseccion(String subseccion) {
        this.subseccion = subseccion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public boolean equalsAlmacenajeArea(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlmacenajeArea almacenajearea = (AlmacenajeArea) o;
        return Objects.equals(id, almacenajearea.id) ||
                Objects.equals(area, almacenajearea.area) ||
                Objects.equals(seccion, almacenajearea.seccion) ||
                Objects.equals(subseccion, almacenajearea.subseccion) ||
                Objects.equals(nota, almacenajearea.nota) ||
                Objects.equals(activo, almacenajearea.activo);

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

