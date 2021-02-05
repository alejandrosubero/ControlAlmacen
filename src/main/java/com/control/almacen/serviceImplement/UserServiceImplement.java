
/*
Create on Sat Jan 30 15:24:05 ART 2021
*Copyright (C) 121.
@author alejandro
@author Hugo Luna
@author ANACODE AND IVANCODE
@since 11.0
@version1.0.0.0
@version  %I%, %G%
*<p>Description: control de  almacen </p>
*/


package com.control.almacen.serviceImplement;

import com.control.almacen.service.UserService;
import com.control.almacen.repository.UserRepository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.control.almacen.entitys.User;


@Service
public class UserServiceImplement implements UserService {

    protected static final Log logger = LogFactory.getLog(UserServiceImplement.class);
    @Autowired
    private UserRepository userrepository;

    @Override
    public User findByNombre(String nombre) {
        logger.info("Starting getUser");
        User userEntity = new User();
        Optional<User> fileOptional1 = userrepository.findByNombre(nombre);
        if (fileOptional1.isPresent()) {
            try {
                userEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return userEntity;
    }

    @Override
    public User findByPasswork(String passwork) {
        logger.info("Starting getUser");
        User userEntity = new User();
        Optional<User> fileOptional1 = userrepository.findByPasswork(passwork);
        if (fileOptional1.isPresent()) {
            try {
                userEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return userEntity;
    }


    @Override
    public User findByDni(String dni) {
        logger.info("Starting getUser");
        User userEntity = new User();
        Optional<User> fileOptional1 = userrepository.findByDni(dni);
        if (fileOptional1.isPresent()) {
            try {
                userEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return userEntity;
    }

    @Override
    public User findByActivo(Boolean activo) {
        logger.info("Starting getUser");
        User userEntity = new User();
        Optional<User> fileOptional1 = userrepository.findByActivo(activo);
        if (fileOptional1.isPresent()) {
            try {
                userEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return userEntity;
    }

    @Override
    public User findByRol(String rol) {
        logger.info("Starting getUser");
        User userEntity = new User();
        Optional<User> fileOptional1 = userrepository.findByRol(rol);
        if (fileOptional1.isPresent()) {
            try {
                userEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return userEntity;
    }


    @Override
    public List<User> getAllUser() {
        logger.info("Get allProyect");
        List<User> listaUser = new ArrayList<User>();
        userrepository.findAll().forEach(user -> listaUser.add(user));
        return listaUser;
    }


    @Override
    public boolean saveUser(User user) {
        logger.info("Save Proyect");
        try {
            userrepository.save(user);
            return true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            return false;
        }
    }


    @Override
    public boolean updateUser(User user) {
        logger.info("Update Proyect");
        boolean clave = false;
        User empre = findById(user.getId());
        empre = user;
        try {
            userrepository.save(empre);
            clave = true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            clave = false;
        }
        return clave;
    }


    @Override
    public User findById(Long id) {
        return userrepository.findById(id).get();
    }


    @Override
    public boolean saveOrUpdateUser(User user) {
        logger.info("Update Proyect");
        boolean clave = false;
        Optional<User> fileOptional2 = userrepository.findById(user.getId());
        if (fileOptional2.isPresent()) {
            clave = this.updateUser(user);
            logger.info(" is update");
        } else {
            clave = this.saveUser(user);
            logger.info(" is save");
        }
        return clave;
    }


    @Override
    public List<User> findByNombreContaining(String nombre) {
        logger.info("Get allProyect");
        List<User> listaUser = new ArrayList<User>();
        listaUser = userrepository.findByNombreContaining(nombre);
        return listaUser;
    }

    @Override
    public List<User> findByPassworkContaining(String passwork) {
        logger.info("Get allProyect");
        List<User> listaUser = new ArrayList<User>();
        listaUser = userrepository.findByPassworkContaining(passwork);
        return listaUser;
    }

    @Override
    public List<User> findByDniContaining(String dni) {
        logger.info("Get allProyect");
        List<User> listaUser = new ArrayList<User>();
        listaUser = userrepository.findByDniContaining(dni);
        return listaUser;
    }

    @Override
    public List<User> findByActivoContaining(Boolean activo) {
        logger.info("Get allProyect");
        List<User> listaUser = new ArrayList<User>();
        listaUser = userrepository.findByActivoContaining(activo);
        return listaUser;
    }

    @Override
    public List<User> findByRolContaining(String rol) {
        logger.info("Get allProyect");
        List<User> listaUser = new ArrayList<User>();
        listaUser = userrepository.findByRolContaining(rol);
        return listaUser;
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


}
