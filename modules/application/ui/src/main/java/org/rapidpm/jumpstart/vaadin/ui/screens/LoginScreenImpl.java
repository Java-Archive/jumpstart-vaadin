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

package org.rapidpm.jumpstart.vaadin.ui.screens;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import org.rapidpm.jumpstart.vaadin.design.login.LoginScreen;
import org.rapidpm.jumpstart.vaadin.logic.properties.PropertyService;
import org.rapidpm.jumpstart.vaadin.logic.security.LoginService;
import org.rapidpm.jumpstart.vaadin.logic.security.User;
import org.rapidpm.jumpstart.vaadin.ui.basics.MainWindow;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import static java.util.Arrays.asList;

public class LoginScreenImpl extends LoginScreen {


  //how to make this more comfortable for the developer ?
  public static final String USERNAME_FIELD = "usernameField";
  public static final String PASSWORD_FIELD = "passwordField";
  public static final String LOGIN_BUTTON = "loginButton";
  public static final String USERNAME = "username";
  public static final String LANGUAGE_SESSION_ATTRIBUTE = "language";

  @Inject
  LoginService loginService;
  @Inject
  PropertyService propertyService;
  @Inject
  MainWindow mainWindow;


  public LoginScreenImpl() {
    tf_username.setId(USERNAME_FIELD);
    pf_password.setId(PASSWORD_FIELD);
    b_login.setId(LOGIN_BUTTON);

    setSizeFull();
    setSizeUndefined();
    tf_username.focus();

    //languageBox.setImmediate(true);

//    languageBox.setNullSelectionAllowed(false);
    cb_language.setTextInputAllowed(false);
  }

  @PostConstruct
  public void postconstruct() {

    cb_language.setItems(
        asList(
            propertyService.resolve("login.language.en"),
            propertyService.resolve("login.language.en"))
    );

    tf_username.setCaption(propertyService.resolve("login.username"));
    pf_password.setCaption(propertyService.resolve("login.password"));

    b_login.setCaption(propertyService.resolve("login.name"));
    b_login.setClickShortcut(KeyCode.ENTER);
    b_login.setDescription (propertyService.resolve("login.info"));
    b_login.addClickListener(clickEvent -> {
      final String username = tf_username.getValue();
      final String password = pf_password.getValue();

      VaadinSession.getCurrent().setAttribute(LANGUAGE_SESSION_ATTRIBUTE, cb_language.getValue());

      final boolean allowed = loginService.isAllowed(username, password);
      if (allowed) {
        getSession().setAttribute(User.class, loginService.loadUser(username, password));
        UI.getCurrent().setContent(null);

        //setting working Area
        UI.getCurrent().setContent(mainWindow);
      } else {
        Notification.show(propertyService.resolve("login.failed"), propertyService.resolve("login.failed.description"), Type.WARNING_MESSAGE);
      }
    });


  }


}
