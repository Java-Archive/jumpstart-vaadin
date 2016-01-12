package org.rapidpm.jumpstart.vaadin.ui.menubar;

import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import org.rapidpm.ddi.DI;
import org.rapidpm.jumpstart.vaadin.logic.properties.PropertyService;
import org.rapidpm.jumpstart.vaadin.ui.basics.MainWindow;
import org.rapidpm.jumpstart.vaadin.ui.screens.chat.RapidChat;
import org.rapidpm.jumpstart.vaadin.ui.screens.info.ContactScreen;
import org.rapidpm.jumpstart.vaadin.ui.screens.info.DisclaimerScreen;
import org.rapidpm.jumpstart.vaadin.ui.screens.info.ImpressumScreen;
import org.rapidpm.jumpstart.vaadin.ui.screens.info.SupportScreen;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by svenruppert on 07.12.15.
 */
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
    addItem(propertyService.resolve("menue.default.chat"), menuItem -> MainWindow.getCurrent().setWorkingAreaContainer(DI.activateDI(new RapidChat())));
    addItem(propertyService.resolve("menue.default.help"), null, null)
            .addItem(propertyService.resolve("menue.default.help.contact"), menuItem -> UI.getCurrent().addWindow(DI.activateDI(new ContactScreen())))
            .addItem(propertyService.resolve("menue.default.help.support"), menuItem -> UI.getCurrent().addWindow(DI.activateDI(new SupportScreen())))
            .addItem(propertyService.resolve("menue.default.help.impressum"), menuItem -> UI.getCurrent().addWindow(DI.activateDI(new ImpressumScreen())))
            .addItem(propertyService.resolve("menue.default.help.disclaimer"), menuItem -> UI.getCurrent().addWindow(DI.activateDI(new DisclaimerScreen())));

  }

}
