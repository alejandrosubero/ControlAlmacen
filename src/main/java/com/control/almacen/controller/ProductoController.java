
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
import com.control.almacen.entitys.Producto;
import com.control.almacen.entitys.ReconsiliacionProductos;
import com.control.almacen.pojo.*;
import com.control.almacen.validation.ProductoValidation;
import com.control.almacen.mapper.ProductoMapper;
import com.control.almacen.service.ProductoService;
import com.control.almacen.mapper.MapperEntityRespone;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.control.almacen.pojo.ProductoPojo;
import com.control.almacen.entitys.AlmacenajeArea;
import com.control.almacen.validation.AlmacenajeAreaValidation;
import com.control.almacen.mapper.AlmacenajeAreaMapper;
import com.control.almacen.pojo.AlmacenajeAreaPojo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoValidation productoValidationService;

    @Autowired
    private ProductoMapper productoMapper;

    @Autowired
    private MapperEntityRespone mapperEntityRespone;

    @Autowired
    private AlmacenajeAreaValidation areaalmacenajesystemValidationService;

    @Autowired
    private AlmacenajeAreaMapper areaalmacenajesystemMapper;


    @PostMapping("/save")
    private Boolean saveProducto(@RequestBody ProductoIngreso productoIngresoList) {
       //  return productoService.saveProducto(productoMapper.PojoToEntity(productoValidationService.valida(productoIngresoList.getProducto())));
        return productoService.save(productoIngresoList);
    }

    @GetMapping("/GetAllProducto")
    private ResponseEntity<EntityRespone> getAllProducto() {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productoService.getAllProducto());
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

