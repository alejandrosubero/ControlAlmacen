
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

import com.control.almacen.validation.UserControlValidation;
import com.control.almacen.mapper.UserControlMapper;
import com.control.almacen.service.UserControlService;
import com.control.almacen.mapper.MapperEntityRespone;
import com.control.almacen.pojo.EntityRespone;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.control.almacen.pojo.UserControlPojo;

import com.control.almacen.validation.UserValidation;
import com.control.almacen.mapper.UserMapper;
import com.control.almacen.pojo.UserPojo;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usercontrol")
public class UserControlController {

    @Autowired
    UserControlService usercontrolService;

    @Autowired
    UserControlValidation usercontrolValidationService;

    @Autowired
   UserControlMapper usercontrolMapper;

    @Autowired
   MapperEntityRespone mapperEntityRespone;

    @Autowired
    UserValidation userValidationService;

    @Autowired
    UserMapper userMapper;



        @GetMapping("/Getlastlogindate/{lastlogindate}")
        private  ResponseEntity<EntityRespone> findByLastLoginDate(@PathVariable("lastlogindate") Date  lastlogindate) {
        Date busca = (Date) usercontrolValidationService.validation(lastlogindate);
        try {
                EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(usercontrolService.findByLastLoginDate(busca));
                return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
             } catch (DataAccessException e) {
                 EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
     }

        @GetMapping("/Getlastoutsystem/{lastoutsystem}")
        private  ResponseEntity<EntityRespone> findByLastOutSystem(@PathVariable("lastoutsystem") Date  lastoutsystem) {
        Date busca = (Date) usercontrolValidationService.validation(lastoutsystem);
        try {
                EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(usercontrolService.findByLastOutSystem(busca));
                return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
             } catch (DataAccessException e) {
                 EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
     }

        @GetMapping("/Getmodificsystem/{modificsystem}")
        private  ResponseEntity<EntityRespone> findByModificSystem(@PathVariable("modificsystem") Boolean  modificsystem) {
        Boolean busca = (Boolean) usercontrolValidationService.validation(modificsystem);
        try {
                EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(usercontrolService.findByModificSystem(busca));
                return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
             } catch (DataAccessException e) {
                 EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
     }


        @GetMapping("/Getlastlogindatecontain/{lastlogindate}")
        private ResponseEntity<EntityRespone> findByLastLoginDateContain(@PathVariable("lastlogindate") Date  lastlogindate) {
              Date busca = (Date) usercontrolValidationService.validation(lastlogindate);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(usercontrolService.findByLastLoginDateContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }

        @GetMapping("/Getlastoutsystemcontain/{lastoutsystem}")
        private ResponseEntity<EntityRespone> findByLastOutSystemContain(@PathVariable("lastoutsystem") Date  lastoutsystem) {
              Date busca = (Date) usercontrolValidationService.validation(lastoutsystem);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(usercontrolService.findByLastOutSystemContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }

        @GetMapping("/Getmodificsystemcontain/{modificsystem}")
        private ResponseEntity<EntityRespone> findByModificSystemContain(@PathVariable("modificsystem") Boolean  modificsystem) {
              Boolean busca = (Boolean) usercontrolValidationService.validation(modificsystem);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(usercontrolService.findByModificSystemContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }


        @GetMapping("/GetUserControl/{id}")
          private ResponseEntity<EntityRespone> findById(@PathVariable("id") String id) {
          EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(usercontrolService.findById(usercontrolValidationService.valida_id(id))); 
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
          }


        @GetMapping("/GetAllUserControl")
        private  ResponseEntity<EntityRespone> getAllUserControl(){
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(usercontrolService.getAllUserControl());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK); }



        @PostMapping("/save")
        private Boolean  saveUserControl(@RequestBody UserControlPojo  usercontrol){ 
            return usercontrolService.saveUserControl(usercontrolMapper.PojoToEntity(usercontrolValidationService.valida(usercontrol)) ); }



        @PostMapping("/Update")
        private Long UpdateUserControl(@RequestBody UserControlPojo  usercontrol){ 
        usercontrolService.updateUserControl(usercontrolMapper.PojoToEntity(usercontrolValidationService.valida(usercontrol)));
            return usercontrol.getId(); }


        @PostMapping("/saveOrUpdate")
        private boolean saveOrUpdateUserControl(@RequestBody UserControlPojo  usercontrol){ 
            return usercontrolService.saveOrUpdateUserControl(usercontrolMapper.PojoToEntity(usercontrolValidationService.valida(usercontrol)) ); }



        @PostMapping("/finduser")
        private ResponseEntity<EntityRespone> findRelacionUser(@RequestBody UserPojo user){ 
           EntityRespone entityRespone = mapperEntityRespone.setEntityT(usercontrolService.findByRelacionUser(userMapper.PojoToEntity(userValidationService.valida(user))));
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


