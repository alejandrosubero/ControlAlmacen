

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
public class ProductoMapper {

    @Autowired
    private AlmacenajeAreaMapper almacenajeareamapper;

    public Producto PojoToEntity(ProductoPojo pojo) {
        Producto entity = new Producto();
        entity.setId(pojo.getId());
        entity.setCodigo(pojo.getCodigo());
        entity.setNombre(pojo.getNombre());
        entity.setDescription(pojo.getDescription());
        entity.setCantidadInicial(pojo.getCantidadInicial());
        entity.setCatidadActual(pojo.getCatidadActual());
        entity.setNotas(pojo.getNotas());
        entity.setActivo(pojo.getActivo());
        entity.setFechaIngreso(pojo.getFechaIngreso());
        entity.setClasificacion(pojo.getClasificacion());
        entity.setFechaUltimaSalida(pojo.getFechaUltimaSalida());
        entity.setFechaUltimoIngreso(pojo.getFechaUltimoIngreso());
        entity.setUltimaCantidadIngesada(pojo.getUltimaCantidadIngesada());
        entity.setUltimaCantidadSalida(pojo.getUltimaCantidadSalida());


        List<AlmacenajeArea> listareaAlmacenajeSystem = new ArrayList<AlmacenajeArea>();
        for (AlmacenajeAreaPojo areaAlmacenajeSystempojo : pojo.getAreaAlmacenajeSystem()) {
            listareaAlmacenajeSystem.add(almacenajeareamapper.PojoToEntity(areaAlmacenajeSystempojo));
        }
        entity.setAreaAlmacenajeSystem(listareaAlmacenajeSystem);
        return entity;
    }


    public ProductoPojo entityToPojo(Producto entity) {
        ProductoPojo pojo = new ProductoPojo();
        List<AlmacenajeAreaPojo> listareaAlmacenajeSystem = new ArrayList<AlmacenajeAreaPojo>();
        pojo.setId(entity.getId());
        pojo.setCodigo(entity.getCodigo());
        pojo.setNombre(entity.getNombre());
        pojo.setDescription(entity.getDescription());
        pojo.setCantidadInicial(entity.getCantidadInicial());
        pojo.setCatidadActual(entity.getCatidadActual());
        pojo.setNotas(entity.getNotas());
        pojo.setActivo(entity.getActivo());
        pojo.setFechaIngreso(entity.getFechaIngreso());
        pojo.setClasificacion(entity.getClasificacion());
        pojo.setFechaUltimaSalida(entity.getFechaUltimaSalida());
        pojo.setFechaUltimoIngreso(entity.getFechaUltimoIngreso());
        pojo.setUltimaCantidadIngesada(entity.getUltimaCantidadIngesada());
        pojo.setUltimaCantidadSalida(entity.getUltimaCantidadSalida());


        for (AlmacenajeArea areaAlmacenajeSystementity : entity.getAreaAlmacenajeSystem()) {
            listareaAlmacenajeSystem.add(almacenajeareamapper.entityToPojo(areaAlmacenajeSystementity));
        }
        pojo.setAreaAlmacenajeSystem(listareaAlmacenajeSystem);
        return pojo;
    }

}
