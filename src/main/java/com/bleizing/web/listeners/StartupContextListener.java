package com.bleizing.web.listeners;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//import com.bleizing.bean.SingletonManager;
//import com.bleizing.bristar.hibernate.managers.BristarHibernateManager;
//import com.bleizing.bristar.managers.ThreadExecutor;
//import com.bleizing.exception.ProcessException;
//import com.bleizing.util.ClassUtil;
//import com.bleizing.util.StringUtils;

/**
 * 
 * @author coovy,
 * 
 * 26-OKT-2017,
 * 
 * Initialize bean and destroy bean
 * 
 */
public class StartupContextListener implements ServletContextListener {

//	public final static String P_PACKAGES = "packages";
//	public final static String P_CLASSES = "classes";
//
//	private Set<String> breakClasses(String classNames){
//
//		Set<String> classSet = new HashSet<String>();
//		String[] classNameArray = classNames.split("\\,");
//		for(String className:classNameArray) {
//			classSet.add(className);
//		}
//
//		return classSet;
//	}
//
//	private Set<String> breakPackageClasses(final String param) {
//		final Set<String> result = new HashSet<String>(0);
//		if(param==null)return result;
//
//
//		final Set<String> _classSet = new HashSet<String>();
//		String[] packageNames = param.split("\\,");
//		for(String packageName:packageNames) {
//			_classSet.addAll(ClassUtil.scanClasses(packageName));
//		}
//		return _classSet;
//	}
	

	public void contextDestroyed(final ServletContextEvent event) {
//		SingletonManager.getInstance().destroy();
//		ThreadExecutor.getInstance().destroy();
	}

	public void contextInitialized(final ServletContextEvent event) {
//		ServletContext context = event.getServletContext();
//		String classNames = context.getInitParameter(P_CLASSES);
//		Set<String> classSet = null;
//		if(!StringUtils.isEmpty(classNames)) {
//			classSet = breakClasses(classNames);
//		}else {
//			classSet = breakPackageClasses(context.getInitParameter(P_PACKAGES));
//		}
//		SingletonManager.getInstance().reload(classSet);
//		ThreadExecutor.getInstance();
//		try {
//			BristarHibernateManager.INSTANCE.executeUpdate("DELETE FROM UserPortalSession");
//		} catch (ProcessException e) {
//			e.printStackTrace();
//		}
	}


}
