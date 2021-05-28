package com.bleizing.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.bleizing.exception.ProcessException;

/**
 * 
 * @author Nuriman
 *
 */
public abstract class ServletForward {

	/**
	 * 
	 * @param servlet
	 * @param req
	 * @param resp
	 * @throws ProcessException
	 */
	public abstract void forward(final HttpServlet servlet, final HttpServletRequest req, final HttpServletResponse resp) throws IOException;

}
