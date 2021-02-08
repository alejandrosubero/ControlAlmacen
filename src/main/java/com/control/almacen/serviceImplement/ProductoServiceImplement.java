
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
import com.control.almacen.mapper.ProductoMapper;
import com.control.almacen.pojo.ProductoIngreso;
import com.control.almacen.repository.*;
import com.control.almacen.service.ListadoProductoService;
import com.control.almacen.service.ProductoService;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.control.almacen.service.ReconsiliacionProductosService;
import com.control.almacen.validation.ProductoValidation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
public class ProductoServiceImplement implements ProductoService {

    protected static final Log logger = LogFactory.getLog(ProductoServiceImplement.class);

    @Autowired
    private ProductoRepository productorepository;

    @Autowired
    private ListadoProductoService listadoProducto;

    @Autowired
    private ReconsiliacionProductosService reconsiliacionProductosService;

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private SalidaProductoRepository salidaProductoRepository;

    @Autowired
    private ProductoValidation productoValidationService;

    @Autowired
    private ProductoMapper productoMapper;


    private Producto product;
    private Optional<Producto> prod;


    /*
    * REGLAS DEL NEGOCIO O PRODUCTOS:
    * 1) AL INGRESAR UN PRODUC SE SALVA UNA ENTRADA, SI ES NEW SE AGREGA ALA LISTA DE PRODUCTOS SI NO ESTA ACTIVO SE AGREGA A RECONSILIACION
    * 2) AL SACAR O DAR DE ALTA UN PRODUC SE SALVA UNA SALIDA,  SI NO ESTA ACTIVO SE AGREGA A RECONSILIACION.
    * 3) AL EDITAR EL PRODUCTO EN LA MODALIDAD DE EDICION SE CUMPLEN LAS REGLAS DE EDICION Y SE SALVA EL PRODUCTO CON EL METODO SAVEPRODUCTO
    * 4) el metodo de consulta allProductos va a regresar todos los productos ACTIVOS O NO
    * 5) LAS CONSULTAS REGULARES SOLO SE EFECTUARAN POR EL METODO findByActivoContaining EL CULA SOLO VA A TRAER LOS PRODUCTOS ACTIVOS.
    * */


