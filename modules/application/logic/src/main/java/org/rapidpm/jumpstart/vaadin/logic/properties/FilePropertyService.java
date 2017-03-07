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

package org.rapidpm.jumpstart.vaadin.logic.properties;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

public class FilePropertyService implements PropertyService {

  private final Map<String, String> storage = new HashMap<>();

  @Override
  public String resolve(final String key) {
    return storage.get(key);
  }

  @Override
  public boolean hasKey(final String key) {
    return storage.containsKey(key);
  }

  @PostConstruct
  public void init() {
    storage.put("admin", "admin");
    storage.put("login.name", "Login"); // i18n
    storage.put("login.info", "Please enter your username and password"); // i18n
    storage.put("login.username", "username"); // i18n
    storage.put("login.password", "password"); // i18n
    storage.put("login.failed", "Login failed..."); // i18n
    storage.put("login.failed.description", "Login failed, please use right User / Password combination"); // i18n

    storage.put("login.language.de", "German");
    storage.put("login.language.en", "English");

    storage.put("app.logo", "/images/rapidpm.PNG"); // i18n
    storage.put("app.version", "Jumpstart Version 0.x.y"); // i18n


    storage.put("menue.default.help", "Help"); // i18n
    storage.put("menue.default.help.contact", "Contact"); // i18n
    storage.put("menue.default.help.support", "Support"); // i18n
    storage.put("menue.default.help.impressum", "Impressum"); // i18n
    storage.put("menue.default.help.disclaimer", "Disclaimer"); // i18n

    storage.put("menue.default.main", "Home"); // i18n
    storage.put("menue.default.main.logout", "Logout"); // i18n7

    storage.put("menue.default.chat", "Chat"); // i18n
  }
}
