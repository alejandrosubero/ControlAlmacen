

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

import com.control.almacen.entitys.ListadoProducto;
import com.control.almacen.pojo.ListadoProductoPojo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

@Component
public class ListadoProductoMapper {

    public ListadoProducto PojoToEntity(ListadoProductoPojo pojo) {
        ListadoProducto entity = new ListadoProducto();
        entity.setId(pojo.getId());
        entity.setNombre(pojo.getNombre());
        entity.setCodigo(pojo.getCodigo());
        entity.setClasificacion(pojo.getClasificacion());
        entity.setDescripcion(pojo.getDescripcion());
        return entity;
    }


    public ListadoProductoPojo entityToPojo(ListadoProducto entity) {
        ListadoProductoPojo pojo = new ListadoProductoPojo();
        pojo.setId(entity.getId());
        pojo.setNombre(entity.getNombre());
        pojo.setCodigo(entity.getCodigo());
        pojo.setClasificacion(entity.getClasificacion());
        pojo.setDescripcion(entity.getDescripcion());
        return pojo;
    }

}
