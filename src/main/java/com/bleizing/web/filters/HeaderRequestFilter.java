package com.bleizing.web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hamdan
 */
public class HeaderRequestFilter implements Filter {

    /**
     *
     */
    public void destroy() {
    }

    /**
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
//        try {
//            final HttpServletRequest _req = (HttpServletRequest) request;
//            final HttpServletResponse _resp = (HttpServletResponse) response;
//            final String _headerAllowOrigin = _req.getHeader("Access-Control-Allow-Origin");
//            _resp.setHeader("Access-Control-Allow-Origin", "newmobile.bri.co.id");
//            if (null != _headerAllowOrigin && !"".equals(_headerAllowOrigin)) {
//                if (!_headerAllowOrigin.contains("newmobile.bri.co.id")) {
//                    _resp.setHeader("Connection", "close");
//                    throw new ProcessException(null, ErrorType.DOMAIN_NOT_ALLOWED);
//                }
//            }
//
//            String _headerHost = _req.getHeader("Host");
//            if (null != _headerHost && !"".equals(_headerHost)) {
//                if (_headerHost.contains(":")) {
//                    _headerHost = _headerHost.split(":")[0];
//                }
//                String[] listHost = BaseConfigParameter.getHostIpAddress().split(";");
//                if (!ArrayUtils.contains(listHost, _headerHost)) {
//                    _resp.setHeader("Connection", "close");
//                    throw new ProcessException(null, ErrorType.DOMAIN_NOT_ALLOWED);
//                }
//            }
//
//
//            chain.doFilter(request, response);
//        } catch (final Throwable t) {
//            t.printStackTrace(System.out);
//        }
    }

    /**
     * @param config
     * @throws ServletException
     */
    public void init(final FilterConfig config) throws ServletException {
    }

}
