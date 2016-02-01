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

package testbench.org.rapidpm.jumpstart.vaadin.ui.v002;

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

public class HelloWorldTestbenchTest extends BaseTestbenchTest {

  public static final String BTN_CLICK_ME = "Click Me v002";

  // may be this way ?
  //DI.setResolvedClass(JumpstartUIComponentFactory.class , Factory.class);

  @Test
  public void test001() throws Exception {
    fiveteenClicks();
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
      button.addClickListener(event -> layout.addComponent(new Label("Thank you for clicking V002 " + LocalDateTime.now())));
      layout.addComponent(button);
      return layout;
    }
  }

}
