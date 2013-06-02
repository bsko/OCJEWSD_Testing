package com.myservices.test.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.myservices.test.entities.Employee;
import com.myservices.test.entities.UnavailableException;

@WebService/*(name="EmployeePortType", portName="EmployeePortName", serviceName="EmployeeServiceName",
  targetNamespace="stubs", endpointInterface="com.myservices.test.soap.IEmployeeServiceSOAP")*/
//@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED, style=SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL)
public interface IEmployeeServiceSOAP {
  @WebMethod(action="actionAttribute", operationName="getEmployeeOperation")
  public Employee getEmployee(String name) throws UnavailableException;
  @WebMethod
  public void addEmployee(Employee empl) throws UnavailableException;
}
