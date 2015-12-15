package org.rapidpm.jumpstart.vaadin.ui.menubar;

import com.vaadin.ui.MenuBar;

import javax.annotation.PostConstruct;

/**
 * Created by b.bosch on 15.12.2015.
 */
public abstract class MainMenuBar extends MenuBar {
  @PostConstruct
  protected abstract void initMenuBar();

}
