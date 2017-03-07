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

package org.rapidpm.jumpstart.vaadin.ui.menubar;

import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import org.rapidpm.ddi.DI;
import org.rapidpm.jumpstart.vaadin.logic.properties.PropertyService;
import org.rapidpm.jumpstart.vaadin.ui.basics.MainWindow;
import org.rapidpm.jumpstart.vaadin.ui.screens.info.ContactScreen;
import org.rapidpm.jumpstart.vaadin.ui.screens.info.DisclaimerScreen;
import org.rapidpm.jumpstart.vaadin.ui.screens.info.ImpressumScreen;
import org.rapidpm.jumpstart.vaadin.ui.screens.info.SupportScreen;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class RapidMenuBar extends MenuBar {

  public static final String MENUBAR = "menubar";

  @Inject
  PropertyService propertyService;

  @PostConstruct
  public void initMenuBar() {

    setId(MENUBAR);

    addItem(propertyService.resolve("menue.default.main"), null, null)
            .addItem(propertyService.resolve("menue.default.main.logout"), menuItem -> {
              getSession().close();
              UI.getCurrent().getPage().setLocation("/");
            });
//    addItem(propertyService.resolve("menue.default.chat"), menuItem -> MainWindow.getCurrent().setWorkingAreaContainer(DI.activateDI(new RapidChat())));
    addItem(propertyService.resolve("menue.default.help"), null, null)
            .addItem(propertyService.resolve("menue.default.help.contact"), menuItem -> UI.getCurrent().addWindow(DI.activateDI(new ContactScreen())))
            .addItem(propertyService.resolve("menue.default.help.support"), menuItem -> UI.getCurrent().addWindow(DI.activateDI(new SupportScreen())))
            .addItem(propertyService.resolve("menue.default.help.impressum"), menuItem -> UI.getCurrent().addWindow(DI.activateDI(new ImpressumScreen())))
            .addItem(propertyService.resolve("menue.default.help.disclaimer"), menuItem -> UI.getCurrent().addWindow(DI.activateDI(new DisclaimerScreen())));

  }

}
