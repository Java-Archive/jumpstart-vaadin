package org.rapidpm.jumpstart.vaadin.logic.event;

import org.rapidpm.jumpstart.vaadin.logic.event.anotations.HandleEvent;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.concurrent.*;

/**
 * Created by b.bosch on 11.12.2015.
 */
public class EventBus {

  private static final ConcurrentHashMap<Class<? extends Serializable>, ConcurrentSkipListSet<EventHandlerInvocation>> handlerMap = new ConcurrentHashMap<>();
  private static final ExecutorService executorService = Executors.newCachedThreadPool();

  public static void register(Object object) throws EventHandlerException {
    final Class clazz = object.getClass();
    for (final Method method : clazz.getMethods()) {
      if (method.isAnnotationPresent(HandleEvent.class)) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 1) {
          throw new EventHandlerException("Method with annotation " + HandleEvent.class.getSimpleName() + " can only have 1 parameter.");
        }
        Class<? extends Serializable> eventClass = (Class<? extends Serializable>) parameterTypes[0];
        addHandlerToBus(object, method, eventClass);
      }
    }
  }

  private static void addHandlerToBus(Object object, Method method, Class<? extends Serializable> eventClass) {
    handlerMap.compute(eventClass, (aClass, eventHandlerDelegators) ->
    {
      if (eventHandlerDelegators == null) {
        eventHandlerDelegators = new ConcurrentSkipListSet<EventHandlerInvocation>();
      }
      eventHandlerDelegators.add(new EventHandlerInvocation(object, method));
      return eventHandlerDelegators;
    });
  }

  public static void fireSycronusEvent(Serializable event) {
    final ConcurrentSkipListSet<EventHandlerInvocation> handlers = handlerMap.getOrDefault(event.getClass(), new ConcurrentSkipListSet<>());
    handlers.forEach(eventHandlerDelegator -> eventHandlerDelegator.invokeHandler(event));
  }

  public static void fireAsyncEvent(Serializable event) {
    final ConcurrentSkipListSet<EventHandlerInvocation> handlers = handlerMap.getOrDefault(event.getClass(), new ConcurrentSkipListSet<>());
    handlers.forEach(eventHandlerDelegator -> executorService.submit(() -> eventHandlerDelegator.invokeHandler(event)));
  }

}
