package testbench.org.rapidpm.jumpstart.vaadin.ui.v001;

import com.vaadin.server.VaadinRequest;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.junit.Test;
import org.rapidpm.ddi.ResponsibleFor;
import org.rapidpm.ddi.implresolver.ClassResolver;
import org.rapidpm.jumpstart.vaadin.ui.JumpstartUIComponentFactory;
import testbench.org.rapidpm.jumpstart.vaadin.ui.BaseTestbenchTest;

import java.time.LocalDateTime;

/**
 * Created by svenruppert on 30.11.15.
 */
public class HelloWorldTestbenchTest extends BaseTestbenchTest {

  public static final String BTN_CLICK_ME = "Click Me v001";

  // may be this way ?
  //DI.setResolvedClass(JumpstartUIComponentFactory.class , Factory.class);

  @ResponsibleFor(JumpstartUIComponentFactory.class)
  public static class JumpstartUIComponentFactoryClassResolver
      implements ClassResolver<JumpstartUIComponentFactory> {
    @Override
    public Class<? extends JumpstartUIComponentFactory> resolve(final Class<JumpstartUIComponentFactory> interf) {
      return Factory.class;
    }
  }

  public static class Factory implements JumpstartUIComponentFactory {
    @Override
    public ComponentContainer createComponentToSetAsContent(final VaadinRequest vaadinRequest) {
      final VerticalLayout layout = new VerticalLayout();
      layout.setMargin(true);
      Button button = new Button(BTN_CLICK_ME);
      button.addClickListener(event -> layout.addComponent(new Label("Thank you for clicking V001 " + LocalDateTime.now())));
      layout.addComponent(button);
      return layout;
    }
  }

  @Test
  public void test001() throws Exception {
    saveScreenshot("before");
    fiveteenClicks();
    saveScreenshot("after");
  }

  private void fiveteenClicks() {
    $(ButtonElement.class).caption(BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(BTN_CLICK_ME).first().click();
    $(ButtonElement.class).caption(BTN_CLICK_ME).first().click();
  }
}
