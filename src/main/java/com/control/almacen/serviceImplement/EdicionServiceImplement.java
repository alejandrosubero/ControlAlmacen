
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

import com.control.almacen.entitys.*;
import com.control.almacen.pojo.ProductoIngreso;
import com.control.almacen.repository.EntradaRepository;
import com.control.almacen.repository.SalidaProductoRepository;
import com.control.almacen.service.EdicionService;
import com.control.almacen.repository.EdicionRepository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.control.almacen.service.ProductoService;
import com.control.almacen.service.ReconsiliacionProductosService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;





@Service
public class EdicionServiceImplement implements EdicionService {

    protected static final Log logger = LogFactory.getLog(EdicionServiceImplement.class);

    @Autowired
    private EdicionRepository edicionrepository;

    @Autowired
    private ReconsiliacionProductosService reconsiliacionProductosService;

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private SalidaProductoRepository salidaProductoRepository;

    @Autowired
    ProductoService productoService;

    private Producto product;

    /*
     * ACCIONES QUE ENTRAN POR EDICION DE PRODUCTO:
     * Regas logicas de la edicion:
     *
     * 1) si se desactiva el producto hay que hacer una reconciliacion y modificar el producto
     * 2) si saco o introdujo  productos del inventario hay que hacer la reconsiliacion de productos, una entrada o salida segun s
     * ea el caso, y modificar el producto. Y EN NOTA QUE FUE POR EDICION DE PRODUCTO
     * 3) si se edita el nombre hay que hacer una reconsiliacion y modificar el producto.
     * 4) si se modifican fechas del producto hay que hacer una reconciliacion y modificar el producto.
     * 5) si se modifica las notas del producto solo se guarda la edicion y se modifica el producto.
     *
     *
     * */

    @Override
    public List<Edicion> finBySearch(String keyword) {
        return edicionrepository.finBySearch(keyword);
    }

    @Override
    public List<Edicion> getAllBetweenDates(Date startDate, Date endDate) {
        return edicionrepository.getAllBetweenDates(startDate, endDate);
    }


    @Override
    public boolean save(Edicion edicion) {
        logger.info("Save Proyect");
        try {
            edicionrepository.save(edicion);
            return true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            return false;
        }
    }


    private boolean managueEdition(Edicion edicion){
        boolean exito = false;
        if (edicion.isIncrementoProducto()){ exito = this.entradaProducto(edicion); }
        if (edicion.isSacoproducto()){ exito=this.salidaProducto(edicion); }
        if(edicion.isDesactivoProducto()){exito=this.reconciliacion(edicion, "EDICION_MODIFICO_Activo"); }
        if(edicion.isEditoNombre()){exito=this.reconciliacion(edicion, "EDICION_NOMBRE");}
        if(edicion.isModificoFechas()){exito=this.reconciliacion(edicion, "EDICION_FECHAS");}
        if(edicion.isModificoNota()){ exito=this.reconciliacion(edicion, "EDICION_NOTA");}
        boolean saveProducto = productoService.saveProducto(edicion.getProducto());

        boolean respuesta = exito && saveProducto? true: false;

        return respuesta;
    }

    private boolean reconciliacion(Edicion edicion, String casusa){
        try {
            ReconsiliacionProductos reconsiliacion = new ReconsiliacionProductos(edicion.getProducto(), edicion.getFechaEdicion(),casusa, edicion.getUser().getCodigoUser());
            ReconsiliacionProductos recon = reconsiliacionProductosService.save(reconsiliacion);
            boolean respuestas = recon.getTicket().equals(casusa)?  true: false;
            return respuestas;
        }catch (DataAccessException e){
            logger.error(" ERROR : " + e);
            e.printStackTrace();
            return false;
        }
    }


    private boolean salidaProducto(Edicion edicion){
        boolean exito = false;
        try {
            Producto producto = edicion.getProducto();
            Cliente cliente = new Cliente(edicion.getUser().getCodigoUser(), "Cambio interno", edicion.getNotas() );
            SalidaProducto salida = new SalidaProducto("EDICION" ,edicion.getUser().getCodigoUser(), edicion.getNotas(), producto, cliente);
            SalidaProducto sali = salidaProductoRepository.save(salida);

            if(sali.getCodigoProducto() != null){ exito = true; }

             logger.info("Save Producto reconsilacion");

             ReconsiliacionProductos reconsiliacion = new ReconsiliacionProductos(producto, salida);
             reconsiliacionProductosService.save(reconsiliacion);

        }catch (DataAccessException e){
            logger.error(" ERROR : " + e);
            e.printStackTrace();
            return false;
        }
        return exito;
    }


