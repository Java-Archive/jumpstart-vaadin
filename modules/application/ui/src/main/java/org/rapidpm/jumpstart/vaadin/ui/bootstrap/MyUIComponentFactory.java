package org.rapidpm.jumpstart.vaadin.ui.bootstrap;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.ComponentContainer;
import org.rapidpm.jumpstart.vaadin.ui.JumpstartUIComponentFactory;
import org.rapidpm.jumpstart.vaadin.ui.screens.LoginScreen;

import javax.inject.Inject;

/**
 * Created by Sven Ruppert on 07.12.15.
 */
public class MyUIComponentFactory implements JumpstartUIComponentFactory {

  @Inject LoginScreen loginScreen;

  @Override
  public ComponentContainer createComponentToSetAsContent(final VaadinRequest vaadinRequest) {
    return loginScreen;
  }
}
