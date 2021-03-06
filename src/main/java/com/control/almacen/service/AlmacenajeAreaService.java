
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
import com.control.almacen.entitys.AlmacenajeArea;import com.control.almacen.entitys.Producto;



public interface AlmacenajeAreaService{

		public AlmacenajeArea  findById(Long id);
		public AlmacenajeArea  findByArea(String area);
		public AlmacenajeArea  findBySeccion(String seccion);
		public AlmacenajeArea  findBySubseccion(String subseccion);
		public AlmacenajeArea  findByNota(String nota);
		public AlmacenajeArea  findByActivo(Boolean activo);
		public List<AlmacenajeArea> getAllAlmacenajeArea();

		public List<AlmacenajeArea>  findByAreaContaining(String area);
		public List<AlmacenajeArea>  findBySeccionContaining(String seccion);
		public List<AlmacenajeArea>  findBySubseccionContaining(String subseccion);
		public List<AlmacenajeArea>  findByNotaContaining(String nota);
		public List<AlmacenajeArea>  findByActivoContaining(Boolean activo);


		public boolean saveAlmacenajeArea(AlmacenajeArea almacenajearea);
		public boolean updateAlmacenajeArea(AlmacenajeArea almacenajearea);
 		public boolean saveOrUpdateAlmacenajeArea(AlmacenajeArea almacenajearea);


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


