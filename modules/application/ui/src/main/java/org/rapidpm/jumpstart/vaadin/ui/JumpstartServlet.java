package org.rapidpm.jumpstart.vaadin.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import org.rapidpm.microservice.optionals.vaadin.DDIVaadinServlet;

import javax.servlet.annotation.WebServlet;
import java.util.Collections;
import java.util.List;

/**
 * Created by svenruppert on 01.12.15.
 */
@WebServlet(urlPatterns = "/*", name = "JumpstartServlet", asyncSupported = false, displayName = "JumpstartServlet")
@VaadinServletConfiguration(ui = JumpstartUI.class, productionMode = false)
public class JumpstartServlet extends DDIVaadinServlet {

  @Override
  public List<String> topLevelPackagesToActivated() {
    return Collections.emptyList(); // add custom pkgs
  }
}
