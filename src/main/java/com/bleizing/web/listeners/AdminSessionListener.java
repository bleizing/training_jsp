package com.bleizing.web.listeners;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.bleizing.logging.Logging;

/**
 * @author austraramadhan
 */
public class AdminSessionListener implements HttpSessionListener {
	
	public final static int DEFAULT_TIMEOUT = 600;
	
	private final Logging _log = new Logging().setClass(this.getClass()).setMethod("AdminSessionListener");
	
	public void sessionCreated(final HttpSessionEvent event) {
		_log.append("sessionCreated");
		
		int timeout  = 0;
		try {
			final String _timeout = event.getSession().getServletContext().getInitParameter("session-time-out");
			timeout = Integer.parseInt(_timeout);
		}catch(Exception e){
			timeout = DEFAULT_TIMEOUT;
		}
		final HttpSession _session = event.getSession();
		_session.setMaxInactiveInterval(timeout);
		_log.info();
	}

	public void sessionDestroyed(final HttpSessionEvent event) {
		_log.append("sessionDestroyed");
		_log.info();
	}

}