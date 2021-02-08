
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


import com.control.almacen.entitys.Edicion;
import com.control.almacen.entitys.Producto;
import com.control.almacen.validation.EdicionValidation;
import com.control.almacen.mapper.EdicionMapper;
import com.control.almacen.service.EdicionService;
import com.control.almacen.mapper.MapperEntityRespone;
import com.control.almacen.pojo.EntityRespone;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.control.almacen.pojo.EdicionPojo;

import com.control.almacen.validation.UserValidation;
import com.control.almacen.mapper.UserMapper;

import com.control.almacen.validation.ProductoValidation;
import com.control.almacen.mapper.ProductoMapper;
import com.control.almacen.pojo.UserPojo;
import com.control.almacen.pojo.ProductoPojo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/edicion")
public class EdicionController {

    @Autowired
    EdicionService edicionService;

    @Autowired
    EdicionValidation edicionValidationService;

    @Autowired
    EdicionMapper edicionMapper;

    @Autowired
    MapperEntityRespone mapperEntityRespone;

    @Autowired
    UserValidation userValidationService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ProductoValidation productoValidationService;

    @Autowired
    ProductoMapper productoMapper;




    @PostMapping("/save")
    private Boolean saveEdicion(@RequestBody EdicionPojo edicion) {
        return edicionService.save(edicionMapper.PojoToEntity(edicionValidationService.valida(edicion)));
    }


    @RequestMapping(value="/Search", method=RequestMethod.GET)
    public List<Edicion> SearchRequest(@RequestParam(name="search") String search) {
        return edicionService.finBySearch((String) productoValidationService.validation(search));
    }


    @RequestMapping(value="/BetweenDates", method=RequestMethod.GET)
    public List<Edicion> getAllBetweenDates(@RequestParam(name="startDate") Date startDate, @RequestParam(name="endDate") Date endDate) {
        return edicionService.getAllBetweenDates((Date) productoValidationService.validation(startDate) , (Date) productoValidationService.validation(endDate));
    }


    @GetMapping("/GetAllEdicion")
    private ResponseEntity<EntityRespone> getAllEdicion() {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(edicionService.getAllEdicion());
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }



    @GetMapping("/GetEdicion/{id}")
    private ResponseEntity<EntityRespone> findById(@PathVariable("id") String id) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(edicionService.findById(edicionValidationService.valida_id(id)));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @PostMapping("/finduser")
    private ResponseEntity<EntityRespone> findRelacionUser(@RequestBody UserPojo user) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(edicionService.findByRelacionUser(userMapper.PojoToEntity(userValidationService.valida(user))));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @PostMapping("/findproducto")
    private ResponseEntity<EntityRespone> findRelacionProducto(@RequestBody ProductoPojo producto) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(edicionService.findByRelacionProducto(productoMapper.PojoToEntity(productoValidationService.valida(producto))));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }




//    @PostMapping("/Update")
//    private Long UpdateEdicion(@RequestBody EdicionPojo edicion) {
//        edicionService.updateEdicion(edicionMapper.PojoToEntity(edicionValidationService.valida(edicion)));
//        return edicion.getId();
//    }
//
//
//    @PostMapping("/saveOrUpdate")
//    private boolean saveOrUpdateEdicion(@RequestBody EdicionPojo edicion) {
//        return edicionService.saveOrUpdateEdicion(edicionMapper.PojoToEntity(edicionValidationService.valida(edicion)));
//    }
//
//
//
//    @GetMapping("/Getfechaedicion/{fechaedicion}")
//    private ResponseEntity<EntityRespone> findByFechaEdicion(@PathVariable("fechaedicion") Date fechaedicion) {
//        Date busca = (Date) edicionValidationService.validation(fechaedicion);
//        try {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(edicionService.findByFechaEdicion(busca));
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//        } catch (DataAccessException e) {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/Getnotas/{notas}")
//    private ResponseEntity<EntityRespone> findByNotas(@PathVariable("notas") String notas) {
//        String busca = (String) edicionValidationService.validation(notas);
//        try {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(edicionService.findByNotas(busca));
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//        } catch (DataAccessException e) {
//            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
//            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//
//    @GetMapping("/Getfechaedicioncontain/{fechaedicion}")
//    private ResponseEntity<EntityRespone> findByFechaEdicionContain(@PathVariable("fechaedicion") Date fechaedicion) {
//        Date busca = (Date) edicionValidationService.validation(fechaedicion);
//        EntityRespone entityRespone = mapperEntityRespone.setEntityT(edicionService.findByFechaEdicionContaining(busca));
//        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
//    }
//
//    @GetMapping("/Getnotascontain/{notas}")
//    private ResponseEntity<EntityRespone> findByNotasContain(@PathVariable("notas") String notas) {
//        String busca = (String) edicionValidationService.validation(notas);
//        EntityRespone entityRespone = mapperEntityRespone.setEntityT(edicionService.findByNotasContaining(busca));
//        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
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


