
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
import com.control.almacen.entitys.AlmacenajeArea;


@Entity
@Table(name = "productaudit")
public class ProductAudit implements Serializable {

    private static final long serialVersionUID = 3303874560810938336L;

    @Id
    @GeneratedValue(generator = "sequence_mat_id_generator")
    @SequenceGenerator(name = "sequence_mat_id_generator", initialValue = 25, allocationSize = 1000)
    @Column(name = "id", updatable = true, nullable = false, length = 200)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Producto productoSystem;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = false)
    private List<AlmacenajeArea> areaAlmacenajeAuditoria = new ArrayList<>();


    @Column(name = "cantidadDiferencia", updatable = true, nullable = true, length = 200)
    private Long cantidadDiferencia;


    @Column(name = "hayDiferenciaCantidad", updatable = true, nullable = true)
    private Boolean hayDiferenciaCantidad;


    @Column(name = "haydiferenciaUbicacion", updatable = true, nullable = true)
    private Boolean haydiferenciaUbicacion;


    @Column(name = "fechaAuditado", updatable = true, nullable = true)
    private Date fechaAuditado;




    public ProductAudit() { }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCantidaddiferencia() {
        return cantidadDiferencia;
    }

    public void setCantidaddiferencia(Long cantidadDiferencia) {
        this.cantidadDiferencia = cantidadDiferencia;
    }

    public Boolean getHaydiferenciacantidad() {
        return hayDiferenciaCantidad;
    }

    public void setHaydiferenciacantidad(Boolean hayDiferenciaCantidad) {
        this.hayDiferenciaCantidad = hayDiferenciaCantidad;
    }

    public Boolean getHaydiferenciaubicacion() {
        return haydiferenciaUbicacion;
    }

    public void setHaydiferenciaubicacion(Boolean haydiferenciaUbicacion) {
        this.haydiferenciaUbicacion = haydiferenciaUbicacion;
    }

    public Date getFechaauditado() {
        return fechaAuditado;
    }

    public void setFechaauditado(Date fechaAuditado) {
        this.fechaAuditado = fechaAuditado;
    }

    public Producto getproductoSystem() {
        return productoSystem;
    }

    public void setproductoSystem(Producto productoSystem) {
        this.productoSystem = productoSystem;
    }

    public List<AlmacenajeArea> getareaAlmacenajeAuditoria() {
        return areaAlmacenajeAuditoria;
    }

    public void setareaAlmacenajeAuditoria(List<AlmacenajeArea> areaAlmacenajeAuditoria) {
        this.areaAlmacenajeAuditoria = areaAlmacenajeAuditoria;
    }

    public boolean equalsProductAudit(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductAudit productaudit = (ProductAudit) o;
        return Objects.equals(id, productaudit.id) ||
                Objects.equals(cantidadDiferencia, productaudit.cantidadDiferencia) ||
                Objects.equals(hayDiferenciaCantidad, productaudit.hayDiferenciaCantidad) ||
                Objects.equals(haydiferenciaUbicacion, productaudit.haydiferenciaUbicacion) ||
                Objects.equals(fechaAuditado, productaudit.fechaAuditado);

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

