package com.b1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;



public class Products extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc://mysql://localhost/ecommerce_project", "jadoo_bhagat", "cdac");
                 PreparedStatement psProducts = connection.prepareStatement("Select * From Products Where categoryId=?")) {
                String tmp = request.getParameter("categoryId");
                int categoryId = Integer.parseInt(tmp);

                psProducts.setInt(1, categoryId);

                try (ResultSet result = psProducts.executeQuery()) {
                    PrintWriter out = response.getWriter();
                    out.println("<html>");
                    out.println("<body>");
                    out.println("<table border='1'>");
                    out.println("<tr>");
                    out.println("<th>Name</th>");
                    out.println("<th>Description</th>");
                    out.println("<th>Price</th>");
                    out.println("<th>Image</th>");
                    out.println("</tr>");
                    while (result.next()) {
                        out.println("<tr>");
                        out.println("<td>" + result.getString("productName") + "</td>");
                        out.println("<td>" + result.getString("productDescription") + "</td>");
                        out.println("<td>" + result.getString("productPrice") + "</td>");
                        out.println("<td><img src='Images/" + result.getString("productImage") + "'height='80px' width='80px'/></td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
