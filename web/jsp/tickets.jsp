<%@ page import="com.foretruff.http.service.TicketService" %>
<%@ page import="com.foretruff.http.dto.TicketDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@include file="ticket" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello world!</h1>
<h1>Купленные билеты:</h1>
<ul>
    <%
        Long flightId = Long.valueOf(request.getParameter("flightId"));
        List<TicketDto> tickets = TicketService.getInstance().findAllByFlightId(flightId);
        for (TicketDto ticket : tickets) {
            out.write(String.format("<li>%s</li>", ticket.getSeatNo()));
        }
    %>
</ul>
<%---- скриплеты лучше не юзать!!!--%>
</body>
</html>

<%! public void jspInit() {
    System.out.println("Hello from jsp!!");
}
%>
