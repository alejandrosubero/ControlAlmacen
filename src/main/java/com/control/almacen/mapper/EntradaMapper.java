

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

import com.control.almacen.entitys.Entrada;
import com.control.almacen.pojo.EntradaPojo;
import com.control.almacen.entitys.Producto;
import com.control.almacen.pojo.ProductoPojo;
import com.control.almacen.entitys.User;
import com.control.almacen.pojo.UserPojo;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

@Component
public class EntradaMapper {

    @Autowired
    private ProductoMapper productomapper;

    @Autowired
    private UserMapper usermapper;

    public Entrada PojoToEntity(EntradaPojo pojo) {
        Entrada entity = new Entrada();
        entity.setId(pojo.getId());
        entity.setNota(pojo.getNota());
        entity.setCantidadingresada(pojo.getCantidadingresada());
        entity.setFechaingreso(pojo.getFechaingreso());
        List<Producto> listproducto = new ArrayList<Producto>();
        List<User> listencargado = new ArrayList<User>();
        entity.setproducto(productomapper.PojoToEntity(pojo.getproducto()));
        entity.setencargado(usermapper.PojoToEntity(pojo.getencargado()));
        return entity;
    }


    public EntradaPojo entityToPojo(Entrada entity) {
        EntradaPojo pojo = new EntradaPojo();
        List<ProductoPojo> listproducto = new ArrayList<ProductoPojo>();
        List<UserPojo> listencargado = new ArrayList<UserPojo>();
        pojo.setId(entity.getId());
        pojo.setNota(entity.getNota());
        pojo.setCantidadingresada(entity.getCantidadingresada());
        pojo.setFechaingreso(entity.getFechaingreso());

        pojo.setproducto(productomapper.entityToPojo(entity.getproducto()));
        pojo.setencargado(usermapper.entityToPojo(entity.getencargado()));
        return pojo;
    }

}
