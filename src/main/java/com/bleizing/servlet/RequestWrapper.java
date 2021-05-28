//package com.bleizing.servlet;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.ServletInputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//
//import org.apache.commons.io.IOUtils;
//
//import com.bleizing.AppSetting;
//
///**
// * 
// * @author Nuriman
// *
// */
//public class RequestWrapper extends HttpServletRequestWrapper {
//
//	/**
//	 * 
//	 */
//	private final transient Map<String, Object> additionalObjects = new HashMap<String, Object>(0);
//	
//	/**
//	 * 
//	 */
//	private final transient ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//	
//	/**
//	 * 
//	 * @param request
//	 */
//	public RequestWrapper(final HttpServletRequest request) {
//		super(request);
//		
//		try {
//			IOUtils.copy(request.getInputStream(), this.buffer);
//		} catch (final Exception e) {
//			if (AppSetting.PRINT_STACKTRACE) {
//				e.printStackTrace(System.out);
//			}
//		}
//	}
//
//	/**
//	 * 
//	 * @param key
//	 * @param value
//	 */
//	protected final void putAdditionalObject(final String key, final Object value) {
//		if (null != key && null != value) {			
//			this.additionalObjects.put(key, value);
//		}
//	}
//
//	/**
//	 * 
//	 * @param key
//	 * @return
//	 */
//	protected final Object getAdditionalObject(final String key) {
//		if (null == key) {
//			return null; // NOPMD by Nuriman on 7/28/17 2:51 PM
//		}
//		
//		return this.additionalObjects.get(key);
//	}
//
//	/**
//	 * 
//	 */
//	public final ServletInputStream getInputStream() throws IOException {
//		return new ServletInput(new ByteArrayInputStream(this.buffer.toByteArray()));
//	}
//	
//	/**
//	 * 
//	 * @return
//	 */
//	public final byte[] toByteArray() {
//		return this.buffer.toByteArray();
//	}
//}
