
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
import com.control.almacen.entitys.UserControl;import com.control.almacen.entitys.User;



public interface UserControlService{
 
		public UserControl  findByLastLoginDate(Date lastLoginDate);

		public UserControl  findByLastOutSystem(Date lastOutSystem);

		public UserControl  findByModificSystem(Boolean modificSystem);

		public List<UserControl>  findByLastLoginDateContaining(Date lastLoginDate);

		public List<UserControl>  findByLastOutSystemContaining(Date lastOutSystem);

		public List<UserControl>  findByModificSystemContaining(Boolean modificSystem);

		public UserControl findById(Long id);
		public boolean saveUserControl(UserControl usercontrol);
		public List<UserControl> getAllUserControl();
		public boolean updateUserControl(UserControl usercontrol);
 		public boolean saveOrUpdateUserControl(UserControl usercontrol);

		public List<UserControl>  findByRelacionUser(User user);
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


