
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
import com.control.almacen.mapper.AlmacenajeAreaMapper;
import com.control.almacen.mapper.ProductoMapper;
import com.control.almacen.pojo.AlmacenajeAreaPojo;
import com.control.almacen.pojo.ProductoIngreso;
import com.control.almacen.repository.ListadoProductoRepository;
import com.control.almacen.repository.ReconsiliacionProductosRepository;
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


@Service
public class EntradaServiceImplement implements EntradaService {

    protected static final Log logger = LogFactory.getLog(EntradaServiceImplement.class);

    @Autowired
    private EntradaRepository entradarepository;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoMapper productoMapper;

    @Autowired
    private AlmacenajeAreaMapper areaalmacenajesystemMapper;

    @Autowired
    private ListadoProductoRepository listadoProductoRepository;

    @Autowired
    private ReconsiliacionProductosRepository reconsiliacionRepository;

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
    public Entrada findByFechaIngreso(Date fechaIngreso) {

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
    public Entrada findById(Long id) {
        return entradarepository.findById(id).get();
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
    public List<Entrada> findByFechaIngresoContaining(Date fechaingreso) {
        logger.info("Get allProyect");
        List<Entrada> listaEntrada = new ArrayList<Entrada>();
        listaEntrada = entradarepository.findByFechaIngresoContaining(fechaingreso);
        return listaEntrada;
    }


    @Override
    public List<Entrada> findByRelacionProducto(String codigoProducto) {
        List<Entrada> listaEntrada = new ArrayList<Entrada>();
        for (Entrada entrada : this.getAllEntrada()) {
            if (entrada.getCodigoProducto().equals(codigoProducto)) {
                listaEntrada.add(entrada);
            }
        }
        return listaEntrada;
    }


    @Override
    public List<Entrada> findByRelacionUser(String encargado) {
        List<Entrada> listaEntrada = new ArrayList<Entrada>();
        for (Entrada entrada : this.getAllEntrada()) {
            if (entrada.getEncargado().equals(encargado)) {
                listaEntrada.add(entrada);
            }
        }
        return listaEntrada;
    }




    @Override
    public boolean saveListEntradaProductoIngreso(List<ProductoIngreso> entradas) {
        return false;
    }



    @Override
    public boolean saveEntradaProductoIngreso(ProductoIngreso productoIngreso) {
        boolean exito = false;
        try {
            Producto producto = productoService.findByCodigo(productoIngreso.getCodigo());

            if (producto.getCodigo() != null) {
                   producto = new Producto();
                   ListadoProducto igresoToListadoProducto = new ListadoProducto();

                    producto.setFechaIngreso(productoIngreso.getFechaIngreso());
                    producto.setCodigo(productoIngreso.getCodigo());
                    producto.setNombre(productoIngreso.getNombre());
                    producto.setFechaUltimoIngreso(productoIngreso.getFechaUltimoIngreso());
                    producto.setCantidadInicial(productoIngreso.getUltimaCantidadIngesada());
                    producto.setCatidadActual(productoIngreso.getUltimaCantidadIngesada());
                    producto.setUltimaCantidadIngesada(productoIngreso.getUltimaCantidadIngesada());
                    producto.setNotas(productoIngreso.getNotas());
                    producto.setActivo(productoIngreso.getActivo());

                    igresoToListadoProducto.setNombre(producto.getNombre());
                    igresoToListadoProducto.setCodigo(producto.getCodigo());
                    igresoToListadoProducto.setDescripcion(producto.getDescription());
                    igresoToListadoProducto.setClasificacion(producto.getClasificacion());
                    listadoProductoRepository.save(igresoToListadoProducto);

                    for ( AlmacenajeAreaPojo almacen : productoIngreso.getAreaAlmacenajeSystem()) {
                        AlmacenajeArea area =  areaalmacenajesystemMapper.PojoToEntity(almacen);
                        producto.getAreaAlmacenajeSystem().add(area);
                    }
                    productoService.saveProducto(producto);
                    exito = this.saveEntradaIngresoProducto(producto.getCodigo(),productoIngreso);
                } else {

                Long candidateRest = producto.getCatidadActual() + productoIngreso.getCantidadInicial();
                producto.setCatidadActual(candidateRest);
                producto.setUltimaCantidadIngesada(productoIngreso.getUltimaCantidadIngesada());
                producto.setFechaUltimoIngreso(productoIngreso.getFechaUltimoIngreso());
            }
            productoService.saveProducto(producto);

            exito = this.saveEntradaIngresoProducto(producto.getCodigo(),productoIngreso);

        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            e.printStackTrace();
            return false;
        }

        return exito;
    }


    public boolean saveEntradaIngresoProducto(String codigo, ProductoIngreso productoIngreso){
        boolean exito = false;
        try {
            Producto producto = productoService.findByCodigo(codigo);
            if(producto.getCodigo() !=null){
                Entrada entrada = new Entrada();
                entrada.setIdProductoEnBase(producto.getId());
                entrada.setCodigoProducto(producto.getCodigo());
                entrada.setNombreProducto(producto.getNombre());
                entrada.setFechaIngreso(producto.getFechaIngreso());
                entrada.setCantidadIngresada(producto.getUltimaCantidadIngesada());
                entrada.setTicket(productoIngreso.getTicket());
                entrada.setCatidadActual(producto.getCatidadActual());
                entrada.setEncargado(productoIngreso.getEncargadoCodigo());
                entrada.setNota(productoIngreso.getNotas());
                entradarepository.save(entrada);

                if(!producto.getActivo()){
                    ReconsiliacionProductos reconsiliacion = new ReconsiliacionProductos(producto,entrada);
                    reconsiliacionRepository.save(reconsiliacion);
                }
            }
            exito = true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            e.printStackTrace();
        }
        return exito;
    }




    @Override
    public boolean saveEntrada(Entrada entrada) {
        logger.info("Save producto Ingresado");

        try {
            Producto producto = productoService.findByCodigo(entrada.getCodigoProducto());
            if (producto.getCodigo() == null || producto.getCatidadActual() == 0) {
                if (producto.getCodigo() == null) {
                    producto = new Producto();
                }
                producto.setFechaIngreso(entrada.getFechaIngreso());
                producto.setCodigo(entrada.getCodigoProducto());
                producto.setNombre(entrada.getNombreProducto());
                producto.setFechaUltimoIngreso(entrada.getFechaIngreso());

                producto.setCantidadInicial(entrada.getCantidadIngresada());
                producto.setCatidadActual(entrada.getCantidadIngresada());
                producto.setUltimaCantidadIngesada(entrada.getCantidadIngresada());

            } else {
                Long candidateRest = producto.getCatidadActual() + entrada.getCantidadIngresada();
                producto.setCatidadActual(candidateRest);
                producto.setUltimaCantidadIngesada(entrada.getCantidadIngresada());
                producto.setFechaUltimoIngreso(entrada.getFechaIngreso());
            }
            return setEntradaProducto(entrada, producto);
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            e.printStackTrace();
            return false;
        }
    }

    private boolean setEntradaProducto(Entrada entrada, Producto producto) {
        boolean exito = false;
        try {
            entradarepository.save(entrada);
            productoService.saveProducto(producto);
            exito = true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            e.printStackTrace();
        }
        return true;
    }


    @Override
    public boolean saveListEntrada(List<Entrada> entradas) {
        logger.info("Save lista de productos Ingresados");
        boolean exito = false;
        int cont = 0;
        try {
            for (Entrada entrada : entradas) {
                if (this.saveEntrada(entrada)) {
                    cont++;
                }
            }
            if (cont == entradas.size()) {
                exito = true;
            }
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            return false;
        }
        return exito;
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




