package org.rapidpm.jumpstart.vaadin.ui.screens.info;


import javax.annotation.PostConstruct;

/**
 * Created by Sven Ruppert on 07.12.15.
 */
public class SupportScreen extends BaseInfoScreen {


  @PostConstruct
  public void init() {
    this.setCaption(propertyService.resolve("menue.default.support"));
  }
}
