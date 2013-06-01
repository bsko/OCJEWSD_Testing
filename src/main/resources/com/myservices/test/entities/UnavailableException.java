package com.myservices.test.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UnavailableException extends Exception {
  
  private static final long serialVersionUID = 1476101901454920457L;
  private String message;
  
  public UnavailableException() {
    
  }
  
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
