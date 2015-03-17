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
        <script src="<c:url value="/resources/js/Chart.js"/>"></script>
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
                            <spring:message code="text148" />
                        </h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <spring:message code="text149" />
                            </div>  
                            <div class="panel-body">
                                <div class="alert alert-warning">
                                    <spring:message code="text100" />
                                </div> 
                                <div id="message" class="alert alert-danger display-none"></div> 
                                <form id="updatePasswordForm" name="updatePasswordForm" action="">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="form-group">
                                                <label for="currentPassword">
                                                    <spring:message code="text268" />
                                                </label>
                                                <input id="currentPassword" name="currentPassword" type="password" class="form-control" required="required" placeholder="<spring:message code="text151" />" maxlength="8" tabindex="1" />
                                            </div>
                                        </div>
                                        <div class="col-lg-12">
                                            <div class="form-group">
                                                <label for="newPassword">
                                                    <spring:message code="text269" />
                                                </label>
                                                <input id="newPassword" name="newPassword" type="password" class="form-control" required="required" placeholder="<spring:message code="text152" />" maxlength="8" tabindex="2" />
                                            </div>
                                        </div>
                                        <div class="col-lg-12">
                                            <div class="form-group">
                                                <label for="newPassword2">
                                                    <spring:message code="text270" />
                                                </label>
                                                <input id="newPassword2" name="newPassword2" type="password" class="form-control" required="required" placeholder="<spring:message code="text153" />" maxlength="8" tabindex="3" />
                                            </div>
                                        </div>
                                        <div class="col-lg-12">
                                            <button type="reset" class="btn btn-default btn-block btn-xs">
                                                <spring:message code="text154"/>
                                            </button>
                                            <button id="updateButton" class="btn btn-block btn-lg btn-success" tabindex="4">
                                                <spring:message code="text150"/>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>                            
                        </div>                        
                    </div>
                </div>
            </div>
        </div><!-- /#wrapper -->
        <script src="scriptI18N.html" type="text/javascript"></script>            
        <jsp:include page="../application/scripts.jsp"/>        
    </body>
</html>