

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

import com.control.almacen.entitys.SalidaProducto;
import com.control.almacen.pojo.SalidaProductoPojo;
import com.control.almacen.entitys.Producto;
import com.control.almacen.pojo.ProductoPojo;
import com.control.almacen.entitys.User;
import com.control.almacen.pojo.UserPojo;
import com.control.almacen.entitys.Cliente;
import com.control.almacen.pojo.ClientePojo;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

@Component
public class SalidaProductoMapper {

//    private Long id;
//    private Date fechadesalida;
//    private Long cantidadSalida;
//    private String ticket;
//    private Long idProductoEnBase;
//    private String codigoProducto;
//    private String nombreProducto;
//    private Long catidadActual;

//    private String encargado;
//    private String nota;
//    private Cliente cliente;


    @Autowired
    private ClienteMapper clientemapper;

    public SalidaProducto PojoToEntity(SalidaProductoPojo pojo) {
        SalidaProducto entity = new SalidaProducto();

        entity.setId(pojo.getId());
        entity.setFechadesalida(pojo.getFechadesalida());
        entity.setCantidadSalida(pojo.getCantidadSalida());
        entity.setTicket(pojo.getTicket());
        entity.setIdProductoEnBase(pojo.getIdProductoEnBase());
        entity.setCodigoProducto(pojo.getCodigoProducto());
        entity.setNombreProducto(pojo.getNombreProducto());
        entity.setCatidadActual(pojo.getCatidadActual());
        entity.setEncargado(pojo.getEncargado());
        entity.setNota(pojo.getNota());
        entity.setCliente(pojo.getCliente());

        return entity;
    }


    public SalidaProductoPojo entityToPojo(SalidaProducto entity) {
        SalidaProductoPojo pojo = new SalidaProductoPojo();

        pojo.setId(entity.getId());
        pojo.setFechadesalida(entity.getFechadesalida());
        pojo.setCantidadSalida(entity.getCantidadSalida());
        pojo.setTicket(entity.getTicket());
        pojo.setIdProductoEnBase(entity.getIdProductoEnBase());
        pojo.setCodigoProducto(entity.getCodigoProducto());
        pojo.setNombreProducto(entity.getNombreProducto());
        pojo.setCatidadActual(entity.getCatidadActual());
        pojo.setEncargado(entity.getEncargado());
        pojo.setNota(entity.getNota());
        pojo.setCliente(entity.getCliente());

        return pojo;
    }

}
