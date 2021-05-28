package com.bleizing.servlet.html;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bleizing.servlet.ServletForward;

/**
 * 
 * @author Nuriman
 *
 */
public abstract class HtmlHandler {

	/**
	 * 
	 */
	protected final transient HttpServletRequest request;
	
	/**
	 * 
	 */
	protected final transient HttpServletResponse response;

	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	public HtmlHandler(final HttpServletRequest request, final HttpServletResponse response) {

		this.request = request;
		this.response = response;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract ServletForward process() throws Exception;
}
