
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



package com.control.almacen.serviceImplement ;

import com.control.almacen.service.ClienteService;
import com.control.almacen.repository.ClienteRepository;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.control.almacen.entitys.Cliente;




@Service
public class ClienteServiceImplement implements ClienteService {

protected static final Log logger = LogFactory.getLog(ClienteServiceImplement.class);
@Autowired
private ClienteRepository clienterepository;

		@Override
		public Cliente findByNombre(String nombre){

		logger.info("Starting getCliente");
			Cliente clienteEntity = new Cliente();
		Optional<Cliente> fileOptional1 = clienterepository.findByNombre(nombre);

		if (fileOptional1.isPresent()) { 

				try {
			clienteEntity = fileOptional1.get();
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);

				}
		}
		return clienteEntity;	}
		@Override
		public Cliente findByDireccion(String direccion){

		logger.info("Starting getCliente");
			Cliente clienteEntity = new Cliente();
		Optional<Cliente> fileOptional1 = clienterepository.findByDireccion(direccion);

		if (fileOptional1.isPresent()) { 

				try {
			clienteEntity = fileOptional1.get();
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);

				}
		}
		return clienteEntity;	}
		@Override
		public Cliente findByNotas(String notas){

		logger.info("Starting getCliente");
			Cliente clienteEntity = new Cliente();
		Optional<Cliente> fileOptional1 = clienterepository.findByNotas(notas);

		if (fileOptional1.isPresent()) { 

				try {
			clienteEntity = fileOptional1.get();
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);

				}
		}
		return clienteEntity;	}




		@Override
		public List<Cliente> getAllCliente(){
		logger.info("Get allProyect");
			List<Cliente> listaCliente = new ArrayList<Cliente>();
				clienterepository.findAll().forEach(cliente -> listaCliente.add(cliente));
			return listaCliente;
}


		@Override
		public boolean saveCliente(Cliente cliente){
		logger.info("Save Proyect");


				try {
				clienterepository.save(cliente);
				return true;
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);
				return false;
				}
		}




		@Override
		public boolean updateCliente(Cliente  cliente ){
			logger.info("Update Proyect");
			boolean clave = false;
		Cliente empre = findById(cliente.getId());
			empre = cliente;

				try {
				clienterepository.save(empre);
						clave = true;
				} catch (DataAccessException e) {
				logger.error(" ERROR : " + e);
				clave = false;
				}

					return clave;
	}



		@Override
		public Cliente findById( Long id){
				return  clienterepository.findById(id).get();
		}



		@Override
		public boolean saveOrUpdateCliente(Cliente  cliente ){
			logger.info("Update Proyect");
			boolean clave = false;
			Optional<Cliente> fileOptional2 = clienterepository.findById(cliente.getId());
			if (fileOptional2.isPresent()) { 
				clave = this.updateCliente(cliente);
				logger.info(" is update");
			} else {
					clave = this.saveCliente(cliente);
					logger.info(" is save");
 				}
 		return clave;
		}


		@Override
		public List<Cliente> findByNombreContaining(String nombre){
			logger.info("Get allProyect");
 			List<Cliente> listaCliente = new ArrayList<Cliente>();
			listaCliente = clienterepository.findByNombreContaining(nombre);
  			return listaCliente;
		}

		@Override
		public List<Cliente> findByDireccionContaining(String direccion){
			logger.info("Get allProyect");
 			List<Cliente> listaCliente = new ArrayList<Cliente>();
			listaCliente = clienterepository.findByDireccionContaining(direccion);
  			return listaCliente;
		}

		@Override
		public List<Cliente> findByNotasContaining(String notas){
			logger.info("Get allProyect");
 			List<Cliente> listaCliente = new ArrayList<Cliente>();
			listaCliente = clienterepository.findByNotasContaining(notas);
  			return listaCliente;
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
