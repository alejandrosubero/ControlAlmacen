
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

import com.control.almacen.entitys.Inventario;
import com.control.almacen.validation.InventarioValidation;
import com.control.almacen.mapper.InventarioMapper;
import com.control.almacen.service.InventarioService;
import com.control.almacen.mapper.MapperEntityRespone;
import com.control.almacen.pojo.EntityRespone;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.control.almacen.pojo.InventarioPojo;
import com.control.almacen.pojo.InventarioPojo;
import com.control.almacen.entitys.Producto;
import com.control.almacen.validation.ProductoValidation;
import com.control.almacen.mapper.ProductoMapper;
import com.control.almacen.entitys.Entrada;
import com.control.almacen.validation.EntradaValidation;
import com.control.almacen.mapper.EntradaMapper;
import com.control.almacen.entitys.SalidaProducto;
import com.control.almacen.validation.SalidaProductoValidation;
import com.control.almacen.mapper.SalidaProductoMapper;
import com.control.almacen.pojo.ProductoPojo;
import com.control.almacen.pojo.EntradaPojo;
import com.control.almacen.pojo.SalidaProductoPojo;
import com.control.almacen.pojo.ProductoPojo;
import com.control.almacen.pojo.EntradaPojo;
import com.control.almacen.pojo.SalidaProductoPojo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    InventarioService inventarioService;

    @Autowired
    InventarioValidation inventarioValidationService;

    @Autowired
    InventarioMapper inventarioMapper;

    @Autowired
    MapperEntityRespone mapperEntityRespone;

    @Autowired
    ProductoValidation productosValidationService;

    @Autowired
    ProductoMapper productosMapper;

    @Autowired
    EntradaValidation entradaValidationService;

    @Autowired
    EntradaMapper entradaMapper;

    @Autowired
    SalidaProductoValidation salidasValidationService;

    @Autowired
    SalidaProductoMapper salidasMapper;


    @GetMapping("/getnombre/{nombre}")
    private ResponseEntity<EntityRespone> findByNombre(@PathVariable("nombre") String nombre) {
        String busca = (String) inventarioValidationService.validation(nombre);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(inventarioService.findByNombre(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Getfechainventario/{fechainventario}")
    private ResponseEntity<EntityRespone> findByFechaInventario(@PathVariable("fechainventario") Date fechainventario) {
        Date busca = (Date) inventarioValidationService.validation(fechainventario);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(inventarioService.findByFechaInventario(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getnombrecontain/{nombre}")
    private ResponseEntity<EntityRespone> findByNombreContain(@PathVariable("nombre") String nombre) {
        String busca = (String) inventarioValidationService.validation(nombre);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(inventarioService.findByNombreContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/getfechainventariocontain/{fechainventario}")
    private ResponseEntity<EntityRespone> findByFechaInventarioContain(@PathVariable("fechainventario") Date fechainventario) {
        Date busca = (Date) inventarioValidationService.validation(fechainventario);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(inventarioService.findByFechaInventarioContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @GetMapping("/getInventario/{id}")
    private ResponseEntity<EntityRespone> findById(@PathVariable("id") String id) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(inventarioService.findById(inventarioValidationService.valida_id(id)));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @GetMapping("/getAllInventario")
    private ResponseEntity<EntityRespone> getAllInventario() {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(inventarioService.getAllInventario());
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @PostMapping("/save")
    private Boolean saveInventario(@RequestBody InventarioPojo inventario) {
        return inventarioService.saveInventario(inventarioMapper.PojoToEntity(inventarioValidationService.valida(inventario)));
    }


    @PostMapping("/update")
    private Long UpdateInventario(@RequestBody InventarioPojo inventario) {
        inventarioService.updateInventario(inventarioMapper.PojoToEntity(inventarioValidationService.valida(inventario)));
        return inventario.getId();
    }


    @PostMapping("/saveOrUpdate")
    private boolean saveOrUpdateInventario(@RequestBody InventarioPojo inventario) {
        return inventarioService.saveOrUpdateInventario(inventarioMapper.PojoToEntity(inventarioValidationService.valida(inventario)));
    }


    @PostMapping("/getProductosContain/")
    private List<Inventario> findByProducto(@RequestBody ProductoPojo producto) {
        return inventarioService.findByProductoContaining(productosMapper.PojoToEntity(productosValidationService.valida(producto)));
    }


    @PostMapping("/getEntradaContain/")
    private List<Inventario> findByEntrada(@RequestBody EntradaPojo entrada) {
        return inventarioService.findByEntradaContaining(entradaMapper.PojoToEntity(entradaValidationService.valida(entrada)));
    }


    @PostMapping("/getSalidasContain/")
    private List<Inventario> findBySalidaProducto(@RequestBody SalidaProductoPojo salidaproducto) {
        return inventarioService.findBySalidaProductoContaining(salidasMapper.PojoToEntity(salidasValidationService.valida(salidaproducto)));
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


