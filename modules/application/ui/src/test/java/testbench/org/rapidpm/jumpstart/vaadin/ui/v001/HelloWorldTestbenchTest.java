package testbench.org.rapidpm.jumpstart.vaadin.ui.v001;

import com.vaadin.testbench.elements.ButtonElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.rapidpm.ddi.DI;
import org.rapidpm.microservice.Main;
import testbench.org.rapidpm.jumpstart.vaadin.ui.BaseTestbenchTest;
import testbench.org.rapidpm.jumpstart.vaadin.ui.v001.MyUI;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by svenruppert on 30.11.15.
 */
public class HelloWorldTestbenchTest extends BaseTestbenchTest {

  @Before
  public void setUpBase() throws Exception {
    DI.clearReflectionModel();
    DI.activatePackages("org.rapidpm");
    DI.activatePackages(this.getClass().getPackage().getName());
    Main.deploy();
    setUpTestbench();
  }

  @After
  public void tearDown() throws Exception {
    tearDownTestbench();
    Main.stop();
    DI.clearReflectionModel();
  }

  @Test
  public void test001() throws Exception {
    fiveteenClicks();
  }

  private void fiveteenClicks() {
    $(ButtonElement.class).caption(MyUI.BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(MyUI.BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(MyUI.BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(MyUI.BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(MyUI.BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(MyUI.BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(MyUI.BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(MyUI.BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(MyUI.BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(MyUI.BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(MyUI.BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(MyUI.BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(MyUI.BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(MyUI.BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(MyUI.BTN_CLICK_ME).first().click();
  }

}
