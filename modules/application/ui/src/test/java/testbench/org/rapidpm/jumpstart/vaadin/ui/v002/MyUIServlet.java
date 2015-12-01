package testbench.org.rapidpm.jumpstart.vaadin.ui.v002;

import com.vaadin.annotations.VaadinServletConfiguration;
import org.rapidpm.microservice.optionals.vaadin.DDIVaadinServlet;

import javax.servlet.annotation.WebServlet;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * Created by svenruppert on 11.08.15.
 */
@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = false, displayName = "HelloWorldTestbenchTest")
@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
public class MyUIServlet extends DDIVaadinServlet {

  public MyUIServlet() {
    System.out.println("MyUIServlet - LocalDateTime.now() = " + LocalDateTime.now());
  }


  @Override
  public List<String> topLevelPackagesToActivated() {
    return Collections.emptyList();
  }
}
