package com.b1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RetvCookie")
public class RetvCookie {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Cookie arrCookie[] = request.getCookies();

        if(arrCookie != null){
            for (Cookie objCookie : arrCookie) {
                out.println("Name : " + objCookie.getName() + "<br/>");
                out.println("Value : " + objCookie.getValue() + "<br/>");
                out.println("Max-Age: " + objCookie.getMaxAge() + "<br/>");
            }
        } else {
            out.println("cookie not found");
        }
    }
}
