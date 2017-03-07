/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package testbench.org.rapidpm.jumpstart.vaadin.ui;

import com.vaadin.testbench.By;
import com.vaadin.testbench.elements.VerticalLayoutElement;
import org.openqa.selenium.WebElement;
import org.rapidpm.jumpstart.vaadin.logic.properties.PropertyService;
import org.rapidpm.jumpstart.vaadin.ui.menubar.RapidMenuBar;
import org.rapidpm.jumpstart.vaadin.ui.screens.LoginScreenImpl;

import javax.inject.Inject;

public class TestbenchTest extends BaseTestbenchTest {

  @Inject public PropertyService propertyService;

  public <T extends TestbenchTest> T loginAsAdmin() {
    getElement(LoginScreenImpl.USERNAME_FIELD).sendKeys("admin");
    getElement(LoginScreenImpl.PASSWORD_FIELD).sendKeys("admin");
    getElement(LoginScreenImpl.LOGIN_BUTTON).click();
    return (T) this;
  }

  protected WebElement getElement(final String usernameField) {
    final WebElement webElement = mainLayout();
    return webElement.findElement(By.id(usernameField));
  }

  protected WebElement mainLayout() {
    return $(VerticalLayoutElement.class).first();
  }

  public <T extends TestbenchTest> T walk2MenuBar() {
    getElement(LoginScreenImpl.USERNAME_FIELD).sendKeys("admin");
    getElement(LoginScreenImpl.PASSWORD_FIELD).sendKeys("admin");
    getElement(LoginScreenImpl.LOGIN_BUTTON).click();
    return (T) this;
  }

  public WebElement menubar() {
    final WebElement menubar = getElement(RapidMenuBar.MENUBAR);
    return menubar;
  }


}
