package com.myservices.test.soap;

import javax.jws.*;
import javax.jws.soap.SOAPBinding;

import com.myservices.test.dao.EmployeeDAO;
import com.myservices.test.dao.exceptions.DAOException;
import com.myservices.test.entities.Employee;
import com.myservices.test.entities.UnavailableException;

@WebService
public class EmployeeServiceSOAP implements IEmployeeServiceSOAP {

  EmployeeDAO dao = EmployeeDAO.getInstance();

  @WebMethod
  public Employee getEmployee(String name) throws UnavailableException {
    try {
      return dao.getEmployee(name);
    } catch(DAOException e) {
      throw new UnavailableException(e.getMessage());
    }
  }
  
  @WebMethod
  public void addEmployee(Employee empl) throws UnavailableException {
    try {
      dao.addEmployee(empl);
    } catch(DAOException e) {
      throw new UnavailableException(e.getMessage());
    }
  }
}
