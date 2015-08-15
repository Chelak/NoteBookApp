<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/5/2015
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<h1>${message}</h1>

<div align="center">
  <form action="adduser" method="post">
    <input type="text" name="name" placeholder="Name">
    <input type="text" name="password" placeholder="Password">
    <input type="submit" value="Add User">
  </form>
</div>
</body>
</html>