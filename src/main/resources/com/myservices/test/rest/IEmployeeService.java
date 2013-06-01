package com.myservices.test.rest;

import javax.ws.rs.core.Response;

import com.myservices.test.entities.Employee;
import com.myservices.test.entities.UnavailableException;

public interface IEmployeeService {
  
  public Employee getEmployee(String name) throws UnavailableException;
  
  public Response addEmployee(Employee empl) throws UnavailableException;
}
