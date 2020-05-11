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
    <title>AuthorForm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<form:form method="POST" modelAttribute="author" class="col-xs-12 col-sm-6 col-sm-offset-3">
    <table>
        <tr>
            <td>FirstName</td>
            <td>LastName</td>
            <td>YearOfBirth</td>
            <td>Pesel</td>
            <td>Email</td>
            <td></td>
        </tr>
        <tr>
    <td><form:input path="firstName"/>
        <form:errors path="firstName"/></td>
    <td><form:input path="lastName"/>
        <form:errors path="lastName"/></td>
    <td><form:input path="yearOfBirth"/>
        <form:errors path="yearOfBirth"/></td>
    <td><form:input path="pesel"/>
        <form:errors path="pesel"/></td>
    <td><form:input path="email"/>
        <form:errors path="email"/></td>
<%--    <form:select path="authors" itemLabel="name" itemValue="id" items="${publishers}"/>--%>
<%--    <form:errors path="publisher"/>--%>
    <td><input type="submit"></td>
    </table>
</form:form>
</body>
</html>
