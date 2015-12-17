package junit.org.rapidpm.jumpstart.vaadin.logic.security;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rapidpm.ddi.DI;
import org.rapidpm.ddi.ResponsibleFor;
import org.rapidpm.ddi.implresolver.ClassResolver;
import org.rapidpm.jumpstart.vaadin.logic.security.LoginService;

import javax.inject.Inject;

/**
 * Created by b.bosch on 30.11.2015.
 */
public class LoginServiceTest {
  @Before
  public void setUp() throws Exception {
    DI.clearReflectionModel();
    DI.activatePackages(getClass().getPackage().getName());
  }

  @After
  public void tearDown() throws Exception {
    DI.clearReflectionModel();
  }

  @Test
  public void test001() throws Exception {

    LoginTester loginTester = new LoginTester();
    DI.activateDI(loginTester);

    Assert.assertTrue(loginTester.loginService.isAllowed("admin", "admin"));
    Assert.assertFalse(loginTester.loginService.isAllowed("admin1", "admin"));

  }

  public class LoginTester {
    @Inject
    LoginService loginService;


  }
  @ResponsibleFor(LoginService.class)
  public static class LoginServiceClassResolver implements ClassResolver<LoginService>{

    @Override
    public Class<? extends LoginService> resolve(Class<LoginService> interf) {
      return AdminLoginService.class;
    }
  }
}
