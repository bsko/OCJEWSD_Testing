package com.myservices.test.rest;

import javax.ws.rs.core.Response;

import com.myservices.test.entities.Employee;
import com.myservices.test.entities.UnavailableException;

public interface IEmployeeService {
  public static final String SOURCE_PATH = "D:/workspace/WebServicesExample/src/main/webapp/sources/";
  
  public Employee getEmployee(String name) throws UnavailableException;
  
  public Response addEmployee(Employee empl) throws UnavailableException;
}
