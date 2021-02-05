
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

import com.control.almacen.mapper.ProductoMapper;
import com.control.almacen.service.EntradaService;
import com.control.almacen.repository.EntradaRepository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.control.almacen.service.ProductoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.control.almacen.entitys.Entrada;
import com.control.almacen.entitys.Producto;
import com.control.almacen.entitys.User;


@Service
public class EntradaServiceImplement implements EntradaService {

    protected static final Log logger = LogFactory.getLog(EntradaServiceImplement.class);

    @Autowired
    private EntradaRepository entradarepository;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public Entrada findByNota(String nota) {

        logger.info("Starting getEntrada");
        Entrada entradaEntity = new Entrada();
        Optional<Entrada> fileOptional1 = entradarepository.findByNota(nota);

        if (fileOptional1.isPresent()) {
            try {
                entradaEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return entradaEntity;
    }

    @Override
    public Entrada findByCantidadIngresada(Long cantidadIngresada) {

        logger.info("Starting getEntrada");
        Entrada entradaEntity = new Entrada();
        Optional<Entrada> fileOptional1 = entradarepository.findByCantidadIngresada(cantidadIngresada);

        if (fileOptional1.isPresent()) {
            try {
                entradaEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return entradaEntity;
    }

    @Override
    public Entrada findByFechaIngreso(String fechaIngreso) {

        logger.info("Starting getEntrada");
        Entrada entradaEntity = new Entrada();
        Optional<Entrada> fileOptional1 = entradarepository.findByFechaIngreso(fechaIngreso);

        if (fileOptional1.isPresent()) {
            try {
                entradaEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return entradaEntity;
    }


    @Override
    public List<Entrada> getAllEntrada() {
        logger.info("Get allProyect");
        List<Entrada> listaEntrada = new ArrayList<Entrada>();
        entradarepository.findAll().forEach(entrada -> listaEntrada.add(entrada));
        return listaEntrada;
    }


    @Override
    public boolean saveEntrada(Entrada entrada) {
        logger.info("Save Proyect");

        try {
            Producto producto =  productoService.findByCodigo(entrada.getproducto().getCodigo());
            Long candidateRest = producto.getCatidadActual() - entrada.getproducto().getUltimaCantidadIngesada();
            producto.setCatidadActual(candidateRest);
            producto.setUltimaCantidadIngesada(entrada.getproducto().getUltimaCantidadIngesada());
            producto.setFechaUltimoIngreso(entrada.getproducto().getFechaUltimoIngreso());
            entrada.setproducto(producto);
            entradarepository.save(entrada);
            productoService.saveOrUpdateProducto(producto);
            return true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            return false;
        }
    }


    @Override
    public boolean saveListEntrada(List<Entrada> entradas) {
        logger.info("Save Proyect");
        try {
            for (Entrada entrada : entradas ) {
                Producto producto =  productoService.findByCodigo(entrada.getproducto().getCodigo());
                Long candidateRest = producto.getCatidadActual() - entrada.getproducto().getUltimaCantidadIngesada();
                producto.setCatidadActual(candidateRest);
                producto.setUltimaCantidadIngesada(entrada.getproducto().getUltimaCantidadIngesada());
                producto.setFechaUltimoIngreso(entrada.getproducto().getFechaUltimoIngreso());
                entrada.setproducto(producto);
                entradarepository.save(entrada);
                productoService.saveOrUpdateProducto(producto);
            }
            return true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            return false;
        }
    }




    @Override
    public boolean updateEntrada(Entrada entrada) {
        logger.info("Update Proyect");
        boolean clave = false;
        Entrada empre = findById(entrada.getId());
        empre = entrada;
        try {
            entradarepository.save(empre);
            clave = true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            clave = false;
        }

        return clave;
    }


    @Override
    public Entrada findById(Long id) {
        return entradarepository.findById(id).get();
    }


    @Override
    public boolean saveOrUpdateEntrada(Entrada entrada) {
        logger.info("Update Proyect");
        boolean clave = false;
        Optional<Entrada> fileOptional2 = entradarepository.findById(entrada.getId());
        if (fileOptional2.isPresent()) {
            clave = this.updateEntrada(entrada);
            logger.info(" is update");
        } else {
            clave = this.saveEntrada(entrada);
            logger.info(" is save");
        }
        return clave;
    }


    @Override
    public List<Entrada> findByNotaContaining(String nota) {
        logger.info("Get allProyect");
        List<Entrada> listaEntrada = new ArrayList<Entrada>();
        listaEntrada = entradarepository.findByNotaContaining(nota);
        return listaEntrada;
    }

    @Override
    public List<Entrada> findByCantidadIngresadaContaining(Long cantidadingresada) {
        logger.info("Get allProyect");
        List<Entrada> listaEntrada = new ArrayList<Entrada>();
        listaEntrada = entradarepository.findByCantidadIngresadaContaining(cantidadingresada);
        return listaEntrada;
    }

    @Override
    public List<Entrada> findByFechaIngresoContaining(String fechaingreso) {
        logger.info("Get allProyect");
        List<Entrada> listaEntrada = new ArrayList<Entrada>();
        listaEntrada = entradarepository.findByFechaIngresoContaining(fechaingreso);
        return listaEntrada;
    }


    @Override
    public List<Entrada> findByRelacionProducto(Producto producto) {
        List<Entrada> listaEntrada = new ArrayList<Entrada>();
        for (Entrada entrada : this.getAllEntrada()) {
            if (entrada.getproducto().equals(producto)) {
                listaEntrada.add(entrada);
            }
        }
        return listaEntrada;
    }

    @Override
    public List<Entrada> findByRelacionUser(User user) {
        List<Entrada> listaEntrada = new ArrayList<Entrada>();
        for (Entrada entrada : this.getAllEntrada()) {
            if (entrada.getencargado().equalsUser(user)) {
                listaEntrada.add(entrada);
            }
        }
        return listaEntrada;
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
