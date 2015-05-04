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
                            <spring:message code="text279" />   
                        </h1>
                    </div>
                </div>                 
                <div class="row">
                    <div class="col-lg-12">
                        <form action="createNewCompanyProcess.html" method="post" id="createNewCompanyForm" name="createNewCompanyForm">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <spring:message code="text157" />
                                </div>
                                <div class="panel-body">

                                    <div id="companyDiv">
                                        <div class="alert alert-info">
                                            <spring:message code="text295"/> <strong><spring:message code="text296"/></strong>
                                        </div> 
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <div class="form-group"> 
                                                    <label><spring:message code="text297"/></label>
                                                    <input name="name" id="name" placeholder="<spring:message code="text75" />" maxlength="60" class="form-control" type="text" required="required" tabindex="1"/>
                                                </div> 
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group"> 
                                                    <label><spring:message code="text298"/></label>
                                                    <input name="brand" id="brand" placeholder="<spring:message code="text77"/>" maxlength="60" class="form-control" type="text" required="required" tabindex="2"/>
                                                </div> 
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group"> 
                                                    <label><spring:message code="text299"/></label>
                                                    <input name="contactName" id="contactName" maxlength="50" class="form-control" type="text" required="required" tabindex="3" />
                                                </div> 
                                            </div>    
                                            <div class="col-lg-6">
                                                <div class="form-group"> 
                                                    <label><spring:message code="text300"/></label>
                                                    <input name="contactLastName" id="contactLastName" maxlength="50" class="form-control" type="text" required="required" tabindex="4" />
                                                </div> 
                                            </div>    
                                            <div class="col-lg-6">
                                                <div class="form-group"> 
                                                    <label><spring:message code="text86" /></label>
                                                    <select id="contactGender" name="contactGender" class="form-control" tabindex="5">
                                                        <option value="1"><spring:message code="text97" /></option>
                                                        <option value="2"><spring:message code="text98" /></option>
                                                    </select>
                                                </div> 
                                            </div>                                                    
                                            <div class="col-lg-6">
                                                <div class="form-group"> 
                                                    <label><spring:message code="text301" /></label>
                                                    <input name="contactPhone" id="contactPhone" placeholder="<spring:message code="text89"/>" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="6" />
                                                </div> 
                                            </div>                                                    

                                            <div class="col-lg-6">
                                                <div class="form-group"> 
                                                    <label><spring:message code="text302" /></label>
                                                    <input name="contactEmail" id="contactEmail" maxlength="50" class="form-control" type="email" required="required" tabindex="7" />
                                                </div> 
                                            </div>  
                                            <div class="col-lg-6">
                                                <div class="form-group"> 
                                                    <label><spring:message code="text172" /></label>
                                                    <select id="category" name="category" class="form-control selectpicker" multiple="multiple" tabindex="8">
                                                        <c:forEach items="${categories}" var="c">
                                                            <option value="${c.id}">${c.name}</option>
                                                        </c:forEach>                                                    
                                                    </select>
                                                </div> 
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group"> 
                                                    <label><spring:message code="text159" /></label>
                                                    <input name="password" id="password" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" tabindex="9" />
                                                </div> 
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group"> 
                                                    <label><spring:message code="text160" /></label>
                                                    <input name="password2" id="password2" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" tabindex="10"/>
                                                </div> 
                                            </div>
                                            <div class="col-lg-12">
                                                <div class="form-group"> 
                                                    <label><spring:message code="text344"/> </label>
                                                    <input name="logo" id="logo" placeholder="" maxlength="55" class="form-control" type="file" tabindex="8" />
                                                </div> 
                                            </div>
                                            <div class="col-lg-12">
                                                <div class="form-group">
                                                    <label><spring:message code="text342" /></label>                                                
                                                    <textarea id="description" name="description" class="form-control" cols="1" rows="6" placeholder="<spring:message code="text343" />"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <spring:message code="text303" />
                                </div>
                                <div class="panel-body">
                                    <div class="alert alert-danger">
                                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                        <spring:message code="text304" />
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text305" /></label>
                                                <input name="taxContactName" id="taxContactName" maxlength="255" class="form-control" type="text" required="required" tabindex="11" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text306" /></label>
                                                <input name="taxContactLastName" id="taxContactLastName" maxlength="255" class="form-control" type="text" required="required" tabindex="12" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text307" /></label>
                                                <input name="taxContactEmail" id="taxContactEmail" placeholder="<spring:message code="text91" />" maxlength="55" class="form-control" type="email" required="required" tabindex="13" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text86" /></label>
                                                <select id="taxContactGender" name="taxContactGender" class="form-control" tabindex="14">
                                                    <option value="1"><spring:message code="text97" /></option>
                                                    <option value="2"><spring:message code="text98" /></option>
                                                </select>
                                            </div> 
                                        </div>                                                    
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text308" /></label>
                                                <input name="taxId" id="taxId" placeholder="<spring:message code="text316" />" maxlength="13" class="form-control" type="text" required="required" tabindex="15" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text309" /></label>
                                                <input name="taxCompanyName" id="taxCompanyName" maxlength="55" class="form-control" type="text" required="required" tabindex="16" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text310" /></label>
                                                <input name="taxContactPhone" id="taxContactPhone" placeholder="<spring:message code="text89"/>" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="17" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text161" /></label>
                                                <input name="address" id="address" placeholder="<spring:message code="text79"/>" maxlength="512" class="form-control" type="text" required="required" tabindex="18" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text82" /></label>
                                                <input name="country" id="country" placeholder="<spring:message code="text83"/>" maxlength="35" class="form-control" type="text" required="required" tabindex="19" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text121" /></label>
                                                <input name="state" id="state" placeholder="" class="form-control" maxlength="55" type="text" required="required" tabindex="20" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text84" /></label>
                                                <input name="city" id="city" placeholder="<spring:message code="text85"/>" maxlength="55" class="form-control" type="text" required="required" tabindex="21" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text80" /></label>
                                                <input name="zipCode" id="zipCode" placeholder="<spring:message code="text81"/>" min="1" max="99999999" class="form-control" type="number" required="required" tabindex="22" />
                                            </div> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <spring:message code="text311" />
                                </div>
                                <div class="panel-body">
                                    <div class="alert alert-danger">
                                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                        <spring:message code="text304" />
                                    </div> 
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text312" /></label>
                                                <input name="ownerAccountBank" id="ownerAccountBank" maxlength="255" class="form-control" type="text" required="required" tabindex="23" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text313" /></label>
                                                <input name="bank" id="bank" maxlength="55" class="form-control" type="text" required="required" tabindex="24" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text314" /></label>
                                                <input name="clabe" id="clabe" maxlength="25" class="form-control" type="text" required="required" tabindex="25" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text315" /></label>
                                                <input name="emailNotifications" id="emailNotifications"  class="form-control" maxlength="35" type="email" required="required" tabindex="26" />
                                            </div> 
                                        </div>                                                                
                                    </div>
                                </div>
                            </div>
                            <button id="saveButton" type="submit" class="btn btn-block btn-lg btn-success" tabindex="27">
                                <spring:message code="text317" />
                            </button>
                            <br/>
                            <br/>
                        </form>
                    </div>
                </div>
            </div>        
        </div><!-- /#wrapper -->            
        <script src="scriptI18N.html" type="text/javascript"></script>
        <jsp:include page="../application/scripts.jsp"/><script src="<c:url value="/resources/js/bootstrap-select.min.js"/>" type="text/javascript"></script>                                
        <script type="text/javascript">eval("${js}");</script>        
        <script>$(".selectpicker").selectpicker();</script>        
    </body>
</html>