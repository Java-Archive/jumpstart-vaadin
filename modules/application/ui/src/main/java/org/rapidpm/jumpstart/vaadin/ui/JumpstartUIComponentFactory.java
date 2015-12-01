package org.rapidpm.jumpstart.vaadin.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.ComponentContainer;

import java.io.Serializable;

/**
 * Created by svenruppert on 01.12.15.
 */
@FunctionalInterface
public interface JumpstartUIComponentFactory extends Serializable {
  ComponentContainer createComponentToSetAsContent(VaadinRequest vaadinRequest);
}
