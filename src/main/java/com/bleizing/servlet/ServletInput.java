//package com.bleizing.servlet;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//import javax.servlet.ReadListener;
//import javax.servlet.ServletInputStream;
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
//public class ServletInput extends ServletInputStream {
//
//	/**
//	 * 
//	 */
//	private final transient ByteArrayInputStream bais;
//	
//	/**
//	 * 
//	 * @param instream
//	 */
//	public ServletInput(final InputStream instream) {
//		final ByteArrayOutputStream _baos = new ByteArrayOutputStream();
//		
//		try {
//			IOUtils.copy(instream, _baos);
//		} catch (final Exception e) {
//			if (AppSetting.PRINT_STACKTRACE) {
//				e.printStackTrace(System.out);
//			}
//		}
//		
//		this.bais = new ByteArrayInputStream(_baos.toByteArray());
//	}
//	
//	/**
//	 * 
//	 */
//	public int read() throws IOException {
//		return this.bais.read();
//	}
//
//	public boolean isFinished() {
//		return false;
//	}
//
//	public boolean isReady() {
//		return false;
//	}
//
//	@Override
//	public void setReadListener(ReadListener arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
