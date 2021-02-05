
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

import com.control.almacen.service.EdicionService;
import com.control.almacen.repository.EdicionRepository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.control.almacen.entitys.Edicion;
import com.control.almacen.entitys.User;
import com.control.almacen.entitys.Producto;


@Service
public class EdicionServiceImplement implements EdicionService {

    protected static final Log logger = LogFactory.getLog(EdicionServiceImplement.class);
    @Autowired
    private EdicionRepository edicionrepository;

    @Override
    public Edicion findByFechaEdicion(Date fechaEdicion) {

        logger.info("Starting getEdicion");
        Edicion edicionEntity = new Edicion();
        Optional<Edicion> fileOptional1 = edicionrepository.findByFechaEdicion(fechaEdicion);
        if (fileOptional1.isPresent()) {
            try {
                edicionEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return edicionEntity;
    }

    @Override
    public Edicion findByNotas(String notas) {

        logger.info("Starting getEdicion");
        Edicion edicionEntity = new Edicion();
        Optional<Edicion> fileOptional1 = edicionrepository.findByNotas(notas);
        if (fileOptional1.isPresent()) {
            try {
                edicionEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return edicionEntity;
    }


    @Override
    public List<Edicion> getAllEdicion() {
        logger.info("Get allProyect");
        List<Edicion> listaEdicion = new ArrayList<Edicion>();
        edicionrepository.findAll().forEach(edicion -> listaEdicion.add(edicion));
        return listaEdicion;
    }


    @Override
    public boolean saveEdicion(Edicion edicion) {
        logger.info("Save Proyect");


        try {
            edicionrepository.save(edicion);
            return true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            return false;
        }
    }


    @Override
    public boolean updateEdicion(Edicion edicion) {
        logger.info("Update Proyect");
        boolean clave = false;
        Edicion empre = findById(edicion.getId());
        empre = edicion;

        try {
            edicionrepository.save(empre);
            clave = true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            clave = false;
        }

        return clave;
    }


    @Override
    public Edicion findById(Long id) {
        return edicionrepository.findById(id).get();
    }


    @Override
    public boolean saveOrUpdateEdicion(Edicion edicion) {
        logger.info("Update Proyect");
        boolean clave = false;
        Optional<Edicion> fileOptional2 = edicionrepository.findById(edicion.getId());
        if (fileOptional2.isPresent()) {
            clave = this.updateEdicion(edicion);
            logger.info(" is update");
        } else {
            clave = this.saveEdicion(edicion);
            logger.info(" is save");
        }
        return clave;
    }


    @Override
    public List<Edicion> findByFechaEdicionContaining(Date fechaedicion) {
        logger.info("Get allProyect");
        List<Edicion> listaEdicion = new ArrayList<Edicion>();
        listaEdicion = edicionrepository.findByFechaEdicionContaining(fechaedicion);
        return listaEdicion;
    }

    @Override
    public List<Edicion> findByNotasContaining(String notas) {
        logger.info("Get allProyect");
        List<Edicion> listaEdicion = new ArrayList<Edicion>();
        listaEdicion = edicionrepository.findByNotasContaining(notas);
        return listaEdicion;
    }


    @Override
    public List<Edicion> findByRelacionUser(User user) {
        List<Edicion> listaEdicion = new ArrayList<Edicion>();
        for (Edicion edicion : this.getAllEdicion()) {
            if (edicion.getuser().equalsUser(user)) {
                listaEdicion.add(edicion);
            }
        }
        return listaEdicion;
    }

    @Override
    public List<Edicion> findByRelacionProducto(Producto producto) {
        List<Edicion> listaEdicion = new ArrayList<Edicion>();
        for (Edicion edicion : this.getAllEdicion()) {
            if (edicion.getproducto().equals(producto)) {
                listaEdicion.add(edicion);
            }
        }
        return listaEdicion;
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
