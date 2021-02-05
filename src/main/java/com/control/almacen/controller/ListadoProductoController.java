
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

import com.control.almacen.validation.ListadoProductoValidation;
import com.control.almacen.mapper.ListadoProductoMapper;
import com.control.almacen.service.ListadoProductoService;
import com.control.almacen.mapper.MapperEntityRespone;
import com.control.almacen.pojo.EntityRespone;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.control.almacen.pojo.ListadoProductoPojo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/listadoproducto")
public class ListadoProductoController {

    @Autowired
    ListadoProductoService listadoproductoService;

    @Autowired
    ListadoProductoValidation listadoproductoValidationService;

    @Autowired
    ListadoProductoMapper listadoproductoMapper;

    @Autowired
    MapperEntityRespone mapperEntityRespone;


    @GetMapping("/Getnombre/{nombre}")
    private ResponseEntity<EntityRespone> findByNombre(@PathVariable("nombre") String nombre) {
        String busca = (String) listadoproductoValidationService.validation(nombre);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(listadoproductoService.findByNombre(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Getcodigo/{codigo}")
    private ResponseEntity<EntityRespone> findByCodigo(@PathVariable("codigo") String codigo) {
        String busca = (String) listadoproductoValidationService.validation(codigo);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(listadoproductoService.findByCodigo(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Getclasificacion/{clasificacion}")
    private ResponseEntity<EntityRespone> findByClasificacion(@PathVariable("clasificacion") String clasificacion) {
        String busca = (String) listadoproductoValidationService.validation(clasificacion);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(listadoproductoService.findByClasificacion(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Getdescripcion/{descripcion}")
    private ResponseEntity<EntityRespone> findByDescripcion(@PathVariable("descripcion") String descripcion) {
        String busca = (String) listadoproductoValidationService.validation(descripcion);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(listadoproductoService.findByDescripcion(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/Getnombrecontain/{nombre}")
    private ResponseEntity<EntityRespone> findByNombreContain(@PathVariable("nombre") String nombre) {
        String busca = (String) listadoproductoValidationService.validation(nombre);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(listadoproductoService.findByNombreContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/Getcodigocontain/{codigo}")
    private ResponseEntity<EntityRespone> findByCodigoContain(@PathVariable("codigo") String codigo) {
        String busca = (String) listadoproductoValidationService.validation(codigo);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(listadoproductoService.findByCodigoContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/Getclasificacioncontain/{clasificacion}")
    private ResponseEntity<EntityRespone> findByClasificacionContain(@PathVariable("clasificacion") String clasificacion) {
        String busca = (String) listadoproductoValidationService.validation(clasificacion);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(listadoproductoService.findByClasificacionContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/Getdescripcioncontain/{descripcion}")
    private ResponseEntity<EntityRespone> findByDescripcionContain(@PathVariable("descripcion") String descripcion) {
        String busca = (String) listadoproductoValidationService.validation(descripcion);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(listadoproductoService.findByDescripcionContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @GetMapping("/GetListadoProducto/{id}")
    private ResponseEntity<EntityRespone> findById(@PathVariable("id") String id) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(listadoproductoService.findById(listadoproductoValidationService.valida_id(id)));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @GetMapping("/GetAllListadoProducto")
    private ResponseEntity<EntityRespone> getAllListadoProducto() {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(listadoproductoService.getAllListadoProducto());
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @PostMapping("/save")
    private Boolean saveListadoProducto(@RequestBody ListadoProductoPojo listadoproducto) {
        return listadoproductoService.saveListadoProducto(listadoproductoMapper.PojoToEntity(listadoproductoValidationService.valida(listadoproducto)));
    }


    @PostMapping("/Update")
    private Long UpdateListadoProducto(@RequestBody ListadoProductoPojo listadoproducto) {
        listadoproductoService.updateListadoProducto(listadoproductoMapper.PojoToEntity(listadoproductoValidationService.valida(listadoproducto)));
        return listadoproducto.getId();
    }


    @PostMapping("/saveOrUpdate")
    private boolean saveOrUpdateListadoProducto(@RequestBody ListadoProductoPojo listadoproducto) {
        return listadoproductoService.saveOrUpdateListadoProducto(listadoproductoMapper.PojoToEntity(listadoproductoValidationService.valida(listadoproducto)));
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


