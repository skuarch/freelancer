<%-- 
    Document   : index
    Created on : Oct 19, 2014, 6:12:09 PM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../application/noCache.jsp"/>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="../application/head.jsp"/>                
        <link href="<c:url value="/resources/css/bootstrap-select.min.css" />" rel="stylesheet">        
    </head>
    <body>
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <jsp:include page="../application/topmenu.jsp" />
                <jsp:include page="../application/sidemenu.jsp" />
            </nav>
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            <spring:message code="text236" />
                        </h1>
                    </div>
                </div>                                
                <div id="output"></div>
            </div>
        </div><!-- /#page-wrapper --> 
        <script src="scriptI18N.html" type="text/javascript"></script>
        <jsp:include page="../application/scripts.jsp"/>        
        <script src="<c:url value="/resources/js/bootstrap-select.min.js"/>" type="text/javascript"></script>                                
        <script type="text/javascript">eval("${js}");</script>        
    </body>
</html>