<%--
  Created by IntelliJ IDEA.
  User: PGCP-AC
  Date: 6/8/2026
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<head>
    <title>Table</title>
</head>
<body>

    <table border="1">
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Image</th>
        </tr>

        <%
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "cdac");
            PreparedStatement psCategory = connection.prepareStatement("select * from category");
                ResultSet result = psCategory.executeQuery();)
            {
                while(result.next())
                {
        %>
            <tr>
                <td><%=result.getString(2)%></td>
                <td><%=result.getString(3)%></td>
                <td><%=result.getString(4)%></td>
            </tr>
        <%
            }
            }
        %>
    </table>

</body>
</html>
