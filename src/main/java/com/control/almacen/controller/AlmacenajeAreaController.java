
/*
Create on Sat Jan 30 15:24:11 ART 2021
*Copyright (C) 121.
@author alejandro
@author Hugo Luna
@author ANACODE AND IVANCODE
@since 11.0
@version1.0.0.0
@version  %I%, %G%
*<p>Description: control de  almacen </p>
*/


package com.control.almacen.controller;

import com.control.almacen.entitys.AlmacenajeArea;
import com.control.almacen.validation.AlmacenajeAreaValidation;
import com.control.almacen.mapper.AlmacenajeAreaMapper;
import com.control.almacen.service.AlmacenajeAreaService;
import com.control.almacen.mapper.MapperEntityRespone;
import com.control.almacen.pojo.EntityRespone;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.control.almacen.pojo.AlmacenajeAreaPojo;
import com.control.almacen.pojo.AlmacenajeAreaPojo;
import com.control.almacen.entitys.Producto;
import com.control.almacen.validation.ProductoValidation;
import com.control.almacen.mapper.ProductoMapper;
import com.control.almacen.pojo.ProductoPojo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/almacenajeArea")
public class AlmacenajeAreaController {

    @Autowired
    AlmacenajeAreaService almacenajeareaService;

    @Autowired
    AlmacenajeAreaValidation almacenajeareaValidationService;

    @Autowired
    AlmacenajeAreaMapper almacenajeareaMapper;

    @Autowired
    MapperEntityRespone mapperEntityRespone;

    @Autowired
    ProductoValidation productoValidationService;

    @Autowired
    ProductoMapper productoMapper;


    @GetMapping("/Getarea/{area}")
    private ResponseEntity<EntityRespone> findByArea(@PathVariable("area") String area) {
        String busca = (String) almacenajeareaValidationService.validation(area);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(almacenajeareaService.findByArea(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Getseccion/{seccion}")
    private ResponseEntity<EntityRespone> findBySeccion(@PathVariable("seccion") String seccion) {
        String busca = (String) almacenajeareaValidationService.validation(seccion);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(almacenajeareaService.findBySeccion(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Getsubseccion/{subseccion}")
    private ResponseEntity<EntityRespone> findBySubseccion(@PathVariable("subseccion") String subseccion) {
        String busca = (String) almacenajeareaValidationService.validation(subseccion);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(almacenajeareaService.findBySubseccion(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Getnota/{nota}")
    private ResponseEntity<EntityRespone> findByNota(@PathVariable("nota") String nota) {
        String busca = (String) almacenajeareaValidationService.validation(nota);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(almacenajeareaService.findByNota(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Getactivo/{activo}")
    private ResponseEntity<EntityRespone> findByActivo(@PathVariable("activo") Boolean activo) {
        Boolean busca = (Boolean) almacenajeareaValidationService.validation(activo);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(almacenajeareaService.findByActivo(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/Getareacontain/{area}")
    private ResponseEntity<EntityRespone> findByAreaContain(@PathVariable("area") String area) {
        String busca = (String) almacenajeareaValidationService.validation(area);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(almacenajeareaService.findByAreaContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/getSeccionContain/{seccion}")
    private ResponseEntity<EntityRespone> findBySeccionContain(@PathVariable("seccion") String seccion) {
        String busca = (String) almacenajeareaValidationService.validation(seccion);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(almacenajeareaService.findBySeccionContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/getSubSeccioncontain/{subseccion}")
    private ResponseEntity<EntityRespone> findBySubseccionContain(@PathVariable("subseccion") String subseccion) {
        String busca = (String) almacenajeareaValidationService.validation(subseccion);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(almacenajeareaService.findBySubseccionContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/getNotaContain/{nota}")
    private ResponseEntity<EntityRespone> findByNotaContain(@PathVariable("nota") String nota) {
        String busca = (String) almacenajeareaValidationService.validation(nota);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(almacenajeareaService.findByNotaContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/getActivoContain/{activo}")
    private ResponseEntity<EntityRespone> findByActivoContain(@PathVariable("activo") Boolean activo) {
        Boolean busca = (Boolean) almacenajeareaValidationService.validation(activo);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(almacenajeareaService.findByActivoContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @GetMapping("/getAlmacenajeArea/{id}")
    private ResponseEntity<EntityRespone> findById(@PathVariable("id") String id) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(almacenajeareaService.findById(almacenajeareaValidationService.valida_id(id)));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @GetMapping("/getAllAlmacenajeArea")
    private ResponseEntity<EntityRespone> getAllAlmacenajeArea() {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(almacenajeareaService.getAllAlmacenajeArea());
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @PostMapping("/save")
    private Boolean saveAlmacenajeArea(@RequestBody AlmacenajeAreaPojo almacenajearea) {
        return almacenajeareaService.saveAlmacenajeArea(almacenajeareaMapper.PojoToEntity(almacenajeareaValidationService.valida(almacenajearea)));
    }


    @PostMapping("/Update")
    private Long UpdateAlmacenajeArea(@RequestBody AlmacenajeAreaPojo almacenajearea) {
        almacenajeareaService.updateAlmacenajeArea(almacenajeareaMapper.PojoToEntity(almacenajeareaValidationService.valida(almacenajearea)));
        return almacenajearea.getId();
    }


    @PostMapping("/saveOrUpdate")
    private boolean saveOrUpdateAlmacenajeArea(@RequestBody AlmacenajeAreaPojo almacenajearea) {
        return almacenajeareaService.saveOrUpdateAlmacenajeArea(almacenajeareaMapper.PojoToEntity(almacenajeareaValidationService.valida(almacenajearea)));
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


