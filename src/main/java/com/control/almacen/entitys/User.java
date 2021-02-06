
/*
Create on Sat Jan 30 15:23:00 ART 2021
*Copyright (C) 121.
@author alejandro
@author Hugo Luna
@author ANACODE AND IVANCODE
@since 11.0
@version1.0.0.0
@version  %I%, %G%
*<p>Description: control de  almacen </p>
*/

package com.control.almacen.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.Date;


@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = -1771914020133067559L;

    @Id
    @GeneratedValue(generator = "sequence_mat_id_generator")
    @SequenceGenerator(name = "sequence_mat_id_generator", initialValue = 25, allocationSize = 1000)
    @Column(name = "id", updatable = true, nullable = false, length = 25)
    private Long id;

    @Column(name = "codigoUser", updatable = true, nullable = true, length = 200)
    private String codigoUser;


    @Column(name = "nombre", updatable = true, nullable = true, length = 200)
    private String nombre;

    @Column(name = "passwork", updatable = true, nullable = true, length = 200)
    private String passwork;

    @Column(name = "dni", updatable = true, nullable = true, length = 200)
    private String dni;

    @Column(name = "activo", updatable = true, nullable = true, length = 200)
    private Boolean activo;

    @Column(name = "rol", updatable = true, nullable = true, length = 200)
    private String rol;

    public User() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCodigoUser() {
        return codigoUser;
    }

    public void setCodigoUser(String codigoUser) {
        this.codigoUser = codigoUser;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(codigoUser, user.codigoUser) && Objects.equals(nombre, user.nombre) && Objects.equals(passwork, user.passwork) && Objects.equals(dni, user.dni) && Objects.equals(activo, user.activo) && Objects.equals(rol, user.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoUser, nombre, passwork, dni, activo, rol);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", codigoUser='" + codigoUser + '\'' +
                ", nombre='" + nombre + '\'' +
                ", passwork='" + passwork + '\'' +
                ", dni='" + dni + '\'' +
                ", activo=" + activo +
                ", rol='" + rol + '\'' +
                '}';
    }
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

