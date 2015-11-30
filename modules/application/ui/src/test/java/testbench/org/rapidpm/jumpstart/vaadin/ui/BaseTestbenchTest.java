package testbench.org.rapidpm.jumpstart.vaadin.ui;

import com.vaadin.testbench.TestBenchTestCase;
import org.jboss.resteasy.test.TestPortProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.rapidpm.ddi.DI;
import org.rapidpm.microservice.Main;

/**
 * Created by svenruppert on 30.11.15.
 */
public class BaseTestbenchTest extends TestBenchTestCase {

  public static final String baseUrl = "http://localhost:" + Main.DEFAULT_SERVLET_PORT + Main.MYAPP;

  @Before
  public void setUpBase() throws Exception {

//    System.setProperty("phantomjs.binary.path", "/Users/svenruppert/Applications/phantomjs-2.0.0-macosx/bin/phantomjs");

    DI.activatePackages("junit.org.rapidpm");
    DI.activatePackages("testbench.org.rapidpm");
    DI.activatePackages("junit.com.vaadin");
    DI.activatePackages("com.vaadin");

    Main.deploy();

    // Create a new Selenium driver - it is automatically extended to work
    // with TestBench
    setDriver(new FirefoxDriver());
//    setDriver(new PhantomJSDriver());

    // Open the test application URL with the ?restartApplication URL
    // parameter to ensure Vaadin provides us with a fresh UI instance.
    getDriver().get(baseUrl + "?restartApplication");

    // If you deploy using WTP in Eclipse, this will fail. You should
    // update baseUrl to point to where the app is deployed.
    String pageSource = getDriver().getPageSource();
    String errorMsg = "Application is not available at " + baseUrl + ". Server not started?";
    Assert.assertFalse(errorMsg, pageSource.contains("HTTP Status 404") ||
        pageSource.contains("can't establish a connection to the server"));
  }

  @After
  public void tearDownBase() throws Exception {

    // Calling quit() on the driver closes the test browser.
    // When called like this, the browser is immediately closed on _any_
    // error. If you wish to take a screenshot of the browser at the time
    // the error occurred, you'll need to add the ScreenshotOnFailureRule
    // to your test and remove this call to quit().
    getDriver().quit();

    Main.stop();
  }


//  public String generateRESTUrl(Class restRessourceClass, String additionalPath) {
//
//    if (restRessourceClass.isAnnotationPresent(Path.class)) {
//
//      final Path path = (Path) restRessourceClass.getAnnotation(Path.class);
//      if (path.value() == null) {
//        throw new DDIModelException("Annotation Path has no value (null) " + restRessourceClass);
//      }
//      final String restAppPath = "/rest";
//      final String generateURL;
//      if (additionalPath == null) {
//        generateURL = TestPortProvider.generateURL(restAppPath + path.value());
//      } else {
//        generateURL = TestPortProvider.generateURL(restAppPath + path.value() + additionalPath);
//      }
//      System.out.println("generateURL = " + generateURL);
//      return generateURL;
//    } else {
//      throw new DDIModelException("The class is not annotated with @Path " + restRessourceClass);
//    }
//  }
}
