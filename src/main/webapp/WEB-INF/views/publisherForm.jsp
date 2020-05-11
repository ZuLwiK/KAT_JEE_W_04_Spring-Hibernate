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
    <title>PublisherForm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<form:form method="POST" modelAttribute="publisher">
    <form:input path="name"/>
    <form:errors path="name"/>
    <form:input path="nip"/>
    <form:errors path="nip"/>
    <form:input path="regon"/>
    <form:errors path="regon"/>
    <form:select path="books" itemLabel="title" itemValue="id" items="${books}"/>
    <form:errors path="books"/>
    <input type="submit">
</form:form>
</body>
</html>
