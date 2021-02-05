package com.control.almacen;

import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.logging.Log;



@SpringBootApplication
public class ControlAlmacenApplication {

		protected static final Log logger = LogFactory.getLog(ControlAlmacenApplication.class);


		public static void main(String[] args) {

		logger.info("the document  Swagger is in link: ==>  http://localhost:1111/control/swagger-ui.html");

			SpringApplication.run(ControlAlmacenApplication.class, args);


		logger.info("the document  Swagger is in link: ==>  http://localhost:1111/control/swagger-ui.html");
	}

}

