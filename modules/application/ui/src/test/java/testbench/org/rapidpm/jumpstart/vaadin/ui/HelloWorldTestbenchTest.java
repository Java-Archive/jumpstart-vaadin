package testbench.org.rapidpm.jumpstart.vaadin.ui;

import com.vaadin.testbench.elements.ButtonElement;
import org.junit.Before;
import org.junit.Test;
import testbench.org.rapidpm.jumpstart.vaadin.ui.v001.MyUI;

/**
 * Created by svenruppert on 30.11.15.
 */
public class HelloWorldTestbenchTest extends BaseTestbenchTest {

  @Override
  @Before
  public void setUpBase() throws Exception {
    super.setUpBase();
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
