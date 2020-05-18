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
    <meta charset="UTF-8">
    <title>All authors</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<div>
    <div class="col-md-7 col-md-6 col-sm-offset-3">
        <table class="table table-bordered">
            <tr>
                <th colspan="7">Authors</th>
            </tr>
            <tr>
                <th>FirstName:</th>
                <th>LastName:</th>
                <th>YearOfBirth:</th>
                <th>Pesel:</th>
                <th>Email:</th>
                <th colspan="2"><a href='/author/'>
                    <button>Add</button>
                </a></th>
            </tr>
            <c:forEach items="${authors}" var="author">
                <tr>
                    <td><c:out value="${author.firstName}"/></td>
                    <td><c:out value="${author.lastName}"/></td>
                    <td><c:out value="${author.yearOfBirth}"/></td>
                    <td><c:out value="${author.pesel}"/></td>
                    <td><c:out value="${author.email}"/></td>
                    <td><a href='/author/edit/${author.id}'>
                        <button>Edit</button>
                    </a></td>
                    <td>
                        <form action="/author/delete/${author.id}" method="post" th:object="${author}">
                            <input type="SUBMIT" value="Delete"
                                   onclick="return confirm('Are you sure you want delete this author?')"/></form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
