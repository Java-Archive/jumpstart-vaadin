package org.rapidpm.jumpstart.vaadin.ui.basics;

import com.vaadin.ui.*;
import org.rapidpm.jumpstart.vaadin.logic.properties.PropertyService;
import org.rapidpm.jumpstart.vaadin.ui.menubar.RapidMenuBar;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by Sven Ruppert on 07.12.15.
 */
public class MainWindowImpl extends VerticalLayout  implements MainWindow {

  public static final String WORKING_AREA_CONTAINER = "workingAreaContainer";

  @Inject
  private PropertyService propertyService;
  @Inject
  private RapidMenuBar menubar;

  @Inject
  private TopPanel topPanel;


  private ComponentContainer workingAreaContainer = new RapidPanel();



  @PostConstruct
  private void buildMainLayout() {
    this.setSizeFull();
    workingAreaContainer.setSizeFull();
    workingAreaContainer.setId(WORKING_AREA_CONTAINER);
    menubar.setSizeUndefined();
    Component topPanel = this.topPanel.getComponent();
    topPanel.setSizeUndefined();
    topPanel.setWidth("100%");
    menubar.setWidth("100%");
    workingAreaContainer.setSizeFull();
    this.setSpacing(false);
    this.addComponent(topPanel);
    this.addComponent(menubar);
    this.addComponent(workingAreaContainer);
    this.setExpandRatio(workingAreaContainer, 1);
    this.setComponentAlignment(workingAreaContainer, Alignment.MIDDLE_CENTER);
    this.setSpacing(false);
  }



  public ComponentContainer getWorkingAreaContainer() {
    return workingAreaContainer;
  }

  public void setWorkingAreaContainer(final ComponentContainer workingArea) {
    this.workingAreaContainer.removeAllComponents();
    this.replaceComponent(workingAreaContainer, workingArea);
    workingAreaContainer = workingArea;
    this.workingAreaContainer.setSizeFull();
//    VerticalLayout components = new VerticalLayout();
    this.workingAreaContainer.setId(WORKING_AREA_CONTAINER);
    this.setExpandRatio(this.workingAreaContainer, 1.0f);
    this.setComponentAlignment(workingAreaContainer, Alignment.MIDDLE_CENTER);
  }

  public MenuBar getMenubar() {
    return menubar;
  }

}
