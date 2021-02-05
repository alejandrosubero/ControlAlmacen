
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

import com.control.almacen.service.ListadoProductoService;
import com.control.almacen.repository.ListadoProductoRepository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.control.almacen.entitys.ListadoProducto;


@Service
public class ListadoProductoServiceImplement implements ListadoProductoService {

    protected static final Log logger = LogFactory.getLog(ListadoProductoServiceImplement.class);
    @Autowired
    private ListadoProductoRepository listadoproductorepository;

    @Override
    public ListadoProducto findByNombre(String nombre) {

        logger.info("Starting getListadoProducto");
        ListadoProducto listadoproductoEntity = new ListadoProducto();
        Optional<ListadoProducto> fileOptional1 = listadoproductorepository.findByNombre(nombre);

        if (fileOptional1.isPresent()) {

            try {
                listadoproductoEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);

            }
        }
        return listadoproductoEntity;
    }

    @Override
    public ListadoProducto findByCodigo(String codigo) {

        logger.info("Starting getListadoProducto");
        ListadoProducto listadoproductoEntity = new ListadoProducto();
        Optional<ListadoProducto> fileOptional1 = listadoproductorepository.findByCodigo(codigo);

        if (fileOptional1.isPresent()) {

            try {
                listadoproductoEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);

            }
        }
        return listadoproductoEntity;
    }

    @Override
    public ListadoProducto findByClasificacion(String clasificacion) {

        logger.info("Starting getListadoProducto");
        ListadoProducto listadoproductoEntity = new ListadoProducto();
        Optional<ListadoProducto> fileOptional1 = listadoproductorepository.findByClasificacion(clasificacion);

        if (fileOptional1.isPresent()) {

            try {
                listadoproductoEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);

            }
        }
        return listadoproductoEntity;
    }

    @Override
    public ListadoProducto findByDescripcion(String descripcion) {

        logger.info("Starting getListadoProducto");
        ListadoProducto listadoproductoEntity = new ListadoProducto();
        Optional<ListadoProducto> fileOptional1 = listadoproductorepository.findByDescripcion(descripcion);

        if (fileOptional1.isPresent()) {

            try {
                listadoproductoEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);

            }
        }
        return listadoproductoEntity;
    }


    @Override
    public List<ListadoProducto> getAllListadoProducto() {
        logger.info("Get allProyect");
        List<ListadoProducto> listaListadoProducto = new ArrayList<ListadoProducto>();
        listadoproductorepository.findAll().forEach(listadoproducto -> listaListadoProducto.add(listadoproducto));
        return listaListadoProducto;
    }


    @Override
    public boolean saveListadoProducto(ListadoProducto listadoproducto) {
        logger.info("Save Proyect");


        try {
            listadoproductorepository.save(listadoproducto);
            return true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            return false;
        }
    }


    @Override
    public boolean updateListadoProducto(ListadoProducto listadoproducto) {
        logger.info("Update Proyect");
        boolean clave = false;
        ListadoProducto empre = findById(listadoproducto.getId());
        empre = listadoproducto;

        try {
            listadoproductorepository.save(empre);
            clave = true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            clave = false;
        }

        return clave;
    }


    @Override
    public ListadoProducto findById(Long id) {
        return listadoproductorepository.findById(id).get();
    }


    @Override
    public boolean saveOrUpdateListadoProducto(ListadoProducto listadoproducto) {
        logger.info("Update Proyect");
        boolean clave = false;
        Optional<ListadoProducto> fileOptional2 = listadoproductorepository.findById(listadoproducto.getId());
        if (fileOptional2.isPresent()) {
            clave = this.updateListadoProducto(listadoproducto);
            logger.info(" is update");
        } else {
            clave = this.saveListadoProducto(listadoproducto);
            logger.info(" is save");
        }
        return clave;
    }


    @Override
    public List<ListadoProducto> findByNombreContaining(String nombre) {
        logger.info("Get allProyect");
        List<ListadoProducto> listaListadoProducto = new ArrayList<ListadoProducto>();
        listaListadoProducto = listadoproductorepository.findByNombreContaining(nombre);
        return listaListadoProducto;
    }

    @Override
    public List<ListadoProducto> findByCodigoContaining(String codigo) {
        logger.info("Get allProyect");
        List<ListadoProducto> listaListadoProducto = new ArrayList<ListadoProducto>();
        listaListadoProducto = listadoproductorepository.findByCodigoContaining(codigo);
        return listaListadoProducto;
    }

    @Override
    public List<ListadoProducto> findByClasificacionContaining(String clasificacion) {
        logger.info("Get allProyect");
        List<ListadoProducto> listaListadoProducto = new ArrayList<ListadoProducto>();
        listaListadoProducto = listadoproductorepository.findByClasificacionContaining(clasificacion);
        return listaListadoProducto;
    }

    @Override
    public List<ListadoProducto> findByDescripcionContaining(String descripcion) {
        logger.info("Get allProyect");
        List<ListadoProducto> listaListadoProducto = new ArrayList<ListadoProducto>();
        listaListadoProducto = listadoproductorepository.findByDescripcionContaining(descripcion);
        return listaListadoProducto;
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
