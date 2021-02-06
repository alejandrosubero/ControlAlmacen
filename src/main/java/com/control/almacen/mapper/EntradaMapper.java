

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
        entity.setCantidadIngresada(pojo.getCantidadIngresada());
        entity.setFechaIngreso(pojo.getFechaIngreso());
        entity.setTicket(pojo.getTicket());
        entity.setIdProductoEnBase(pojo.getIdProductoEnBase());
        entity.setCodigoProducto(pojo.getCodigoProducto());
        entity.setNombreProducto(pojo.getNombreProducto());
        entity.setCatidadActual(pojo.getCatidadActual());
        entity.setEncargado(pojo.getEncargado());
        entity.setNota(pojo.getNota());

        return entity;
    }


    public EntradaPojo entityToPojo(Entrada entity) {
        EntradaPojo pojo = new EntradaPojo();

        pojo.setId(entity.getId());
        pojo.setCantidadIngresada(entity.getCantidadIngresada());
        pojo.setFechaIngreso(entity.getFechaIngreso());
        pojo.setTicket(entity.getTicket());
        pojo.setIdProductoEnBase(entity.getIdProductoEnBase());
        pojo.setCodigoProducto(entity.getCodigoProducto());
        pojo.setNombreProducto(entity.getNombreProducto());
        pojo.setCatidadActual(entity.getCatidadActual());
        pojo.setEncargado(entity.getEncargado());
        pojo.setNota(entity.getNota());
        return pojo;
    }

}
