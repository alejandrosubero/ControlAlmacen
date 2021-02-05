/*
Create on Sat Jan 30 15:24:38 ART 2021
*Copyright (C) 121.
@author alejandro
@author Hugo Luna
@author ANACODE AND IVANCODE
@since 11.0
@version1.0.0.0
@version  %I%, %G%
*<p>Description: control de  almacen </p>
*/


package com.control.almacen.validation ;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;import java.util.Date;

import com.control.almacen.entitys.Producto;import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import com.control.almacen.pojo.ProductoPojo;import com.control.almacen.pojo.ProductoPojo;import com.control.almacen.entitys.AlmacenajeArea;
import com.control.almacen.pojo.AlmacenajeAreaPojo;



    @Service
    public class ProductoValidation {

        public ProductoPojo valida(ProductoPojo producto) {
        ProductoPojo pojo = null;
        try {
             if (producto != null) {
              if (
        producto.getId() != null &&
        producto.getCodigo() != null &&
        producto.getNombre() != null &&
        producto.getDescription() != null &&
        producto.getCantidadInicial() != null &&
        producto.getCatidadActual() != null &&
        producto.getNotas() != null &&
        producto.getActivo() != null &&
        producto.getFechaIngreso() != null &&
        producto.getClasificacion() != null        ) {
        pojo = producto;
         }
        }
            return pojo;
        } catch (Exception e) {
            e.printStackTrace();
            return pojo;
        }
    }
// remplace de name of variable for you proyecte
    public Long valida_id( String poder) {
             Long id_Delete = 0l;        try {
          if (poder != null) {
          if (poder.length() > 0 && !Pattern.matches("[a-zA-Z]+", poder)) {
         id_Delete = Long.parseLong(poder);            }
        }
            return id_Delete;
        } catch (Exception e) {
            e.printStackTrace();
            return id_Delete;
        }
    }
    public <T> Object validation(T t) {
         T elemento = null;
        try {
        if (t != null) {
            elemento = t;
        }
            return elemento;
        } catch (Exception e) {
            e.printStackTrace();
            return elemento;
        }
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