    private boolean entradaProducto(Edicion edicion){
        boolean exito = false;
        try {
            Producto producto = edicion.getProducto();
            Entrada entrada = new Entrada("EDICION" ,edicion.getUser().getCodigoUser(), edicion.getNotas(), producto);
            Entrada entrada2 = entradaRepository.save(entrada);

            if(entrada2.getCodigoProducto() != null){ exito = true; }
            logger.info("Save Producto reconsilacion");

            ReconsiliacionProductos reconsiliacion = new ReconsiliacionProductos(producto,entrada);
            reconsiliacionProductosService.save(reconsiliacion);

        }catch (DataAccessException e){
            logger.error(" ERROR : " + e);
            e.printStackTrace();
            return false;
        }
        return exito;
    }


    @Override
    public List<Edicion> getAllEdicion() {
        logger.info("Get allProyect");
        List<Edicion> listaEdicion = new ArrayList<Edicion>();
        edicionrepository.findAll().forEach(edicion -> listaEdicion.add(edicion));
        return listaEdicion;
    }


    @Override
    public Edicion findById(Long id) {
        return edicionrepository.findById(id).get();
    }


    @Override
    public List<Edicion> findByFechaEdicionContaining(Date fechaedicion) {
        logger.info("Get allProyect");
        List<Edicion> listaEdicion = new ArrayList<Edicion>();
        listaEdicion = edicionrepository.findByFechaEdicionContaining(fechaedicion);
        return listaEdicion;
    }


    @Override
    public List<Edicion> findByRelacionUser(User user) {
        List<Edicion> listaEdicion = new ArrayList<Edicion>();
        for (Edicion edicion : this.getAllEdicion()) {
            if (edicion.getUser().equals(user)) {
                listaEdicion.add(edicion);
            }
        }
        return listaEdicion;
    }


    @Override
    public List<Edicion> findByRelacionProducto(Producto producto) {
        List<Edicion> listaEdicion = new ArrayList<Edicion>();
        for (Edicion edicion : this.getAllEdicion()) {
            if (edicion.getProducto().equals(producto)) {
                listaEdicion.add(edicion);
            }
        }
        return listaEdicion;
    }


//
//
//    @Override
//    public Edicion findByFechaEdicion(Date fechaEdicion) {
//        logger.info("Starting getEdicion");
//        Edicion edicionEntity = new Edicion();
//        Optional<Edicion> fileOptional1 = edicionrepository.findByFechaEdicion(fechaEdicion);
//        if (fileOptional1.isPresent()) {
//            try {
//                edicionEntity = fileOptional1.get();
//            } catch (DataAccessException e) {
//                logger.error(" ERROR : " + e);
//            }
//        }
//        return edicionEntity;
//    }
//
//    @Override
//    public Edicion findByNotas(String notas) {
//        logger.info("Starting getEdicion");
//        Edicion edicionEntity = new Edicion();
//        Optional<Edicion> fileOptional1 = edicionrepository.findByNotas(notas);
//        if (fileOptional1.isPresent()) {
//            try {
//                edicionEntity = fileOptional1.get();
//            } catch (DataAccessException e) {
//                logger.error(" ERROR : " + e);
//            }
//        }
//        return edicionEntity;
//    }
//
//    @Override
//    public boolean saveEdicion(Edicion edicion) {
//        logger.info("Save Proyect");
//        try {
//            edicionrepository.save(edicion);
//            return true;
//        } catch (DataAccessException e) {
//            logger.error(" ERROR : " + e);
//            return false;
//        }
//    }
//
//
//    @Override
//    public boolean updateEdicion(Edicion edicion) {
//        logger.info("Update Proyect");
//        boolean clave = false;
//        Edicion empre = findById(edicion.getId());
//        empre = edicion;
//        try {
//            edicionrepository.save(empre);
//            clave = true;
//        } catch (DataAccessException e) {
//            logger.error(" ERROR : " + e);
//            clave = false;
//        }
//        return clave;
//    }
//
//
//
//    @Override
//    public boolean saveOrUpdateEdicion(Edicion edicion) {
//        logger.info("Update Proyect");
//        boolean clave = false;
//        Optional<Edicion> fileOptional2 = edicionrepository.findById(edicion.getId());
//        if (fileOptional2.isPresent()) {
//            clave = this.updateEdicion(edicion);
//            logger.info(" is update");
//        } else {
//            clave = this.saveEdicion(edicion);
//            logger.info(" is save");
//        }
//        return clave;
//    }
//
//
//
//    @Override
//    public List<Edicion> findByNotasContaining(String notas) {
//        logger.info("Get allProyect");
//        List<Edicion> listaEdicion = new ArrayList<Edicion>();
//        listaEdicion = edicionrepository.findByNotasContaining(notas);
//        return listaEdicion;
//    }
//




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
