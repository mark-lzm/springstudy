<%--
  Created by IntelliJ IDEA.
  User: 22186
  Date: 2022/4/3
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
username:
#{username}
request:
<%= request.getParameter("username")%>
</body>
</html>
