
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

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import com.control.almacen.entitys.Producto;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository< Producto, Long> {
 
		public Optional<Producto> findByCodigo(String codigo);
		public Optional<Producto> findByNombre(String nombre);
		public Optional<Producto> findByActivo(Boolean activo);

	public List<Producto> findByActivoContaining(Boolean activo);
	public List<Producto> findByCodigoContaining(String codigo);
	public List<Producto> findByNombreContaining(String nombre);
	public List<Producto> findByCantidadInicialContaining(Long cantidadInicial);
	public List<Producto> findByCatidadActualContaining(Long catidadActual);
	public List<Producto> findByClasificacionContaining(String clasificacion);
	public List<Producto> findByDescriptionContaining(String description);
	public List<Producto> findByNotasContaining(String notas);
	public List<Producto> findByFechaIngresoContaining(Date fechaIngreso);

//	public Optional<Producto> findByCantidadInicial(Long cantidadInicial);
//	public Optional<Producto> findByCatidadActual(Long catidadActual);
//	public Optional<Producto> findByNotas(String notas);
//	public Optional<Producto> findByFechaIngreso(Date fechaIngreso);
//	public Optional<Producto> findByClasificacion(String clasificacion);
//	public Optional<Producto> findByDescription(String description);


		@Query(value = "SELECT p FROM Producto p WHERE CONCAT(p.codigo, ' ', p.nombre, ' ', p.description,' ', p.catidadActual, ' ' , p.fechaIngreso, ' ', p.clasificacion) LIKE %?1%")
		public List<Producto> finBySearch(String keyword);


		@Query(value="SELECT t FROM Producto t WHERE t.fechaIngreso Between ?1 and ?2")
		public List<Producto> findAllBetweenDates(@Temporal Date desde, @Temporal Date hasta);


		@Query("select a from Producto a where TRUNC(a.fechaIngreso) between ?1 and ?2")
		List<Producto> findByFechaBetween(@Temporal Date inicio, @Temporal Date fin);


		@Query(value = "from Producto t where t.fechaIngreso BETWEEN :startDate AND :endDate")
		public List<Producto> getAllBetweenDates(@Param("startDate")Date startDate, @Param("endDate")Date endDate);



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





// findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(OffsetDateTime endDate, OffsetDateTime startDate);
//	@Query(value = "from EntityClassTable t where yourDate BETWEEN :startDate AND :endDate")
//	public List<EntityClassTable> getAllBetweenDates(@Param("startDate")Date startDate,@Param("endDate")Date endDate);


//	@Query(value = "SELECT t FROM Humano t WHERE t.id =?1")
//	public Humano findByIdQuery(Long id);
// SELECT * FROM `usuarios` WHERE fecha BETWEEN '2016-03-20' AND '2016-20-31'

// https://www.baeldung.com/spring-data-jpa-query-by-date
