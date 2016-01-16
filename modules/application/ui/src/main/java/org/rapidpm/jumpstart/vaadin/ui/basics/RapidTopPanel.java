package org.rapidpm.jumpstart.vaadin.ui.basics;

import com.vaadin.server.ClassResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import org.rapidpm.jumpstart.vaadin.logic.properties.PropertyService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by Sven Ruppert on 15.12.2015.
 */
public class RapidTopPanel implements TopPanel {

  private final HorizontalLayout iconsLayout = new HorizontalLayout();

  @Inject
  private PropertyService propertyService;

  @Override
  public Component getComponent() {
    return iconsLayout;
  }

  @PostConstruct
  private void createIconsLayout() {
    iconsLayout.setWidth("100%");
    iconsLayout.setMargin(new MarginInfo(false, false, false, false));

    if (propertyService.hasKey("app.logo")) {
      final String resourceName = propertyService.resolve("app.logo");
      final Image iconLeft = new Image(null, new ClassResource(resourceName));
      final Image iconRight = new Image(null, new ClassResource(resourceName));

      iconsLayout.addComponent(iconLeft);
      iconsLayout.setComponentAlignment(iconLeft, Alignment.TOP_LEFT);

      if (propertyService.hasKey("app.version")) {
        final Label versionLabel = new Label(propertyService.resolve("app.version"));
        versionLabel.setSizeUndefined();
        iconsLayout.addComponent(versionLabel);
        iconsLayout.setComponentAlignment(versionLabel, Alignment.MIDDLE_CENTER);
        iconsLayout.setExpandRatio(versionLabel, 1.0f);
      }

      iconsLayout.addComponent(iconRight);
      iconsLayout.setComponentAlignment(iconRight, Alignment.TOP_RIGHT);
    }
  }

}
