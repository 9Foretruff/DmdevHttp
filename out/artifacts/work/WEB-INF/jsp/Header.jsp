<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>

    <c:if test="${ not empty sessionScope.user}">
        <div id="logout">
            <form method="post" action="${pageContext.request.contextPath}/logout">
                <button type="submit">Logout</button>
            </form>
        </div>
    </c:if>

    <div id="locale">
        <form action="${pageContext.request.contextPath}/locale" method="post">
            <button type="submit" name="language" value="uk_UA">UA</button>
            <button type="submit" name="language" value="en_US">EN</button>
            <button type="submit" name="language" value="de_LU">DE</button>
        </form>
    </div>
    <fmt:setLocale value="${sessionScope.language != null ? sessionScope.language : (param.language != null ?  param.language : 'en_US')}"/>
    <fmt:setBundle basename="translation"/>
</div>