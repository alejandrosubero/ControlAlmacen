
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
import com.control.almacen.entitys.ListadoProducto;


public interface ListadoProductoService{
 
		public ListadoProducto  findByNombre(String nombre);

		public ListadoProducto  findByCodigo(String codigo);

		public ListadoProducto  findByClasificacion(String clasificacion);

		public ListadoProducto  findByDescripcion(String descripcion);

		public List<ListadoProducto>  findByNombreContaining(String nombre);

		public List<ListadoProducto>  findByCodigoContaining(String codigo);

		public List<ListadoProducto>  findByClasificacionContaining(String clasificacion);

		public List<ListadoProducto>  findByDescripcionContaining(String descripcion);

		public ListadoProducto findById(Long id);
		public boolean saveListadoProducto(ListadoProducto listadoproducto);
		public List<ListadoProducto> getAllListadoProducto();
		public boolean updateListadoProducto(ListadoProducto listadoproducto);
 		public boolean saveOrUpdateListadoProducto(ListadoProducto listadoproducto);

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


