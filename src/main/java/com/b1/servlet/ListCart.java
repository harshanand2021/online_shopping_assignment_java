package com.b1.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/ListCart")
public class ListCart extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        HttpSession session = request.getSession(false);

        if(session == null)
        {
            response.sendRedirect("login.html");
            return;
        }

        ArrayList<Products> objCart = (ArrayList<Products>)session.getAttribute("cart");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("Welcome" + session.getAttribute("username") + "</br>");
        out.println("<a href='Logout'>Logout</a>");

        if(objCart==null)
            out.println("Cart is empty");

        else
        {
            out.println("<table border='1'>");
            double total=0.0;
            for(Products objProd : objCart)
            {
                out.println("<tr>");
                out.println("<td>" + objProd.getCategoryId() + "</td>");
                out.println("<td>" + objProd.getProductId() + "</td>");
                out.println("<td>" + objProd.getPrice() + "</td>");
                out.println("</tr>");
                total += objProd.getPrice();
            }
            out.println("</total>");
            out.println("<h3>Total : " + total + "</h3><br/>");
            out.println("<a href='Category'>Continue Shopping</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
