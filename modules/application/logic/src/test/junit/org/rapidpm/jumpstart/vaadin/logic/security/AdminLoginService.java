package junit.org.rapidpm.jumpstart.vaadin.logic.security;


import org.rapidpm.jumpstart.vaadin.logic.security.LoginService;
import org.rapidpm.jumpstart.vaadin.logic.security.User;

/**
 * Created by b.bosch on 30.11.2015.
 */
public class AdminLoginService implements LoginService {
  @Override
  public boolean isAllowed(String username, String password) {
    return "admin".equals(username) && "admin".equals(password);
  }

  @Override
  public User loadUser(String username, String password) {
    User user = new User();
    user.setUsername(username);
    return user;
  }
}
