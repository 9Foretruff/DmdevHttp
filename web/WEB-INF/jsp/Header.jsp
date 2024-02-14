<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${ not empty sessionScope.user}">
    <div>
        <form method="post" action="${pageContext.request.contextPath}/logout">
            <button type="submit">Logout</button>
        </form>
    </div>
</c:if>