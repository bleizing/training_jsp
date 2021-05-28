package com.bleizing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bleizing.servlet.ServletForward;
import com.bleizing.servlet.html.HtmlController;
import com.bleizing.servlet.html.HtmlHandler;
import com.bleizing.servlet.html.presentations.JspViewer;

@HtmlController({"/login"})
public class Login extends HtmlHandler {

	public Login(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	/**
	 *
	 */
	public ServletForward process() throws Exception {
		return new JspViewer("/WEB-INF/pages/login.jsp");
	}

}