<%-- 
    Document   : oldBrowser
    Created on : Oct 23, 2014, 2:38:20 PM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>   
    <head>
        <jsp:include page="head.jsp" />
    </head>    
    <body>
        <h1><spring:message code="text16" /></h1>
        <spring:message code="text17" />
        <jsp:include page="scripts.jsp" />
    </body>
</html>