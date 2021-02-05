

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

import com.control.almacen.entitys.AlmacenajeArea;
import com.control.almacen.pojo.AlmacenajeAreaPojo;
import com.control.almacen.entitys.Producto;
import com.control.almacen.pojo.ProductoPojo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

@Component
public class AlmacenajeAreaMapper {

    @Autowired
    private ProductoMapper productomapper;

    public AlmacenajeArea PojoToEntity(AlmacenajeAreaPojo pojo) {
        AlmacenajeArea entity = new AlmacenajeArea();
        entity.setId(pojo.getId());
        entity.setArea(pojo.getArea());
        entity.setSeccion(pojo.getSeccion());
        entity.setSubseccion(pojo.getSubseccion());
        entity.setNota(pojo.getNota());
        entity.setActivo(pojo.getActivo());

        return entity;
    }


    public AlmacenajeAreaPojo entityToPojo(AlmacenajeArea entity) {
        AlmacenajeAreaPojo pojo = new AlmacenajeAreaPojo();

        pojo.setId(entity.getId());
        pojo.setArea(entity.getArea());
        pojo.setSeccion(entity.getSeccion());
        pojo.setSubseccion(entity.getSubseccion());
        pojo.setNota(entity.getNota());
        pojo.setActivo(entity.getActivo());


        return pojo;
    }

}
