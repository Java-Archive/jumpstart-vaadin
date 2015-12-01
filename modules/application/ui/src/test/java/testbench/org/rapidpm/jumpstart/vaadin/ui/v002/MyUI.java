package testbench.org.rapidpm.jumpstart.vaadin.ui.v002;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

import java.time.LocalDateTime;

/**
 *
 */
@Theme("valo")
public class MyUI extends UI {

  public static final String BTN_CLICK_ME = "Click Me v002";

  public MyUI() {
    System.out.println("MyUI() - LocalDateTime.now() = " + LocalDateTime.now());
  }


  public MyUI(final Component content) {
    super(content);
    System.out.println("MyUI(content) - LocalDateTime.now() = " + LocalDateTime.now());
  }

  @Override
  protected void init(VaadinRequest vaadinRequest) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);
    Button button = new Button(BTN_CLICK_ME);
    button.addClickListener(event -> {
      layout.addComponent(new Label("Thank you for clicking V002 " + LocalDateTime.now()));
    });
    layout.addComponent(button);

  }


}
