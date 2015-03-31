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
            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <jsp:include page="../application/topmenu.jsp" />
                <jsp:include page="../application/sidemenu.jsp" />
            </nav>
            <div id="page-wrapper">
                <br/>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <spring:message code="text73" />
                            </div>
                            <div class="panel-body">
                                <div id="message" class="alert alert-warning">
                                    <spring:message code="text100" />
                                </div> 
                                <div id="message" class="alert alert-danger display-none"></div> 
                                <form action="updateProfile.html" role="form" method="post" id="profileFreelancerForm" name="profileFreelancerForm">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text90" /></label>
                                                <input name="email" id="email" value="${freelancerBasic.email}" placeholder="<spring:message code="text91" />" maxlength="50" class="form-control" type="email" required="required" tabindex="1" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text74" /></label>
                                                <input name="name" id="name" value="${freelancerBasic.name}" placeholder="<spring:message code="text75" />" maxlength="60" class="form-control" type="text" required="required" tabindex="2"/>
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text76" /></label>
                                                <input name="lastName" id="lastName" value="${freelancerBasic.lastName}" placeholder="<spring:message code="text77"/>" maxlength="60" class="form-control" type="text" required="required" tabindex="3"/>
                                            </div> 
                                        </div>                                        
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text78" /></label>
                                                <input name="address" id="address" value="${freelancerBasic.addressAll}" placeholder="<spring:message code="text79"/>" class="form-control" type="text" required="required" tabindex="6" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text82" /></label>
                                                <input name="country" id="country" value="${freelancerBasic.country}" placeholder="<spring:message code="text83"/>" maxlength="25" class="form-control" type="text" required="required" tabindex="7" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text121" /></label>
                                                <input name="state" id="state" placeholder="" value="${freelancerBasic.state}" class="form-control" maxlength="35" type="text" required="required" tabindex="8" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text84" /></label>
                                                <input name="city" id="city" value="${freelancerBasic.city}" placeholder="<spring:message code="text85"/>" maxlength="35" class="form-control" type="text" required="required" tabindex="9" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text80" /></label>
                                                <input name="zipCode" id="zipCode" value="${freelancerBasic.zipCode}" placeholder="<spring:message code="text81"/>" min="1" max="99999999" class="form-control" type="number" required="required" tabindex="10" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group">                                                 
                                                <label><spring:message code="text86" /></label>
                                                <select id="gender" name="gender" class="form-control" tabindex="11">                                                                                                        
                                                    <option value="1" ${freelancerBasic.gender == "1" ? "selected='selected'": ""}><spring:message code="text97" /></option>
                                                    <option value="2" ${freelancerBasic.gender == "2" ? "selected='selected'": ""}><spring:message code="text98" /></option>
                                                </select>
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text88" /></label>
                                                <input name="phone" id="phone" value="${freelancerBasic.phone}" placeholder="<spring:message code="text89"/>" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="12" />
                                            </div> 
                                        </div>                                                                                                            
                                        <div class="col-lg-12">
                                            <button id="saveButton" class="btn btn-block btn-lg btn-success">
                                                <spring:message code="text143"/>
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
        <script type="text/javascript">eval("${js}");</script>        
    </body>
</html>