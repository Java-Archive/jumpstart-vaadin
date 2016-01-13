package org.rapidpm.jumpstart.vaadin.ui.screens;

import com.vaadin.event.ShortcutAction;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;
import org.rapidpm.jumpstart.vaadin.logic.api.Languages;
import org.rapidpm.jumpstart.vaadin.logic.properties.PropertyService;
import org.rapidpm.jumpstart.vaadin.logic.security.LoginService;
import org.rapidpm.jumpstart.vaadin.logic.security.User;
import org.rapidpm.jumpstart.vaadin.ui.basics.MainWindow;
import org.rapidpm.jumpstart.vaadin.ui.basics.RapidPanel;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Arrays;

/**
 * Created by svenruppert on 07.12.15.
 */
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
    loginButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
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
        Notification.show(propertyService.resolve("login.failed"), propertyService.resolve("login.failed.description"), Notification.Type.WARNING_MESSAGE);
      }
    });


  }


}
