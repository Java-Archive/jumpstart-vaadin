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

package org.rapidpm.jumpstart.vaadin.logic.event;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

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
