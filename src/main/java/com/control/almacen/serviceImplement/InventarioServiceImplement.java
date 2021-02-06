
/*
Create on Sat Jan 30 15:24:05 ART 2021
*Copyright (C) 121.
@author alejandro
@author Hugo Luna
@author ANACODE AND IVANCODE
@since 11.0
@version1.0.0.0
@version  %I%, %G%
*<p>Description: control de  almacen </p>
*/


package com.control.almacen.serviceImplement;

import com.control.almacen.entitys.*;
import com.control.almacen.service.InventarioService;
import com.control.almacen.repository.InventarioRepository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.*;


@Service
public class InventarioServiceImplement implements InventarioService {

    protected static final Log logger = LogFactory.getLog(InventarioServiceImplement.class);
    @Autowired
    private InventarioRepository inventariorepository;

    @Override
    public Inventario findByNombre(String nombre) {
        logger.info("Starting getInventario");
        Inventario inventarioEntity = new Inventario();
        Optional<Inventario> fileOptional1 = inventariorepository.findByNombre(nombre);
        if (fileOptional1.isPresent()) {
            try {
                inventarioEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return inventarioEntity;
    }

    @Override
    public Inventario findByFechaInventario(Date fechaInventario) {

        logger.info("Starting getInventario");
        Inventario inventarioEntity = new Inventario();
        Optional<Inventario> fileOptional1 = inventariorepository.findByFechaInventario(fechaInventario);
        if (fileOptional1.isPresent()) {
            try {
                inventarioEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return inventarioEntity;
    }


    @Override
    public List<Inventario> getAllInventario() {
        logger.info("Get allProyect");
        List<Inventario> listaInventario = new ArrayList<Inventario>();
        inventariorepository.findAll().forEach(inventario -> listaInventario.add(inventario));
        return listaInventario;
    }


    @Override
    public boolean saveInventario(Inventario inventario) {
        logger.info("Save Proyect");
        try {
            inventariorepository.save(inventario);
            return true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            return false;
        }
    }


    @Override
    public boolean updateInventario(Inventario inventario) {
        logger.info("Update Proyect");
        boolean clave = false;
        Inventario empre = findById(inventario.getId());
        empre = inventario;
        try {
            inventariorepository.save(empre);
            clave = true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            clave = false;
        }
        return clave;
    }


    @Override
    public Inventario findById(Long id) {
        return inventariorepository.findById(id).get();
    }


    @Override
    public boolean saveOrUpdateInventario(Inventario inventario) {
        logger.info("Update Proyect");
        boolean clave = false;
        Optional<Inventario> fileOptional2 = inventariorepository.findById(inventario.getId());
        if (fileOptional2.isPresent()) {
            clave = this.updateInventario(inventario);
            logger.info(" is update");
        } else {
            clave = this.saveInventario(inventario);
            logger.info(" is save");
        }
        return clave;
    }


    @Override
    public List<Inventario> findByNombreContaining(String nombre) {
        logger.info("Get allProyect");
        List<Inventario>listaInventario = new ArrayList<Inventario>();
        listaInventario = inventariorepository.findByNombreContaining(nombre);
        return listaInventario;
    }


    @Override
    public List<Inventario> findByFechaInventarioContaining(Date fechainventario) {
        logger.info("Get allProyect");
        List<Inventario> listaInventario = new ArrayList<Inventario>();
        listaInventario = inventariorepository.findByFechaInventarioContaining(fechainventario);
        return listaInventario;
    }


    @Override
    public List<Inventario> findByProductoContaining(Producto productos) {
        logger.info("metodo: metodContainingRelacion NEW ");
        logger.info("Get allProyect");
        List<Inventario> listaInventario = new ArrayList<Inventario>();
        for (Inventario inventario : this.getAllInventario()) {
            for (Producto productosx : inventario.getproductos()) {
                if (productosx.equals(productos)) {
                    listaInventario.add(inventario);
                }
            }
        }
        return listaInventario;
    }


    @Override
    public List<Inventario> findByEntradaContaining(Entrada entrada) {
        logger.info("metodo: metodContainingRelacion NEW ");
        logger.info("Get allProyect");
        List<Inventario> listaInventario = new ArrayList<Inventario>();
        for (Inventario inventario : this.getAllInventario()) {
            for (Entrada entradax : inventario.getentrada()) {
                if (entradax.equals(entrada)) {
                    listaInventario.add(inventario);
                }
            }
        }
        return listaInventario;
    }


    @Override
    public List<Inventario> findBySalidaProductoContaining(SalidaProducto salidas) {
        logger.info("metodo: metodContainingRelacion NEW ");
        logger.info("Get allProyect");
        List<Inventario> listaInventario = new ArrayList<Inventario>();
        for (Inventario inventario : this.getAllInventario()) {
            for (SalidaProducto salidasx : inventario.getsalidas()) {
                if (salidasx.equals(salidas)) {
                    listaInventario.add(inventario);
                }
            }
        }
        return listaInventario;
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


}

// Inventario:

// id,  nombre, fechaInventario,
// Producto => // id, codigo, nombre, description, cantidadInicial, catidadActual, notas, activo, fechaIngreso, clasificacion, fechaUltimoIngreso,  ultimaCantidadIngesada, fechaUltimaSalida, ultimaCantidadSalida;
// Almacen-Area => // id, area, seccion, subseccion, nota, activo,


 // Entrada:

// id, nota, cantidadIngresada,  fechaIngreso
// producto=> // id, codigo, nombre, description, cantidadInicial, catidadActual, notas, activo, fechaIngreso, clasificacion, fechaUltimoIngreso,  ultimaCantidadIngesada, fechaUltimaSalida, ultimaCantidadSalida;
// User => encargado; // id, nombre, passwork, dni, activo, rol,


// SalidaProducto :

// id, fechadesalida,
// producto=> // id, codigo, nombre, description, cantidadInicial, catidadActual, notas, activo, fechaIngreso, clasificacion, fechaUltimoIngreso,  ultimaCantidadIngesada, fechaUltimaSalida, ultimaCantidadSalida;
// User => encargado; // id, nombre, passwork, dni, activo, rol,
// Cliente => // id, nombre,  direccion, notas

