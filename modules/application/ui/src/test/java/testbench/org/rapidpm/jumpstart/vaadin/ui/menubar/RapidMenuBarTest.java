package testbench.org.rapidpm.jumpstart.vaadin.ui.menubar;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import testbench.org.rapidpm.jumpstart.vaadin.ui.TestbenchTest;

/**
 * Created by svenruppert on 07.12.15.
 */
public class RapidMenuBarTest extends TestbenchTest {


  @Test
  public void test001() throws Exception {
    Assert.assertTrue(
        loginAsAdmin()
            .menubar()
            .findElement(menuItemXPath("menue.default.main"))
            .isDisplayed());

  }

  @NotNull
  private By menuItemXPath(String propertyKey) {
    return By.xpath("//*[text() = '" + propertyService.resolve(propertyKey) + "']");
  }
}