package service.Impl;

import service.IWebService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(
  targetNamespace="http://service.niuyd.com",
  portName="TestWebServiceSOAPPort",
  serviceName="TestWebService",
  name="TestWebServiceWSS"
)
public class WebServiceDemoBO implements IWebService {

  @Override
  @WebMethod(
    operationName="getReturnValue",
    exclude=false
  )
  public @WebResult(name ="result",targetNamespace = "http://service.niuyd.com",partName = "121") String getName(@WebParam(name="code",targetNamespace = "http://service.niuyd.com",partName = "12312") String code) {
    return "得到了客户端的值"+code;
  }
}
