<%-- 
    Document   : testNotification
    Created on : Oct 24, 2014, 10:45:52 AM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../application/head.jsp"/>
    </head>    
    <body>
        <h1>Test Notification</h1>
        <input id="text" type="text" value="hello !!!" />
        <input type="button" value="send notification" onclick="testNotification(document.getElementById('text').value);" />
        <jsp:include page="../application/scripts.jsp"/>
    </body>
</html>
