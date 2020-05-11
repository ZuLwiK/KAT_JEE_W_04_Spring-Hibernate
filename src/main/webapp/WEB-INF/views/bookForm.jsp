<%--
  Created by IntelliJ IDEA.
  User: micha
  Date: 09.05.2020
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>BookForm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<form:form method="POST" modelAttribute="book" class="col-xs-12 col-sm-6 col-sm-offset-3">
    <table>
        <tr>
            <td>Title</td>
            <td>Rating</td>
            <td>Description</td>
            <td>Publisher</td>
        </tr>
            <tr>
        <td><form:input path="title"/>
            <form:errors path="title"/></td>
        <td><form:input path="rating"/>
            <form:errors path="rating"/></td>
        <td><form:input path="description"/>
            <form:errors path="description"/></td>
        <td><form:select path="publisher" itemLabel="name" itemValue="id" items="${publishers}"/>
            <form:errors path="publisher"/></td>
        <td><input type="submit"></td></tr>
    </table>
</form:form>
</body>
</html>
