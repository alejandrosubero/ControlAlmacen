

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

    @Autowired
    private ProductoMapper productomapper;

    @Autowired
    private UserMapper usermapper;

    @Autowired
    private ClienteMapper clientemapper;

    public SalidaProducto PojoToEntity(SalidaProductoPojo pojo) {
        SalidaProducto entity = new SalidaProducto();
        entity.setId(pojo.getId());
        entity.setFechadesalida(pojo.getFechadesalida());
        List<Producto> listproducto = new ArrayList<Producto>();
        List<User> listusuario = new ArrayList<User>();
        List<Cliente> listcliente = new ArrayList<Cliente>();
        entity.setproducto(productomapper.PojoToEntity(pojo.getproducto()));
        entity.setusuario(usermapper.PojoToEntity(pojo.getusuario()));
        entity.setcliente(clientemapper.PojoToEntity(pojo.getcliente()));
        return entity;
    }


    public SalidaProductoPojo entityToPojo(SalidaProducto entity) {
        SalidaProductoPojo pojo = new SalidaProductoPojo();
        List<ProductoPojo> listproducto = new ArrayList<ProductoPojo>();
        List<UserPojo> listusuario = new ArrayList<UserPojo>();
        List<ClientePojo> listcliente = new ArrayList<ClientePojo>();
        pojo.setId(entity.getId());
        pojo.setFechadesalida(entity.getFechadesalida());

        pojo.setproducto(productomapper.entityToPojo(entity.getproducto()));
        pojo.setusuario(usermapper.entityToPojo(entity.getusuario()));
        pojo.setcliente(clientemapper.entityToPojo(entity.getcliente()));
        return pojo;
    }

}
