package org.rapidpm.jumpstart.vaadin.ui.basics;

import com.vaadin.server.ClassResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import org.rapidpm.jumpstart.vaadin.logic.properties.PropertyService;
import org.rapidpm.jumpstart.vaadin.ui.menubar.RapidMenuBar;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by svenruppert on 07.12.15.
 */
public class MainWindow extends VerticalLayout {

  public static final String WORKING_AREA_CONTAINER = "workingAreaContainer";

  @Inject PropertyService propertyService;
  @Inject RapidMenuBar menubar;

  public static MainWindow getCurrent() {
    return (MainWindow) UI.getCurrent().getContent();
  }

  private final HorizontalLayout iconsLayout = new HorizontalLayout();

  private RapidPanel workingAreaContainer = new RapidPanel();


  @PostConstruct
  private void buildMainLayout() {
    this.setSizeFull();
    workingAreaContainer.setSizeFull();
    workingAreaContainer.setId(WORKING_AREA_CONTAINER);

    createIconsLayout();

    menubar.setSizeUndefined();
    iconsLayout.setSizeUndefined();
    iconsLayout.setWidth("100%");
    menubar.setWidth("100%");
    workingAreaContainer.setSizeFull();
    this.setSpacing(false);
    this.addComponent(iconsLayout);
    this.addComponent(menubar);
    this.addComponent(workingAreaContainer);
    this.setExpandRatio(workingAreaContainer, 1);
    this.setComponentAlignment(workingAreaContainer, Alignment.MIDDLE_CENTER);
    this.setSpacing(false);
  }

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


  public RapidPanel getWorkingAreaContainer() {
    return workingAreaContainer;
  }

  public void setWorkingAreaContainer(final RapidPanel workingArea) {
    this.workingAreaContainer.removeAllComponents();
    this.replaceComponent(workingAreaContainer,workingArea);
    workingAreaContainer = workingArea;
    this.workingAreaContainer.setSizeFull();
    this.workingAreaContainer.setMargin(true);
    this.workingAreaContainer.setSpacing(true);
    this.workingAreaContainer.setId(WORKING_AREA_CONTAINER);
    this.setExpandRatio(this.workingAreaContainer, 1.0f);
    this.setComponentAlignment(workingAreaContainer, Alignment.MIDDLE_CENTER);
  }

  public MenuBar getMenubar() {
    return menubar;
  }

}
