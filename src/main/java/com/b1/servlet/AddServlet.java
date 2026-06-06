package com.b1.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet
public class AddServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();

        out.println("Session Created<br/>");
        out.println("Session ID : " + session.getId() + "<br/>");
        out.println("Session CT : " + new Date().getTime() + "<br/>");
        out.println("Session LT : " + new Date(session.getCreationTime()) + "<br/>");
        out.println("Session MIA : " +  new Date(session.getLastAccessedTime()) + "<br/>");
        out.println("Session New : " + session.isNew() + "<br/>");
        session.setAttribute("username", "jadoobhagat");
    }
}
