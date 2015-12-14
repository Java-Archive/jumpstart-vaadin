package org.rapidpm.jumpstart.vaadin.ui.screens.chat;

import org.rapidpm.jumpstart.vaadin.ui.basics.RapidPanel;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by b.bosch on 10.12.2015.
 */
public class RapidChat extends RapidPanel {
  @Inject
  private RapidChatComponent chatComponent;

  @PostConstruct
  public void init() {
    chatComponent.setSizeFull();
    chatComponent.setResponsive(true);
    this.addComponent(chatComponent);

  }
}
