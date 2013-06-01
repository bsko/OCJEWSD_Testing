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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.myservices.test.entities.Employee;
import com.myservices.test.entities.UnavailableException;

@Path("xml")
public class EmployeeServiceXML extends EmployeeServiceJSON {
  
  @Path("/{name}")
  @GET
  @Produces(MediaType.APPLICATION_XML)
  public Employee getEmployee(@PathParam("name") String name) throws UnavailableException {
    return super.getEmployee(name);
  }

  @POST
  @Produces(MediaType.APPLICATION_XML)
  @Consumes(MediaType.APPLICATION_XML)
  @Override
  public Response addEmployee(Employee empl) throws UnavailableException {
    return super.addEmployee(empl);
  }
}
