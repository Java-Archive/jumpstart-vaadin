package junit.org.rapidpm.jumpstart.vaadin.logic.event;

import org.rapidpm.jumpstart.vaadin.logic.event.anotations.HandleEvent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by b.bosch on 12.12.2015.
 */
public class TestHandlerClass {
  AtomicInteger callCount = new AtomicInteger(0);

  @HandleEvent
  public void handleTestEvent(TestEvent event){
    int i = callCount.incrementAndGet();
  }


  @HandleEvent
  public void handleSeccondTestEvent(SecondTestEvent event){
    callCount.incrementAndGet();

  }

  public int getCallCount(){
    return callCount.get();
  }
}
