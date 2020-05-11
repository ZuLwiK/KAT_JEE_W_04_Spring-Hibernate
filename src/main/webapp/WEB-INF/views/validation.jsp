<%--
  Created by IntelliJ IDEA.
  User: micha
  Date: 10.05.2020
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Validation</title>
</head>
<body>
<table>
    <tbody>
    <c:forEach items="${validations}" var="validation">
        <tr>
            <td><c:out value="${validation.getPropertyPath()}"/> : </td>
            <td><c:out value="${validation.getMessage()}"/></td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>

