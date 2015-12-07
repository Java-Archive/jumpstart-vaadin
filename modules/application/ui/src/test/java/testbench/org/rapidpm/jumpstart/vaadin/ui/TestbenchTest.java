package testbench.org.rapidpm.jumpstart.vaadin.ui;

import com.vaadin.testbench.By;
import com.vaadin.testbench.elements.VerticalLayoutElement;
import org.openqa.selenium.WebElement;
import org.rapidpm.jumpstart.vaadin.logic.properties.PropertyService;
import org.rapidpm.jumpstart.vaadin.ui.basics.MainWindow;
import org.rapidpm.jumpstart.vaadin.ui.menubar.RapidMenuBar;
import org.rapidpm.jumpstart.vaadin.ui.screens.LoginScreen;

import javax.inject.Inject;

/**
 * Created by svenruppert on 07.12.15.
 */
public class TestbenchTest extends BaseTestbenchTest {

  public @Inject PropertyService propertyService;

  public <T extends TestbenchTest> T loginAsAdmin() {
    getElement(LoginScreen.USERNAME_FIELD).sendKeys("admin");
    getElement(LoginScreen.PASSWORD_FIELD).sendKeys("admin");
    getElement(LoginScreen.LOGIN_BUTTON).click();
    return (T) this;
  }

  public <T extends TestbenchTest> T walk2MenuBar() {
    getElement(LoginScreen.USERNAME_FIELD).sendKeys("admin");
    getElement(LoginScreen.PASSWORD_FIELD).sendKeys("admin");
    getElement(LoginScreen.LOGIN_BUTTON).click();
    return (T) this;
  }

  public WebElement menubar() {
    final WebElement menubar = getElement(RapidMenuBar.MENUBAR);
    return menubar;
  }


  protected WebElement getElement(final String usernameField) {
    final WebElement webElement = mainLayout();
    return webElement.findElement(By.id(usernameField));
  }

  protected WebElement mainLayout() {
    return $(VerticalLayoutElement.class).first();
  }


}
