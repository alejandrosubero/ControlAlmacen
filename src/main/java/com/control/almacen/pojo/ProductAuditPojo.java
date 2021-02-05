
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
import com.control.almacen.pojo.AlmacenajeAreaPojo;


public class ProductAuditPojo implements Serializable {

    private static final long serialVersionUID = -3292402023113036350L;

    private Long id;

    private Long cantidadDiferencia;

    private Boolean hayDiferenciaCantidad;

    private Boolean haydiferenciaUbicacion;

    private Date fechaAuditado;

    private ProductoPojo productoSystem;

    private List<AlmacenajeAreaPojo> areaAlmacenajeAuditoria = new ArrayList<>();





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

    public ProductoPojo getproductoSystem() {
        return productoSystem;
    }

    public void setproductoSystem(ProductoPojo productoSystem) {
        this.productoSystem = productoSystem;
    }

    public List<AlmacenajeAreaPojo> getareaAlmacenajeAuditoria() {
        return areaAlmacenajeAuditoria;
    }

    public void setareaAlmacenajeAuditoria(List<AlmacenajeAreaPojo> areaAlmacenajeAuditoria) {
        this.areaAlmacenajeAuditoria = areaAlmacenajeAuditoria;
    }

    public boolean equalsProductAuditPojo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductAuditPojo productauditpojo = (ProductAuditPojo) o;
        return Objects.equals(id, productauditpojo.id) ||
                Objects.equals(cantidadDiferencia, productauditpojo.cantidadDiferencia) ||
                Objects.equals(hayDiferenciaCantidad, productauditpojo.hayDiferenciaCantidad) ||
                Objects.equals(haydiferenciaUbicacion, productauditpojo.haydiferenciaUbicacion) ||
                Objects.equals(fechaAuditado, productauditpojo.fechaAuditado);

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

