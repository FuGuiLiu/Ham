package com.sky.ham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/menu")
public class ConsoleController {
    @RequestMapping("/chartReport")
    public String chart() {
        return "/chart";
    }

    @RequestMapping(value = "/calendar")
    public void goCalendar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/WEB-INF/page/fullCalendar.html").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
