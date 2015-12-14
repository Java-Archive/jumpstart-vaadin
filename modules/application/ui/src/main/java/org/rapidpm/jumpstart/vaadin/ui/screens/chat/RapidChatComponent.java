package org.rapidpm.jumpstart.vaadin.ui.screens.chat;


import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.rapidpm.jumpstart.vaadin.design.RapidChatDesign;
import org.rapidpm.jumpstart.vaadin.logic.chat.ChatMessage;
import org.rapidpm.jumpstart.vaadin.logic.event.EventBus;
import org.rapidpm.jumpstart.vaadin.logic.event.anotations.HandleEvent;
import org.rapidpm.jumpstart.vaadin.logic.security.User;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

/**
 * Created by b.bosch on 10.12.2015.
 */
public class RapidChatComponent extends RapidChatDesign {
  private VerticalLayout chatMessageLayout;

  @PostConstruct
  public void init() {
    EventBus.register(this);
    chatMessageLayout = new VerticalLayout();
    this.chatPanel.setContent(chatMessageLayout);
    sendButton.addClickListener((event -> sendMessageEvent()));
    sendButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
    chatMessageLayout.addComponentAttachListener(event -> scrollToChat(event));
    userLabel.setValue(UI.getCurrent().getSession().getAttribute(User.class).getUsername());


  }

  private void scrollToChat(ComponentAttachEvent event) {
    getUI().scrollIntoView(event.getAttachedComponent());
  }

  @HandleEvent
  public void handleMessageEvent(ChatMessage message) {
    Label chatMessageLabel = new Label(message.toString());
    chatMessageLayout.addComponent(chatMessageLabel);
    chatMessageLayout.getUI().push();
  }

  private void sendMessageEvent() {
    String user = userLabel.getValue();
    String message = this.inputText.getValue();
    this.inputText.clear();
    ChatMessage chatMessage = new ChatMessage(user, LocalDateTime.now(), message);
    EventBus.fireSycronusEvent(chatMessage);
  }
}
