<%-- 
    Document   : createNewProduct
    Created on : Nov 12, 2014, 9:39:31 AM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="../application/head.jsp"/>   
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/datatables.boostrap.css" />"/>                
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
                            <spring:message code="text43" />
                        </h1>
                    </div>                    
                </div>                
                <div id="output"></div>
            </div>
            <div class="modal fade" id="productDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">
                                Product Details
                            </h4>
                        </div>
                        <div class="modal-body" id="outputProducModalDetail">
                            
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>                            
                        </div>
                    </div>
                </div>                
            </div>
            <script src="scriptI18N.html" type="text/javascript"></script>
            <jsp:include page="../application/scripts.jsp"/>        
            <script type="text/javascript">eval("${js}");</script>
            <script type="text/javascript" charset="utf8" src="<c:url value="/resources/js/jquery.dataTables.js"/>"></script>            
            <script type="text/javascript" charset="utf8" src="<c:url value="/resources/js/dataTables.boostrap.js"/>"></script>                                             
    </body>
</html>