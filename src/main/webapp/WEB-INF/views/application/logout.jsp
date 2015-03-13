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
    </head>
    <body>
        <div id="wrapper">            
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            <spring:message code="text229" />
                        </h1>
                        <a class="btn btn-default" href="login.html">login</a>
                    </div>
                </div>
            </div>
        </div><!-- /#page-wrapper -->    
        <script src="scriptI18N.html" type="text/javascript"></script>
        <jsp:include page="../application/scripts.jsp"/>
    </body>
</html>