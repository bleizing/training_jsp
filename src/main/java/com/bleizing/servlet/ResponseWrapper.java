//package com.bleizing.servlet;
//
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpServletResponseWrapper;
//
///**
// * 
// * @author Nuriman
// *
// */
//public class ResponseWrapper extends HttpServletResponseWrapper {
//
//	/**
//	 * 
//	 */
//	private transient ServletOutputStream out;
//	
//	/**
//	 * 
//	 */
//	private transient PrintWriter writer;
//	
//	/**
//	 * 
//	 */
//	private transient ServletOutput servletOut;
//
//	/**
//	 * 
//	 * @param resp
//	 * @throws IOException
//	 */
//	public ResponseWrapper(final HttpServletResponse resp) throws IOException {
//		super(resp);
//	}
//
//	/**
//	 * 
//	 */
//	public ServletOutputStream getOutputStream() throws IOException {
//		if (null != this.writer) {
//			throw new IllegalStateException("getWriter() has already been called on this response.");
//		}
//
//		if (null == this.out) {
//			this.out = getResponse().getOutputStream(); // NOPMD by Nuriman on 7/28/17 2:19 PM
//			this.servletOut = new ServletOutput(out);
//		}
//
//		return this.servletOut;
//	}
//
//	/**
//	 * 
//	 */
//	public PrintWriter getWriter() throws IOException {
//		if (null != this.out) {
//			throw new IllegalStateException("getOutputStream() has already been called on this response.");
//		}
//
//		if (null == this.writer) {
//			this.servletOut = new ServletOutput(getResponse().getOutputStream()); // NOPMD by Nuriman on 7/28/17 2:19 PM
//			this.writer = new PrintWriter(new OutputStreamWriter(servletOut, getResponse().getCharacterEncoding()), true); // NOPMD by Nuriman on 7/28/17 2:19 PM
//		}
//
//		return this.writer;
//	}
//
//	/**
//	 * 
//	 */
//	public void flushBuffer() throws IOException {
//		if (null != this.writer) {
//			this.writer.flush();
//		}
//		
//		if (null != this.out) {
//			this.servletOut.flush();
//		}
//	}
//
//	/**
//	 * 
//	 * @return
//	 */
//	public final byte[] toByteArray() {
//		byte[] ret = new byte[0]; // NOPMD by Nuriman on 7/28/17 2:18 PM
//		if (null != this.servletOut) {
//			ret = this.servletOut.toByteArray();
//		}
//		
//		return ret;
//	}
//}
