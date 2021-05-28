//package com.bleizing.servlet;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.WriteListener;
//
///**
// * 
// * @author Nuriman
// *
// */
//public class ServletOutput extends ServletOutputStream {
//
//	/**
//	 * 
//	 */
//	private final transient OutputStream out;
//	
//	/**
//	 * 
//	 */
//	private final transient ByteArrayOutputStream buffer;
//
//	/**
//	 * 
//	 * @param out
//	 */
//	public ServletOutput(final OutputStream out) {
//		this.out = out;
//		this.buffer = new ByteArrayOutputStream();
//	}
//
//	/**
//	 * 
//	 */
//	public void write(final int byt) throws IOException {
//		this.out.write(byt);
//		this.buffer.write(byt);
//	}
//
//	/**
//	 * 
//	 * @return
//	 */
//	public byte[] toByteArray() {
//		return this.buffer.toByteArray();
//	}
//
//	public boolean isReady() {
//		return false;
//	}
//
//	@Override
//	public void setWriteListener(WriteListener arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
