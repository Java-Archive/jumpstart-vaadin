package org.rapidpm.jumpstart.vaadin.ui.screens.chat;


import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.rapidpm.jumpstart.vaadin.design.RapidChatDesign;
import org.rapidpm.jumpstart.vaadin.logic.chat.ChatMessage;
import org.rapidpm.jumpstart.vaadin.logic.event.EventBus;
import org.rapidpm.jumpstart.vaadin.logic.event.anotations.HandleEvent;
import org.rapidpm.jumpstart.vaadin.logic.security.User;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;

/**
 * Created by Sven Ruppert on 10.12.2015.
 */
public class RapidChatComponent extends RapidChatDesign {
  private VerticalLayout chatMessageLayout;

  @Override
  public void attach() {
    super.attach();
    EventBus.register(this);
  }

  @Override
  public void detach() {
    super.detach();
    EventBus.unregister(this);
  }

  @PostConstruct
  public void init() {
    chatMessageLayout = new VerticalLayout();
    this.chatPanel.setContent(chatMessageLayout);
    sendButton.addClickListener((event -> sendMessageEvent()));
    sendButton.setClickShortcut(KeyCode.ENTER);
    chatMessageLayout.addComponentAttachListener(this::scrollToChat);
    userLabel.setValue(UI.getCurrent().getSession().getAttribute(User.class).getUsername());
  }

  private void sendMessageEvent() {
    String user = userLabel.getValue();
    String message = this.inputText.getValue();
    this.inputText.clear();
    ChatMessage chatMessage = new ChatMessage(user, LocalDateTime.now(), message);
    EventBus.fireSynchronousEvent(chatMessage);
  }

  @PreDestroy
  public void tearDown() {
    EventBus.unregister(this);
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
}
