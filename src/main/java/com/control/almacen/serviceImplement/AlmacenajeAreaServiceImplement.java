
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

import com.control.almacen.service.AlmacenajeAreaService;
import com.control.almacen.repository.AlmacenajeAreaRepository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.control.almacen.entitys.AlmacenajeArea;
import com.control.almacen.entitys.Producto;


@Service
public class AlmacenajeAreaServiceImplement implements AlmacenajeAreaService {

    protected static final Log logger = LogFactory.getLog(AlmacenajeAreaServiceImplement.class);
    @Autowired
    private AlmacenajeAreaRepository almacenajearearepository;

    @Override
    public AlmacenajeArea findByArea(String area) {

        logger.info("Starting getAlmacenajeArea");
        AlmacenajeArea almacenajeareaEntity = new AlmacenajeArea();
        Optional<AlmacenajeArea> fileOptional1 = almacenajearearepository.findByArea(area);

        if (fileOptional1.isPresent()) {

            try {
                almacenajeareaEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);

            }
        }
        return almacenajeareaEntity;
    }

    @Override
    public AlmacenajeArea findBySeccion(String seccion) {

        logger.info("Starting getAlmacenajeArea");
        AlmacenajeArea almacenajeareaEntity = new AlmacenajeArea();
        Optional<AlmacenajeArea> fileOptional1 = almacenajearearepository.findBySeccion(seccion);

        if (fileOptional1.isPresent()) {

            try {
                almacenajeareaEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);

            }
        }
        return almacenajeareaEntity;
    }

    @Override
    public AlmacenajeArea findBySubseccion(String subseccion) {

        logger.info("Starting getAlmacenajeArea");
        AlmacenajeArea almacenajeareaEntity = new AlmacenajeArea();
        Optional<AlmacenajeArea> fileOptional1 = almacenajearearepository.findBySubseccion(subseccion);
        if (fileOptional1.isPresent()) {
            try {
                almacenajeareaEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return almacenajeareaEntity;
    }


    @Override
    public AlmacenajeArea findByNota(String nota) {
        logger.info("Starting getAlmacenajeArea");
        AlmacenajeArea almacenajeareaEntity = new AlmacenajeArea();
        Optional<AlmacenajeArea> fileOptional1 = almacenajearearepository.findByNota(nota);
        if (fileOptional1.isPresent()) {
            try {
                almacenajeareaEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return almacenajeareaEntity;
    }


    @Override
    public AlmacenajeArea findByActivo(Boolean activo) {
        logger.info("Starting getAlmacenajeArea");
        AlmacenajeArea almacenajeareaEntity = new AlmacenajeArea();
        Optional<AlmacenajeArea> fileOptional1 = almacenajearearepository.findByActivo(activo);
        if (fileOptional1.isPresent()) {
            try {
                almacenajeareaEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return almacenajeareaEntity;
    }


    @Override
    public List<AlmacenajeArea> getAllAlmacenajeArea() {
        logger.info("Get allProyect");
        List<AlmacenajeArea> listaAlmacenajeArea = new ArrayList<AlmacenajeArea>();
        almacenajearearepository.findAll().forEach(almacenajearea -> listaAlmacenajeArea.add(almacenajearea));
        return listaAlmacenajeArea;
    }


    @Override
    public boolean saveAlmacenajeArea(AlmacenajeArea almacenajearea) {
        logger.info("Save Proyect");
        try {
            almacenajearearepository.save(almacenajearea);
            return true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            return false;
        }
    }


    @Override
    public boolean updateAlmacenajeArea(AlmacenajeArea almacenajearea) {
        logger.info("Update Proyect");
        boolean clave = false;
        AlmacenajeArea empre = findById(almacenajearea.getId());
        empre = almacenajearea;
        try {
            almacenajearearepository.save(empre);
            clave = true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            clave = false;
        }
        return clave;
    }


    @Override
    public AlmacenajeArea findById(Long id) {
        return almacenajearearepository.findById(id).get();
    }


    @Override
    public boolean saveOrUpdateAlmacenajeArea(AlmacenajeArea almacenajearea) {
        logger.info("Update Proyect");
        boolean clave = false;
        Optional<AlmacenajeArea> fileOptional2 = almacenajearearepository.findById(almacenajearea.getId());
        if (fileOptional2.isPresent()) {
            clave = this.updateAlmacenajeArea(almacenajearea);
            logger.info(" is update");
        } else {
            clave = this.saveAlmacenajeArea(almacenajearea);
            logger.info(" is save");
        }
        return clave;
    }


    @Override
    public List<AlmacenajeArea> findByAreaContaining(String area) {
        logger.info("Get allProyect");
        List<AlmacenajeArea> listaAlmacenajeArea = new ArrayList<AlmacenajeArea>();
        listaAlmacenajeArea = almacenajearearepository.findByAreaContaining(area);
        return listaAlmacenajeArea;
    }

    @Override
    public List<AlmacenajeArea> findBySeccionContaining(String seccion) {
        logger.info("Get allProyect");
        List<AlmacenajeArea> listaAlmacenajeArea = new ArrayList<AlmacenajeArea>();
        listaAlmacenajeArea = almacenajearearepository.findBySeccionContaining(seccion);
        return listaAlmacenajeArea;
    }

    @Override
    public List<AlmacenajeArea> findBySubseccionContaining(String subseccion) {
        logger.info("Get allProyect");
        List<AlmacenajeArea> listaAlmacenajeArea = new ArrayList<AlmacenajeArea>();
        listaAlmacenajeArea = almacenajearearepository.findBySubseccionContaining(subseccion);
        return listaAlmacenajeArea;
    }

    @Override
    public List<AlmacenajeArea> findByNotaContaining(String nota) {
        logger.info("Get allProyect");
        List<AlmacenajeArea> listaAlmacenajeArea = new ArrayList<AlmacenajeArea>();
        listaAlmacenajeArea = almacenajearearepository.findByNotaContaining(nota);
        return listaAlmacenajeArea;
    }

    @Override
    public List<AlmacenajeArea> findByActivoContaining(Boolean activo) {
        logger.info("Get allProyect");
        List<AlmacenajeArea> listaAlmacenajeArea = new ArrayList<AlmacenajeArea>();
        listaAlmacenajeArea = almacenajearearepository.findByActivoContaining(activo);
        return listaAlmacenajeArea;
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
