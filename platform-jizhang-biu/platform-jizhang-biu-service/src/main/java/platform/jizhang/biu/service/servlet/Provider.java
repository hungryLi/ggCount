package platform.jizhang.biu.service.servlet;

import java.util.ResourceBundle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
	public static void init() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring.xml" });
		context.start();
		singleton();
	}

	public static ApplicationContext context = null;

	public static ApplicationContext singleton() {
		if (context == null) {
			context = new ClassPathXmlApplicationContext(new String[] { "providerApplicationContext.xml" });
		}
		return context;
	};
	
	public static ResourceBundle getConfig()
	{
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		
		return bundle;
	}
	
}
