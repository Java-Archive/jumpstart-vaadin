package testbench.org.rapidpm.jumpstart.vaadin.ui.screens.login;

import com.vaadin.testbench.elements.NotificationElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.rapidpm.jumpstart.vaadin.ui.basics.MainWindow;
import org.rapidpm.jumpstart.vaadin.ui.menubar.RapidMenuBar;
import org.rapidpm.jumpstart.vaadin.ui.screens.LoginScreen;
import testbench.org.rapidpm.jumpstart.vaadin.ui.TestbenchTest;

import static org.junit.Assert.assertEquals;

/**
 * Created by svenruppert on 07.12.15.
 */
public class LoginTestbenchTest extends TestbenchTest {

  @Test
  public void test001() throws Exception {
    screenshot();
    getElement(LoginScreen.USERNAME_FIELD).sendKeys("admin");
    getElement(LoginScreen.PASSWORD_FIELD).sendKeys("admin");
    getElement(LoginScreen.LOGIN_BUTTON).click();

    final WebElement menubar = getElement(RapidMenuBar.MENUBAR);
    Assert.assertNotNull(menubar);
    Assert.assertTrue(menubar.isDisplayed());
    screenshot();
  }

  @Test
  public void test002() throws Exception {
    screenshot();
    getElement(LoginScreen.USERNAME_FIELD).sendKeys("admin");
    getElement(LoginScreen.PASSWORD_FIELD).sendKeys("XX");
    getElement(LoginScreen.LOGIN_BUTTON).click();

    NotificationElement notification = $(NotificationElement.class).first();
    assertEquals(propertyService.resolve("login.failed"), notification.getCaption());
    assertEquals(propertyService.resolve("login.failed.description"), notification.getDescription());
    assertEquals("warning", notification.getType());
    notification.close();
    screenshot();
  }

}