    @Override
    public boolean saveProducto(Producto producto) {
        logger.info("Save Proyect");
        try {
            productorepository.save(producto);
            return true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public List<Producto> search(String search) {  return productorepository.finBySearch(search); }


    @Override
    public Producto findById(Long id) { return productorepository.findById(id).get(); }


    @Override
    public List<Producto> getAllProducto() {
        logger.info("Get allProyect");
        List<Producto> listaProducto = new ArrayList<Producto>();
        productorepository.findAll().forEach(producto -> listaProducto.add(producto));
        return listaProducto;
    }

    @Override
    public List<Producto> findByActivoContaining(Boolean activo) {
        logger.info("Get allProyect");
        List<Producto> listaProducto = new ArrayList<Producto>();
        listaProducto = productorepository.findByActivoContaining(activo);
        return listaProducto;
    }

    @Override
    public boolean save(ProductoIngreso productoIngreso) {
        boolean exito = false;
        Producto producto =  productoMapper.PojoToEntity(productoValidationService.valida(productoIngreso.getProducto()));
        if(this.saveProductos(producto, productoIngreso)){
//            exito = !productoIngreso.getSalida()?  this.entradaProducto(productoIngreso, producto) : this.salidaProducto(productoIngreso, producto);

            if(!productoIngreso.getSalida()){
                exito =  this.entradaProducto(productoIngreso, producto);
            }else{
                exito = this.salidaProducto(productoIngreso, producto);
            }
        }
        return exito;
    }


    private boolean saveProductos(Producto producto, ProductoIngreso productoIngreso) {
        logger.info("Save Producto");
        try {
            this.prod = productorepository.findByCodigo(producto.getCodigo());
            if (!this.prod.isPresent()){
                producto.setCantidadInicial(producto.getUltimaCantidadIngesada());
                producto.setCatidadActual(producto.getUltimaCantidadIngesada());
                product = productorepository.save(producto);
                this.saveListado(producto);
            }else{

               if (!productoIngreso.getSalida()){
                   this.addProduct(producto);
               }else{
                   this.restProduct(producto);
               }
            }
            return true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            e.printStackTrace();
            return false;
        }
    }


    private boolean salidaProducto(ProductoIngreso productoIngreso, Producto producto){
        boolean exito = false;
        try {
            SalidaProducto salida = new SalidaProducto();

            salida.setCantidadSalida(this.product.getUltimaCantidadSalida());
            salida.setFechadesalida(this.product.getFechaUltimaSalida());
            salida.setCatidadActual(this.product.getCatidadActual());
            salida.setTicket(productoIngreso.getTicket());
            salida.setIdProductoEnBase(this.product.getId());
            salida.setCodigoProducto(this.product.getCodigo());
            salida.setNombreProducto(this.product.getNombre());
            salida.setEncargado(productoIngreso.getEncargadoCodigo());
            salida.setNota(productoIngreso.getProducto().getNotas());
            salida.setCliente(productoIngreso.getCliente());

            SalidaProducto sali = salidaProductoRepository.save(salida);
            if(sali.getCodigoProducto() != null){ exito = true; }

            if(!producto.getActivo()){
                logger.info("Save Producto reconsilacion");
                ReconsiliacionProductos reconsiliacion = new ReconsiliacionProductos(producto, salida);
                reconsiliacionProductosService.save(reconsiliacion);
            }
        }catch (DataAccessException e){
            logger.error(" ERROR : " + e);
            e.printStackTrace();
            return false;
        }
        return exito;
    }


    private boolean entradaProducto(ProductoIngreso productoIngreso, Producto producto){
        boolean exito = false;
        try {
            Entrada entrada = new Entrada();
            entrada.setIdProductoEnBase(this.product.getId());
            entrada.setCodigoProducto(this.product.getCodigo());
            entrada.setNombreProducto(this.product.getNombre());
            entrada.setFechaIngreso(this.product.getFechaIngreso());
            entrada.setCantidadIngresada(this.product.getUltimaCantidadIngesada());
            entrada.setCatidadActual(this.product.getCatidadActual());
            entrada.setNota(this.product.getNotas());
            entrada.setTicket(productoIngreso.getTicket());
            entrada.setEncargado(productoIngreso.getEncargadoCodigo());
            Entrada entrada2 = entradaRepository.save(entrada);

            if(entrada2.getCodigoProducto() != null){ exito = true; }

            if(!producto.getActivo()){
                logger.info("Save Producto reconsilacion");
                ReconsiliacionProductos reconsiliacion = new ReconsiliacionProductos(producto,entrada);
                reconsiliacionProductosService.save(reconsiliacion);
            }
        }catch (DataAccessException e){
            logger.error(" ERROR : " + e);
            e.printStackTrace();
            return false;
        }
        return exito;
    }


    private void saveListado(Producto producto){
        logger.info("Save Producto in list");
        ListadoProducto igresoToListadoProducto = new ListadoProducto();
        igresoToListadoProducto.setNombre(producto.getNombre());
        igresoToListadoProducto.setCodigo(producto.getCodigo());
        igresoToListadoProducto.setDescripcion(producto.getDescription());
        igresoToListadoProducto.setClasificacion(producto.getClasificacion());
        listadoProducto.saveListadoProducto(igresoToListadoProducto);
    }


    private void addProduct(Producto producto){

        Producto productoEntity =  this.prod.get();
        Long valor = productoEntity.getCatidadActual() + producto.getUltimaCantidadIngesada();
        productoEntity.setCatidadActual(valor);
        productoEntity.setUltimaCantidadIngesada(producto.getUltimaCantidadIngesada());
        productoEntity.setFechaUltimoIngreso(producto.getFechaUltimoIngreso());
        product = productorepository.save(productoEntity);
    }


    private void restProduct(Producto producto){

        Producto productoEntity =  this.prod.get();
        Long valor = productoEntity.getCatidadActual() - producto.getUltimaCantidadIngesada();
        productoEntity.setCatidadActual(valor);
        productoEntity.setUltimaCantidadSalida(producto.getUltimaCantidadSalida());
        productoEntity.setFechaUltimoIngreso(producto.getFechaUltimoIngreso());
        product = productorepository.save(productoEntity);
    }


    @Override
    public Producto findByCodigo(String codigo) {
        logger.info("Starting getProducto");
        Producto productoEntity = new Producto();
        Optional<Producto> fileOptional1 = productorepository.findByCodigo(codigo);
        if (fileOptional1.isPresent()) {
            try {
                productoEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return productoEntity;
    }


    @Override
    public Producto findByNombre(String nombre) {

        logger.info("Starting getProducto");
        Producto productoEntity = new Producto();
        Optional<Producto> fileOptional1 = productorepository.findByNombre(nombre);
        if (fileOptional1.isPresent()) {
            try {
                productoEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return productoEntity;
    }



    @Override
    public boolean updateProducto(Producto producto) {
        logger.info("Update Proyect");
        boolean clave = false;
        Producto empre = findById(producto.getId());
        empre = producto;
        try {
            productorepository.save(empre);
            clave = true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            clave = false;
        }
        return clave;
    }


    @Override
    public boolean saveOrUpdateProducto(Producto producto) {
        logger.info("Update Proyect");
        boolean clave = false;
        Optional<Producto> fileOptional2 = productorepository.findById(producto.getId());
        if (fileOptional2.isPresent()) {
            clave = this.updateProducto(producto);
            logger.info(" is update");
        } else {
            clave = this.saveProducto(producto);
            logger.info(" is save");
        }
        return clave;
    }


    @Override
    public List<Producto> findByCodigoContaining(String codigo) {
        logger.info("Get allProyect");
        List<Producto> listaProducto = new ArrayList<Producto>();
        listaProducto = productorepository.findByCodigoContaining(codigo);
        return listaProducto;
    }

    @Override
    public List<Producto> findByNombreContaining(String nombre) {
        logger.info("Get allProyect");
        List<Producto> listaProducto = new ArrayList<Producto>();
        listaProducto = productorepository.findByNombreContaining(nombre);
        return listaProducto;
    }

    @Override
    public List<Producto> findByDescriptionContaining(String description) {
        logger.info("Get allProyect");
        List<Producto> listaProducto = new ArrayList<Producto>();
        listaProducto = productorepository.findByDescriptionContaining(description);
        return listaProducto;
    }

    @Override
    public List<Producto> findByCantidadInicialContaining(Long cantidadinicial) {
        logger.info("Get allProyect");
        List<Producto> listaProducto = new ArrayList<Producto>();
        listaProducto = productorepository.findByCantidadInicialContaining(cantidadinicial);
        return listaProducto;
    }

    @Override
    public List<Producto> findByCatidadActualContaining(Long catidadactual) {
        logger.info("Get allProyect");
        List<Producto> listaProducto = new ArrayList<Producto>();
        listaProducto = productorepository.findByCatidadActualContaining(catidadactual);
        return listaProducto;
    }

    @Override
    public List<Producto> findByNotasContaining(String notas) {
        logger.info("Get allProyect");
        List<Producto> listaProducto = new ArrayList<Producto>();
        listaProducto = productorepository.findByNotasContaining(notas);
        return listaProducto;
    }



    @Override
    public List<Producto> findByFechaIngresoContaining(Date fechaingreso) {
        logger.info("Get allProyect");
        List<Producto> listaProducto = new ArrayList<Producto>();
        listaProducto = productorepository.findByFechaIngresoContaining(fechaingreso);
        return listaProducto;
    }

    @Override
    public List<Producto> findByClasificacionContaining(String clasificacion) {
        logger.info("Get allProyect");
        List<Producto> listaProducto = new ArrayList<Producto>();
        listaProducto = productorepository.findByClasificacionContaining(clasificacion);
        return listaProducto;
    }


    @Override
    public List<Producto> findByAlmacenajeAreaContaining(AlmacenajeArea areaAlmacenajeSystem) {
        logger.info("metodo: metodContainingRelacion NEW ");
        logger.info("Get allProyect");
        List<Producto> listaProducto = new ArrayList<Producto>();
        for (Producto producto : this.getAllProducto()) {
            for (AlmacenajeArea areaAlmacenajeSystemx : producto.getAreaAlmacenajeSystem()) {
                if (areaAlmacenajeSystemx.equalsAlmacenajeArea(areaAlmacenajeSystem)) {
                    listaProducto.add(producto);
                }
            }
        }
        return listaProducto;

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



    //    @Override
//    public Producto findByDescription(String description) {
//
//        logger.info("Starting getProducto");
//        Producto productoEntity = new Producto();
//        Optional<Producto> fileOptional1 = productorepository.findByDescription(description);
//        if (fileOptional1.isPresent()) {
//            try {
//                productoEntity = fileOptional1.get();
//            } catch (DataAccessException e) {
//                logger.error(" ERROR : " + e);
//            }
//        }
//        return productoEntity;
//    }

//    @Override
//    public Producto findByCantidadInicial(Long cantidadInicial) {
//        logger.info("Starting getProducto");
//        Producto productoEntity = new Producto();
//        Optional<Producto> fileOptional1 = productorepository.findByCantidadInicial(cantidadInicial);
//        if (fileOptional1.isPresent()) {
//            try {
//                productoEntity = fileOptional1.get();
//            } catch (DataAccessException e) {
//                logger.error(" ERROR : " + e);
//
//            }
//        }
//        return productoEntity;
//    }

//    @Override
//    public Producto findByCatidadActual(Long catidadActual) {
//
//        logger.info("Starting getProducto");
//        Producto productoEntity = new Producto();
//        Optional<Producto> fileOptional1 = productorepository.findByCatidadActual(catidadActual);
//        if (fileOptional1.isPresent()) {
//            try {
//                productoEntity = fileOptional1.get();
//            } catch (DataAccessException e) {
//                logger.error(" ERROR : " + e);
//            }
//        }
//        return productoEntity;
//    }

//    @Override
//    public Producto findByNotas(String notas) {
//        logger.info("Starting getProducto");
//        Producto productoEntity = new Producto();
//        Optional<Producto> fileOptional1 = productorepository.findByNotas(notas);
//        if (fileOptional1.isPresent()) {
//            try {
//                productoEntity = fileOptional1.get();
//            } catch (DataAccessException e) {
//                logger.error(" ERROR : " + e);
//            }
//        }
//        return productoEntity;
//    }


//    @Override
//    public Producto findByActivo(Boolean activo) {
//        logger.info("Starting getProducto");
//        Producto productoEntity = new Producto();
//        Optional<Producto> fileOptional1 = productorepository.findByActivo(activo);
//        if (fileOptional1.isPresent()) {
//            try {
//                productoEntity = fileOptional1.get();
//            } catch (DataAccessException e) {
//                logger.error(" ERROR : " + e);
//            }
//        }
//        return productoEntity;
//    }

//    @Override
//    public Producto findByFechaIngreso(Date fechaIngreso) {
//
//        logger.info("Starting getProducto");
//        Producto productoEntity = new Producto();
//        Optional<Producto> fileOptional1 = productorepository.findByFechaIngreso(fechaIngreso);
//        if (fileOptional1.isPresent()) {
//            try {
//                productoEntity = fileOptional1.get();
//            } catch (DataAccessException e) {
//                logger.error(" ERROR : " + e);
//            }
//        }
//        return productoEntity;
//    }


//    @Override
//    public Producto findByClasificacion(String clasificacion) {
//        logger.info("Starting getProducto");
//        Producto productoEntity = new Producto();
//        Optional<Producto> fileOptional1 = productorepository.findByClasificacion(clasificacion);
//        if (fileOptional1.isPresent()) {
//            try {
//                productoEntity = fileOptional1.get();
//            } catch (DataAccessException e) {
//                logger.error(" ERROR : " + e);
//            }
//        }
//        return productoEntity;
//    }

}
