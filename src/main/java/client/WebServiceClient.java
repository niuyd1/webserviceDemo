package client;



import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.encoding.XMLType;
import java.net.InetAddress;
import java.net.URL;
/**
 * 该种方式可以自定义命名空间，服务视图名等元素，方便以后维护，是一种标准的开发方式
 * @author Administrator
 *
 */
public class WebServiceClient {
  public static void main(String[] args) {
    try{
      //axis调用WebService
      InetAddress address = InetAddress.getLocalHost();
      String s = address.toString().split("/")[1];
      String serviceUrl = "http://" + s + ":3307/student";
      System.out.println(serviceUrl);
      Service service = new Service();
      Call call = (Call) service.createCall();
      call.setTargetEndpointAddress(new URL(serviceUrl));
     // call.setOperationName("getName");这样会报“找不到{}getName的分派方法”
      call.setOperationName(new QName("http://service.niuyd.com","getReturnValue"));
      call.addParameter(new QName("http://service.niuyd.com", "code"), XMLType.SOAP_STRING, javax.xml.rpc.ParameterMode.IN);
      Object res = call.invoke(new Object[]{"0"});
      System.out.println(res.toString());
    }catch (Exception e){
      e.printStackTrace();
    }

  }
}
