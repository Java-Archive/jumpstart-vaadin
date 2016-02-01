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

package junit.org.rapidpm.jumpstart.vaadin.ui;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rapidpm.ddi.DI;
import org.rapidpm.ddi.ResponsibleFor;
import org.rapidpm.ddi.implresolver.ClassResolver;
import org.rapidpm.jumpstart.vaadin.logic.security.LoginService;

import javax.inject.Inject;

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

  @ResponsibleFor(LoginService.class)
  public static class ImplResolver implements ClassResolver<LoginService> {

    @Override
    public Class<? extends LoginService> resolve(final Class<LoginService> interf) {
      return AdminLoginService.class;
    }
  }

  public class LoginTester {
    @Inject
    LoginService loginService;


  }
}
