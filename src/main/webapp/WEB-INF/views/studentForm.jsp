<%--
  Created by IntelliJ IDEA.
  User: micha
  Date: 09.05.2020
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>StudentForm</title>
</head>
<body>
<form:form method="post"
           modelAttribute="student">
    FirstName: <form:input path="firstName"/><br>
    LastName: <form:input path="lastName"/><br>
    Gender:
    Male: <form:radiobutton path="gender" value="M"/>
    Female: <form:radiobutton path="gender" value="F"/><br>
    Country: <form:select path="country" items="${countries}"/><br>
    Notes: <form:textarea path="notes" rows="3"
                          cols="20"/><br>
    Recieve mails: <form:checkbox path="mailingList"/><br>
    ProgrammingSkills:
    <form:select path="programmingSkills" items="${programmingSkills}" multiple="true">
        <form:option value="-" label="--Please Select--"/>
        <form:options items="${programmingSkills}"/>
    </form:select>
    Hobbies:<form:checkboxes items="${hobbies}" path="hobbies"/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
