
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
import com.control.almacen.entitys.Producto;
import com.control.almacen.entitys.AlmacenajeArea;
import com.control.almacen.pojo.ProductoIngreso;


public interface ProductoService{


		public Producto findById(Long id);
		public boolean save(ProductoIngreso productoIngresoList);
		public Producto  findByCodigo(String codigo);

		public Producto  findByNombre(String nombre);


		public List<Producto> getAllProducto();
		public List<Producto>  findByCodigoContaining(String codigo);

		public List<Producto>  findByNombreContaining(String nombre);
		public List<Producto>  findByActivoContaining(Boolean activo);

		public List<Producto> search( String search);
		public List<Producto>  findByDescriptionContaining(String description);
		public List<Producto>  findByCantidadInicialContaining(Long cantidadInicial);
		public List<Producto>  findByCatidadActualContaining(Long catidadActual);
		public List<Producto>  findByNotasContaining(String notas);
		public List<Producto>  findByFechaIngresoContaining(Date fechaIngreso);
		public List<Producto>  findByClasificacionContaining(String clasificacion);

		public List<Producto>  findByAlmacenajeAreaContaining(AlmacenajeArea areaAlmacenajeSystem);

		public boolean saveProducto(Producto producto);
		public boolean updateProducto(Producto producto);
		public boolean saveOrUpdateProducto(Producto producto);


	//	public Producto  findByCantidadInicial(Long cantidadInicial);
	//	public Producto  findByDescription(String description);
	// public Producto  findByFechaIngreso(Date fechaIngreso);
	// public Producto  findByClasificacion(String clasificacion);
	//	public Producto  findByCatidadActual(Long catidadActual);
		//	public Producto  findByNotas(String notas);
		//	public Producto  findByActivo(Boolean activo);








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


