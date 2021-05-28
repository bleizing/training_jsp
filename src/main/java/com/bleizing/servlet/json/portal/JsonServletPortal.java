package com.bleizing.servlet.json.portal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.commons.lang.StringUtils;
//import org.hibernate.criterion.Criterion;
//import org.hibernate.criterion.Restrictions;
//
//import com.google.common.reflect.TypeToken;
//import com.google.gson.Gson;
//
//import com.bleizing.AppSetting;
//import com.bleizing.bristar.hibernate.entities.ActivityEntity;
//import com.bleizing.bristar.hibernate.entities.ActivityNoteEntity;
//import com.bleizing.bristar.hibernate.entities.AuditEntity;
//import com.bleizing.bristar.hibernate.entities.GroupPortalEntity;
//import com.bleizing.bristar.hibernate.entities.UserEntity;
//import com.bleizing.bristar.hibernate.managers.BristarHibernateManager;
//import com.bleizing.bristar.managers.RespMappingManager;
//import com.bleizing.bristar.managers.RespMappingManager.RspData;
//import com.bleizing.bristar.web.admins.json.dto.params.RoleDto;
//import com.bleizing.bristar.web.publics.json.constanta.InfosysConstants;
//import com.bleizing.enums.AuditStatusEnum;
//import com.bleizing.enums.AuditTypeEnum;
//import com.bleizing.exception.ErrorType;
//import com.bleizing.exception.ProcessException;
//import com.bleizing.exception.ProcessExceptionDesc;
//import com.bleizing.gson.JsonBuilder;
//import com.bleizing.logging.Logging;
//import com.bleizing.servlet.RequestWrapper;
//import com.bleizing.servlet.ResponseWrapper;
//import com.bleizing.servlet.json.AllowGetMethod;
//import com.bleizing.servlet.json.AuditLog;
//import com.bleizing.servlet.json.IgnoreLogin;
//import com.bleizing.servlet.json.JsonController;
//import com.bleizing.servlet.json.JsonHandler;
//import com.bleizing.servlet.json.ParamDto;
//import com.bleizing.servlet.json.ResultDto;
//import com.bleizing.servlet.json.RolePortal;
//import com.bleizing.servlet.json.TransactionalValidator;
//import com.bleizing.util.ClassUtil;

/**
 * @author Nuriman
 */
public class JsonServletPortal extends HttpServlet {

//    /**
//     *
//     */
//    private static final Map<String, Class<?>> JSON_WEB_SERVS = new HashMap<String, Class<?>>();
//
//    /**
//     *
//     */
//    private static final long serialVersionUID = 2887067222300155133L;
//
//    /**
//     * Status TYpe
//     */
//
//    public enum Status {
//        NEW			( "NEW"),
//        ACTIVE		( "ACTIVE"),
//        INACTIVE	( "INACTIVE"),
//        DELETED	    ( "DELETED");
//
//
//        public final String VALUE;
//
//        /**
//         *
//         *
//         * @param status
//         */
//        Status(final String status) {
//
//            this.VALUE = status;
//        }
//    }
//
//
//    private final static String _LOGGER = "logger";
//
//    private String _loggerName = null;

    public void init(final ServletConfig config) throws ServletException {
        super.init(config);

//        _loggerName = config.getInitParameter(_LOGGER);
//
//        if(_loggerName == null){
//            _loggerName = getClass().getCanonicalName();
//        }
//
//        final Set<String> _packageSet = this.breakPackage(config.getInitParameter("packages"));
//        final Set<String> _classSet = new HashSet<String>();
//        for (final String _package : _packageSet) {
//            _classSet.addAll(ClassUtil.scanClasses(_package));
//        }
//
//        for (final String _className : _classSet) {
//            final Class<?> _class = ClassUtil.forName(_className);
//            if (null == _class) {
//                continue;
//            }
//
//            if (!JsonHandler.class.isAssignableFrom(_class)) {
//                continue;
//            }
//
//            final JsonController _jsonWebService = _class.getAnnotation(JsonController.class);
//            if (null == _jsonWebService || null == _jsonWebService.value()) {
//                continue;
//            }
//
//            for (final String _value : _jsonWebService.value()) {
//                if (null == _value || "".equals(_value.trim())) {
//                    continue;
//                }
//
//                final String _item = _value.trim();
//                final String _key = _item.charAt(0) == '/' ? _item : "/".concat(_item);
//                if (JsonServletPortal.JSON_WEB_SERVS.containsKey(_key)) {
//                    continue;
//                }
//
//                JsonServletPortal.JSON_WEB_SERVS.put(_key, _class);
//
//
//            }
//
//        }

    }

//    /**
//     * @param param
//     * @return
//     */
//    private Set<String> breakPackage(final String param) {
//        final Set<String> _ret = new HashSet<String>(0);
//        if (null != param) {
//            _ret.addAll(Arrays.asList(param.split(",")));
//        }
//
//        return _ret;
//    }

    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) {
//        try {
//            this.doPost(req, resp);
//            // resp.getWriter().write("TEST ONLY");
//        } catch (final Exception e) {
//            if (AppSetting.PRINT_STACKTRACE) {
//                e.printStackTrace(System.out);
//            }
//        }
    }

    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
