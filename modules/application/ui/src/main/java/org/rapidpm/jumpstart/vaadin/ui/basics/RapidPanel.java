package org.rapidpm.jumpstart.vaadin.ui.basics;

import com.vaadin.ui.VerticalLayout;
import org.rapidpm.jumpstart.vaadin.logic.properties.PropertyService;

import javax.inject.Inject;

public class RapidPanel extends VerticalLayout {

  @Inject PropertyService propertyService;

  public RapidPanel() {
    this.setSpacing(true);
    this.setMargin(true);
  }
}
