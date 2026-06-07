package com.b1.entity;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Category")
public class Category extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_project","root","cdac");
                PreparedStatement psAllCategories = connection.prepareStatement("Select * From Category")){
                try(ResultSet result = psAllCategories.executeQuery()){
                    PrintWriter out = response.getWriter();
                    out.println("<html>");
                    out.println("<body>");
                    out.println("<table border='1'>");
                    out.println("<tr>");
                    out.println("<th>Name</th>");
                    out.println("<th>Description</th>");
                    out.println("<th>Image</th>");
                    out.println("</tr>");

                    while(result.next()){
                        out.println("<tr>");
                        out.println("<td><a href='Products?CategoryId=" + result.getInt("categoryId")
                        + "'>" + result.getString("categoryName") + "</a></td>" + "<td>"+
                                result.getString("categoryDescription") + "</td>"
                                );
                        out.println("<td><img src=Images/" + result.getString("categoryImageUrl") + "' height='80px' width='80px'/></td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    out.println("</body>");
                    out.println("</html>");
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }  catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
