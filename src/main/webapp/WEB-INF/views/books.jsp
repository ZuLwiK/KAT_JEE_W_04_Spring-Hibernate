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
    <title>All books</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<div>
    <div class="col-md-7 col-md-6 col-sm-offset-3">
        <table class="table table-bordered">
            <tr>
                <td colspan="7">Books</td>
            </tr>
            <tr>
                <th>Title: <c:out value="${book.title}"/></th>
                <th>Rating:</th>
                <th>Description:</th>
                <th>Publisher:</th>
                <th>Authors:</th>
                <th colspan="2"><a href='/bookForm'>
                    <button>Add</button>
                </a></th>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td><c:out value="${book.title}"/></td>
                    <td><c:out value="${book.rating}"/></td>
                    <td><c:out value="${book.description}"/></td>
                    <td><c:out value="${book.publisher.name}"/></td>
                    <td><c:out value="${book.authors}"/></td>
                    <td><a href='/book/edit/${book.id}'>
                        <button class="bullet-button">Edit</button>
                    </a></td>
                    <td>
                        <form action="/book/delete/${book.id}" method="post" th:object="${book}">
                            <input type="SUBMIT" value="Delete"
                                   onclick="return confirm('Are you sure you want delete this book?')" class="decrement-arrow-button"/></form>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
</body>
</html>