//        final Logging _log = new Logging(_loggerName).setClass(this.getClass()).setMethod("doPost");
//
//        Exception error = null;
//        ResultDto result = new ResultDto();
//        ParamDto param = new ParamDto();
//        final ActivityNoteEntity _actNote = new ActivityNoteEntity();
//        HttpSession session = req.getSession();
//        Class<?> _classImpl = null;
//        UserEntity user = null;
//        RequestWrapper _reqWrapper = null;
//        ResponseWrapper _resWrapper = null;
//        final String _ptInfo = req.getPathInfo();
//        JsonHandler<? extends ParamDto, ? extends ResultDto> _service = null;
//        try {
//            if (null == req || null == resp) {
//                throw new ProcessException(null,ErrorType.INVALID_REQUEST_MODEL);
//            }
//
//            _log.append("request info: ").append(req).appendLine();
//
//            resp.setHeader("Content-Type", "application/json");
//            if (null == _ptInfo) {
//                throw new ProcessException(null,ErrorType.PATH_NOT_FOUND);
//            }
//
//            if (!JsonServletPortal.JSON_WEB_SERVS.containsKey(_ptInfo)) {
//                throw new ProcessException(null,ErrorType.PATH_NOT_FOUND);
//            }
//
//            _reqWrapper = new RequestWrapper(req);
//            _resWrapper = new ResponseWrapper(resp);
//
//            _classImpl = JsonServletPortal.JSON_WEB_SERVS.get(_ptInfo);
//
//            if (null == _classImpl) {
//                throw new ProcessException(null,ErrorType.CLASS_IMPLEMENT_NOT_FOUND);
//            }
//
//            _log.append("Using class : " + _classImpl.getCanonicalName()).appendLine();
//            final Constructor<?> _constructor = _classImpl.getConstructor(HttpServletRequest.class,
//                    HttpServletResponse.class, Logging.class);
//            final Object _instance = _constructor.newInstance(_reqWrapper, _resWrapper, _log);
//
//            if (req.getMethod() == "GET") {
//                AllowGetMethod _allowGet = _classImpl.getAnnotation(AllowGetMethod.class);
//                if (_allowGet == null) {
//                    throw new ProcessException(null,ErrorType.METHOD_NOT_ALLOWED);
//                }
//            }
//
//            if (!AppSetting.IGNORE_LOGIN) {
//                IgnoreLogin _ignoreLogin = _classImpl.getAnnotation(IgnoreLogin.class);
//
//                if (_ignoreLogin == null) {
//
//                    if (session.getAttribute(InfosysConstants.SESSION.SESSION_LOGIN_USER_PORTAL) == null) {
//                        throw new ProcessException(null,ErrorType.AUTH_USER_NOT_LOGGED_IN);
//                    }
//                }
//            }
//
//            if(AppSetting.ENABLE_GROUP_ROLE_PORTAL){
//                RolePortal _rolePortal = _classImpl.getAnnotation(RolePortal.class);
//                if(null != _rolePortal){
//                    final String _role = _rolePortal.value();
//
//                    if(!getRoleGroup(session, _role)){
//                        throw new ProcessException(null,ErrorType.FAILED_PORTAL_ROLE_PRIVILEGE);
//                    }
//                }
//            }
//
//            user = session.getAttribute(InfosysConstants.SESSION.SESSION_LOGIN_USER) == null ? null : (UserEntity) session.getAttribute(InfosysConstants.SESSION.SESSION_LOGIN_USER);
//
//            _service = (JsonHandler<? extends ParamDto, ? extends ResultDto>) _instance;
//            param = _service.param;
//
//            if (AppSetting.ENABLE_VALIDATION_TRANSACTION) {
//                TransactionalValidator _trxValidator = _classImpl.getAnnotation(TransactionalValidator.class);
//                if (_trxValidator != null) {
//                    if (!param.getDeviceId().equals(session.getAttribute(InfosysConstants.SESSION.SESSION_DEVICE_ID))) {
//                        throw new ProcessException(null,ErrorType.AUTH_TRX_FAILED_DIFERRENT_DEVICE);
//                    }
//                }
//            }
//
//            _service.setActivityNote(_actNote);
//            _service.doProcess();
//
//
//        } catch (final Exception e) {
//            error = e;
//
//            if (AppSetting.PRINT_STACKTRACE) {
//                e.printStackTrace(System.out);
//            }
//        } finally {
//            _log.append("param: ").append(param).appendLine();
//
//            if (_service != null)
//                result = _service.result;
//
//            if (null == result.getCode()) {
//                result.setCode(Integer.MAX_VALUE);
//            }
//
//            if (null == error) {
//                _log.info();
//            } else {
//
//                Boolean unexpectedError = false;
//
//                if (error instanceof ProcessExceptionDesc) {
//                    final ProcessExceptionDesc _peD = (ProcessExceptionDesc) error;
//                    result.setCode(_peD.errorType.code);
//                    result.setMessage(_peD.customMessage);
//                } else if (error instanceof ProcessException) {
//                    final ProcessException _pex = (ProcessException) error;
//                    result.setCode(_pex.getErrorType().code);
//                    result.setMessage(_pex.getErrorType().description);
//                    if (result.getCode().equals(ErrorType.UNEXPECTED_ERROR.code)) {
//                        unexpectedError = true;
//                    }
//                } else if (error instanceof ConnectException) {
//                    result.setCode(ErrorType.CONNECTION_REFUSED.code);
//                    result.setMessage(ErrorType.CONNECTION_REFUSED.description);
//                } else if (error instanceof SocketTimeoutException) {
//                    result.setCode(ErrorType.CONNECTION_READ_TIMEOUT.code);
//                    result.setMessage(ErrorType.CONNECTION_READ_TIMEOUT.description);
//                } else {
//                    unexpectedError = true;
//                    result.setCode(ErrorType.UNEXPECTED_ERROR.code);
//                    result.setMessage(ErrorType.UNEXPECTED_ERROR.description);
//                }
//
//
//                if (unexpectedError) {
//                    _log.append("error: ").append(error).appendLine();
//                }
//
//
//            }
//
//            //do mapping handler
//            errorMapping(_ptInfo, result, _log);
//
//            _log.append("result: ").append(result).appendLine();
//            if (AppSetting.ENABLE_AUDIT) {
//                AuditLog _auditLog = _classImpl.getAnnotation(AuditLog.class);
//                if (_auditLog != null && _auditLog.write()) {
//                    String _activityType = null;
//                    if (_auditLog.name().length > 1) {
//                        for (AuditTypeEnum _auditEach : _auditLog.name()) {
//                            if (param.getAuditType().equals(_auditEach)) {
//                                _activityType = _auditEach.name();
//                                break;
//                            }
//                        }
//                    } else {
//                        _activityType = _auditLog.name()[0].name();
//                    }
//
//                    if (_activityType == null) {
//                        return;
//                    }
//                    _activityType = _activityType.toUpperCase();
//                    final List<Criterion> _criterionList = new ArrayList<>();
//                    final Criterion _crit = Restrictions.eq("code", _activityType);
//                    _criterionList.add(_crit);
//                    List<ActivityEntity> _actEntList = new ArrayList<>();
//                    try {
//                        _actEntList = BristarHibernateManager.INSTANCE.select(ActivityEntity.class, null,
//                                _criterionList, null, null);
//                        if (!_actEntList.isEmpty()) {
//                            ActivityEntity _actEnt = _actEntList.get(0);
//                            try {
//                                writeAuditActivity(_actEnt, param, result, _actNote, _log, user, session);
//                                _log.append("Audit Created").appendLine();
//                            } catch (ProcessException e) {
//                                if (AppSetting.PRINT_STACKTRACE) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }
//                    } catch (ProcessException e) {
//                        if (AppSetting.PRINT_STACKTRACE) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//
//            _log.info();
//
//            try {
//                final String _respString = JsonBuilder.serialize(result);
//                this.writeResponse(resp, _respString);
//            } catch (final Exception e) {
//                e.getMessage();
//            }
//        }

    }


