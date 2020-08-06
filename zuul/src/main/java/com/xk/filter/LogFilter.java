package com.xk.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        // 获取请求上下文
        RequestContext context = RequestContext.getCurrentContext();
        // 获取到request
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();
        response.setCharacterEncoding("GBK");

        String user = request.getParameter("user");

        // 若请求中没有user请求参数，则无法通过过滤
        if(StringUtils.isEmpty(user)) {
            // 指定当前请求未通过zuul过滤，默认值为true
            System.out.println("user为空");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            try {
                response.getWriter().print("user为空");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }


        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String remoteAddr = request.getRemoteAddr();
        System.out.println("访问者IP："+remoteAddr+"访问地址:"+request.getRequestURI());
        return null;
    }
}
