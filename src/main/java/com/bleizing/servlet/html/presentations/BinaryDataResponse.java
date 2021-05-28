//package com.bleizing.servlet.html.presentations;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.bleizing.exception.ProcessException;
//import com.bleizing.servlet.ServletForward;
//
///**
// * 
// * @author Taufik.indra
// *
// */
//public class BinaryDataResponse extends ServletForward {
//
//	/**
//	 * 
//	 */
//	private final transient String filename;
//	
//	/**
//	 * 
//	 */
//	private final transient String contentType;
//	
//	/**
//	 * 
//	 */
//	private final transient byte[] data;
//	
//	/**
//	 * 
//	 * @param filename
//	 * @param contentType
//	 * @param data
//	 */
//	public BinaryDataResponse(final String filename, final String contentType, final byte[] data) { 
//		this.filename = filename;
//		this.data = data;
//		this.contentType = contentType;
//	}
//	
//	/**
//	 * 
//	 */
//	public void forward(final HttpServlet servlet, final HttpServletRequest req, final HttpServletResponse resp) throws ProcessException {
//
//		if (null != this.contentType && !"".equals(this.contentType.trim())) {
//			resp.setHeader("Content-Type", this.contentType.trim()); 
//		}
//
//		if (null != this.filename && !"".equals(this.filename.trim())) {
//			resp.setHeader("Content-Disposition", "filename=\"".concat(this.filename.trim()).concat("\"")); 
//		}
//
//		if (null != this.data) {
//			try {
//				resp.getOutputStream().write(this.data); 
//			} catch (final Throwable t) { 
//				t.printStackTrace(System.out);
//			}
//		}
//		
//	}
//
//}