//    private void errorMapping(String handler, ResultDto resultDto, Logging _log) {
//        String errorCode = resultDto.getErrorCode();
//        if (errorCode == null) {
//            int code = resultDto.getCode();
//            if (code != 0) {
//                errorCode = String.valueOf(code);
//            } else {
//                return;
//            }
//        }
//        RespMappingManager instance = RespMappingManager.get();
//        if (instance == null) return;
//        RspData rspData = instance.getRspData(handler, errorCode);
//        if (rspData == null) return;
//        _log.append("Using error-data : ").appendLine();
//        _log.append(rspData.toString()).appendLine();
//
//        resultDto.setMessage(rspData.getDescription() + "(" + errorCode + ")");
//    }
//
//    private void writeResponse(final HttpServletResponse resp, final String content) {
//        try {
//            resp.getWriter().write(content);
//        } catch (final Exception e) {
//        }
//    }
//
//
//    private void writeAuditActivity(final ActivityEntity actEnt, final ParamDto param, final ResultDto result, final ActivityNoteEntity actNote, final Logging log, final UserEntity user, final HttpSession session) throws ProcessException {
//
//        AuditEntity _auditTable = new AuditEntity();
//        String _type = actNote.getType();
//        if (!StringUtils.isEmpty(_type)) {
//            BristarHibernateManager.INSTANCE.insert(actNote);
//            _auditTable.setActivityNoteEntity(actNote);
//        }
//
//        _auditTable.setAuditType(actEnt);
//        _auditTable.setDataReq(param.toString().replaceAll("(\"[Pp][Aa][Ss][Ss][Ww][Oo][Rr][Dd]\"[ ]{0,10}:[ ]{0,10}\").+(?=\")", "$1***")
//                .replaceAll("(\"[Nn][Ee][Ww][Pp][Aa][Ss][Ss][Ww][Oo][Rr][Dd]\"[ ]{0,10}:[ ]{0,10}\").+(?=\")", "$1***"));
//        _auditTable.setDataResp(result.toString());
//        _auditTable.setDurationTimeAPI(String.valueOf(log.duration));
//        _auditTable.setOwner(user);
//        _auditTable.setRc(result.getCode().toString());
//        _auditTable.setRequestTimeAPI(log.start);
//        _auditTable.setRespMsg(result.getMessage());
//        _auditTable.setResponseTimeAPI(log.finish);
//        if (result.getCode() != 0) {
//            _auditTable.setStatus(AuditStatusEnum.FAILED);
//        } else {
//            _auditTable.setStatus(AuditStatusEnum.SUCCESS);
//        }
//        _auditTable.setSessionId(session.getId());
//        _auditTable.setTokenId(session == null ? "" : (String) session.getAttribute(InfosysConstants.SESSION.SESSION_TOKEN));
//        _auditTable.setCreatedBy(user);
//        BristarHibernateManager.INSTANCE.insert(_auditTable);
//    }
//
//    public static Boolean getRoleGroup(final HttpSession session, String val){
//
//        GroupPortalEntity _ent = (GroupPortalEntity) session.getAttribute(InfosysConstants.SESSION.SESSION_GROUP_ROLE_PORTAL);
//
//        if(_ent != null) {
//        	String _roleNya = _ent.getRoleGroup();
//
//	        Type listObj = new TypeToken<List<RoleDto>>(){}.getType();
//	        List<RoleDto> list = new Gson().fromJson(_roleNya, listObj);
//
//	        for (RoleDto data : list){
//	           if(data.getRole().equalsIgnoreCase(val)){
//	               return true;
//	           }
//	        }
//        }
//        
//        return false;
//    }

}
