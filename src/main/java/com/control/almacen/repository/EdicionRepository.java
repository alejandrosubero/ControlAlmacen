
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


package com.control.almacen.repository;

import java.util.List;import java.util.Date;

import java.util.Optional;

import com.control.almacen.entitys.Producto;
import com.control.almacen.entitys.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.control.almacen.entitys.Edicion;
import org.springframework.data.repository.query.Param;

public interface EdicionRepository extends CrudRepository< Edicion, Long> {
 
		public Optional<Edicion> findByFechaEdicion(Date fechaEdicion);
		public List<Edicion> findByFechaEdicionContaining(Date fechaEdicion);
		public Optional<Edicion> findByNotas(String notas);
		public List<Edicion> findByNotasContaining(String notas);

		public List<Edicion> findBySacoproductoContaining(boolean valor);

		public List<Edicion> findByIncrementoProductoContaining(boolean valor);

		public List<Edicion> findByEditoNombreContaining(boolean valor);

		public List<Edicion> findByDesactivoProductoContaining(boolean valor);

		public List<Edicion> findByModificoNotaContaining(boolean valor);

		public List<Edicion> findByModificoFechasContaining(boolean valor);

		public List<Edicion> findByProductoContaining(Producto producto);


	@Query(value = "SELECT p FROM Edicion p WHERE CONCAT(p.fechaEdicion, ' ', p.modificoFechas, ' ', p.sacoproducto, ' ', p.incrementoProducto,' ', p.editoNombre, ' ' , p.desactivoProducto, ' ', p.modificoNota) LIKE %?1%")
	public List<Edicion> finBySearch(String keyword);

	@Query(value = "from Edicion t where t.fechaEdicion BETWEEN :startDate AND :endDate")
	public List<Edicion> getAllBetweenDates(@Param("startDate")Date startDate, @Param("endDate")Date endDate);


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


