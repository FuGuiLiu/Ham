package com.sky.ham.interceptor;

import com.sky.ham.entity.TxUser;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TxUser user = (TxUser) request.getSession().getAttribute("txUser");
        if (user == null) {
            request.setAttribute("info", "first");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
}
