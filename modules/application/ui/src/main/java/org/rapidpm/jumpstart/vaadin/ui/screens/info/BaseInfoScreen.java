package org.rapidpm.jumpstart.vaadin.ui.screens.info;

import org.rapidpm.jumpstart.vaadin.ui.basics.RapidWindow;

import javax.annotation.PostConstruct;


/**
 * Created by svenruppert on 07.12.15.
 */
public class BaseInfoScreen extends RapidWindow {


  @PostConstruct
  public void init() {
    this.setWidth(50, Unit.PERCENTAGE);
    this.setHeight(50, Unit.PERCENTAGE);
  }

}
