
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
import org.springframework.data.repository.CrudRepository;
import com.control.almacen.entitys.User;

public interface UserRepository extends CrudRepository< User, Long> {
 
		public Optional<User> findByNombre(String nombre);
		public List<User> findByNombreContaining(String nombre);
		public Optional<User> findByPasswork(String passwork);
		public List<User> findByPassworkContaining(String passwork);
		public Optional<User> findByDni(String dni);
		public List<User> findByDniContaining(String dni);
		public Optional<User> findByActivo(Boolean activo);
		public List<User> findByActivoContaining(Boolean activo);
		public Optional<User> findByRol(String rol);
		public List<User> findByRolContaining(String rol);

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


