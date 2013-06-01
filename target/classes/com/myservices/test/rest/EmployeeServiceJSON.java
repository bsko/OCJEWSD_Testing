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

import com.myservices.test.entities.Employee;
import com.myservices.test.entities.UnavailableException;


@Path("json")
public class EmployeeServiceJSON implements IEmployeeService {
  
  @Path("/{name}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Override
  public Employee getEmployee(@PathParam("name") String name) throws UnavailableException {
    try {
      InputStream is = new FileInputStream(new File(SOURCE_PATH + name + ".properties"));
      Properties props = new Properties();
      props.load(is);
      Employee result = new Employee();
      result.setId(Long.parseLong(props.getProperty("id")));
      result.setName(props.getProperty("name"));
      result.setSurname(props.getProperty("surname"));
      result.setAge(Integer.parseInt(props.getProperty("age")));
      result.setPhoneNumber(props.getProperty("phoneNumber"));
      result.setDescription(props.getProperty("description"));
      return result;
    } catch (NumberFormatException e1) {
      throw new UnavailableException("Information is broken.");
    } catch (Throwable e) {
      throw new UnavailableException("No employee with such name found.");
    }
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Override
  public Response addEmployee(Employee empl) throws UnavailableException {
    if(empl.getName() == null || "".equals(empl.getName()) || empl.getId() == null) {
      throw new UnavailableException("Information is broken.");
    }
    Properties props = new Properties();
    props.setProperty("id", empl.getId().toString());
    props.setProperty("name", empl.getName());
    props.setProperty("surname", empl.getSurname());
    props.setProperty("age", empl.getAge() != null ? empl.getAge().toString() : "");
    props.setProperty("phoneNumber", empl.getPhoneNumber());
    props.setProperty("description", empl.getDescription());
    
    File file = new File(SOURCE_PATH + empl.getName() + ".properties");
    if(file.exists()) {
      file.delete();
    }
    try {
      props.store(new FileOutputStream(SOURCE_PATH + empl.getName() + ".properties"), null);
    } catch(IOException e) {
      throw new UnavailableException("Couldn't save: " + e.getMessage());
    }
    return Response.ok("Successfully created!").build();
  }
}
