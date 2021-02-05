
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
import com.control.almacen.entitys.Cliente;
import com.control.almacen.validation.ClienteValidation;
import com.control.almacen.mapper.ClienteMapper;
import com.control.almacen.service.ClienteService;
import com.control.almacen.mapper.MapperEntityRespone;
import com.control.almacen.pojo.EntityRespone;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Date;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.control.almacen.pojo.ClientePojo;
import com.control.almacen.pojo.ClientePojo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
   private ClienteService clienteService;

    @Autowired
    private ClienteValidation clienteValidationService;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private MapperEntityRespone mapperEntityRespone;



        @GetMapping("/Getnombre/{nombre}")
        private  ResponseEntity<EntityRespone> findByNombre(@PathVariable("nombre") String  nombre) {
        String busca = (String) clienteValidationService.validation(nombre);
        try {
                EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(clienteService.findByNombre(busca));
                return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
             } catch (DataAccessException e) {
                 EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
     }

        @GetMapping("/Getdireccion/{direccion}")
        private  ResponseEntity<EntityRespone> findByDireccion(@PathVariable("direccion") String  direccion) {
        String busca = (String) clienteValidationService.validation(direccion);
        try {
                EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(clienteService.findByDireccion(busca));
                return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
             } catch (DataAccessException e) {
                 EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
     }

        @GetMapping("/Getnotas/{notas}")
        private  ResponseEntity<EntityRespone> findByNotas(@PathVariable("notas") String  notas) {
        String busca = (String) clienteValidationService.validation(notas);
        try {
                EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(clienteService.findByNotas(busca));
                return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
             } catch (DataAccessException e) {
                 EntityRespone entityRespone = mapperEntityRespone.setEntityResponT(null, "Ocurrio un error", e.getMessage());
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.BAD_REQUEST);
        }
     }


        @GetMapping("/Getnombrecontain/{nombre}")
        private ResponseEntity<EntityRespone> findByNombreContain(@PathVariable("nombre") String  nombre) {
              String busca = (String) clienteValidationService.validation(nombre);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(clienteService.findByNombreContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }

        @GetMapping("/Getdireccioncontain/{direccion}")
        private ResponseEntity<EntityRespone> findByDireccionContain(@PathVariable("direccion") String  direccion) {
              String busca = (String) clienteValidationService.validation(direccion);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(clienteService.findByDireccionContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }

        @GetMapping("/Getnotascontain/{notas}")
        private ResponseEntity<EntityRespone> findByNotasContain(@PathVariable("notas") String  notas) {
              String busca = (String) clienteValidationService.validation(notas);
              EntityRespone entityRespone = mapperEntityRespone.setEntityT(clienteService.findByNotasContaining(busca));
              return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
        }


        @GetMapping("/GetCliente/{id}")
          private ResponseEntity<EntityRespone> findById(@PathVariable("id") String id) {
          EntityRespone entityRespone = mapperEntityRespone.setEntityTobj(clienteService.findById(clienteValidationService.valida_id(id))); 
             return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK);
          }


        @GetMapping("/GetAllCliente")
        private  ResponseEntity<EntityRespone> getAllCliente(){
        EntityRespone entityRespone = mapperEntityRespone.setEntityT(clienteService.getAllCliente());
            return new ResponseEntity<EntityRespone>(entityRespone, HttpStatus.OK); }



        @PostMapping("/save")
        private Boolean  saveCliente(@RequestBody ClientePojo  cliente){ 
            return clienteService.saveCliente(clienteMapper.PojoToEntity(clienteValidationService.valida(cliente)) ); }



        @PostMapping("/Update")
        private Long UpdateCliente(@RequestBody ClientePojo  cliente){ 
        clienteService.updateCliente(clienteMapper.PojoToEntity(clienteValidationService.valida(cliente)));
            return cliente.getId(); }


        @PostMapping("/saveOrUpdate")
        private boolean saveOrUpdateCliente(@RequestBody ClientePojo  cliente){ 
            return clienteService.saveOrUpdateCliente(clienteMapper.PojoToEntity(clienteValidationService.valida(cliente)) ); }


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


