package com.bleizing.web.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author nuriman
 * austraramadhan
 */
public class VariableInjectorFilter implements Filter {

    /**
     *
     */
    public void destroy() {
    }

    /**
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        try {
            final HttpServletRequest _req = (HttpServletRequest) request;
            final HttpSession _session = _req.getSession();
            _req.setAttribute("ctxIP", _req.getLocalAddr());
            _req.setAttribute("ctx", _req.getContextPath());
            _req.setAttribute("ctxAssets", _req.getContextPath().concat("/assets"));
            _req.setAttribute("ctxJsModules", _req.getContextPath().concat("/scripts/jsmodules"));
            _req.setAttribute("reqTid", new Date().getTime());
//            final Object _userObj = _session.getAttribute(InfosysConstants.SESSION.SESSION_LOGIN_USER);
//            if (_userObj instanceof UserEntity) {
//                final UserEntity _user = (UserEntity) _userObj;
//                final StringBuilder _fullname = new StringBuilder();
//                _fullname.append(_user.getFullname());
//                if (null != _user.getFullname()) {
//                    _fullname.append(" [").append(_user.getFullname()).append(']');
//                }
//                _req.setAttribute("userName", _fullname.toString());
//            }
            chain.doFilter(request, response);
        } catch (final Throwable t) {
            t.printStackTrace(System.out);
        }
    }

    /**
     *
     * @param config
     * @throws ServletException
     */
    public void init(final FilterConfig config) throws ServletException {
    }

}
