
/*
Create on Sat Jan 30 15:23:57 ART 2021
*Copyright (C) 121.
@author alejandro
@author Hugo Luna
@author ANACODE AND IVANCODE
@since 11.0
@version1.0.0.0
@version  %I%, %G%
*<p>Description: control de  almacen </p>
*/


package com.control.almacen.service ;

import java.util.Optional;import java.util.Date;

import java.util.ArrayList;
import java.util.List;
import com.control.almacen.entitys.ProductAudit;import com.control.almacen.entitys.Producto;
import com.control.almacen.entitys.AlmacenajeArea;



public interface ProductAuditService{
 
		public ProductAudit  findByCantidadDiferencia(Long cantidadDiferencia);

		public ProductAudit  findByHayDiferenciaCantidad(Boolean hayDiferenciaCantidad);

		public ProductAudit  findByHaydiferenciaUbicacion(Boolean haydiferenciaUbicacion);

		public ProductAudit  findByFechaAuditado(Date fechaAuditado);

		public List<ProductAudit>  findByCantidadDiferenciaContaining(Long cantidadDiferencia);

		public List<ProductAudit>  findByHayDiferenciaCantidadContaining(Boolean hayDiferenciaCantidad);

		public List<ProductAudit>  findByHaydiferenciaUbicacionContaining(Boolean haydiferenciaUbicacion);

		public List<ProductAudit>  findByFechaAuditadoContaining(Date fechaAuditado);

		public ProductAudit findById(Long id);
		public boolean saveProductAudit(ProductAudit productaudit);
		public List<ProductAudit> getAllProductAudit();
		public boolean updateProductAudit(ProductAudit productaudit);
 		public boolean saveOrUpdateProductAudit(ProductAudit productaudit);

		public List<ProductAudit>  findByRelacionProducto(Producto producto);
		public List<ProductAudit>  findByAlmacenajeAreaContaining(AlmacenajeArea areaAlmacenajeAuditoria);
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


