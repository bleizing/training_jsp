package com.bleizing.servlet.html.htmlib;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.hibernate.criterion.Restrictions;
//
//import com.google.gson.Gson;
//
//import com.bleizing.AppSetting;
//import com.bleizing.bristar.hibernate.entities.SysConfigEntity;
//import com.bleizing.bristar.hibernate.managers.BristarHibernateManager;
//import com.bleizing.bristar.web.ibbri.json.Rekening;
//import com.bleizing.bristar.web.ibbri.paramdto.QrCodeStore;
//import com.bleizing.bristar.web.publics.json.constanta.InfosysConstants;
//import com.bleizing.bristar.web.publics.json.dto.results.RespListAccountDto;
//import com.bleizing.bristar.web.publics.json.dto.results.RespListAccountItemDto;
//import com.bleizing.bristar.web.publics.json.dto.results.RespLoginDto;
//import com.bleizing.bristar.web.publics.json.utils.BriSendJsonPost;
//import com.bleizing.exception.ErrorType;
//import com.bleizing.exception.ProcessException;
//import com.bleizing.logging.Logging;
//import com.bleizing.logging.impl.ApplicationLogging;
//import com.bleizing.servlet.ServletForward;
//import com.bleizing.servlet.html.HtmlController;
//import com.bleizing.servlet.html.HtmlHandler;
//import com.bleizing.servlet.json.IgnoreLogin;
//import com.bleizing.servlet.json.ResultDto;
//import com.bleizing.servlet.json.ibbri.RekeningData;
//import com.bleizing.util.ClassUtil;

/**
 * 
 * @author Nuriman
 *
 */
public class HtmlServlet extends HttpServlet {

	/**
	 * 
	 */
//	public static String URL_BACKEND = "";
//	public static String PATH_INFO = "";
//	public static Map<String, QrCodeStore.QrData> MAPQR = new ConcurrentHashMap<String, QrCodeStore.QrData>();
//	private static void getSessionFromBackEnd(final HttpSession session, final HttpServletRequest request, final Logging logger ,final HttpServletResponse resp) throws Exception{
//
//
//		final String _sessionBackEnd = (String) session.getAttribute(InfosysConstants.IBSESSION.SESSION_ID);
//		String _sessionUrlBackend = (String) session.getAttribute(InfosysConstants.IBSESSION.SESSION_URL_BACKEND);
//		if(null == _sessionUrlBackend){
//			logger.append("firstime in this session generate session base ib config ").appendLine();
//			logger.append("session ini = ").append(session.getId()).appendLine();
//			List<SysConfigEntity> _list = BristarHibernateManager.INSTANCE.select(SysConfigEntity.class,null, Restrictions.eq("key.module", "BASE_IB_CONFIG"), null, null );
//			if(null != _list){
//				for (SysConfigEntity _items: _list){
//					final String _keySession = _items.getKey().getCode()+"."+_items.getKey().getModule();
//					if(_keySession.equalsIgnoreCase(InfosysConstants.IBSESSION.SESSION_URL_BACKEND)){
//						URL_BACKEND = _items.getValue();
//					}
//					logger.append(_keySession +" = ").append(_items.getValue()).appendLine();
//					session.setAttribute(_keySession, _items.getValue());
//				}
//			}
//
//		}
//
//		if(null == _sessionBackEnd){
//			try {
//				BriSendJsonPost _sendPost =  new BriSendJsonPost();
//				final Map<String, Object> obj = new HashMap<String, Object>();
//				final String _urlGetSession = URL_BACKEND+"getsession";
//				String _ret = _sendPost.sendPostPostIB(obj, _urlGetSession, "iii", request, logger);
//				ResultDto _res = new Gson().fromJson(_ret, ResultDto.class);
//				session.setAttribute(InfosysConstants.IBSESSION.SESSION_ID, _res.getSessionId());
//			}catch (Exception e){
//				logger.append("not find ").append(e.getMessage()).appendLine();
//				resp.sendRedirect(request.getContextPath() + "/pages/auth/405");
//				//session.setAttribute(InfosysConstants.IBSESSION.SESSION_ID,"___not");
//			}
//
//		}
//	}
//	private static final long serialVersionUID = 8086986036140406102L;
//
//	/**
//	 * 
//	 */
//	private static final Map<String, Class<?>> HTML_CONTROLLERS = new HashMap<String, Class<?>>();

	
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);


//		WebSocketMessaging.run();

		
//		final Set<String> _packageSet = this.breakPackage(config.getInitParameter("packages"));
//		final Set<String> _classSet = new HashSet<String>();
//		for (final String _package: _packageSet) {
//			_classSet.addAll(ClassUtil.scanClasses(_package));
//		}
//		
//		for (final String _className : _classSet) {
//			final Class<?> _class = ClassUtil.forName(_className);
//			if (null == _class) {
//				continue;
//			}
//			
//			if (!HtmlHandler.class.isAssignableFrom(_class)) {
//				continue;
//			}
//						
//			final HtmlController _annotation = _class.getAnnotation(HtmlController.class);
//			if (null == _annotation || null == _annotation.value()) {
//				continue;
//			}
//
//			
//			for (final String _value : _annotation.value()) {
//				if (null == _value || "".equals(_value.trim())) {
//					continue;
//				}
//				
//				final String _item = _value.trim();
//				final String _key = _item.charAt(0) == '/'? _item : "/".concat(_item);
//				if (HtmlServlet.HTML_CONTROLLERS.containsKey(_key)) {
//					continue;
//				}
//				
//				HtmlServlet.HTML_CONTROLLERS.put(_key, _class);
//				
//			}
//
//		}

	}

	/**
	 * 
	 */
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) {
		this.doPost(req, resp);
	}

	/**
	 * 
	 */
	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
