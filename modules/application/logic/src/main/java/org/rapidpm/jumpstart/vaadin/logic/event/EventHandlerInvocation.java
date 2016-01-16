package org.rapidpm.jumpstart.vaadin.logic.event;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Created by Sven Ruppert on 12.12.2015.
 */
public class EventHandlerInvocation implements Comparable {
  private final Object objectToCall;
  private final Method handler;

  public EventHandlerInvocation(Object objectToCall, Method handler) {
    this.objectToCall = objectToCall;
    this.handler = handler;
  }

  public void invokeHandler(Serializable event) {
    try {
      handler.invoke(objectToCall, event);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  @Override
  public int compareTo(Object o) {
    return this.hashCode() - o.hashCode();
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectToCall, handler);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EventHandlerInvocation that = (EventHandlerInvocation) o;
    return Objects.equals(objectToCall, that.objectToCall) &&
            Objects.equals(handler, that.handler);
  }

  public boolean callsHandlerOf(Object objectWithHandler) {
    return objectToCall == objectWithHandler;
  }
}
