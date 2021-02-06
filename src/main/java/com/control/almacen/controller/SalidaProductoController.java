
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

import com.control.almacen.entitys.*;
import com.control.almacen.pojo.*;
import com.control.almacen.validation.SalidaProductoValidation;
import com.control.almacen.mapper.SalidaProductoMapper;
import com.control.almacen.service.SalidaProductoService;
import com.control.almacen.mapper.MapperEntityRespone;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.control.almacen.pojo.SalidaProductoPojo;
import com.control.almacen.validation.ProductoValidation;
import com.control.almacen.mapper.ProductoMapper;
import com.control.almacen.validation.UserValidation;
import com.control.almacen.mapper.UserMapper;
import com.control.almacen.validation.ClienteValidation;
import com.control.almacen.mapper.ClienteMapper;
import com.control.almacen.pojo.ProductoPojo;
import com.control.almacen.pojo.UserPojo;
import com.control.almacen.pojo.ClientePojo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/salidaproducto")
public class SalidaProductoController {

    @Autowired
    SalidaProductoService salidaproductoService;

    @Autowired
    SalidaProductoValidation salidaproductoValidationService;

    @Autowired
    SalidaProductoMapper salidaproductoMapper;

    @Autowired
    MapperEntityRespone mapperEntityRespone;

    @Autowired
    ProductoValidation productoValidationService;

    @Autowired
    ProductoMapper productoMapper;

    @Autowired
    UserValidation usuarioValidationService;

    @Autowired
    UserMapper usuarioMapper;

    @Autowired
    ClienteValidation clienteValidationService;

    @Autowired
    ClienteMapper clienteMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserValidation userValidationService;


    @GetMapping("/Getfechadesalida/{fechadesalida}")
    private ResponseEntity<EntityRespone> findByFechadesalida(@PathVariable("fechadesalida") Date fechadesalida) {
        Date busca = (Date) salidaproductoValidationService.validation(fechadesalida);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(salidaproductoService.findByFechadesalida(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/Getfechadesalidacontain/{fechadesalida}")
    private ResponseEntity<EntityRespone> findByFechadesalidaContain(@PathVariable("fechadesalida") Date fechadesalida) {
        Date busca = (Date) salidaproductoValidationService.validation(fechadesalida);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(salidaproductoService.findByFechadesalidaContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @GetMapping("/GetSalidaProducto/{id}")
    private ResponseEntity<EntityRespone> findById(@PathVariable("id") String id) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(salidaproductoService.findById(salidaproductoValidationService.valida_id(id)));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @GetMapping("/GetAllSalidaProducto")
    private ResponseEntity<EntityRespone> getAllSalidaProducto() {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(salidaproductoService.getAllSalidaProducto());
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @PostMapping("/save")
    private Boolean saveSalidaProducto(@RequestBody SalidaProductoPojo salidaproducto) {
        boolean exito = false;
        SalidaProducto entity =  salidaproductoMapper.PojoToEntity(salidaproductoValidationService.valida(salidaproducto));
        return  exito = entity != null? salidaproductoService.saveSalidaProducto(entity) : false;
    }

    @PostMapping("/saveList")
    private Boolean saveListSalidaProducto(@RequestBody List<SalidaProductoPojo> salidaproductoLista) {
        List<SalidaProducto>  salidaproductos = new ArrayList<SalidaProducto>();
        for (SalidaProductoPojo salidaproducto : salidaproductoLista) {
            salidaproductos.add(salidaproductoMapper.PojoToEntity(salidaproductoValidationService.valida(salidaproducto)));
        }
        return salidaproductoService.saveListaSalidaProducto(salidaproductos);
    }


    @PostMapping("/findproducto")
    private ResponseEntity<EntityRespone> findRelacionProducto(@RequestBody String codigoProducto) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(salidaproductoService.findByRelacionProducto((String) salidaproductoValidationService.validation(codigoProducto)));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @PostMapping("/findusuario")
    private ResponseEntity<EntityRespone> findRelacionUser(@RequestBody String encargado) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(salidaproductoService.findByRelacionUser((String) salidaproductoValidationService.validation(encargado)));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @PostMapping("/findcliente")
    private ResponseEntity<EntityRespone> findRelacionCliente(@RequestBody ClientePojo cliente) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(salidaproductoService.findByRelacionCliente(clienteMapper.PojoToEntity(clienteValidationService.valida(cliente))));
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


