//package com.bleizing.servlet.html.presentations;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.SimpleDateFormat;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.google.gson.Gson;
//
//import com.bleizing.bristar.web.admins.json.dto.results.RespLoginQrCode;
//import com.bleizing.bristar.web.ibbri.paramdto.QrCodeStore;
//import com.bleizing.bristar.web.ibbri.tool.WebTool;
//import com.bleizing.bristar.web.publics.json.constanta.InfosysConstants;
//import com.bleizing.bristar.web.publics.json.dto.results.RespLoginDto;
//import com.bleizing.bristar.web.publics.json.utils.BriSendJsonPost;
//import com.bleizing.exception.ProcessException;
//import com.bleizing.logging.Logging;
//import com.bleizing.logging.impl.ApplicationLogging;
//import com.bleizing.servlet.ServletForward;
//import com.bleizing.servlet.html.htmlib.HtmlServlet;
//
///**
// * 
// * @author Taufik.indra
// *
// */
//public class EventStream extends ServletForward {
//
//	/**
//	 *
//	 */
//
//	private final Integer LOOP_TRY = 500;
//	private final Long THREAD_SLEEP = 1000l;
//	private final transient String qrCode;
//
//
//
//	/**
//	 *
//	 * @param qrCode
//	 *
//	 */
//	public EventStream(final String qrCode) {
//		this.qrCode = qrCode;
//
//	}
//	private final BriSendJsonPost _sendPost =  new BriSendJsonPost();
//	private final Map<String, Object> obj = new HashMap<String, Object>();
//	
//	/**
//	 * 
//	 */
//
//
//
//
//	public void forward(final HttpServlet servlet, final HttpServletRequest req, final HttpServletResponse resp) throws ProcessException, IOException {
//
//		resp.setHeader("Content-Type", "text/event-stream;charset=UTF-8");
//
//		Integer _check = 0;
//
//		HttpSession _session = req.getSession();
//
//		final String _sessionBackEnd = (String) _session.getAttribute(InfosysConstants.IBSESSION.SESSION_ID);
//
//		PrintWriter _out = null;
//        QrCodeStore.QrData _dataActive = null;
//		Logging logger = new ApplicationLogging().setClass(this.getClass()).setMethod("doPost");
//		for (int i = 0; i<LOOP_TRY;i++){
//			try{
//				_out= resp.getWriter();
//				QrCodeStore _qr = new QrCodeStore();
////				QrCodeStore.QrData _data = _qr.getData(_sessionBackEnd);
//				QrCodeStore.QrData _data = QrCodeStore.map.get(_sessionBackEnd);
//				if(null == _data){
//					_data = new QrCodeStore.QrData();
//					_data.setStatus("INACTIVE");
//					_data.setAddData("-");
//					QrCodeStore.map.put(_sessionBackEnd, _data);
//				}else{
//					if(_data.getStatus().equalsIgnoreCase("ACTIVE")){
//						_check = 0;
//						logger.append("dia = " + _check).append(_data.getAddData()).appendLine();
//                        _dataActive = _data;
//						break;
//					}
//                }
//
//			}catch (Exception e){
//				logger.append("gagal = ").append(e.getStackTrace().toString()).appendLine();
//				_check = 9;
//				break;
//			}
//
//			try {
//				Thread.sleep(THREAD_SLEEP);
//			}catch (InterruptedException ix){
//				ix.printStackTrace();
//				logger.append("gagal = ").append(WebTool.exceptionConvert(ix.getStackTrace())).appendLine();
//				_check = 9;
//				break;
//			}
//			_check = 3;
//		}
//        logger.append("last check = ").append(_check).appendLine();
//		if(null == _out){
//			_out = resp.getWriter();
//		}
//		if(_check == 1){
//			logger.append("MASUK CLOSE").appendLine();
//			_out.print("event: server-time\n");
//			SimpleDateFormat _smpl = new SimpleDateFormat("dd MM yyyy hh:mm");
//			_out.print("data: 9000\n\n");
//			_out.flush();
//			QrCodeStore.map.remove(_sessionBackEnd);
//		}else if(_check == 0 && null != _dataActive){
//			logger.append("IN CLOSE STATUS HAS BEEN ACTIVE ").appendLine();
//			final String _url = HtmlServlet.URL_BACKEND;
//			String _kk = _sessionBackEnd;
//			obj.put("tokenIb", _kk);
//			final String _ret = _sendPost.sendPostPostIB(obj, _url+"loginQrCode", _kk, req, logger);
//			logger.append("call backend = ").append(_ret).appendLine();
//			RespLoginQrCode resultData = new Gson().fromJson(_ret, RespLoginQrCode.class );
//			String _fullName = resultData.getFullName();
//			if(resultData.getCode() == 0){
//				_out.print("event: server-time\n");
//				_out.print("data: 0\n\n");
//				_out.flush();
//				RespLoginDto _dtoLogin = new RespLoginDto();
//				_dtoLogin.setName(resultData.getFullName());
//				_dtoLogin.setUsername(resultData.getUserName());
//				_session.setAttribute(InfosysConstants.IBSESSION.SESSION_RESULT_DTO, _dtoLogin);
//				logger.append("IN CLOSE HAVE NAME = "+_fullName).appendLine();
//			}else{
//				_out.print("event: server-time\n");
//				_out.print("data: 9000\n\n");
//				_out.flush();
//				logger.append("FROM BACKEND CODE = ").append(resultData.getCode()).appendLine();
//				logger.append("FROM BACKEND MESSAGE = ").append(resultData.getMessage()).appendLine();
//			}
//			QrCodeStore.map.remove(_sessionBackEnd);
//		}else if(_check == 3){
//			_out.print("event: server-time\n");
//			_out.print("data: 9010\n\n");
//			_out.flush();
//			QrCodeStore.map.remove(_sessionBackEnd);
//		}
//		else{
//			logger.append("MASUK CLOSE UNEXPECTED").appendLine();
//			_out.print("event: server-time\n");
//			_out.print("data: 9001\n\n");
//			_out.flush();
//			QrCodeStore.map.remove(_sessionBackEnd);
//		}
//
//		logger.info();
//		
//	}
//
//}
