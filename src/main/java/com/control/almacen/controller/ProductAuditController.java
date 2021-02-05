
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

import com.control.almacen.entitys.ProductAudit;
import com.control.almacen.validation.ProductAuditValidation;
import com.control.almacen.mapper.ProductAuditMapper;
import com.control.almacen.service.ProductAuditService;
import com.control.almacen.mapper.MapperEntityRespone;
import com.control.almacen.pojo.EntityRespone;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.control.almacen.pojo.ProductAuditPojo;

import com.control.almacen.validation.ProductoValidation;
import com.control.almacen.mapper.ProductoMapper;

import com.control.almacen.validation.AlmacenajeAreaValidation;
import com.control.almacen.mapper.AlmacenajeAreaMapper;
import com.control.almacen.pojo.ProductoPojo;
import com.control.almacen.pojo.AlmacenajeAreaPojo;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/productaudit")
public class ProductAuditController {

    @Autowired
    ProductAuditService productauditService;

    @Autowired
    ProductAuditValidation productauditValidationService;

    @Autowired
    ProductAuditMapper productauditMapper;

    @Autowired
    MapperEntityRespone mapperEntityRespone;

//    @Autowired
//    ProductoValidation productosystemValidationService;
//
//    @Autowired
//    ProductoMapper productosystemMapper;

    @Autowired
    AlmacenajeAreaValidation areaalmacenajeauditoriaValidationService;

    @Autowired
    AlmacenajeAreaMapper areaalmacenajeauditoriaMapper;

    @Autowired
    ProductoMapper productoMapper;

    @Autowired
    ProductoValidation productoValidationService;

    @GetMapping("/Getcantidaddiferencia/{cantidaddiferencia}")
    private ResponseEntity<EntityRespone> findByCantidadDiferencia(@PathVariable("cantidaddiferencia") Long cantidaddiferencia) {
        Long busca = (Long) productauditValidationService.validation(cantidaddiferencia);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(productauditService.findByCantidadDiferencia(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Gethaydiferenciacantidad/{haydiferenciacantidad}")
    private ResponseEntity<EntityRespone> findByHayDiferenciaCantidad(@PathVariable("haydiferenciacantidad") Boolean haydiferenciacantidad) {
        Boolean busca = (Boolean) productauditValidationService.validation(haydiferenciacantidad);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(productauditService.findByHayDiferenciaCantidad(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Gethaydiferenciaubicacion/{haydiferenciaubicacion}")
    private ResponseEntity<EntityRespone> findByHaydiferenciaUbicacion(@PathVariable("haydiferenciaubicacion") Boolean haydiferenciaubicacion) {
        Boolean busca = (Boolean) productauditValidationService.validation(haydiferenciaubicacion);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(productauditService.findByHaydiferenciaUbicacion(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Getfechaauditado/{fechaauditado}")
    private ResponseEntity<EntityRespone> findByFechaAuditado(@PathVariable("fechaauditado") Date fechaauditado) {
        Date busca = (Date) productauditValidationService.validation(fechaauditado);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(productauditService.findByFechaAuditado(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/Getcantidaddiferenciacontain/{cantidaddiferencia}")
    private ResponseEntity<EntityRespone> findByCantidadDiferenciaContain(@PathVariable("cantidaddiferencia") Long cantidaddiferencia) {
        Long busca = (Long) productauditValidationService.validation(cantidaddiferencia);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productauditService.findByCantidadDiferenciaContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/Gethaydiferenciacantidadcontain/{haydiferenciacantidad}")
    private ResponseEntity<EntityRespone> findByHayDiferenciaCantidadContain(@PathVariable("haydiferenciacantidad") Boolean haydiferenciacantidad) {
        Boolean busca = (Boolean) productauditValidationService.validation(haydiferenciacantidad);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productauditService.findByHayDiferenciaCantidadContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/Gethaydiferenciaubicacioncontain/{haydiferenciaubicacion}")
    private ResponseEntity<EntityRespone> findByHaydiferenciaUbicacionContain(@PathVariable("haydiferenciaubicacion") Boolean haydiferenciaubicacion) {
        Boolean busca = (Boolean) productauditValidationService.validation(haydiferenciaubicacion);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productauditService.findByHaydiferenciaUbicacionContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/Getfechaauditadocontain/{fechaauditado}")
    private ResponseEntity<EntityRespone> findByFechaAuditadoContain(@PathVariable("fechaauditado") Date fechaauditado) {
        Date busca = (Date) productauditValidationService.validation(fechaauditado);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productauditService.findByFechaAuditadoContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @GetMapping("/GetProductAudit/{id}")
    private ResponseEntity<EntityRespone> findById(@PathVariable("id") String id) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(productauditService.findById(productauditValidationService.valida_id(id)));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @GetMapping("/GetAllProductAudit")
    private ResponseEntity<EntityRespone> getAllProductAudit() {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productauditService.getAllProductAudit());
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @PostMapping("/save")
    private Boolean saveProductAudit(@RequestBody ProductAuditPojo productaudit) {
        return productauditService.saveProductAudit(productauditMapper.PojoToEntity(productauditValidationService.valida(productaudit)));
    }


    @PostMapping("/Update")
    private Long UpdateProductAudit(@RequestBody ProductAuditPojo productaudit) {
        productauditService.updateProductAudit(productauditMapper.PojoToEntity(productauditValidationService.valida(productaudit)));
        return productaudit.getId();
    }


    @PostMapping("/saveOrUpdate")
    private boolean saveOrUpdateProductAudit(@RequestBody ProductAuditPojo productaudit) {
        return productauditService.saveOrUpdateProductAudit(productauditMapper.PojoToEntity(productauditValidationService.valida(productaudit)));
    }


    @PostMapping("/getAreaAlmacenajeAuditoriaContain/")
    private List<ProductAudit> findByAlmacenajeArea(@RequestBody AlmacenajeAreaPojo almacenajearea) {
        return productauditService.findByAlmacenajeAreaContaining(areaalmacenajeauditoriaMapper.PojoToEntity(areaalmacenajeauditoriaValidationService.valida(almacenajearea)));
    }


    @PostMapping("/findproductoSystem")
    private ResponseEntity<EntityRespone> findRelacionProducto(@RequestBody ProductoPojo producto) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productauditService.findByRelacionProducto(productoMapper.PojoToEntity(productoValidationService.valida(producto))));
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


