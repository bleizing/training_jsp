package com.bleizing.web.listeners;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import com.bleizing.servlet.html.htmlib.HtmlServlet;

/**
 * 
 * @author nuriman
 * @update by Hendra,
 * 
 * 13-FEB-2018,menambahkan inactive timeout ke dalam parameter
 */
public class SessionListener implements HttpSessionListener {

//	public final static String JBOSS_NODE_NAME = "jboss.node.name";
//	public final static String REAL_SESSION_ID = "real_sess_id";
//
//	public final static String MAX_INACTIVE_SESSION = "max-inactive-session";
//	public final static String CREATED_TIME = "created-time";
//	public final static String ON_CHANGE_SESSION = "on-change-session";
//	public final static String PORTAL_SESS_ENTITY_ID = "portal-sess-entity-id";
//
//
//	public final static int DEFAULT_INACTIVE_SESSION_TIMEOUT = 600;//10 minutes
//
//	public final static String HQL_UPDATE_CLEAN ="UPDATE UserSession us SET us.tokenStatus=?,us.tokenIb=null,us.tokenExpired=null WHERE us.id=?";
//
//
//	private final static Map<Long,String> activeSessionId = new HashMap<Long,String>();
//
//	public static void putActiveLogin(Long id,String sessionId) {
//		activeSessionId.put(id,sessionId);
//	}
//
//	public static boolean isActiveLogin(Long id) {
//		return (activeSessionId.get(id)!=null);
//	}
//
//
//	public static String getRealSessionId(HttpSession session) {
//		Object obj = session.getAttribute(REAL_SESSION_ID);
//		if(obj==null)return null;
//		return (String)obj;
//	}
	public void sessionCreated(final HttpSessionEvent event) {
//		final HttpSession _session = event.getSession();
//		_session.setAttribute(REAL_SESSION_ID, _session.getId()+ "." + System.getProperty(JBOSS_NODE_NAME));
//
//
//
//		_session.setMaxInactiveInterval(BaseConfigParameter.getInt(MAX_INACTIVE_SESSION, DEFAULT_INACTIVE_SESSION_TIMEOUT));
//		_session.setAttribute(CREATED_TIME, System.currentTimeMillis());
//
//		final Logging _log = new ApplicationLogging().setClass(this.getClass()).setMethod("SessionCreated");
//		_log.append("Session created '" + _session.getId() + "Servlet context "+ HtmlServlet.PATH_INFO);
//
//
//		_log.info();
	}

//	private boolean getBoolean(HttpSession session,String key) {
//		Object objChangedSession = session.getAttribute(key);
//		if(objChangedSession==null)return false;
//		return (Boolean)objChangedSession;
//	}
//
//	private Long getPortalSessionEntityId(HttpSession session) {
//		Object objSessId = session.getAttribute(PORTAL_SESS_ENTITY_ID);
//		if(objSessId==null)return null;
//		return (Long)objSessId;
//	}

	public void sessionDestroyed(final HttpSessionEvent event) {
//		final Logging _log = new ApplicationLogging().setClass(this.getClass()).setMethod("SessionDestroyed");
//
//		final HttpSession _session = event.getSession();
//		_log.append("Session destroyed '" + _session.getId() + "'").appendLine();
//
//		if(getBoolean(_session,ON_CHANGE_SESSION)) {
//			_log.append("User on change session, do not log-out current login session from backend system").appendLine();
//		}else {
//			final Object _userObj = _session.getAttribute(InfosysConstants.SESSION.SESSION_LOGIN_USER); // NOPMD by Nuriman on 7/28/17 6:46 PM
//
//			if (_userObj!=null && _userObj instanceof UserEntity) {
//
//				final UserEntity _user = (UserEntity) _userObj;
//				_log.append("Logout user '" + _user.getUsername() + "'").appendLine();
//				try {
//					LoginServices.logout(_user.getUsername(), "0.0.0.0", "BACK_END_LOGOUT", _log);
//				} catch (IOException e) {
//					//e.printStackTrace();
//				} catch (ProcessException e) {
//					//e.printStackTrace();
//				}
//				activeSessionId.remove(_user.getId());//remove active session
//			}
//
//			Long portalSessionEntityId = getPortalSessionEntityId(_session);
//			if(portalSessionEntityId!=null) {
//				try {
//					BristarHibernateManager.INSTANCE.executeUpdate(HQL_UPDATE_CLEAN, UserSessionEntity.TOKEN_INIT,portalSessionEntityId);
//				}catch(Exception e) {
//                    //ignore the exception
//				}
//			}
//
//
//		}
//
//		_log.info();
	}

}
