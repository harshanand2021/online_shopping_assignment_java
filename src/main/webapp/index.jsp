<%--
  Created by IntelliJ IDEA.
  User: PGCP-AC
  Date: 6/8/2026
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        for(int iTmp=0; iTmp<100; iTmp++)
        {
    %>

    <font color="red"><h1><%=new java.util.Date()%></h1></font>

    <%
        }
    %>

</body>
</html>