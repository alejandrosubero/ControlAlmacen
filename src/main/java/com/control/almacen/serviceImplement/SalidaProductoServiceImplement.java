
/*
Create on Sat Jan 30 15:24:05 ART 2021
*Copyright (C) 121.
@author alejandro
@author Hugo Luna
@author ANACODE AND IVANCODE
@since 11.0
@version1.0.0.0
@version  %I%, %G%
*<p>Description: control de  almacen </p>
*/


package com.control.almacen.serviceImplement;

import com.control.almacen.mapper.ProductoMapper;
import com.control.almacen.pojo.ProductoPojo;
import com.control.almacen.repository.ProductoRepository;
import com.control.almacen.service.ProductoService;
import com.control.almacen.service.SalidaProductoService;
import com.control.almacen.repository.SalidaProductoRepository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.control.almacen.entitys.SalidaProducto;
import com.control.almacen.entitys.Producto;
import com.control.almacen.entitys.User;
import com.control.almacen.entitys.Cliente;


@Service
public class SalidaProductoServiceImplement implements SalidaProductoService {

    protected static final Log logger = LogFactory.getLog(SalidaProductoServiceImplement.class);

    @Autowired
    private SalidaProductoRepository salidaproductorepository;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public SalidaProducto findByFechadesalida(Date fechadesalida) {
        logger.info("Starting getSalidaProducto");
        SalidaProducto salidaproductoEntity = new SalidaProducto();
        Optional<SalidaProducto> fileOptional1 = salidaproductorepository.findByFechadesalida(fechadesalida);
        if (fileOptional1.isPresent()) {
            try {
                salidaproductoEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);
            }
        }
        return salidaproductoEntity;
    }


    @Override
    public List<SalidaProducto> getAllSalidaProducto() {
        logger.info("Get allProyect");
        List<SalidaProducto> listaSalidaProducto = new ArrayList<SalidaProducto>();
        salidaproductorepository.findAll().forEach(salidaproducto -> listaSalidaProducto.add(salidaproducto));
        return listaSalidaProducto;
    }


    @Override
    public boolean saveSalidaProducto(SalidaProducto salidaproducto) {
        logger.info("Start save out product");
        try {
            logger.info("recupero producto");
            Producto producto =  productoService.findByCodigo(salidaproducto.getproducto().getCodigo());
            Long candidateRest = producto.getCatidadActual() - salidaproducto.getproducto().getUltimaCantidadSalida();
            producto.setCatidadActual(candidateRest);
            producto.setUltimaCantidadSalida(salidaproducto.getproducto().getUltimaCantidadSalida());
            producto.setFechaUltimaSalida(salidaproducto.getproducto().getFechaUltimaSalida());
            logger.info("new salida producto actualiza");
            salidaproducto.setproducto(producto);
            salidaproductorepository.save(salidaproducto);
            logger.info("actualiza producto");
            productoService.saveOrUpdateProducto(producto);
            return true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            return false;
        }
    }


    @Override
    public boolean saveListaSalidaProducto(List<SalidaProducto> salidaproductos) {
        logger.info("Start save out product");
        try {
            logger.info("recupero producto");
            for ( SalidaProducto salidaproducto : salidaproductos) {
                Producto producto =  productoService.findByCodigo(salidaproducto.getproducto().getCodigo());
                Long candidateRest = producto.getCatidadActual() - salidaproducto.getproducto().getUltimaCantidadSalida();
                producto.setCatidadActual(candidateRest);
                producto.setUltimaCantidadSalida(salidaproducto.getproducto().getUltimaCantidadSalida());
                producto.setFechaUltimaSalida(salidaproducto.getproducto().getFechaUltimaSalida());
                logger.info("new salida producto actualiza");
                salidaproducto.setproducto(producto);
                salidaproductorepository.save(salidaproducto);
                logger.info("actualiza producto");
                productoService.saveOrUpdateProducto(producto);
            }
            return true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            return false;
        }
    }



    @Override
    public boolean updateSalidaProducto(SalidaProducto salidaproducto) {
        logger.info("Update Proyect");
        boolean clave = false;
        SalidaProducto empre = findById(salidaproducto.getId());
        empre = salidaproducto;
        try {
            salidaproductorepository.save(empre);
            clave = true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            clave = false;
        }
        return clave;
    }


    @Override
    public SalidaProducto findById(Long id) {
        return salidaproductorepository.findById(id).get();
    }


    @Override
    public boolean saveOrUpdateSalidaProducto(SalidaProducto salidaproducto) {
        logger.info("Update Proyect");
        boolean clave = false;
        Optional<SalidaProducto> fileOptional2 = salidaproductorepository.findById(salidaproducto.getId());
        if (fileOptional2.isPresent()) {
            clave = this.updateSalidaProducto(salidaproducto);
            logger.info(" is update");
        } else {
            clave = this.saveSalidaProducto(salidaproducto);
            logger.info(" is save");
        }
        return clave;
    }


    @Override
    public List<SalidaProducto> findByFechadesalidaContaining(Date fechadesalida) {
        logger.info("Get allProyect");
        List<SalidaProducto> listaSalidaProducto = new ArrayList<SalidaProducto>();
        listaSalidaProducto = salidaproductorepository.findByFechadesalidaContaining(fechadesalida);
        return listaSalidaProducto;
    }


    @Override
    public List<SalidaProducto> findByRelacionProducto(Producto producto) {
        List<SalidaProducto> listaSalidaProducto = new ArrayList<SalidaProducto>();
        for (SalidaProducto salidaproducto : this.getAllSalidaProducto()) {
            if (salidaproducto.getproducto().equals(producto)) {
                listaSalidaProducto.add(salidaproducto);
            }
        }
        return listaSalidaProducto;
    }

    @Override
    public List<SalidaProducto> findByRelacionUser(User user) {
        List<SalidaProducto> listaSalidaProducto = new ArrayList<SalidaProducto>();
        for (SalidaProducto salidaproducto : this.getAllSalidaProducto()) {
            if (salidaproducto.getusuario().equalsUser(user)) {
                listaSalidaProducto.add(salidaproducto);
            }
        }
        return listaSalidaProducto;
    }

    @Override
    public List<SalidaProducto> findByRelacionCliente(Cliente cliente) {
        List<SalidaProducto> listaSalidaProducto = new ArrayList<SalidaProducto>();
        for (SalidaProducto salidaproducto : this.getAllSalidaProducto()) {
            if (salidaproducto.getcliente().equalsCliente(cliente)) {
                listaSalidaProducto.add(salidaproducto);
            }
        }
        return listaSalidaProducto;
    }

 /*
 Copyright (C) 2008 Google Inc.
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/


}
