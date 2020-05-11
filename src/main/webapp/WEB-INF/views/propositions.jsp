<%--
  Created by IntelliJ IDEA.
  User: micha
  Date: 09.05.2020
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Books propositions</title>
</head>
<body>
<table>
    <tbody>
    <c:forEach items="${propositions}" var="proposition">
        <td>
        <td>Title: <c:out value="${proposition.title}"/>
            </a></td>
        <td>Rating: <c:out value="${proposition.rating}"/></td>
        <td>Description: <c:out value="${proposition.description}"/></td>
        <td>Publisher: <c:out value="${proposition.publisher.name}"/></td>
        <td>Authors: <c:out value="${proposition.authors}"/></td>
        <td><a href='/proposition/edit/${proposition.id}'><button>Edit</button></a><form action="/proposition/delete/${book.id}" method="post" th:object="${book}">
            <input type="SUBMIT" value="Delete" onclick="return confirm('Are you sure you want delete this book proposition?')"/></form>
        </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
