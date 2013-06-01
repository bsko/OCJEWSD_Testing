package com.myservices.test.rest.providers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.myservices.test.entities.UnavailableException;

@Provider
public class UnavailableExceptionMapper implements ExceptionMapper<UnavailableException>{

  @Override
  public Response toResponse(UnavailableException arg0) {
    return Response.status(404).entity(arg0.getMessage()).build();
  }

}
