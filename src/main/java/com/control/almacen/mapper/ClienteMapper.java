

/*
Create on Sat Jan 30 15:24:28 ART 2021
*Copyright (C) 121.
@author alejandro
@author Hugo Luna
@author ANACODE AND IVANCODE
@since 11.0
@version1.0.0.0
@version  %I%, %G%
*<p>Description: control de  almacen </p>
*/


package com.control.almacen.mapper;

import com.control.almacen.entitys.Cliente;
import com.control.almacen.pojo.ClientePojo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

@Component
public class ClienteMapper {

    public Cliente PojoToEntity(ClientePojo pojo) {
        Cliente entity = new Cliente();
        entity.setId(pojo.getId());
        entity.setNombre(pojo.getNombre());
        entity.setDireccion(pojo.getDireccion());
        entity.setNotas(pojo.getNotas());
        return entity;
    }


    public ClientePojo entityToPojo(Cliente entity) {
        ClientePojo pojo = new ClientePojo();
        pojo.setId(entity.getId());
        pojo.setNombre(entity.getNombre());
        pojo.setDireccion(entity.getDireccion());
        pojo.setNotas(entity.getNotas());

        return pojo;
    }

}
