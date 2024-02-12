<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@include file="Header.jsp" %>

<div>
    <span>Content привіт</span>
    <p>Size:${requestScope.flights.size()}</p>
    <p>Id:${requestScope.flights.get(0).id}</p>
    <p>Id 2:${requestScope.flights[1].id}</p>
    <p>Map:${sessionScope.flightsMap[1]}</p>
    <p>JSESSION:${cookie["JSESSIONID"].value}</p>
    <p>Header:${header["Cookie"]}</p>
    <p>Param id:${param.id}</p>
    <p>Param test:${param.test}</p>
    <p>Not Empty list:${not empty flights}</p>
    hello world my name is maks =  hello world 123999888 biba 3337
</div>

<%@include file="footer.jsp" %>

</body>
</html>