package org.rapidpm.jumpstart.vaadin.logic.security;

/**
 * Created by Sven Ruppert on 07.12.15.
 */
public class User {

  private String username;


  @Override
  public String toString() {
    return "User{" +
        "username='" + username + '\'' +
        '}';
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }
}
