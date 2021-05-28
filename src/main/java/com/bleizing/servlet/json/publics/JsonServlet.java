//package com.bleizing.servlet.json.publics;
//
//import com.bleizing.AppSetting;
//import com.bleizing.bristar.hibernate.entities.ActivityEntity;
//import com.bleizing.bristar.hibernate.entities.ActivityNoteEntity;
//import com.bleizing.bristar.hibernate.entities.AuditEntity;
//import com.bleizing.bristar.hibernate.entities.UserEntity;
//import com.bleizing.bristar.hibernate.managers.BristarHibernateManager;
//import com.bleizing.bristar.managers.RespMappingManager;
//import com.bleizing.bristar.managers.RespMappingManager.RspData;
//import com.bleizing.bristar.web.publics.json.constanta.InfosysConstants;
//import com.bleizing.bristar.web.publics.json.utils.BaseConfigParameter;
//import com.bleizing.enums.AuditStatusEnum;
//import com.bleizing.enums.AuditTypeEnum;
//import com.bleizing.enums.TerminalEnum;
//import com.bleizing.enums.TransactionTypeEnum;
//import com.bleizing.exception.ErrorType;
//import com.bleizing.exception.ProcessException;
//import com.bleizing.exception.ProcessExceptionDesc;
//import com.bleizing.gson.JsonBuilder;
//import com.bleizing.logging.Logging;
//import com.bleizing.logging.impl.ApplicationLogging;
//import com.bleizing.servlet.RequestWrapper;
//import com.bleizing.servlet.ResponseWrapper;
//import com.bleizing.servlet.json.*;
//import com.bleizing.util.ClassUtil;
//import com.bleizing.util.StreamUtil;
//import com.bleizing.util.StringUtils;
//import org.hibernate.criterion.Criterion;
//import org.hibernate.criterion.Restrictions;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.Serializable;
//import java.lang.reflect.Constructor;
//import java.net.ConnectException;
//import java.net.SocketTimeoutException;
//import java.util.*;
//
///**
// * @author Nuriman
// * <p>
// * 20-JUN-2018, menambahkan satu parameter clientReffNo
// */
//public class JsonServlet extends HttpServlet {
//    public final static String DEFAULT_FRONT_END_TEMPLATE = "%s\nKode:%s";
//    public final static String FRONT_END_TEMPLATE = "frontend_template";
//
//    public final static String C_LOGGER = "logger";
//    public final static String C_PACKAGES = "packages";
//
//    public final static String C_DEFAULT_LOGGER = ApplicationLogging.LOGGING_NAME;
//    /**
//     *
//     */
//    private static final Map<String, JsonControllerClass> JSON_WEB_SERVS = new HashMap<String, JsonControllerClass>();
//
//    private static final String[] DESKRIPSI_ACTIVITY_NOREK = new String[]{"fromAcc", "accountNumb", "noHp", "cardNumb", "noRek"};
//    private static final String[] DESKRIPSI_ACTIVITY_DEST = new String[]{"destNumber", "toAcc", "toPhone", "destination", "phoneNumber", "paymentNumb", "paymentNumber", "purchaseNumber", "accountNumber", "depositoAccountNumber"};
//    private static final String[] DESKRIPSI_ACTIVITY_AMOUNT = new String[]{"amount", "totalAmount"};
//
//
//    /**
//     *
//     */
//    private static final long serialVersionUID = 2887067222300155133L;
//
//    private String loggerName;
//
//    /**
//     *
//     */
//    public void init(final ServletConfig config) throws ServletException {
//        super.init(config);
//
//        String packagesName = config.getInitParameter(C_PACKAGES);
//        this.loggerName = config.getInitParameter(C_LOGGER);
//
//        if (StringUtils.isEmpty(loggerName)) {
//            this.loggerName = C_DEFAULT_LOGGER;
//        }
//
//        final Set<String> _packageSet = this.breakPackage(packagesName);
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
//            TransactionTypeEnum tranTypeEnum = _jsonWebService.tranType();
//            for (final String _value : _jsonWebService.value()) {
//                if (null == _value || "".equals(_value.trim())) {
//                    continue;
//                }
//
//                final String _item = _value.trim();
//                final String _key = _item.charAt(0) == '/' ? _item : "/".concat(_item);
//                if (JsonServlet.JSON_WEB_SERVS.containsKey(_key)) {
//                    continue;
//                }
//
//                JsonServlet.JSON_WEB_SERVS.put(_key, new JsonControllerClass(tranTypeEnum, _class));
//
//
//            }
//
//        }
//
//    }
//
//
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
//
//    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) {
//        try {
//            this.doPost(req, resp);
//            // resp.getWriter().write("TEST ONLY");
//        } catch (final Exception e) {
//            if (AppSetting.PRINT_STACKTRACE) {
//                e.printStackTrace(System.out);
//            }
//        }
//    }
//
//    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
//        final Logging _log = new Logging(loggerName).setClass(this.getClass()).setMethod("doPost");
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
//        TransactionTypeEnum pathTranType = TransactionTypeEnum.NO;
//        JsonHandler<? extends ParamDto, ? extends ResultDto> _service = null;
//
//        try {
//            if (null == req || null == resp) {
//                throw new ProcessException(null, ErrorType.INVALID_REQUEST_MODEL);
//            }
//
//            _log.append("request info: ").append(req).appendLine();
////            _log.append("<<<<<< HEADER_REQUEST_FROM_FRONT_END>>>>>>").appendLine();
////            Enumeration<String> headerNames = req.getHeaderNames();
////            while (headerNames.hasMoreElements()) {
////                String headerName = headerNames.nextElement();
////                String headerValue = req.getHeader(headerName);
////
////                _log.append("[" + headerName + "]").append(":").append("[" + headerValue + "]").appendLine();
////            }
//
//            resp.setHeader("Content-Type", "application/json");
//            if (null == _ptInfo) {
//                throw new ProcessException(null, ErrorType.PATH_NOT_FOUND);
//            }
//
//            if (!JsonServlet.JSON_WEB_SERVS.containsKey(_ptInfo)) {
//                throw new ProcessException(null, ErrorType.PATH_NOT_FOUND);
//            }
//
//            _reqWrapper = new RequestWrapper(req);
//            _resWrapper = new ResponseWrapper(resp);
//
//            JsonControllerClass controllerClass = JsonServlet.JSON_WEB_SERVS.get(_ptInfo);
//
//            if (null == controllerClass) {
//                throw new ProcessException(null, ErrorType.CLASS_IMPLEMENT_NOT_FOUND);
//            }
//
//            _classImpl = controllerClass.getClazz();
//            pathTranType = controllerClass.getTranType();
//
//            _log.append("Using class: " + _classImpl.getCanonicalName()).appendLine();
//            _log.append("Incoming Message: " + StreamUtil.byteArrayToString((_reqWrapper.toByteArray())));
//            final Constructor<?> _constructor = _classImpl.getConstructor(HttpServletRequest.class,
//                    HttpServletResponse.class, Logging.class);
//            final Object _instance = _constructor.newInstance(_reqWrapper, _resWrapper, _log);
//
////            if (!req.getMethod().equals("GET") && !req.getMethod().equals("POST")) {
////                throw new ProcessException(null, ErrorType.METHOD_NOT_ALLOWED);
////            }
//
//            if (req.getMethod().equals("GET")) {
//                AllowGetMethod _allowGet = _classImpl.getAnnotation(AllowGetMethod.class);
//                if (_allowGet == null) {
//                    throw new ProcessException(null, ErrorType.METHOD_NOT_ALLOWED);
//                }
//            }
//
//            user = session.getAttribute(InfosysConstants.SESSION.SESSION_LOGIN_USER) == null ? null : (UserEntity) session.getAttribute(InfosysConstants.SESSION.SESSION_LOGIN_USER);
//
//
//            if (!AppSetting.IGNORE_LOGIN) {
//                IgnoreLogin _ignoreLogin = _classImpl.getAnnotation(IgnoreLogin.class);
//                if (_ignoreLogin == null) {
//                    if (user == null) {
//                        throw new ProcessException(null, ErrorType.AUTH_USER_NOT_LOGGED_IN);
//                    }
//                }
//            }
//
//
//            _service = (JsonHandler<? extends ParamDto, ? extends ResultDto>) _instance;
//            param = _service.param;
//
//            TerminalEnum _agent = (TerminalEnum) session.getAttribute(InfosysConstants.SESSION.SESSION_AGENT);
//
//            if (null == _agent || "".equals(_agent)) {
//                _agent = TerminalEnum.UNKNOWN;
//            }
//
//            if (!_agent.equals(TerminalEnum.IB)) {
//                if (AppSetting.ENABLE_VALIDATION_TRANSACTION) {
//                    TransactionalValidator _trxValidator = _classImpl.getAnnotation(TransactionalValidator.class);
//                    if (_trxValidator != null) {
//                        if (!param.getDeviceId().equals(session.getAttribute(InfosysConstants.SESSION.SESSION_DEVICE_ID))) {
//                            throw new ProcessException(null, ErrorType.AUTH_TRX_FAILED_DIFERRENT_DEVICE);
//                        }
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
//            if (null != error) {
//
//                Boolean unexpectedError = false;
//
//                if (error instanceof ProcessExceptionDesc) {
//                    final ProcessExceptionDesc _peD = (ProcessExceptionDesc) error;
//                    result.setCode(_peD.errorType.code);
//                    result.setMessage(_peD.customMessage);
//                    if (_peD.getErrorCode() != null) {
//                        result.setErrorCode(_peD.getErrorCode());
//                    }
//                } else if (error instanceof ProcessException) {
//                    final ProcessException _pex = (ProcessException) error;
//                    result.setCode(_pex.getErrorType().code);
//                    result.setMessage(_pex.getErrorType().description);
//                    if (result.getCode().equals(ErrorType.UNEXPECTED_ERROR.code)) {
//                        unexpectedError = true;
//                    }
//                    if (_pex.getErrorCode() != null) {
//                        result.setErrorCode(_pex.getErrorCode());
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
//            }
//
//
//            //do mapping handler
//            errorMapping(pathTranType, _ptInfo, result, _log);
//            if (param.getClientReffNo() != null) {
//                result.setClientReffNo(param.getClientReffNo());
//            }
//
////            _log.append("<<<<<< HEADER_RESPONSE_TO_FRONT_END>>>>>>").appendLine();
////            Collection<String> headerNamesResponse = resp.getHeaderNames();
////            while (!headerNamesResponse.isEmpty()) {
////                String headerName = headerNamesResponse.toString();
////
////                _log.append("[" + headerName + "]").append(":").append("[" + resp.getHeader(headerName) + "]").appendLine();
////            }
//            _log.append("result: ").append(result).appendLine();
//            if (AppSetting.ENABLE_AUDIT) {
//                auditLog(_classImpl, param, result, _actNote, user, session, _log);
//            }
//
//            if (error == null) {
//                _log.info();
//            } else {
//                _log.error();
//            }
//
//
//            try {
//                final String _respString = JsonBuilder.serialize(result);
//                this.writeResponse(resp, _respString);
//            } catch (final Exception e) {
//                e.getMessage();
//            }
//        }
//
//    }
//
//    private void auditLog(Class<?> _classImpl, ParamDto param, ResultDto result,
//                          ActivityNoteEntity _actNote, UserEntity user, HttpSession session, Logging _log) {
//        try {
//            AuditLog _auditLog = _classImpl.getAnnotation(AuditLog.class);
//            if (_auditLog != null && _auditLog.write()) {
//                String _activityType = null;
//                if (_auditLog.name().length > 1) {
//                    for (AuditTypeEnum _auditEach : _auditLog.name()) {
//                        if (param.getAuditType() != null && param.getAuditType().equals(_auditEach)) {
//                            _activityType = _auditEach.name();
//                            break;
//                        }
//                    }
//                } else {
//                    _activityType = _auditLog.name()[0].name();
//                }
//
//                if (_activityType == null) {
//                    return;
//                }
//                _activityType = _activityType.toUpperCase();
//                final List<Criterion> _criterionList = new ArrayList<>();
//                final Criterion _crit = Restrictions.eq("code", _activityType);
//                _criterionList.add(_crit);
//                List<ActivityEntity> _actEntList = BristarHibernateManager.INSTANCE.select(ActivityEntity.class, null, _criterionList, null, null);
//                if (!_actEntList.isEmpty()) {
//                    ActivityEntity _actEnt = _actEntList.get(0);
//                    try {
//                        String _deskrispiActivity = _actEnt.getDeskripsiActivity();
//                        if (null != _deskrispiActivity && !"".equals(_deskrispiActivity)) {
//                            _actNote.setAdditional1(replaceDeskripsiActivity(_deskrispiActivity, param, result));
//                        }
//
//                        writeAuditActivity(_actEnt, param, result, _actNote, _log, user, session);
//                        _log.append("Audit Created").appendLine();
//                    } catch (ProcessException e) {
//                        if (AppSetting.PRINT_STACKTRACE) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//
//            }
//        } catch (ProcessException e) {
//            if (AppSetting.PRINT_STACKTRACE) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private String replaceDeskripsiActivity(String deskripsi, ParamDto param, ResultDto result) {
//        Map<String, Object> _paramMap = JsonBuilder.deserialize(param.toString(), Map.class);
//        Map<String, Object> _resultMap = JsonBuilder.deserialize(result.toString(), Map.class);
//        String transaksiDes = "";
//
//        if (null != deskripsi && !"".equals(deskripsi)) {
//            String _statusCardSetting = "";
//            Boolean _isEnable = (Boolean) _paramMap.get("isEnabled");
//            String _namaBank = "";
//            String _namaBankResp = (String) _resultMap.get("namaBank");
//            String _coupon = "";
//            String _couponResp = (String) _resultMap.get("coupon");
//            String _kode = "";
//            String _kodeResp = (String) _resultMap.get("kode");
//
//
//            if (null != _isEnable) {
//                if (_isEnable) {
//                    _statusCardSetting = "Aktif";
//                } else {
//                    _statusCardSetting = "Non-Aktif";
//                }
//            }
//
//            if (null != _namaBankResp && !"".equals(_namaBankResp)) {
//                _namaBank = _namaBankResp;
//            }
//
//            if (null != _couponResp && !"".equals(_couponResp)) {
//                _coupon = _couponResp;
//            }
//
//            if (null != _kodeResp && !"".equals(_kodeResp)) {
//                _kode = _kodeResp;
//            }
//
//            String[] splitsDesk = deskripsi.split(";");
//            if (0 == result.getCode()) {
//                //Sukses
//                transaksiDes = splitsDesk[0];
//            } else {
//                //Tidak Sukses
//                transaksiDes = splitsDesk[1];
//            }
//
//            transaksiDes = transaksiDes
//                    .replace("${noRek}", getMapByNoRek(_paramMap))
//                    .replace("${dest}", getMapByDest(_paramMap))
//                    .replace("${amount}", getMapByAmount(_paramMap))
//                    .replace("${status}", _statusCardSetting)
//                    .replace("${namaBank}", _namaBank)
//                    .replace("${noKupon}", _coupon)
//                    .replace("${kode}", _kode);
//        }
//
////        if (ArrayUtils.contains(InfosysConstants.PURCHASE.RC_SUSPEND, result.getCode()) || ArrayUtils.contains(InfosysConstants.PAYMENT.RC_SUSPEND, result.getCode())) {
////
////        }
//        return transaksiDes;
//    }
//
//    private String getMapByNoRek(Map<String, Object> deskripsiMap) {
//        String noRek = "";
//        List<String> listNoRek = Arrays.asList(DESKRIPSI_ACTIVITY_NOREK);
//        for (String _noRek : listNoRek) {
//            String valueNoRekMap = (String) deskripsiMap.get(_noRek);
//            if (null != valueNoRekMap) {
//                noRek = valueNoRekMap;
//                break;
//            }
//        }
//        return noRek;
//    }
//
//    private String getMapByDest(Map<String, Object> deskripsiMap) {
//        String dest = "";
//        List<String> listDest = Arrays.asList(DESKRIPSI_ACTIVITY_DEST);
//        for (String _dest : listDest) {
//            String valueDestMap = "";
//            try {
//                valueDestMap = (String) deskripsiMap.get(_dest);
//            } catch (Exception e) {
//                Map<String, String> mapDest = (Map<String, String>) deskripsiMap.get(_dest);
//                valueDestMap = mapDest.toString();
//            }
//
//            if (null != valueDestMap) {
//                dest = valueDestMap;
//                break;
//            }
//        }
//        return dest;
//    }
//
//    private String getMapByAmount(Map<String, Object> deskripsiMap) {
//        String result = "";
//        List<String> list = Arrays.asList(DESKRIPSI_ACTIVITY_AMOUNT);
//        for (String eachList : list) {
//            String value = String.valueOf(deskripsiMap.get(eachList));
//            if (null != value) {
//                result = value;
//                break;
//            }
//        }
//        return result;
//    }
//
//
//    private String buildMessage(RspData rspData) {
//        String template = BaseConfigParameter.getString(FRONT_END_TEMPLATE, DEFAULT_FRONT_END_TEMPLATE);
//        return String.format(template, rspData.getDescription(), rspData.getRspCode());
//    }
//
//    private void errorMapping(TransactionTypeEnum tranType, String path, ResultDto resultDto, Logging _log) {
//        String errorCode = resultDto.getErrorCode();
//        int code = resultDto.getCode();
//        String alternateErrorCode = null;
//        if (code != 0) {
//            alternateErrorCode = String.valueOf(code);
//        }
//
//        RespMappingManager instance = RespMappingManager.get();
//        if (instance == null) return;
//
//        RspData rspData = retrieveErrorDataByPath(instance, path, errorCode, alternateErrorCode);
//
//        if (null == rspData) {
//            if (tranType == null || TransactionTypeEnum.NO.equals(tranType)) {
//                rspData = retrieveErrorData(instance, "", errorCode, alternateErrorCode);
//            } else {
//                String tranHandler = tranType.toString();
//                rspData = retrieveErrorData(instance, tranHandler, errorCode, alternateErrorCode);
//            }
//
//        }
//
//
//        if (rspData == null) return;
//        _log.append("Using rsp-data : ").appendLine();
//        _log.append(rspData.toString()).appendLine();
//
//        resultDto.setMessage(buildMessage(rspData));
//        if (rspData.getDestRspCode() != 0) {
//            resultDto.setCode(rspData.getDestRspCode());
//        }
//    }
//
//    private RspData retrieveErrorDataByPath(RespMappingManager errorMappingManager, String path, String errorCode, String alternateErrorCode) {
//        String tranHandler = errorMappingManager.getErrorHandler(path);
//        if (tranHandler != null && !tranHandler.isEmpty()) {
//            return retrieveErrorData(errorMappingManager, tranHandler, errorCode, alternateErrorCode);
//        }
//        return null;
//    }
//
//
//    private RspData retrieveErrorData(RespMappingManager errorMappingManager, String handler, String errorCode, String alternateErrorCode) {
//
//        RspData rspData = errorMappingManager.getRspData(handler, errorCode);
//        if (rspData == null) {
//            rspData = errorMappingManager.getRspData(handler, alternateErrorCode);
//        }
//
//        return rspData;
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
//        TerminalEnum _agent = (TerminalEnum) session.getAttribute(InfosysConstants.SESSION.SESSION_AGENT);
//
//        if (null == _agent || "".equals(_agent)) {
//            _agent = TerminalEnum.UNKNOWN;
//        }
//
//        _auditTable.setTerminalEnum(_agent);
//        _auditTable.setAuditType(actEnt);
//
//        String _excludePass = excludePass(param.toString());
//
//        //		_auditTable.setDataReq(param.toString().replaceAll("(\"[Pp][Aa][Ss][Ss][Ww][Oo][Rr][Dd]\"[ ]{0,10}:[ ]{0,10}\").+(?=\")", "$1***")
//        //				.replaceAll("(\"[Nn][Ee][Ww][Pp][Aa][Ss][Ss][Ww][Oo][Rr][Dd]\"[ ]{0,10}:[ ]{0,10}\").+(?=\")", "$1***"));
//
//        _auditTable.setDataReq(_excludePass);
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
//    private String excludePass(String str) {
//        str = str.replaceAll("(\"confirmPassword\"(?>\\s+|):(?>\\s+|)(?=\")\")([^\"]+(?=\"))", "$1*****");
//        str = str.replaceAll("(\"newPassword\"(?>\\s+|):(?>\\s+|)(?=\")\")([^\"]+(?=\"))", "$1*****");
//        str = str.replaceAll("(\"oldPassword\"(?>\\s+|):(?>\\s+|)(?=\")\")([^\"]+(?=\"))", "$1*****");
//        str = str.replaceAll("(\"password\"(?>\\s+|):(?>\\s+|)(?=\")\")([^\"]+(?=\"))", "$1*****");
//        str = str.replaceAll("(\"pin\"(?>\\s+|):(?>\\s+|)(?=\")\")([^\"]+(?=\"))", "$1*****");
//        return str;
//    }
//
//    private final static class JsonControllerClass implements Serializable {
//        /**
//         *
//         */
//        private static final long serialVersionUID = 1L;
//        private TransactionTypeEnum tranType;
//        private Class<?> clazz;
//
//        private JsonControllerClass(TransactionTypeEnum tranType, Class<?> clazz) {
//            setTranType(tranType);
//            setClazz(clazz);
//        }
//
//        public TransactionTypeEnum getTranType() {
//            return tranType;
//        }
//
//        public void setTranType(TransactionTypeEnum tranType) {
//            this.tranType = tranType;
//        }
//
//        public Class<?> getClazz() {
//            return clazz;
//        }
//
//        public void setClazz(Class<?> clazz) {
//            this.clazz = clazz;
//        }
//
//        @Override
//        public int hashCode() {
//            final int prime = 31;
//            int result = 1;
//            result = prime * result + ((tranType == null) ? 0 : tranType.hashCode());
//            return result;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj)
//                return true;
//            if (obj == null)
//                return false;
//            if (getClass() != obj.getClass())
//                return false;
//            JsonControllerClass other = (JsonControllerClass) obj;
//            return tranType == other.tranType;
//        }
//
//
//    }
//
//}
