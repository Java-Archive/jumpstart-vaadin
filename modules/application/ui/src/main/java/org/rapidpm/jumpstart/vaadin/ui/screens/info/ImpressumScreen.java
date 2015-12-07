package org.rapidpm.jumpstart.vaadin.ui.screens.info;

import javax.annotation.PostConstruct;

/**
 * Created by svenruppert on 07.12.15.
 */
public class ImpressumScreen extends BaseInfoScreen {


  @PostConstruct
  public void init() {
    this.setCaption(propertyService.resolve("menue.default.impressum"));
  }
}
