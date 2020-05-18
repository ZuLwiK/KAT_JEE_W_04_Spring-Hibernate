<%--
  Created by IntelliJ IDEA.
  User: micha
  Date: 09.05.2020
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All publishers</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<div>
    <div class="col-xs-12 col-sm-6 col-sm-offset-3">
        <table class="table table-bordered">
            <tr>
                <th colspan="6">Publishers</th>
            </tr>
            <tr>
                <th>Name: <c:out value="${book.title}"/></th>
                <th>Nip:</th>
                <th>Regon:</th>
                <th>Books:</th>
                <th colspan="2"><a href='/publisher/'>
                    <button>Add</button>
                </a></th>
            </tr>
            <c:forEach items="${publishers}" var="publisher">
                <tr>
                    <td><c:out value="${publisher.name}"/></td>
                    <td><c:out value="${publisher.nip}"/></td>
                    <td><c:out value="${publisher.regon}"/></td>
                    <td><c:out value="${publisher.books}"/></td>
                    <td><a href='/publisher/edit/${publisher.id}'>
                        <button>Edit</button>
                    </a></td>
                    <td>
                        <form action="/publisher/delete/${publisher.id}" method="post" th:object="${publisher}">
                            <input type="SUBMIT" value="Delete"
                                   onclick="return confirm('Are you sure you want delete this publisher?')"/></form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
