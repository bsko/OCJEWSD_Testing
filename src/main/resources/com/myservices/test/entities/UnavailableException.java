package com.myservices.test.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UnavailableException extends Exception {
  
  private String message;
  
  public UnavailableException(String cause) {
    message = cause;
  }

  @Override
  public String getLocalizedMessage() {
    return message;
  }

  @Override
  public String getMessage() {
    return message;
  }
  
  
}
