package com.omototest.jmssender;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ContextUtil {
	public static Context getInitialContext() throws NamingException {
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		//
		/*props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		props.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.naming");
		props.setProperty(Context.PROVIDER_URL, "203.123.190.50:1099");
		props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		props.setProperty("org.omg.CORBA.ORBInitialHost", "203.123.190.50");
	    props.setProperty("org.omg.CORBA.ORBInitialPort", "1099");*/
	
		Context context = new InitialContext(props);
		return context;
	}
}
