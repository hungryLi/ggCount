package platform.jizhang.biu.service.servlet;
 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

 
public class ProviderInit extends HttpServlet {
	public void init() throws ServletException {
		try {
			System.out.println("初始化dubbo服务端");
			Provider.init();
		} catch (Exception e) {
			System.out.println("初始化dubbo服务端失败");
			e.printStackTrace();
		}
	}

}
