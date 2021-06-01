<%--
  Created by IntelliJ IDEA.
  User: Jahir Hussain A
  Date: 31-05-2021
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="logic" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<table>
    <tr>
        <td> Name</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td> Alias</td>
        <td>${alias}</td>
    </tr>
    <tr>
        <td> E-Mail ID</td>
        <td>${email}</td>
    </tr>
    <tr>
        <td>Followers</td>
        <td>${followersCount}</td>
    </tr>
</table>
</body>
</html>
