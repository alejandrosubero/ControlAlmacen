

/*
Create on Sat Jan 30 15:24:28 ART 2021
*Copyright (C) 121.
@author alejandro
@author Hugo Luna
@author ANACODE AND IVANCODE
@since 11.0
@version1.0.0.0
@version  %I%, %G%
*<p>Description: control de  almacen </p>
*/


package com.control.almacen.mapper;
import com.control.almacen.entitys.User;
import com.control.almacen.pojo.UserPojo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

    @Component
    public class UserMapper {

        public User PojoToEntity(UserPojo pojo) {
           User entity = new User();
          entity.setId(pojo.getId());
          entity.setNombre(pojo.getNombre());
          entity.setPasswork(pojo.getPasswork());
          entity.setDni(pojo.getDni());
          entity.setActivo(pojo.getActivo());
          entity.setRol(pojo.getRol());
            return entity;
        }


    public UserPojo entityToPojo(User entity) {
        UserPojo pojo = new UserPojo();
        pojo.setId(entity.getId());
        pojo.setNombre(entity.getNombre());
        pojo.setPasswork(entity.getPasswork());
        pojo.setDni(entity.getDni());
        pojo.setActivo(entity.getActivo());
        pojo.setRol(entity.getRol());

            return pojo;
        }

}
