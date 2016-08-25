package cn.itcast.test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import cn.itcast.ejb3.HelloWorld;
import cn.itcast.ejb3.impl.HelloWorldBean;

public class EJBClient {

	public static void main(String[] args) {
		
		/*Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		try {
			InitialContext ctx = new InitialContext(props);
			HelloWorld helloworld = (HelloWorld) ctx.lookup("HelloWorldBean/remote");
			System.out.println(helloworld.sayHello("·ðÉ½"));
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}*/
		
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
		try {
			final Context context = new InitialContext(jndiProperties);
			final String appName = "";
			final String moduleName = "helloworld";
			final String distinctName = "";
			final String beanName = HelloWorldBean.class.getSimpleName();
			final String viewClassName = HelloWorld.class.getName();
			
			HelloWorld helloworld = (HelloWorld) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
			System.out.println(helloworld.sayHello("·ðÉ½"));
			
//			HelloWorld helloworld = new HelloWorldBean();
//			System.out.println(helloworld.sayHello("ÖØÇì"));
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}


