//
//    @GetMapping("/Getcodigo/{codigo}")
//    private ResponseEntity<EntityRespone> findByCodigo(@PathVariable("codigo") String codigo) {
//        String busca = (String) productoValidationService.validation(codigo);
//        try {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(productoService.findByCodigo(busca));
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//        } catch (DataAccessException e) {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/Getnombre/{nombre}")
//    private ResponseEntity<EntityRespone> findByNombre(@PathVariable("nombre") String nombre) {
//        String busca = (String) productoValidationService.validation(nombre);
//        try {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(productoService.findByNombre(busca));
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//        } catch (DataAccessException e) {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/Getdescription/{description}")
//    private ResponseEntity<EntityRespone> findByDescription(@PathVariable("description") String description) {
//        String busca = (String) productoValidationService.validation(description);
//        try {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(productoService.findByDescription(busca));
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//        } catch (DataAccessException e) {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/Getcantidadinicial/{cantidadinicial}")
//    private ResponseEntity<EntityRespone> findByCantidadInicial(@PathVariable("cantidadinicial") Long cantidadinicial) {
//        Long busca = (Long) productoValidationService.validation(cantidadinicial);
//        try {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(productoService.findByCantidadInicial(busca));
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//        } catch (DataAccessException e) {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/Getcatidadactual/{catidadactual}")
//    private ResponseEntity<EntityRespone> findByCatidadActual(@PathVariable("catidadactual") Long catidadactual) {
//        Long busca = (Long) productoValidationService.validation(catidadactual);
//        try {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(productoService.findByCatidadActual(busca));
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//        } catch (DataAccessException e) {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/Getnotas/{notas}")
//    private ResponseEntity<EntityRespone> findByNotas(@PathVariable("notas") String notas) {
//        String busca = (String) productoValidationService.validation(notas);
//        try {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(productoService.findByNotas(busca));
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//        } catch (DataAccessException e) {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/Getactivo/{activo}")
//    private ResponseEntity<EntityRespone> findByActivo(@PathVariable("activo") Boolean activo) {
//        Boolean busca = (Boolean) productoValidationService.validation(activo);
//        try {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(productoService.findByActivo(busca));
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//        } catch (DataAccessException e) {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/Getfechaingreso/{fechaingreso}")
//    private ResponseEntity<EntityRespone> findByFechaIngreso(@PathVariable("fechaingreso") Date fechaingreso) {
//        Date busca = (Date) productoValidationService.validation(fechaingreso);
//        try {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(productoService.findByFechaIngreso(busca));
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//        } catch (DataAccessException e) {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/Getclasificacion/{clasificacion}")
//    private ResponseEntity<EntityRespone> findByClasificacion(@PathVariable("clasificacion") String clasificacion) {
//        String busca = (String) productoValidationService.validation(clasificacion);
//        try {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(productoService.findByClasificacion(busca));
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//        } catch (DataAccessException e) {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//
//    @GetMapping("/Getcodigocontain/{codigo}")
//    private ResponseEntity<EntityRespone> findByCodigoContain(@PathVariable("codigo") String codigo) {
//        String busca = (String) productoValidationService.validation(codigo);
//        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productoService.findByCodigoContaining(busca));
//        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//    }
//
//    @GetMapping("/Getnombrecontain/{nombre}")
//    private ResponseEntity<EntityRespone> findByNombreContain(@PathVariable("nombre") String nombre) {
//        String busca = (String) productoValidationService.validation(nombre);
//        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productoService.findByNombreContaining(busca));
//        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//    }
//
//    @GetMapping("/Getdescriptioncontain/{description}")
//    private ResponseEntity<EntityRespone> findByDescriptionContain(@PathVariable("description") String description) {
//        String busca = (String) productoValidationService.validation(description);
//        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productoService.findByDescriptionContaining(busca));
//        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//    }
//
//    @GetMapping("/Getcantidadinicialcontain/{cantidadinicial}")
//    private ResponseEntity<EntityRespone> findByCantidadInicialContain(@PathVariable("cantidadinicial") Long cantidadinicial) {
//        Long busca = (Long) productoValidationService.validation(cantidadinicial);
//        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productoService.findByCantidadInicialContaining(busca));
//        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//    }
//
//    @GetMapping("/Getcatidadactualcontain/{catidadactual}")
//    private ResponseEntity<EntityRespone> findByCatidadActualContain(@PathVariable("catidadactual") Long catidadactual) {
//        Long busca = (Long) productoValidationService.validation(catidadactual);
//        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productoService.findByCatidadActualContaining(busca));
//        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//    }
//
//    @GetMapping("/Getnotascontain/{notas}")
//    private ResponseEntity<EntityRespone> findByNotasContain(@PathVariable("notas") String notas) {
//        String busca = (String) productoValidationService.validation(notas);
//        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productoService.findByNotasContaining(busca));
//        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//    }
//
//    @GetMapping("/Getactivocontain/{activo}")
//    private ResponseEntity<EntityRespone> findByActivoContain(@PathVariable("activo") Boolean activo) {
//        Boolean busca = (Boolean) productoValidationService.validation(activo);
//        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productoService.findByActivoContaining(busca));
//        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//    }
//
//    @GetMapping("/Getfechaingresocontain/{fechaingreso}")
//    private ResponseEntity<EntityRespone> findByFechaIngresoContain(@PathVariable("fechaingreso") Date fechaingreso) {
//        Date busca = (Date) productoValidationService.validation(fechaingreso);
//        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productoService.findByFechaIngresoContaining(busca));
//        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//    }
//
//    @GetMapping("/Getclasificacioncontain/{clasificacion}")
//    private ResponseEntity<EntityRespone> findByClasificacionContain(@PathVariable("clasificacion") String clasificacion) {
//        String busca = (String) productoValidationService.validation(clasificacion);
//        EntityRespone entityRespone = mapperEntityRespone.setEntityT(productoService.findByClasificacionContaining(busca));
//        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//    }
//
//
//    @GetMapping("/GetProducto/{id}")
//    private ResponseEntity<EntityRespone> findById(@PathVariable("id") String id) {
//        EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(productoService.findById(productoValidationService.valida_id(id)));
//        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//    }
//
//
//
//
//
//    @PostMapping("/save")
//    private Boolean saveProducto(@RequestBody ProductoPojo producto) {
//        return productoService.saveProducto(productoMapper.PojoToEntity(productoValidationService.valida(producto)));
//    }
//
//
//    @PostMapping("/Update")
//    private Long UpdateProducto(@RequestBody ProductoPojo producto) {
//        productoService.updateProducto(productoMapper.PojoToEntity(productoValidationService.valida(producto)));
//        return producto.getId();
//    }
//
//
//    @PostMapping("/saveOrUpdate")
//    private boolean saveOrUpdateProducto(@RequestBody ProductoPojo producto) {
//        return productoService.saveOrUpdateProducto(productoMapper.PojoToEntity(productoValidationService.valida(producto)));
//    }
//
//
//    @PostMapping("/Get_areaAlmacenajeSystem_contain/")
//    private List<Producto> findByAlmacenajeArea(@RequestBody AlmacenajeAreaPojo almacenajearea) {
//        return productoService.findByAlmacenajeAreaContaining(areaalmacenajesystemMapper.PojoToEntity(areaalmacenajesystemValidationService.valida(almacenajearea)));
//    }
//
//
//    @RequestMapping(value="/Search", method=RequestMethod.GET)
//    public List<Producto>  SearchRequest(@RequestParam(name="search") String search) {
//    return productoService.search((String) productoValidationService.validation(search));
//    }
//


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


