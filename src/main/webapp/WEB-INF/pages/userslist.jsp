<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Content List </title>
</head>
<body>
<div align="center">

    <div style="color: teal; font-size: 30px"> Content List</div>

    <c:if test="${!empty userList}">
        <table border="1" bgcolor="black" width="600px">
            <tr
                    style="background-color: teal; color: white; text-align: center;"
                    height="40px">

                <td>Title</td>
                <td>Content</td>

            </tr>
            <c:forEach items="${userList}" var="user">
                <tr
                        style="background-color: white; color: black; text-align: center;"
                        height="30px">

                    <td><c:out value="${user.name}" />
                    </td>
                    <td><c:out value="${user.password}" />
                    <td><a href="<c:url value='/edit/${user.id}' />" >Edit</a></td>
                    <td><a href="<c:url value='/remove/${user.id}' />" >Delete</a></td>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </c:if>


    <a href="/user/adduser">Click Here to add new User</a>
</div>
</body>
</html>