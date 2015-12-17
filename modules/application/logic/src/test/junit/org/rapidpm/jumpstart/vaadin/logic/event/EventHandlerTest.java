package junit.org.rapidpm.jumpstart.vaadin.logic.event;

import org.junit.Assert;
import org.junit.Test;
import org.rapidpm.jumpstart.vaadin.logic.event.EventBus;

import javax.inject.Inject;

/**
 * Created by b.bosch on 12.12.2015.
 */
public class EventHandlerTest {

  public static final int FIRE_NR_EVENTS = 100;

  @Test
  public void test001() throws Exception {

    TestHandlerClass testHandlerClass = new TestHandlerClass();
    TestHandlerClass testHandlerClass2 = new TestHandlerClass();
    EventBus.register(testHandlerClass);

    for(int i = 0; i < FIRE_NR_EVENTS; i++){
      EventBus.fireSycronusEvent(new TestEvent());
    }
     EventBus.register(testHandlerClass2);

    for(int i = 0; i < FIRE_NR_EVENTS; i++){
      EventBus.fireSycronusEvent(new SecondTestEvent());
    }


    Assert.assertEquals(FIRE_NR_EVENTS * 2, testHandlerClass.getCallCount());
    Assert.assertEquals(FIRE_NR_EVENTS, testHandlerClass2.getCallCount());
  }

  @Test
  public void test002() throws Exception {
    TestHandlerClass testHandlerClass = new TestHandlerClass();
    TestHandlerClass testHandlerClass2 = new TestHandlerClass();
    EventBus.register(testHandlerClass);

    for(int i = 0; i < FIRE_NR_EVENTS; i++){
      EventBus.fireAsyncEvent(new TestEvent());
    }
    EventBus.register(testHandlerClass2);

    for(int i = 0; i < FIRE_NR_EVENTS; i++){
      EventBus.fireAsyncEvent(new SecondTestEvent());
    }
    Thread.sleep(100);
    Assert.assertEquals(FIRE_NR_EVENTS * 2, testHandlerClass.getCallCount());
    Assert.assertEquals(FIRE_NR_EVENTS, testHandlerClass2.getCallCount());
  }
}
