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
<form:form method="POST" modelAttribute="book">
    <table>
        <tr><td colspan="3">====================================================<td></td></tr>
        <tr>
            <td>Title:</td>
            <td><form:input path="title"/>
                <form:errors path="title"/>
            </td>
            <td></td>
        </tr>
        <tr><td colspan="3">====================================================<td></td></tr>
        <tr>
            <td>Authors:</td>
            <td><form:select path="authors" itemLabel="authorName" itemValue="id" items="${authors}" multiple="true"/>
                <form:errors path="authors"/></td>
            <td><a href='/author/'>
                <button>Add</button>
            </a></td>
        </tr>
        <tr><td colspan="3">====================================================<td></td></tr>
        <tr>
            <td>Publisher:</td>
            <td><form:select path="publisher" itemLabel="name" itemValue="id" items="${publishers}" multiple="true"/>
                <form:errors path="publisher"/></td>
            <td></td>
        </tr>
        <tr><td colspan="3">====================================================<td></td></tr>
        <tr>
            <td>Description:</td>
            <td><form:textarea path="description" rows="3" cols="20"/>
                <form:errors path="description"/></td>
            <td></td>
        </tr>
        <tr><td colspan="3">====================================================<td></td></tr>
        <tr>
            <td>Rating:</td>
            <td><form:input path="rating"/>
                <form:errors path="rating"/></td>
            <td></td>
        </tr>
        <tr><td colspan="3">====================================================<td></td></tr>
        <tr>
            <td></td>
            <td><input type="button" value="Cancel"></td>
            <td><input type="submit" value="Ok"></td>
        </tr>

    </table>
</form:form>
</body>
</html>
