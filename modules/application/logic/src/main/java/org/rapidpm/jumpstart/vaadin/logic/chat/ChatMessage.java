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

package org.rapidpm.jumpstart.vaadin.logic.chat;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ChatMessage implements Serializable {
  private final String user;
  private final LocalDateTime timestamp;
  private final String message;

  public ChatMessage(String user, LocalDateTime timestamp, String message) {
    this.user = user;
    this.timestamp = timestamp;
    this.message = message;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  @Override
  public int hashCode() {
    int result = user != null ? user.hashCode() : 0;
    result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
    result = 31 * result + (message != null ? message.hashCode() : 0);
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ChatMessage that = (ChatMessage) o;

    if (user != null ? !user.equals(that.user) : that.user != null) return false;
    if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
    return message != null ? message.equals(that.message) : that.message == null;

  }

  @Override
  public String toString() {
    return String.format("%s %s: %s", timestamp.toLocalTime(), user, message);
  }
}
