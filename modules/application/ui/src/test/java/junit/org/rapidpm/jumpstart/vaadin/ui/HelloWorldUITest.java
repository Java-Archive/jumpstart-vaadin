package junit.org.rapidpm.jumpstart.vaadin.ui;

import org.junit.After;
import org.junit.Before;
import org.rapidpm.ddi.DI;
import org.rapidpm.microservice.Main;


/**
 * Created by svenruppert on 30.11.15.
 */
public class HelloWorldUITest {

  @Before
  public void setUp() throws Exception {
    DI.clearReflectionModel();
    DI.activatePackages("org.rapidpm");
    DI.activatePackages(HelloWorldUITest.class.getPackage().getName());
    Main.deploy();




  }


  @After
  public void tearDown() throws Exception {
    Main.stop();
    DI.clearReflectionModel();
  }
}
