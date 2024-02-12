<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<%@include file="ticket" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty requestScope.tickets}">
    <h1>Hello world!</h1>
    <h1>Купленные билеты:</h1>
    <ul>
        <c:forEach var="ticket" items="${requestScope.tickets}">
            <li>${fn:toLowerCase(ticket.seatNo)}</li>
        </c:forEach>
    </ul>
</c:if>
<%---- скриплеты лучше не юзать!!!--%>
</body>
</html>

<%--<%! public void jspInit() {--%>
<%--    System.out.println("Hello from jsp!!");--%>
<%--}--%>
<%--%>--%>
