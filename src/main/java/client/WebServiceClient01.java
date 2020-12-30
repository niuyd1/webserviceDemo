package client;
/**
 * 工具生成客户端
 * wsimport是jdk自带的webservice客户端工具,可以根据wsdl文档生成客户端调用代码(java代码).
 * wsimport.exe位于JAVA_HOME\bin目录下
 * 常用参数为:
 * 			-d<目录>  - 将生成.class文件。默认参数。
 * 			-s<目录> - 将生成.java文件。
 * 			-p<生成的新包名> -将生成的类，放于指定的包下
 * 创建一个客户端空项目，cmd命令行进入此项目的src目录， 使用以下命令生成客户端代码
 * wsimport -s . http://10.6.193.150:3307/student?wsdl
 * -s是指编译出源代码文件,后面的.(点)指將代码放到当前目录下.最后面的http….是指获取wsdl说明书的地址
 * 该种方式使用简单，但一些关键的元素在代码生成时写死在生成代码中，不方便维护，所以仅用于测试。
 */
public class WebServiceClient01 {
  public static void main(String[] args) {
    //生成客户端代码就不回报错
    //创建服务视图，视图是从wsdl文件的service标签的name属性获取
    TestWebService service=new TestWebService();
    //获取服务实现类，实现类从wsdl文件的portType的name属性获取
    TestWebServiceWSS serviceWSS=service.getPort(TestWebServiceWSS.class);
    //获取查询方法，从portType的operation标签获取
    String result=serviceWSS.getReturnValue("北京");
    System.out.println(result);
  }

}
