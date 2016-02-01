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
import com.vaadin.ui.*;
import com.vaadin.ui.Notification.Type;
import org.rapidpm.jumpstart.vaadin.logic.api.Languages;
import org.rapidpm.jumpstart.vaadin.logic.properties.PropertyService;
import org.rapidpm.jumpstart.vaadin.logic.security.LoginService;
import org.rapidpm.jumpstart.vaadin.logic.security.User;
import org.rapidpm.jumpstart.vaadin.ui.basics.MainWindow;
import org.rapidpm.jumpstart.vaadin.ui.basics.RapidPanel;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Arrays;

public class LoginScreen extends RapidPanel {


  public static final String USERNAME_FIELD = "usernameField";
  public static final String PASSWORD_FIELD = "passwordField";
  public static final String LOGIN_BUTTON = "loginButton";
  public static final String USERNAME = "username";
  public static final String LANGUAGE_SESSION_ATTRIBUTE = "language";

  private final Button loginButton = new Button();
  private final FormLayout loginLayout = new FormLayout();
  private final TextField usernameField = new TextField();
  private final PasswordField passwordField = new PasswordField();
  private final ComboBox languageBox = new ComboBox("Language", Arrays.asList(Languages.values()));

  @Inject
  LoginService loginService;
  @Inject
  PropertyService propertyService;
  @Inject
  MainWindow mainWindow;


  public LoginScreen() {
    // self injection if you want or postconstruct
    // DI.activateDI(this);

    usernameField.setId(USERNAME_FIELD);
    passwordField.setId(PASSWORD_FIELD);
    loginButton.setId(LOGIN_BUTTON);

    setSizeFull();
    setSizeUndefined();
    usernameField.focus();

    languageBox.setImmediate(true);
    languageBox.setValue(Languages.GERMAN);
    languageBox.setNullSelectionAllowed(false);
    languageBox.setTextInputAllowed(false);

    loginLayout.addComponent(usernameField);
    loginLayout.addComponent(passwordField);

    addComponent(loginLayout);
    addComponent(loginButton);
    addComponent(languageBox);
  }

  @PostConstruct
  public void postconstruct() {
    usernameField.setCaption(propertyService.resolve("login.username"));
    passwordField.setCaption(propertyService.resolve("login.password"));

    loginButton.setCaption(propertyService.resolve("login.name"));
    loginButton.setClickShortcut(KeyCode.ENTER);
    loginLayout.setCaption(propertyService.resolve("login.info"));
    loginButton.addClickListener(clickEvent -> {
      final String username = usernameField.getValue();
      final String password = passwordField.getValue();

      VaadinSession.getCurrent().setAttribute(LANGUAGE_SESSION_ATTRIBUTE, languageBox.getValue());

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
