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
    <title>Edit/Add a proposition</title>
</head>
<body>
<form:form method="POST" modelAttribute="proposition">
    <form:input path="title"/>
    <form:errors path="title"/>
    <form:input path="rating"/>
    <form:errors path="rating"/>
    <form:input path="description"/>
    <form:errors path="description"/>
    <form:select path="publisher" itemLabel="name" itemValue="id" items="${publishers}"/>
    <form:errors path="publisher"/>
    <form:hidden path="proposition" value="true" />
    <input type="submit">
</form:form>
</body>
</html>
