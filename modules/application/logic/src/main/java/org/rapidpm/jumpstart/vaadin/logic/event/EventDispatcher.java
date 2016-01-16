package org.rapidpm.jumpstart.vaadin.logic.event;

/**
 * Created by Sven Ruppert on 15.12.2015.
 */
public interface EventDispatcher<E> {
  void dispatchEvent(E event);
  void addHandler(EventHandlerInvocation handler);
  void removeHandler(EventHandlerInvocation handler);

}
