package com.linewell.gg.interceptor;

import com.linewell.gg.dao.mapperwas.module.JsUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //判断是否获取江苏政务服务网
        HttpSession session = request.getSession();
        JsUser user = (JsUser)session.getAttribute("user");
        if(null != user){
            if (StringUtils.isEmpty(user.getIdcardNum())) {
                response.sendRedirect("http://sq.jszwfw.gov.cn/jsjis/front/login.do?appMark=jszwfw&gotoUrl=aHR0cDovL3NxLmpzendmdy5nb3YuY24v");
            }
            return true;
        }else{
            response.sendRedirect("http://sq.jszwfw.gov.cn/jsjis/front/login.do?appMark=jszwfw&gotoUrl=aHR0cDovL3NxLmpzendmdy5nb3YuY24v");
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        //System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        //System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
