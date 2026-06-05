package com.b1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Headers extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        Enumeration<String> headerNames = request.getHeaderNames();

        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>Name</th>");
        out.println("<th>Value</th>");
        out.println("</tr>");

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String value =  request.getHeader(headerName);

            out.println("<tr>");
            out.println("<td>" + headerName + "</td>");
            out.println("<td>" + value + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    }
}
