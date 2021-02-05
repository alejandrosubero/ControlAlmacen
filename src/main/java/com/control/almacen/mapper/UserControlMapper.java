

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
import com.control.almacen.entitys.UserControl;
import com.control.almacen.pojo.UserControlPojo;
import com.control.almacen.entitys.User;
import com.control.almacen.pojo.UserPojo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

    @Component
    public class UserControlMapper {

      @Autowired
      private UserMapper usermapper;

        public UserControl PojoToEntity(UserControlPojo pojo) {
           UserControl entity = new UserControl();
          entity.setId(pojo.getId());
          entity.setLastlogindate(pojo.getLastlogindate());
          entity.setLastoutsystem(pojo.getLastoutsystem());
          entity.setModificsystem(pojo.getModificsystem());
        List<User> listuser = new ArrayList<User>();
        entity.setuser(usermapper.PojoToEntity(pojo.getuser()));
            return entity;
        }


    public UserControlPojo entityToPojo(UserControl entity) {
        UserControlPojo pojo = new UserControlPojo();
        List<UserPojo> listuser = new ArrayList<UserPojo>();
        pojo.setId(entity.getId());
        pojo.setLastlogindate(entity.getLastlogindate());
        pojo.setLastoutsystem(entity.getLastoutsystem());
        pojo.setModificsystem(entity.getModificsystem());

        pojo.setuser(usermapper.entityToPojo(entity.getuser()));
            return pojo;
        }

}
