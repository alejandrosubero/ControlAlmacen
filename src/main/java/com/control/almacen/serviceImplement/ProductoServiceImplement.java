
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

import com.control.almacen.entitys.Entrada;
import com.control.almacen.entitys.ListadoProducto;
import com.control.almacen.repository.EntradaRepository;
import com.control.almacen.repository.ListadoProductoRepository;
import com.control.almacen.repository.ReconsiliacionProductosRepository;
import com.control.almacen.service.ListadoProductoService;
import com.control.almacen.service.ProductoService;
import com.control.almacen.repository.ProductoRepository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.control.almacen.service.ReconsiliacionProductosService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.control.almacen.entitys.Producto;
import com.control.almacen.entitys.AlmacenajeArea;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
public class ProductoServiceImplement implements ProductoService {

    protected static final Log logger = LogFactory.getLog(ProductoServiceImplement.class);
    @Autowired
    private ProductoRepository productorepository;


    @Autowired
    private ReconsiliacionProductosService reconsiliacionProductosService;

    @Autowired
    private ListadoProductoService listadoProducto;


    @Autowired
    private ReconsiliacionProductosRepository reconsiliacionRepository;

    @Autowired
    private ListadoProductoRepository listadoProductoRepository;

    @Autowired
    private EntradaRepository entradaRepository;


    @Override
    public List<Producto> search(String search) {
        return productorepository.finBySearch(search);
    }



    @Override
    public boolean saveProducto(Producto producto) {
        logger.info("Save Proyect");
        try {
            Optional<Producto> prod = productorepository.findByCodigo(producto.getCodigo());
            if (!prod.isPresent()){
                producto.setCantidadInicial(producto.getUltimaCantidadIngesada());
                producto.setCatidadActual(producto.getUltimaCantidadIngesada());
                productorepository.save(producto);

                ListadoProducto igresoToListadoProducto = new ListadoProducto();
                igresoToListadoProducto.setNombre(producto.getNombre());
                igresoToListadoProducto.setCodigo(producto.getCodigo());
                igresoToListadoProducto.setDescripcion(producto.getDescription());
                igresoToListadoProducto.setClasificacion(producto.getClasificacion());

                listadoProducto.saveListadoProducto(igresoToListadoProducto);

            }else{
                Producto productoEntity = new Producto();
                productoEntity = prod.get();
                Long valor = productoEntity.getCatidadActual() + producto.getUltimaCantidadIngesada();
                producto.setCatidadActual(valor);
                productorepository.save(producto);
                ********
            }

//            if(!prod.getCodigo().isEmpty()){
//
//            }

            return true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            e.printStackTrace();
            return false;
        }
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
    public Producto findByDescription(String description) {

        logger.info("Starting getProducto");
        Producto productoEntity = new Producto();
        Optional<Producto> fileOptional1 = productorepository.findByDescription(description);
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
    public Producto findByCantidadInicial(Long cantidadInicial) {
        logger.info("Starting getProducto");
        Producto productoEntity = new Producto();
        Optional<Producto> fileOptional1 = productorepository.findByCantidadInicial(cantidadInicial);
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
    public Producto findByCatidadActual(Long catidadActual) {

        logger.info("Starting getProducto");
        Producto productoEntity = new Producto();
        Optional<Producto> fileOptional1 = productorepository.findByCatidadActual(catidadActual);
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
    public Producto findByNotas(String notas) {
        logger.info("Starting getProducto");
        Producto productoEntity = new Producto();
        Optional<Producto> fileOptional1 = productorepository.findByNotas(notas);

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
    public Producto findByActivo(Boolean activo) {
        logger.info("Starting getProducto");
        Producto productoEntity = new Producto();
        Optional<Producto> fileOptional1 = productorepository.findByActivo(activo);

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
    public Producto findByFechaIngreso(Date fechaIngreso) {

        logger.info("Starting getProducto");
        Producto productoEntity = new Producto();
        Optional<Producto> fileOptional1 = productorepository.findByFechaIngreso(fechaIngreso);

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
    public Producto findByClasificacion(String clasificacion) {

        logger.info("Starting getProducto");
        Producto productoEntity = new Producto();
        Optional<Producto> fileOptional1 = productorepository.findByClasificacion(clasificacion);

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
    public List<Producto> getAllProducto() {
        logger.info("Get allProyect");
        List<Producto> listaProducto = new ArrayList<Producto>();
        productorepository.findAll().forEach(producto -> listaProducto.add(producto));
        return listaProducto;
    }







    public boolean saveProductox(Producto producto) {
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
    public Producto findById(Long id) {
        return productorepository.findById(id).get();
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
    public List<Producto> findByActivoContaining(Boolean activo) {
        logger.info("Get allProyect");
        List<Producto> listaProducto = new ArrayList<Producto>();
        listaProducto = productorepository.findByActivoContaining(activo);
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


}
