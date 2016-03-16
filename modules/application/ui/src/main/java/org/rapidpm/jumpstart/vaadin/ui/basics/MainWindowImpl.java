/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.rapidpm.jumpstart.vaadin.ui.basics;

import com.vaadin.ui.*;
import org.rapidpm.jumpstart.vaadin.logic.properties.PropertyService;
import org.rapidpm.jumpstart.vaadin.ui.menubar.RapidMenuBar;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class MainWindowImpl extends VerticalLayout  implements MainWindow {

  public static final String WORKING_AREA_CONTAINER = "workingAreaContainer";

  @Inject
  public PropertyService propertyService;
  @Inject
  public RapidMenuBar menubar;

  @Inject
  public TopPanel topPanel;


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
