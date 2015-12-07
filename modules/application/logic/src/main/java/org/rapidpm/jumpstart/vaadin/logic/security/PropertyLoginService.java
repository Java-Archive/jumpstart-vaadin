package org.rapidpm.jumpstart.vaadin.logic.security;

import org.rapidpm.jumpstart.vaadin.logic.properties.PropertyService;

import javax.inject.Inject;

/**
 * Created by svenruppert on 07.12.15.
 */
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
