package com.myservices.test.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.myservices.test.dao.EmployeeDAO;
import com.myservices.test.dao.exceptions.DAOException;
import com.myservices.test.entities.Employee;

@Path("newfill")
public class SimpleNewFillClass {

  private EmployeeDAO dao = EmployeeDAO.getInstance();
  
  @GET
  public String newFill() {
    Employee empl = new Employee();
    empl.setId(1L);
    empl.setName("Stan");
    empl.setSurname("Smith");
    empl.setAge(18);
    empl.setPhoneNumber("4922896900");
    empl.setDescription("The first one");
    try {
      dao.addEmployee(empl);
      return "Success!";
    } catch(DAOException e) {
      return e.getMessage();
    }
  }

}
