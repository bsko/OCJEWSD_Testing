package com.myservices.test.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import com.myservices.test.dao.EmployeeDAO;
import com.myservices.test.dao.exceptions.DAOException;
import com.myservices.test.entities.Employee;
import com.myservices.test.entities.UnavailableException;


@Path("json")
public class EmployeeServiceJSON implements IEmployeeService {
  
  EmployeeDAO dao = EmployeeDAO.getInstance();
  
  @Path("/{name}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Employee getEmployee(@PathParam("name") String name) throws UnavailableException {
    try {
      return dao.getEmployee(name);
    } catch (DAOException e) {
      throw new UnavailableException(e.getMessage());
    }
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response addEmployee(Employee empl) throws UnavailableException {
    try {
      dao.addEmployee(empl);
      return Response.ok("Successfully created!").build();
    } catch (DAOException e) {
      throw new UnavailableException(e.getMessage());
    }
  }
}
