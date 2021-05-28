package com.bleizing.web.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * @author nuriman
 *
 */
public class ServletCtxListener implements ServletContextListener {

	public static final List<ServletContext> CONTEXTS = new ArrayList<ServletContext>();
	
	public void contextDestroyed(final ServletContextEvent event) {
		event.getServletContext();
	}

	public void contextInitialized(final ServletContextEvent event) {
		ServletCtxListener.CONTEXTS.add(event.getServletContext());
//		System.out.println("INIT====" + ServletCtxListener.CONTEXTS.size());
	}

}
