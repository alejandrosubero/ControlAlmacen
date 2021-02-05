

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

import com.control.almacen.entitys.Inventario;
import com.control.almacen.pojo.InventarioPojo;
import com.control.almacen.entitys.Producto;
import com.control.almacen.pojo.ProductoPojo;
import com.control.almacen.entitys.Entrada;
import com.control.almacen.pojo.EntradaPojo;
import com.control.almacen.entitys.SalidaProducto;
import com.control.almacen.pojo.SalidaProductoPojo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

@Component
public class InventarioMapper {

    @Autowired
    private ProductoMapper productomapper;

    @Autowired
    private EntradaMapper entradamapper;

    @Autowired
    private SalidaProductoMapper salidaproductomapper;

    public Inventario PojoToEntity(InventarioPojo pojo) {
        Inventario entity = new Inventario();
        entity.setId(pojo.getId());
        entity.setNombre(pojo.getNombre());
        entity.setFechainventario(pojo.getFechainventario());
        List<Producto> listproductos = new ArrayList<Producto>();
        List<Entrada> listentrada = new ArrayList<Entrada>();
        List<SalidaProducto> listsalidas = new ArrayList<SalidaProducto>();
        for (ProductoPojo productospojo : pojo.getproductos()) {
            listproductos.add(productomapper.PojoToEntity(productospojo));
        }
        entity.setproductos(listproductos);
        for (EntradaPojo entradapojo : pojo.getentrada()) {
            listentrada.add(entradamapper.PojoToEntity(entradapojo));
        }
        entity.setentrada(listentrada);
        for (SalidaProductoPojo salidaspojo : pojo.getsalidas()) {
            listsalidas.add(salidaproductomapper.PojoToEntity(salidaspojo));
        }
        entity.setsalidas(listsalidas);
        return entity;
    }


    public InventarioPojo entityToPojo(Inventario entity) {
        InventarioPojo pojo = new InventarioPojo();
        List<ProductoPojo> listproductos = new ArrayList<ProductoPojo>();
        List<EntradaPojo> listentrada = new ArrayList<EntradaPojo>();
        List<SalidaProductoPojo> listsalidas = new ArrayList<SalidaProductoPojo>();
        pojo.setId(entity.getId());
        pojo.setNombre(entity.getNombre());
        pojo.setFechainventario(entity.getFechainventario());

        for (Producto productosentity : entity.getproductos()) {
            listproductos.add(productomapper.entityToPojo(productosentity));
        }
        pojo.setproductos(listproductos);
        for (Entrada entradaentity : entity.getentrada()) {
            listentrada.add(entradamapper.entityToPojo(entradaentity));
        }
        pojo.setentrada(listentrada);
        for (SalidaProducto salidasentity : entity.getsalidas()) {
            listsalidas.add(salidaproductomapper.entityToPojo(salidasentity));
        }
        pojo.setsalidas(listsalidas);
        return pojo;
    }

}
