<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
    <label for="name">Name:
        <input type="text" name="name" id="name">
    </label><br>
    <label for="birthday">Birthday:
        <input type="date" name="birthday" id="birthday" required>
    </label><br>
    <label for="emailId">Email:
        <input type="email" name="email" id="emailId" required>
    </label><br>
    <label for="imageId">Image:
        <input type="file" name="image" id="imageId" required>
    </label><br>
    <label for="passwordId">Password:
        <input type="password" name="password" id="passwordId" required>
    </label><br>
    <label for="role">Role:
        <select name="role" id="role" required>
            <c:forEach var="role" items="${requestScope.roles}">
                <option value="${role}" name="role">${role}</option>
            </c:forEach>
        </select>
    </label>
    <br>
    <label>
        <c:forEach var="gender" items="${requestScope.genders}">
            <input type="radio" name="gender" value="${gender}"> ${gender}
            <br>
        </c:forEach>
    </label>
    <button type="submit">Send</button>

    <c:if test="${not empty requestScope.errors}">
        <div style="color: red">
            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span>
                <br>
            </c:forEach>
        </div>

    </c:if>

</form>


</body>
</html>
