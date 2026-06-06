package com.b1.servlet;


import com.b1.dao.CategoryDAO;
import com.b1.dao.CategoryDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet
public class Category extends HttpServlet {
    private static final long serialVersionUID = 1L;

    CategoryDAO categoryDAO;

    @Override
    public void init(ServletConfig config)throws ServletException {
        super.init(config);
        try {
            categoryDAO = new CategoryDAOImpl(getServletContext());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {
        categoryDAO.close();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if(session==null){
            response.sendRedirect("login.html");
        }
    }
}
