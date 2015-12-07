package org.rapidpm.jumpstart.vaadin.logic.properties;

/**
 * Created by svenruppert on 07.12.15.
 */
public interface PropertyService {
  String resolve(String key);
  boolean hasKey(String keyy);
}
