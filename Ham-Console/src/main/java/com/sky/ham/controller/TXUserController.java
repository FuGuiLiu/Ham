package com.sky.ham.controller;

import com.sky.ham.entity.TxUser;
import com.sky.ham.service.TxUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/user")
public class TXUserController {
    @Resource
    private TxUserService txUserService;

    @RequestMapping(value = "/login")
    public void login(@ModelAttribute TxUser txUser, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        // TODO: 2020/9/24 校验用户登录
        TxUser user = txUser != null ? txUserService.queryLogin(txUser) : null;
        if (user != null) {
            session.setAttribute("txUser", user);
            request.getRequestDispatcher("../index.jsp").forward(request, response);
            return;
        }
        request.setAttribute("error", "discorrect email or password");
        request.getRequestDispatcher("../login.jsp").forward(request, response);
    }
}
