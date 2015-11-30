package org.rapidpm.jumpstart.vaadin.logic.security;


/**
 * Created by b.bosch on 30.11.2015.
 */
public class AdminLoginService implements LoginService {
  @Override
  public boolean isAllowed(String username, String password) {
    return "admin".equals(username) && "admin".equals(password);
  }
}
