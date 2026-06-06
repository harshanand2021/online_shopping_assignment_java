package com.b1.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet
public class RetrvSession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        PrintWriter out = response.getWriter();
        if(session == null)
            out.println("No session found");
        else
        {
            out.println("Session ID : " + session.getId() + "</br>");
            out.println("Session CT : " + session.getCreationTime() + "</br>");
            out.println("Session Last Accessed : " + session.getLastAccessedTime() + "</br>");
            out.println("Session Max Inactive : " + session.getMaxInactiveInterval() + "</br>");
            out.println(session.getAttribute("username") + "</br>");
        }
    }
}
