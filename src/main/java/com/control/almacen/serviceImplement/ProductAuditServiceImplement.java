
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

import com.control.almacen.service.ProductAuditService;
import com.control.almacen.repository.ProductAuditRepository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.control.almacen.entitys.ProductAudit;
import com.control.almacen.entitys.Producto;
import com.control.almacen.entitys.AlmacenajeArea;


@Service
public class ProductAuditServiceImplement implements ProductAuditService {

    protected static final Log logger = LogFactory.getLog(ProductAuditServiceImplement.class);
    @Autowired
    private ProductAuditRepository productauditrepository;

    @Override
    public ProductAudit findByCantidadDiferencia(Long cantidadDiferencia) {

        logger.info("Starting getProductAudit");
        ProductAudit productauditEntity = new ProductAudit();
        Optional<ProductAudit> fileOptional1 = productauditrepository.findByCantidadDiferencia(cantidadDiferencia);

        if (fileOptional1.isPresent()) {

            try {
                productauditEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);

            }
        }
        return productauditEntity;
    }

    @Override
    public ProductAudit findByHayDiferenciaCantidad(Boolean hayDiferenciaCantidad) {

        logger.info("Starting getProductAudit");
        ProductAudit productauditEntity = new ProductAudit();
        Optional<ProductAudit> fileOptional1 = productauditrepository.findByHayDiferenciaCantidad(hayDiferenciaCantidad);

        if (fileOptional1.isPresent()) {

            try {
                productauditEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);

            }
        }
        return productauditEntity;
    }

    @Override
    public ProductAudit findByHaydiferenciaUbicacion(Boolean haydiferenciaUbicacion) {

        logger.info("Starting getProductAudit");
        ProductAudit productauditEntity = new ProductAudit();
        Optional<ProductAudit> fileOptional1 = productauditrepository.findByHaydiferenciaUbicacion(haydiferenciaUbicacion);

        if (fileOptional1.isPresent()) {

            try {
                productauditEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);

            }
        }
        return productauditEntity;
    }

    @Override
    public ProductAudit findByFechaAuditado(Date fechaAuditado) {

        logger.info("Starting getProductAudit");
        ProductAudit productauditEntity = new ProductAudit();
        Optional<ProductAudit> fileOptional1 = productauditrepository.findByFechaAuditado(fechaAuditado);

        if (fileOptional1.isPresent()) {

            try {
                productauditEntity = fileOptional1.get();
            } catch (DataAccessException e) {
                logger.error(" ERROR : " + e);

            }
        }
        return productauditEntity;
    }


    @Override
    public List<ProductAudit> getAllProductAudit() {
        logger.info("Get allProyect");
        List<ProductAudit> listaProductAudit = new ArrayList<ProductAudit>();
        productauditrepository.findAll().forEach(productaudit -> listaProductAudit.add(productaudit));
        return listaProductAudit;
    }


    @Override
    public boolean saveProductAudit(ProductAudit productaudit) {
        logger.info("Save Proyect");


        try {
            productauditrepository.save(productaudit);
            return true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            return false;
        }
    }


    @Override
    public boolean updateProductAudit(ProductAudit productaudit) {
        logger.info("Update Proyect");
        boolean clave = false;
        ProductAudit empre = findById(productaudit.getId());
        empre = productaudit;

        try {
            productauditrepository.save(empre);
            clave = true;
        } catch (DataAccessException e) {
            logger.error(" ERROR : " + e);
            clave = false;
        }

        return clave;
    }


    @Override
    public ProductAudit findById(Long id) {
        return productauditrepository.findById(id).get();
    }


    @Override
    public boolean saveOrUpdateProductAudit(ProductAudit productaudit) {
        logger.info("Update Proyect");
        boolean clave = false;
        Optional<ProductAudit> fileOptional2 = productauditrepository.findById(productaudit.getId());
        if (fileOptional2.isPresent()) {
            clave = this.updateProductAudit(productaudit);
            logger.info(" is update");
        } else {
            clave = this.saveProductAudit(productaudit);
            logger.info(" is save");
        }
        return clave;
    }


    @Override
    public List<ProductAudit> findByCantidadDiferenciaContaining(Long cantidaddiferencia) {
        logger.info("Get allProyect");
        List<ProductAudit> listaProductAudit = new ArrayList<ProductAudit>();
        listaProductAudit = productauditrepository.findByCantidadDiferenciaContaining(cantidaddiferencia);
        return listaProductAudit;
    }

    @Override
    public List<ProductAudit> findByHayDiferenciaCantidadContaining(Boolean haydiferenciacantidad) {
        logger.info("Get allProyect");
        List<ProductAudit> listaProductAudit = new ArrayList<ProductAudit>();
        listaProductAudit = productauditrepository.findByHayDiferenciaCantidadContaining(haydiferenciacantidad);
        return listaProductAudit;
    }

    @Override
    public List<ProductAudit> findByHaydiferenciaUbicacionContaining(Boolean haydiferenciaubicacion) {
        logger.info("Get allProyect");
        List<ProductAudit> listaProductAudit = new ArrayList<ProductAudit>();
        listaProductAudit = productauditrepository.findByHaydiferenciaUbicacionContaining(haydiferenciaubicacion);
        return listaProductAudit;
    }

    @Override
    public List<ProductAudit> findByFechaAuditadoContaining(Date fechaauditado) {
        logger.info("Get allProyect");
        List<ProductAudit> listaProductAudit = new ArrayList<ProductAudit>();
        listaProductAudit = productauditrepository.findByFechaAuditadoContaining(fechaauditado);
        return listaProductAudit;
    }


    @Override
    public List<ProductAudit> findByRelacionProducto(Producto producto) {
        List<ProductAudit> listaProductAudit = new ArrayList<ProductAudit>();
        for (ProductAudit productaudit : this.getAllProductAudit()) {
            if (productaudit.getproductoSystem().equals(producto)) {
                listaProductAudit.add(productaudit);
            }
        }
        return listaProductAudit;
    }


    @Override
    public List<ProductAudit> findByAlmacenajeAreaContaining(AlmacenajeArea areaAlmacenajeAuditoria) {
        logger.info("metodo: metodContainingRelacion NEW ");
        logger.info("Get allProyect");
        List<ProductAudit> listaProductAudit = new ArrayList<ProductAudit>();
        for (ProductAudit productaudit : this.getAllProductAudit()) {
            for (AlmacenajeArea areaAlmacenajeAuditoriax : productaudit.getareaAlmacenajeAuditoria()) {
                if (areaAlmacenajeAuditoriax.equalsAlmacenajeArea(areaAlmacenajeAuditoria)) {
                    listaProductAudit.add(productaudit);
                }
            }
        }
        return listaProductAudit;

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
