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

import com.vaadin.testbench.TestBenchTestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.rapidpm.ddi.DI;
import org.rapidpm.microservice.Main;
import org.rapidpm.microservice.MainUndertow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class BaseTestbenchTest extends TestBenchTestCase {

  public static final String baseUrl = "http://localhost:" + MainUndertow.DEFAULT_SERVLET_PORT + MainUndertow.MYAPP;
  public static final String VAADIN_TESTBENCH_DRIVER_PROPERTY = "vaadin.testbench.driver";
  public static final String DEAFAULT_WEB_DRIVER = "firefox";
  public static final String FIREFOX = "firefox";
  public static final String CHROME = "chrome";
  public static final String PHANTOMJS = "phantomjs";
  private RemoteWebDriver remoteWebDriver;


  @Before
  public void setUpBase() throws Exception {
    DI.clearReflectionModel();
    DI.activatePackages("org.rapidpm");
    DI.activatePackages(this.getClass());
    DI.activateDI(this);
    Main.deploy();
    setUpTestbench();
  }

  //@Before
  public void setUpTestbench() throws Exception {

//    System.setProperty("phantomjs.binary.path", "/Users/svenruppert/Applications/phantomjs-2.0.0-macosx/bin/phantomjs");


    remoteWebDriver = getRemoteWebDriver();
    // Create a new Selenium driver - it is automatically extended to work
    // with TestBench
    setDriver(remoteWebDriver);
//    setDriver(new PhantomJSDriver());

    // Open the test application URL with the ?restartApplication URL
    // parameter to ensure Vaadin provides us with a fresh UI instance.
    getDriver().get(baseUrl + "?restartApplication");
    if (remoteWebDriver.getCapabilities().getBrowserName().equals(BrowserType.PHANTOMJS)) {
      getCommandExecutor().resizeViewPortTo(1280, 768);
    }

    getCommandExecutor().enableWaitForVaadin();

    // If you deploy using WTP in Eclipse, this will fail. You should
    // update baseUrl to point to where the app is deployed.
    String pageSource = getDriver().getPageSource();
    String errorMsg = "Application is not available at " + baseUrl + ". Server not started?";
    Assert.assertFalse(errorMsg, pageSource.contains("HTTP Status 404") ||
            pageSource.contains("can't establish a connection to the server"));
  }

  private RemoteWebDriver getRemoteWebDriver() {

    String webDriver = System.getProperty(VAADIN_TESTBENCH_DRIVER_PROPERTY, DEAFAULT_WEB_DRIVER);
    RemoteWebDriver remoteWebDriver;
    switch (webDriver.toLowerCase()) {
      case FIREFOX:
        remoteWebDriver = new FirefoxDriver();
        break;
      case CHROME:
        remoteWebDriver = new ChromeDriver();
        break;
      case PHANTOMJS:
        remoteWebDriver = new PhantomJSDriver();
        break;
      default:
        remoteWebDriver = new FirefoxDriver();
    }
    return remoteWebDriver;
  }

  @After
  public void tearDown() throws Exception {
    tearDownTestbench();
    Main.stop();
    DI.clearReflectionModel();
  }

  //@After
  public void tearDownTestbench() throws Exception {

    // Calling quit() on the driver closes the test browser.
    // When called like this, the browser is immediately closed on _any_
    // error. If you wish to take a screenshot of the browser at the time
    // the error occurred, you'll need to add the ScreenshotOnFailureRule
    // to your test and remove this call to quit().
    getDriver().quit();
  }

  @Deprecated
  protected void screenshot() throws IOException {
    saveScreenshot(LocalDateTime.now().toString());
  }

  protected void saveScreenshot(String name) throws IOException {
    String fileName = String.format("%s_%s.png", getClass().getSimpleName(), name);
    byte[] screenshotAs = remoteWebDriver.getScreenshotAs(OutputType.BYTES);
    File file = new File("target", fileName);
    try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
      fileOutputStream.write(screenshotAs);
    }
  }


}
