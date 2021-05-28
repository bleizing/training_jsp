//package com.bleizing.servlet.json;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.bleizing.AppSetting;
//import com.bleizing.bristar.hibernate.entities.ActivityNoteEntity;
//import com.bleizing.bristar.web.publics.json.utils.ResponseFactory;
//import com.bleizing.erasures.BaseErasure;
//import com.bleizing.exception.ErrorType;
//import com.bleizing.gson.JsonBuilder;
//import com.bleizing.logging.Logging;
//import com.bleizing.servlet.RequestWrapper;
//import com.bleizing.servlet.ResponseWrapper;
//import com.bleizing.util.StreamUtil;
//import com.bleizing.validators.ValidationResult;
//import com.bleizing.validators.ValidatorProcessor;
//
///**
// * 
// * @author Nuriman
// *
// */
//public abstract class JsonHandler<P extends ParamDto, R extends ResultDto> extends BaseErasure {
//
//	/**
//	 * 
//	 */
//	public final transient P param;
//
//	/**
//	 * 
//	 */
//	public final transient R result;
//
//	protected transient ActivityNoteEntity activityNote;
//	/**
//	 * 
//	 */
//	private final Class<?> paramType;
//
//	/**
//	 * 
//	 */
//	private final Class<?> resultType;
//
//	/**
//	 * 
//	 */
//	protected final transient HttpServletRequest request;
//
//	/**
//	 * 
//	 */
//	protected final transient HttpServletResponse response; 
//
//
//	/**
//	 * 
//	 */
//	protected final transient String requestContent;
//
//	public void setActivityNote(ActivityNoteEntity actNote){
//		activityNote = actNote;
//	}
//
//	protected final Logging logger;
//
//
//
//	public JsonHandler(final HttpServletRequest request, final HttpServletResponse response, final Logging logger) throws Exception {
//		//final JsonRequestWrapper request, final JsonResponseWrapper response
//		this.logger = logger;
//
//		if (!(request instanceof RequestWrapper)) {
//			throw new ClassFormatError("Request parameter should instance of RequestWrapper");
//		}
//
//		if (!(response instanceof ResponseWrapper)) {
//			throw new ClassFormatError("Response parameter should instance of ResponseWrapper");
//		}
//
//		this.request = request;
//		this.response = response;
//
//		this.requestContent = StreamUtil.byteArrayToString(((RequestWrapper) this.request).toByteArray());
//
//		//this.logger.append("Incoming raw message : " + this.requestContent).appendLine();
//		this.paramType = this.getParamType();
//		this.resultType = this.getResultType();
//
//		this.param = this.wrapParam();
//		this.result = this.wrapResult();
//
//
//	}
//
//	@SuppressWarnings("unchecked")
//	private P wrapParam() {
//		P ret = null; // NOPMD by Nuriman on 7/28/17 2:12 PM
//		if (!this.requestContent.equalsIgnoreCase("")) {
//			try {
//				ret = (P) JsonBuilder.deserialize(this.requestContent, this.paramType);
//
//			} catch (Exception e) {				
//				if (AppSetting.PRINT_STACKTRACE) {
//					e.printStackTrace(System.out);
//				}
//			}			
//		}
//
//		if (null == ret) {
//			ret = (P) JsonBuilder.deserialize("{}", this.paramType);
//		}
//
//		return ret;
//	}
//
//	@SuppressWarnings("unchecked")
//	private R wrapResult() {
//		return (R) JsonBuilder.deserialize("{}", this.resultType);
//	}
//
//	private Class<?> getParamType() {
//		return this.getErasureType(0); 
//	}
//
//	private Class<?> getResultType() {
//		return this.getErasureType(1);
//	}
//	
//	protected void setErrorResult(ErrorType errorType) {
//		result.setCode(errorType.code);
//        result.setMessage(errorType.description);
//
//	}
//	
//	protected String maskData(String data) {
//		if(data==null)return "";
//		StringBuffer sb = new StringBuffer();
//		for(int i=0;i<data.length();i++) {
//			sb.append("*");
//		}
//		return sb.toString();
//	}
//
//
//	protected String getSessionString(final HttpSession _session,String key) {
//		Object obj = _session.getAttribute(key);
//		if(obj==null)return null;
//		return(String)obj;
//	}
//
//	public void doProcess()throws Exception{
//		//doing validation process
//		ValidationResult validationResult = ValidatorProcessor.evaluate(this.param,this.logger);
//
//		if(!validationResult.equals(ValidationResult.OK)) {
//			ResponseFactory.constructResponse(result, validationResult.getErrorType(),null,validationResult.getMessage());
//			return;
//		}
//		process();
//	}
//
//	/**
//	 * 
//	 * @throws Exception
//	 */
//	public abstract void process() throws Exception;
//}
