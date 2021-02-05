

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

import com.control.almacen.entitys.ProductAudit;
import com.control.almacen.pojo.ProductAuditPojo;
import com.control.almacen.entitys.Producto;
import com.control.almacen.pojo.ProductoPojo;
import com.control.almacen.entitys.AlmacenajeArea;
import com.control.almacen.pojo.AlmacenajeAreaPojo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

@Component
public class ProductAuditMapper {

    @Autowired
    private ProductoMapper productomapper;

    @Autowired
    private AlmacenajeAreaMapper almacenajeareamapper;

    public ProductAudit PojoToEntity(ProductAuditPojo pojo) {
        ProductAudit entity = new ProductAudit();
        entity.setId(pojo.getId());
        entity.setCantidaddiferencia(pojo.getCantidaddiferencia());
        entity.setHaydiferenciacantidad(pojo.getHaydiferenciacantidad());
        entity.setHaydiferenciaubicacion(pojo.getHaydiferenciaubicacion());
        entity.setFechaauditado(pojo.getFechaauditado());
        List<Producto> listproductoSystem = new ArrayList<Producto>();
        List<AlmacenajeArea> listareaAlmacenajeAuditoria = new ArrayList<AlmacenajeArea>();
        entity.setproductoSystem(productomapper.PojoToEntity(pojo.getproductoSystem()));

        for (AlmacenajeAreaPojo areaAlmacenajeAuditoriapojo : pojo.getareaAlmacenajeAuditoria()) {
            listareaAlmacenajeAuditoria.add(almacenajeareamapper.PojoToEntity(areaAlmacenajeAuditoriapojo));
        }

        entity.setareaAlmacenajeAuditoria(listareaAlmacenajeAuditoria);
        return entity;
    }


    public ProductAuditPojo entityToPojo(ProductAudit entity) {
        ProductAuditPojo pojo = new ProductAuditPojo();
        List<ProductoPojo> listproductoSystem = new ArrayList<ProductoPojo>();
        List<AlmacenajeAreaPojo> listareaAlmacenajeAuditoria = new ArrayList<AlmacenajeAreaPojo>();
        pojo.setId(entity.getId());
        pojo.setCantidaddiferencia(entity.getCantidaddiferencia());
        pojo.setHaydiferenciacantidad(entity.getHaydiferenciacantidad());
        pojo.setHaydiferenciaubicacion(entity.getHaydiferenciaubicacion());
        pojo.setFechaauditado(entity.getFechaauditado());
        pojo.setproductoSystem(productomapper.entityToPojo(entity.getproductoSystem()));

        for (AlmacenajeArea areaAlmacenajeAuditoriaentity : entity.getareaAlmacenajeAuditoria()) {
            listareaAlmacenajeAuditoria.add(almacenajeareamapper.entityToPojo(areaAlmacenajeAuditoriaentity));
        }
        pojo.setareaAlmacenajeAuditoria(listareaAlmacenajeAuditoria);
        return pojo;
    }

}
