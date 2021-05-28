package com.bleizing.servlet.html.presentations;

import java.io.FileNotFoundException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.bleizing.AppSetting;
//import com.bleizing.exception.ProcessException;
import com.bleizing.servlet.ServletForward;

public class JspViewer extends ServletForward {

	protected final String jspFile;
	
	public JspViewer(final String jspFile) {
		this.jspFile = jspFile;
	}
	
	public void forward(final HttpServlet servlet, final HttpServletRequest req, final HttpServletResponse resp) {
		try {
			final ServletContext _thisPage = servlet.getServletContext();
			final ServletContext _fwdPage = _thisPage.getContext(req.getContextPath());
			final RequestDispatcher _jsp = _fwdPage.getRequestDispatcher(this.jspFile);
			if (null == _jsp) {
				throw new FileNotFoundException("unable to find viewer file '" + this.jspFile + "'");
			}
			
			_jsp.forward(req, resp);
		} catch (final Exception e) {
//			if (AppSetting.PRINT_STACKTRACE) {
//				e.printStackTrace(System.out);
//			}
		}

	}

}
