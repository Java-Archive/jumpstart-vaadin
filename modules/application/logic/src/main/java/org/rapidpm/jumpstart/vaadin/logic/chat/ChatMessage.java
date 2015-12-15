package org.rapidpm.jumpstart.vaadin.logic.chat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by b.bosch on 10.12.2015.
 */
public class ChatMessage implements Serializable {
  private String user;
  private LocalDateTime timestamp;
  private String message;

  public ChatMessage(String user, LocalDateTime timestamp, String message) {
    this.user = user;
    this.timestamp = timestamp;
    this.message = message;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return String.format("%s %s: %s", timestamp.toLocalTime(), user, message);
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
  public int hashCode() {
    int result = user != null ? user.hashCode() : 0;
    result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
    result = 31 * result + (message != null ? message.hashCode() : 0);
    return result;
  }
}
