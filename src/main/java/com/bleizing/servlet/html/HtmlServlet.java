package com.bleizing.servlet.html;

import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bleizing.exception.ErrorType;
import com.bleizing.exception.ProcessException;
import com.bleizing.logging.Logging;
import com.bleizing.servlet.ServletForward;
import com.bleizing.util.ClassUtil;

/**
 * 
 * @author Nuriman
 *
 */
public class HtmlServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8086986036140406102L;
	
	private final Logging _log = new Logging().setClass(this.getClass()).setMethod("HtmlServlet");

	/**
	 * 
	 */
	private static final Map<String, Class<?>> HTML_CONTROLLERS = new HashMap<String, Class<?>>();

	
	public void init(final ServletConfig config) throws ServletException {
		
		super.init(config);
		
		_log.append("init").appendLine();
		
		final Set<String> _packageSet = this.breakPackage(config.getInitParameter("packages"));
		final Set<String> _classSet = new HashSet<String>();
		for (final String _package: _packageSet) {
			_classSet.addAll(ClassUtil.scanClasses(_package));
		}
		
		for (final String _className : _classSet) {
			final Class<?> _class = ClassUtil.forName(_className);
			if (null == _class) {
				continue;
			}
			
			if (!HtmlHandler.class.isAssignableFrom(_class)) {
				continue;
			}
						
			final HtmlController _annotation = _class.getAnnotation(HtmlController.class);
			if (null == _annotation || null == _annotation.value()) {
				continue;
			}

			
			for (final String _value : _annotation.value()) {
				if (null == _value || "".equals(_value.trim())) {
					continue;
				}
				
				final String _item = _value.trim();
				final String _key = _item.charAt(0) == '/'? _item : "/".concat(_item);
				if (HtmlServlet.HTML_CONTROLLERS.containsKey(_key)) {
					continue;
				}
				
				HtmlServlet.HTML_CONTROLLERS.put(_key, _class);
				
			}

		}

	}

	/**
	 * 
	 */
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) {
		_log.append("doGet").appendLine();
		this.doPost(req, resp);
	}

	/**
	 * 
	 */
	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
		_log.append("doPost").appendLine();
		_log.append("request info: ").append(req).appendLine();
		
		try {
			if (null == req || null == resp) {
				throw new ProcessException(null,ErrorType.INVALID_REQUEST_MODEL);
			}
//
			final String _ptInfo = req.getPathInfo();
			_log.append("path:" + _ptInfo).appendLine();
			if (null == _ptInfo) {
				throw new ProcessException(null,ErrorType.PATH_NOT_FOUND);
			}

			if (!HtmlServlet.HTML_CONTROLLERS.containsKey(_ptInfo)) {
				throw new ProcessException(null,ErrorType.PATH_NOT_FOUND);
			}
//
			HttpSession session = req.getSession();
//
			final Class<?> _classImpl = HtmlServlet.HTML_CONTROLLERS.get(_ptInfo);
			final Constructor<?> _constructor = _classImpl.getConstructor(HttpServletRequest.class, HttpServletResponse.class);
			final Object _instance = _constructor.newInstance(req, resp);
//
			final HtmlHandler _service = (HtmlHandler) _instance;
			final ServletForward _fwd = _service.process();
			_log.append("session trigDate : " + session.getAttribute("trigDate")).appendLine();
			session.setAttribute("trigDate", new Date().getTime());
			_log.append("session id : " + session.getId()).appendLine();
//			if (!AppSetting.IGNORE_LOGIN) {
//				IgnoreLogin _ignoreLogin = _classImpl.getAnnotation(IgnoreLogin.class);
//
//				if (null == _ignoreLogin) {
//
//					if (session.getAttribute(InfosysConstants.SESSION.SESSION_LOGIN_USER_PORTAL) == null) {
//
//						if(!_ptInfo.equalsIgnoreCase("/login")){
//							resp.sendRedirect(req.getContextPath() + "/pages/login");
//						}
//
//					}else {
//						if(_ptInfo.equalsIgnoreCase("/login")){
//							resp.sendRedirect(req.getContextPath() + "/pages/home");
//						}
//						UserPortalEntity _entUser = (UserPortalEntity) session.getAttribute(InfosysConstants.SESSION.SESSION_LOGIN_USER_PORTAL);
//						SimpleDateFormat _smpl = new SimpleDateFormat("MM . yyyy");
//						req.setAttribute("sessionUserName", _entUser.getUsername());
//						req.setAttribute("sessionGroupName", _entUser.getOwnerGroup().getNameGroup());
//						req.setAttribute("sessionCreateOn", _smpl.format(_entUser.getCreatedOn()));
//						req.setAttribute("ctxArrayRole", _entUser.getOwnerGroup().getRoleGroup());
//						req.setAttribute("sessionUserStatus", _entUser.getStatus());
//						if(_entUser.getStatus().equalsIgnoreCase(JsonServletPortal.Status.NEW.VALUE) && !_ptInfo.equalsIgnoreCase("/user/profile")
//								&& !_ptInfo.equalsIgnoreCase("/get/img/profile")){
//							resp.sendRedirect(req.getContextPath()+"/pages/user/profile");
//						}else{
//							UserProfilePortalEntity _entProfile = (UserProfilePortalEntity) session.getAttribute(InfosysConstants.SESSION.SESSION_LOGIN_USER_PORTAL_PROFILE);
//							if(null != _entProfile){
//								req.setAttribute("sessionUserProfile", _entProfile);
//							}
//						}
//						//ON USER ACTIVE
//						try {
//							HttpSessionEventListenerPortal.DataUserSession _map =	HttpSessionEventListenerPortal.map.get(_entUser.getId().toString());
//							if(null == _map){
//								_log.append("map this user null direct to login").appendLine();
//								session.invalidate();
//								resp.sendRedirect(req.getContextPath() + "/pages/login");
//							}
//						}catch (Exception e){
//							_log.append("ERROR ON CHECK MAP LISTENER : ").append(new Gson().toJson(e.getStackTrace()));
//						}
//						//END ON USER ACTIVE
//
//
//
//					}
//
//					if(AppSetting.ENABLE_GROUP_ROLE_PORTAL){
//						RolePortal _rolePortal = _classImpl.getAnnotation(RolePortal.class);
//						if(null != _rolePortal){
//							final String _role = _rolePortal.value();
//							if(!JsonServletPortal.getRoleGroup(session, _role)){
//								resp.sendRedirect(req.getContextPath() + "/pages/auth/role");
//							}
//						}
//					}
//				}
//			}
//
			_fwd.forward(this, req, resp);
//			
			_log.info();
		} catch (final Exception e) {
			_log.append("").append(e).appendLine().error();

//			if (AppSetting.PRINT_STACKTRACE) {
				e.printStackTrace(System.out);
//			}
		}
	}

	/**
	 * 
	 * @param param
	 * @return
	 */
	private Set<String> breakPackage(final String param) {
		final Set<String> _ret = new HashSet<String>(0);
		if (null != param) {
			_ret.addAll(Arrays.asList(param.split(",")));
		}
		
		return _ret;
	}


	
}
