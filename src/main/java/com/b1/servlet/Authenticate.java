package com.b1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Authenticate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username == null || username.equals(""))
            out.println("Authentication Falied");

        if(username.equals("cdac") && password.equals("cdac@123")){
            out.println("Authentication Successful");
        }
        else{
            out.println("Authentication Failed");
        }
    }
}
