

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

    private Long id;
    private Date fechaEdicion;
    private boolean sacoproducto;
    private boolean incrementoProducto;
    private boolean editoNombre;
    private boolean desactivoProducto;
    private boolean modificoNota;
    private boolean modificoFechas;
    private String notas;
    private User user;
    private Producto producto;




    public Edicion PojoToEntity(EdicionPojo pojo) {
        List<User> listuser = new ArrayList<User>();
        List<Producto> listproducto = new ArrayList<Producto>();

        Edicion entity = new Edicion();

        entity.setId(pojo.getId());
        entity.setFechaEdicion(pojo.getFechaEdicion());
        entity.setSacoproducto(pojo.isSacoproducto());
        entity.setDesactivoProducto(pojo.isDesactivoProducto());
        entity.setEditoNombre(pojo.isEditoNombre());
        entity.setNotas(pojo.getNotas());
        entity.setIncrementoProducto(pojo.isIncrementoProducto());
        entity.setModificoNota(pojo.isModificoNota());
        entity.setModificoFechas(pojo.isModificoFechas());
        entity.setProducto(pojo.getProducto());
        entity.setUser(pojo.getUser());

        return entity;
    }


    public EdicionPojo entityToPojo(Edicion entity) {
        List<UserPojo> listuser = new ArrayList<UserPojo>();
        List<ProductoPojo> listproducto = new ArrayList<ProductoPojo>();

        EdicionPojo pojo = new EdicionPojo();

        pojo.setId(entity.getId());
        pojo.setFechaEdicion(entity.getFechaEdicion());
        pojo.setSacoproducto(entity.isSacoproducto());
        pojo.setDesactivoProducto(entity.isDesactivoProducto());
        pojo.setEditoNombre(entity.isEditoNombre());
        pojo.setNotas(entity.getNotas());
        pojo.setIncrementoProducto(entity.isIncrementoProducto());
        pojo.setModificoNota(entity.isModificoNota());
        pojo.setModificoFechas(entity.isModificoFechas());
        pojo.setProducto(entity.getProducto());
        pojo.setUser(entity.getUser());

        return pojo;
    }

}
