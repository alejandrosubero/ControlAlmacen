

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

import com.control.almacen.entitys.Edicion;
import com.control.almacen.pojo.EdicionPojo;
import com.control.almacen.entitys.User;
import com.control.almacen.pojo.UserPojo;
import com.control.almacen.entitys.Producto;
import com.control.almacen.pojo.ProductoPojo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

@Component
public class EdicionMapper {

    @Autowired
    private UserMapper usermapper;

    @Autowired
    private ProductoMapper productomapper;

    public Edicion PojoToEntity(EdicionPojo pojo) {
        Edicion entity = new Edicion();
        entity.setId(pojo.getId());
        entity.setFechaedicion(pojo.getFechaedicion());
        entity.setNotas(pojo.getNotas());
        List<User> listuser = new ArrayList<User>();
        List<Producto> listproducto = new ArrayList<Producto>();
        entity.setuser(usermapper.PojoToEntity(pojo.getuser()));
        entity.setproducto(productomapper.PojoToEntity(pojo.getproducto()));
        return entity;
    }


    public EdicionPojo entityToPojo(Edicion entity) {
        EdicionPojo pojo = new EdicionPojo();
        List<UserPojo> listuser = new ArrayList<UserPojo>();
        List<ProductoPojo> listproducto = new ArrayList<ProductoPojo>();
        pojo.setId(entity.getId());
        pojo.setFechaedicion(entity.getFechaedicion());
        pojo.setNotas(entity.getNotas());

        pojo.setuser(usermapper.entityToPojo(entity.getuser()));
        pojo.setproducto(productomapper.entityToPojo(entity.getproducto()));
        return pojo;
    }

}