//		final Logging _log = new ApplicationLogging().setClass(this.getClass()).setMethod("doPost");
//
//		try {
//			if (null == req || null == resp) {
//				throw new ProcessException(null,ErrorType.INVALID_REQUEST_MODEL);
//			}
//
//			final String _ptInfo = req.getPathInfo();
//			if (null == _ptInfo) {
//				throw new ProcessException(null,ErrorType.PATH_NOT_FOUND);
//			}
//
//			if (!HtmlServlet.HTML_CONTROLLERS.containsKey(_ptInfo)) {
//				throw new ProcessException(null,ErrorType.PATH_NOT_FOUND);
//			}
//			PATH_INFO = _ptInfo;
//			HttpSession session = req.getSession();
//			if(!_ptInfo.equalsIgnoreCase("/auth/405")){
//				getSessionFromBackEnd(session, req, _log, resp);
//			}
//
//
//			final Class<?> _classImpl = HtmlServlet.HTML_CONTROLLERS.get(_ptInfo);
//			final Constructor<?> _constructor = _classImpl.getConstructor(HttpServletRequest.class, HttpServletResponse.class);
//			final Object _instance = _constructor.newInstance(req, resp);
//
//			final HtmlHandler _service = (HtmlHandler) _instance;
//			final ServletForward _fwd = _service.process();
//
//			req.setAttribute("sessionUserStatus", session.getId());
//			if (!AppSetting.IGNORE_LOGIN) {
//				IgnoreLogin _ignoreLogin = _classImpl.getAnnotation(IgnoreLogin.class);
//				if (null == _ignoreLogin) {
//
//					if (null == session.getAttribute(InfosysConstants.IBSESSION.SESSION_RESULT_DTO)) {
//
//						if(!_ptInfo.equalsIgnoreCase("/login")){
//							resp.sendRedirect(req.getContextPath() + "/pages/login");
//						}
//
//					}else {
//						RespLoginDto _respLogin = (RespLoginDto) session.getAttribute(InfosysConstants.IBSESSION.SESSION_RESULT_DTO);
//						req.setAttribute("fullnameUser", _respLogin.getName());
//					}
//				}
//			}
//			req.setAttribute("idSession", session.getAttribute(InfosysConstants.IBSESSION.SESSION_ID));
//
//			RekeningData _rekening = _classImpl.getAnnotation(RekeningData.class);
//			if(null != _rekening){
//				RespListAccountDto _resp = Rekening.getRekening(req, _log);
//
//				final String _strResp = new Gson().toJson(_resp);
//				req.setAttribute("istRek", "localStorage.REKENING_DATA_BACK = JSON.stringify("+_strResp+");");
//				final String _valData = _rekening.value();
//				req.setAttribute("rekList", itemRek(_resp));
//				req.setAttribute("onloaddata" ,Rekening.GLOBALVAR.STRONLOAD.get(_valData)+";");
//
//			}
//			_fwd.forward(this, req, resp);
//			
//			_log.info();
//		} catch (final Exception e) {
//			_log.append("").append(e).appendLine().error();
//
//			if (AppSetting.PRINT_STACKTRACE) {
//				e.printStackTrace(System.out);
//			}
//		}
	}

//	private Map itemRek(final RespListAccountDto _resp){
//		final Map _ret = new HashMap();
//		final ArrayList _list = new ArrayList();
//
//		for(RespListAccountItemDto _item:_resp.getItems()){
//			Map _mapItem = new HashMap();
//			_mapItem.put("isPrimary", _item.getIsPrimary());
//			_mapItem.put("balance", _item.getBalance());
//			_mapItem.put("balanceDecimal", _item.getBalanceDecimal());
//			_mapItem.put("currency", _item.getCurrency());
//			_mapItem.put("account", _item.getAccount());
//			_mapItem.put("accountName", _item.getAccountName());
//			_mapItem.put("alias", _item.getAlias());
//			_mapItem.put("typeAccount", _item.getTypeAccount());
//			_mapItem.put("productType", _item.getProductType());
//			_list.add(_mapItem);
//		}
//		_ret.put("items", _list);
//		return _ret;
//	}
//	/**
//	 * 
//	 * @param param
//	 * @return
//	 */
//
//	private Set<String> breakPackage(final String param) {
//		final Set<String> _ret = new HashSet<String>(0);
//		if (null != param) {
//			_ret.addAll(Arrays.asList(param.split(",")));
//		}
//		
//		return _ret;
//	}


	
}
