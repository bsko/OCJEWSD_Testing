package com.myservices.test.rest;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceContext;

public class EmployeeProvider implements Provider<Source> {

  @Resource
  private WebServiceContext context;
  
  @Override
  public Source invoke(Source request) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
