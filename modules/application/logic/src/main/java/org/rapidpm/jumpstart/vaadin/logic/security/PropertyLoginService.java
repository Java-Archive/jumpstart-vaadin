/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.rapidpm.jumpstart.vaadin.logic.security;

import org.rapidpm.jumpstart.vaadin.logic.properties.PropertyService;

import javax.inject.Inject;

public class PropertyLoginService implements LoginService {

  @Inject PropertyService propertyService;

  @Override
  public boolean isAllowed(final String username, final String password) {

    if (propertyService.hasKey(username)) {
      final String passwd = propertyService.resolve(username);
      return password.equals(passwd);
    } else {
      return false;
    }
  }

  @Override
  public User loadUser(final String username, final String password) {
    final User user = new User();
    user.setUsername(username);
    return user;
  }
}
