
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

import com.control.almacen.service.UserControlService;
import com.control.almacen.repository.UserControlRepository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.control.almacen.entitys.UserControl;
import com.control.almacen.entitys.User;


@Service
public class UserControlServiceImplement implements UserControlService {

    protected static final Log logger = LogFactory.getLog(UserControlServiceImplement.class);
    @Autowired
    private UserControlRepository usercontrolrepository;

    @Override
    public UserControl findByLastLoginDate(Date lastLoginDate) {

        logger.info("Starting getUserControl");
        UserControl usercontrolEntity = new UserControl();
        Optional<UserControl> fileOptional1 = usercontrolrepository.findByLastLoginDate(lastLoginDate);
        if (fileOptional1.isPresent()) {
            try {
                usercontrolEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return usercontrolEntity;
    }

    @Override
    public UserControl findByLastOutSystem(Date lastOutSystem) {

        logger.info("Starting getUserControl");
        UserControl usercontrolEntity = new UserControl();
        Optional<UserControl> fileOptional1 = usercontrolrepository.findByLastOutSystem(lastOutSystem);
        if (fileOptional1.isPresent()) {
            try {
                usercontrolEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return usercontrolEntity;
    }

    @Override
    public UserControl findByModificSystem(Boolean modificSystem) {

        logger.info("Starting getUserControl");
        UserControl usercontrolEntity = new UserControl();
        Optional<UserControl> fileOptional1 = usercontrolrepository.findByModificSystem(modificSystem);
        if (fileOptional1.isPresent()) {
            try {
                usercontrolEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return usercontrolEntity;
    }


    @Override
    public List<UserControl> getAllUserControl() {
        logger.info("Get allProyect");
        List<UserControl> listaUserControl = new ArrayList<UserControl>();
        usercontrolrepository.findAll().forEach(usercontrol -> listaUserControl.add(usercontrol));
        return listaUserControl;
    }


    @Override
    public boolean saveUserControl(UserControl usercontrol) {
        logger.info("Save Proyect");
        try {
            usercontrolrepository.save(usercontrol);
            return true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            return false;
        }
    }


    @Override
    public boolean updateUserControl(UserControl usercontrol) {
        logger.info("Update Proyect");
        boolean clave = false;
        UserControl empre = findById(usercontrol.getId());
        empre = usercontrol;
        try {
            usercontrolrepository.save(empre);
            clave = true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            clave = false;
        }
        return clave;
    }


    @Override
    public UserControl findById(Long id) {
        return usercontrolrepository.findById(id).get();
    }


    @Override
    public boolean saveOrUpdateUserControl(UserControl usercontrol) {
        logger.info("Update Proyect");
        boolean clave = false;
        Optional<UserControl> fileOptional2 = usercontrolrepository.findById(usercontrol.getId());
        if (fileOptional2.isPresent()) {
            clave = this.updateUserControl(usercontrol);
            logger.info(" is update");
        } else {
            clave = this.saveUserControl(usercontrol);
            logger.info(" is save");
        }
        return clave;
    }


    @Override
    public List<UserControl> findByLastLoginDateContaining(Date lastlogindate) {
        logger.info("Get allProyect");
        List<UserControl> listaUserControl = new ArrayList<UserControl>();
        listaUserControl = usercontrolrepository.findByLastLoginDateContaining(lastlogindate);
        return listaUserControl;
    }

    @Override
    public List<UserControl> findByLastOutSystemContaining(Date lastoutsystem) {
        logger.info("Get allProyect");
        List<UserControl> listaUserControl = new ArrayList<UserControl>();
        listaUserControl = usercontrolrepository.findByLastOutSystemContaining(lastoutsystem);
        return listaUserControl;
    }

    @Override
    public List<UserControl> findByModificSystemContaining(Boolean modificsystem) {
        logger.info("Get allProyect");
        List<UserControl> listaUserControl = new ArrayList<UserControl>();
        listaUserControl = usercontrolrepository.findByModificSystemContaining(modificsystem);
        return listaUserControl;
    }


    @Override
    public List<UserControl> findByRelacionUser(User user) {
        List<UserControl> listaUserControl = new ArrayList<UserControl>();
        for (UserControl usercontrol : this.getAllUserControl()) {
            if (usercontrol.getuser().equals(user)) {
                listaUserControl.add(usercontrol);
            }
        }
        return listaUserControl;
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
