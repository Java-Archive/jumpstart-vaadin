package org.rapidpm.jumpstart.vaadin.ui.basics;

import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;

/**
 * Created by Sven Ruppert on 08.01.2016.
 */
public interface MainWindow extends Component {
  static MainWindow getCurrent() {
    return (MainWindow) UI.getCurrent().getContent();
  }

  void setWorkingAreaContainer(ComponentContainer components);
}
