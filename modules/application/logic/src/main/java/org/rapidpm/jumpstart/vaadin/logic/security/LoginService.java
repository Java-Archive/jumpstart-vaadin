package org.rapidpm.jumpstart.vaadin.logic.security;

/**
 * Created by Sven Ruppert on 30.11.15.
 */
public interface LoginService {
  boolean isAllowed(String username, String password);

  User loadUser(String username, String password);
}
