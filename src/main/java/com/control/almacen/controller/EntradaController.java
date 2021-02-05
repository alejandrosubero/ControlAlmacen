
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

import com.control.almacen.entitys.Entrada;
import com.control.almacen.validation.EntradaValidation;
import com.control.almacen.mapper.EntradaMapper;
import com.control.almacen.service.EntradaService;
import com.control.almacen.mapper.MapperEntityRespone;
import com.control.almacen.pojo.EntityRespone;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.control.almacen.pojo.EntradaPojo;
import com.control.almacen.pojo.EntradaPojo;
import com.control.almacen.entitys.Producto;
import com.control.almacen.validation.ProductoValidation;
import com.control.almacen.mapper.ProductoMapper;
import com.control.almacen.entitys.User;
import com.control.almacen.validation.UserValidation;
import com.control.almacen.mapper.UserMapper;
import com.control.almacen.pojo.ProductoPojo;
import com.control.almacen.pojo.UserPojo;
import com.control.almacen.pojo.ProductoPojo;
import com.control.almacen.pojo.UserPojo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/entrada")
public class EntradaController {

    @Autowired
    EntradaService entradaService;

    @Autowired
    EntradaValidation entradaValidationService;

    @Autowired
    EntradaMapper entradaMapper;

    @Autowired
    MapperEntityRespone mapperEntityRespone;

    @Autowired
    ProductoValidation productoValidationService;

    @Autowired
    ProductoMapper productoMapper;

    @Autowired
    UserValidation encargadoValidationService;

    @Autowired
    UserMapper encargadoMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserValidation userValidationService;


    @GetMapping("/Getnota/{nota}")
    private ResponseEntity<EntityRespone> findByNota(@PathVariable("nota") String nota) {
        String busca = (String) entradaValidationService.validation(nota);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(entradaService.findByNota(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Getcantidadingresada/{cantidadingresada}")
    private ResponseEntity<EntityRespone> findByCantidadIngresada(@PathVariable("cantidadingresada") Long cantidadingresada) {
        Long busca = (Long) entradaValidationService.validation(cantidadingresada);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(entradaService.findByCantidadIngresada(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Getfechaingreso/{fechaingreso}")
    private ResponseEntity<EntityRespone> findByFechaIngreso(@PathVariable("fechaingreso") String fechaingreso) {
        String busca = (String) entradaValidationService.validation(fechaingreso);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(entradaService.findByFechaIngreso(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/Getnotacontain/{nota}")
    private ResponseEntity<EntityRespone> findByNotaContain(@PathVariable("nota") String nota) {
        String busca = (String) entradaValidationService.validation(nota);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(entradaService.findByNotaContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/Getcantidadingresadacontain/{cantidadingresada}")
    private ResponseEntity<EntityRespone> findByCantidadIngresadaContain(@PathVariable("cantidadingresada") Long cantidadingresada) {
        Long busca = (Long) entradaValidationService.validation(cantidadingresada);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(entradaService.findByCantidadIngresadaContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/Getfechaingresocontain/{fechaingreso}")
    private ResponseEntity<EntityRespone> findByFechaIngresoContain(@PathVariable("fechaingreso") String fechaingreso) {
        String busca = (String) entradaValidationService.validation(fechaingreso);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(entradaService.findByFechaIngresoContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @GetMapping("/GetEntrada/{id}")
    private ResponseEntity<EntityRespone> findById(@PathVariable("id") String id) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(entradaService.findById(entradaValidationService.valida_id(id)));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @GetMapping("/GetAllEntrada")
    private ResponseEntity<EntityRespone> getAllEntrada() {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(entradaService.getAllEntrada());
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @PostMapping("/save")
    private Boolean saveEntrada(@RequestBody EntradaPojo entrada) {
        return entradaService.saveEntrada(entradaMapper.PojoToEntity(entradaValidationService.valida(entrada)));
    }


    @PostMapping("/saveList")
    private Boolean saveEntrada(@RequestBody List<EntradaPojo> entradasListas) {
        List<Entrada> entradas = new ArrayList<Entrada>();
        for (EntradaPojo entrada:entradasListas) {
            entradas.add(entradaMapper.PojoToEntity(entradaValidationService.valida(entrada)));
        }
        return entradaService.saveListEntrada(entradas);
    }


    @PostMapping("/Update")
    private Long UpdateEntrada(@RequestBody EntradaPojo entrada) {
        entradaService.updateEntrada(entradaMapper.PojoToEntity(entradaValidationService.valida(entrada)));
        return entrada.getId();
    }


    @PostMapping("/saveOrUpdate")
    private boolean saveOrUpdateEntrada(@RequestBody EntradaPojo entrada) {
        return entradaService.saveOrUpdateEntrada(entradaMapper.PojoToEntity(entradaValidationService.valida(entrada)));
    }


    @PostMapping("/findproducto")
    private ResponseEntity<EntityRespone> findRelacionProducto(@RequestBody ProductoPojo producto) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(entradaService.findByRelacionProducto(productoMapper.PojoToEntity(productoValidationService.valida(producto))));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @PostMapping("/findencargado")
    private ResponseEntity<EntityRespone> findRelacionUser(@RequestBody UserPojo user) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(entradaService.findByRelacionUser(userMapper.PojoToEntity(userValidationService.valida(user))));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
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


