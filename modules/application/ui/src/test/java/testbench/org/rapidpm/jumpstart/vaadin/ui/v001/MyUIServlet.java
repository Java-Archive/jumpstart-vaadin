package testbench.org.rapidpm.jumpstart.vaadin.ui.v001;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;
import org.rapidpm.microservice.optionals.vaadin.DDIVaadinServlet;

import javax.servlet.annotation.WebServlet;
import java.time.LocalDateTime;

/**
 * Created by svenruppert on 11.08.15.
 */
@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = false, displayName = "HelloWorldTestbenchTest")
@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
public class MyUIServlet extends DDIVaadinServlet {

  public MyUIServlet() {
    System.out.println("MyUIServlet - LocalDateTime.now() = " + LocalDateTime.now());
  }


}
