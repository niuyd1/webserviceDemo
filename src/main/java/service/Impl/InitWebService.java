package service.Impl;


import service.IWebService;

import javax.xml.ws.Endpoint;
import java.net.InetAddress;

/**
 * 发布webservice服务
 */
public class InitWebService {

  public static void main(String[] args)  {
    try{
      //定义webService地址: ip+port
      InetAddress address = InetAddress.getLocalHost();
      String s = address.toString().split("/")[1];
      String addr = "http://" + s + ":3307/student";
      IWebService service = new WebServiceDemoBO();
      //发布服务 地址+服务实现类
      Endpoint.publish(addr, service);
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
