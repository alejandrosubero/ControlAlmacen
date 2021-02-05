
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
import java.util.Objects;
import java.util.Date;



@Entity
@Table(name = "usercontrol")
public class UserControl implements Serializable {

    private static final long serialVersionUID = 1809232353904959397L;

    @Id
    @GeneratedValue(generator = "sequence_mat_id_generator")
    @SequenceGenerator(name = "sequence_mat_id_generator", initialValue = 25, allocationSize = 1000)
    @Column(name = "id", updatable = true, nullable = false, length = 25)
    private Long id;


    @Column(name = "last_Login_Date", updatable = true, nullable = true, length = 200)
    private Date lastLoginDate;


    @Column(name = "lastOutSystem", updatable = true, nullable = true, length = 200)
    private Date lastOutSystem;


    @Column(name = "modificSystem", updatable = true, nullable = true, length = 200)
    private Boolean modificSystem;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastlogindate() {
        return lastLoginDate;
    }

    public void setLastlogindate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getLastoutsystem() {
        return lastOutSystem;
    }

    public void setLastoutsystem(Date lastOutSystem) {
        this.lastOutSystem = lastOutSystem;
    }

    public Boolean getModificsystem() {
        return modificSystem;
    }

    public void setModificsystem(Boolean modificSystem) {
        this.modificSystem = modificSystem;
    }

    public User getuser() {
        return user;
    }

    public void setuser(User user) {
        this.user = user;
    }


    public boolean equalsUserControl(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserControl usercontrol = (UserControl) o;
        return Objects.equals(id, usercontrol.id) ||
                Objects.equals(lastLoginDate, usercontrol.lastLoginDate) ||
                Objects.equals(lastOutSystem, usercontrol.lastOutSystem) ||
                Objects.equals(modificSystem, usercontrol.modificSystem);

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

