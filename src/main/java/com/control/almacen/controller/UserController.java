
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

import com.control.almacen.entitys.User;
import com.control.almacen.validation.UserValidation;
import com.control.almacen.mapper.UserMapper;
import com.control.almacen.service.UserService;
import com.control.almacen.mapper.MapperEntityRespone;
import com.control.almacen.pojo.EntityRespone;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.control.almacen.pojo.UserPojo;
import com.control.almacen.pojo.UserPojo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserValidation userValidationService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    MapperEntityRespone mapperEntityRespone;


    @GetMapping("/Getnombre/{nombre}")
    private ResponseEntity<EntityRespone> findByNombre(@PathVariable("nombre") String nombre) {
        String busca = (String) userValidationService.validation(nombre);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(userService.findByNombre(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Getpasswork/{passwork}")
    private ResponseEntity<EntityRespone> findByPasswork(@PathVariable("passwork") String passwork) {
        String busca = (String) userValidationService.validation(passwork);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(userService.findByPasswork(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Getdni/{dni}")
    private ResponseEntity<EntityRespone> findByDni(@PathVariable("dni") String dni) {
        String busca = (String) userValidationService.validation(dni);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(userService.findByDni(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Getactivo/{activo}")
    private ResponseEntity<EntityRespone> findByActivo(@PathVariable("activo") Boolean activo) {
        Boolean busca = (Boolean) userValidationService.validation(activo);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(userService.findByActivo(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Getrol/{rol}")
    private ResponseEntity<EntityRespone> findByRol(@PathVariable("rol") String rol) {
        String busca = (String) userValidationService.validation(rol);
        try {
            EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(userService.findByRol(busca));
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        } catch (DataAccessException e) {
            EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/Getnombrecontain/{nombre}")
    private ResponseEntity<EntityRespone> findByNombreContain(@PathVariable("nombre") String nombre) {
        String busca = (String) userValidationService.validation(nombre);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(userService.findByNombreContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/Getpassworkcontain/{passwork}")
    private ResponseEntity<EntityRespone> findByPassworkContain(@PathVariable("passwork") String passwork) {
        String busca = (String) userValidationService.validation(passwork);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(userService.findByPassworkContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/Getdnicontain/{dni}")
    private ResponseEntity<EntityRespone> findByDniContain(@PathVariable("dni") String dni) {
        String busca = (String) userValidationService.validation(dni);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(userService.findByDniContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/Getactivocontain/{activo}")
    private ResponseEntity<EntityRespone> findByActivoContain(@PathVariable("activo") Boolean activo) {
        Boolean busca = (Boolean) userValidationService.validation(activo);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(userService.findByActivoContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }

    @GetMapping("/Getrolcontain/{rol}")
    private ResponseEntity<EntityRespone> findByRolContain(@PathVariable("rol") String rol) {
        String busca = (String) userValidationService.validation(rol);
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(userService.findByRolContaining(busca));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @GetMapping("/GetUser/{id}")
    private ResponseEntity<EntityRespone> findById(@PathVariable("id") String id) {
        EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(userService.findById(userValidationService.valida_id(id)));
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @GetMapping("/GetAllUser")
    private ResponseEntity<EntityRespone> getAllUser() {
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(userService.getAllUser());
        return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
    }


    @PostMapping("/save")
    private Boolean saveUser(@RequestBody UserPojo user) {
        return userService.saveUser(userMapper.PojoToEntity(userValidationService.valida(user)));
    }


    @PostMapping("/Update")
    private Long UpdateUser(@RequestBody UserPojo user) {
        userService.updateUser(userMapper.PojoToEntity(userValidationService.valida(user)));
        return user.getId();
    }


    @PostMapping("/saveOrUpdate")
    private boolean saveOrUpdateUser(@RequestBody UserPojo user) {
        return userService.saveOrUpdateUser(userMapper.PojoToEntity(userValidationService.valida(user)));
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


