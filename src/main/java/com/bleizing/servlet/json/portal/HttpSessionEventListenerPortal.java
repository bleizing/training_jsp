//package com.bleizing.servlet.json.portal;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//import javax.servlet.http.HttpSessionAttributeListener;
//import javax.servlet.http.HttpSessionBindingEvent;
//
//import org.hibernate.criterion.Restrictions;
//
//import com.google.gson.Gson;
//import com.google.gson.annotations.Expose;
//
//import com.bleizing.bristar.hibernate.entities.UserPortalEntity;
//import com.bleizing.bristar.hibernate.entities.UserPortalSessionEntity;
//import com.bleizing.bristar.hibernate.managers.BristarHibernateManager;
//import com.bleizing.bristar.web.publics.json.constanta.InfosysConstants;
//import com.bleizing.logging.Logging;
//import com.bleizing.logging.impl.ApplicationLogging;
//import com.bleizing.servlet.json.ParamDto;
//
///**
// * @author Taufik.Indra
// *
// */
//
//public class HttpSessionEventListenerPortal implements HttpSessionAttributeListener {
//
//
//
//    public static Map<String, DataUserSession> map = new ConcurrentHashMap<String, DataUserSession>();
//    public static class DataUserSession extends ParamDto {
//        @Expose
//        private String username;
//        @Expose
//        private String sessionId;
//        @Expose
//        private Long userId;
//        @Expose
//        private String lastActive;
//
//        @Expose
//        private String desc;
//
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getSessionId() {
//            return sessionId;
//        }
//
//        public void setSessionId(String sessionId) {
//            this.sessionId = sessionId;
//        }
//
//        public String getLastActive() {
//            return lastActive;
//        }
//
//        public void setLastActive(String lastActive) {
//            this.lastActive = lastActive;
//        }
//
//        public Long getUserId() {
//            return userId;
//        }
//
//        public void setUserId(Long userId) {
//            this.userId = userId;
//        }
//
//        public String getDesc() {
//            return desc;
//        }
//
//        public void setDesc(String desc) {
//            this.desc = desc;
//        }
//    }
//
//
//
//    @Override
//    public void attributeAdded(HttpSessionBindingEvent event) {
//
//        String strAttributeName = event.getName();
//        Object objAttributeValue = event.getValue();
//        System.out.println("Attribute added: [" + strAttributeName + " : " + objAttributeValue + "]");
//    }
//
//
//    @Override
//    public void attributeRemoved(HttpSessionBindingEvent event)  {
//
//        String strAttributeName = event.getName();
//
//        Object objAttributeValue = event.getValue();
//        final Logging _log = new ApplicationLogging().setClass(this.getClass()).setMethod("doPost");
//
//        if(InfosysConstants.SESSION.SESSION_LOGIN_USER_PORTAL_ID.equalsIgnoreCase(strAttributeName)){
//
//            try {
//                UserPortalSessionEntity _ent = (UserPortalSessionEntity) objAttributeValue;
//                _log.append("remove session user : ").append(_ent.getUser().getUsername()).appendLine();
//                map.remove(_ent.getUser().getId().toString());
//                BristarHibernateManager.INSTANCE.delete(_ent);
//
//            }catch (Exception e){
//                _log.append("gagal remove session : ").append(new Gson().toJson(e.getStackTrace()));
//                e.printStackTrace();
//            }
//
//        }
//
//        _log.append("Attribute removed: [" + strAttributeName + " : " + objAttributeValue + "]").appendLine();
//    }
//
//    @Override
//    public void attributeReplaced(HttpSessionBindingEvent event) {
//        String strAttributeName = event.getName();
//        Object objAttributeValue = event.getValue();
//        System.out.println("Attribute id Session = "+event.getSession().getId());
//        UserPortalEntity _user = (UserPortalEntity) event.getSession().getAttribute(InfosysConstants.SESSION.SESSION_LOGIN_USER_PORTAL);
//        if(null != _user){
//            try {
//                UserPortalSessionEntity _sessionDb = BristarHibernateManager.INSTANCE.get(UserPortalSessionEntity.class, null, Restrictions.eq("user", _user), null);
//                if(null == _sessionDb){
//                    //event.getSession().invalidate();
//                }
//
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        }
//        System.out.println("Attribute replaced: [" + strAttributeName + " : " + objAttributeValue + "]");
//
//    }
//}
