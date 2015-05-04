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
            <form action="createNewAffiliate.html" role="form" method="post" id="createNewAffiliate" name="createNewAffiliate">
                <input type="hidden" name="affiliateType" id="affiliateType" value="1">
                <div id="page-wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">                                
                                <spring:message code="text156" />                                   
                            </h1>
                        </div>
                    </div>  
                    <div class="row">
                        <div class="col-lg-12">
                            <div id="message" class="alert alert-warning">
                                <spring:message code="text100" />                            
                            </div> 
                            <div class="panel panel-default">
                                <div class="panel-heading">                                    
                                    <spring:message code="text322"/>                
                                </div>
                                <div class="panel-body">                                                                                                             

                                    <div class="alert alert-success">
                                        <spring:message code="text322"/> 
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text158" /></label>
                                                <input name="name" id="name" placeholder="<spring:message code="text75" />" maxlength="60" class="form-control" type="text" required="required" tabindex="1"/>
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text76" /></label>
                                                <input name="lastName" id="lastName" placeholder="<spring:message code="text77"/>" maxlength="60" class="form-control" type="text" required="required" tabindex="2"/>
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text90" /></label>
                                                <input name="email" id="email" placeholder="<spring:message code="text91" />" maxlength="55" class="form-control" type="email" required="required" tabindex="3" />
                                            </div> 
                                        </div>  
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text162" /></label>
                                                <input name="phone" id="phone" placeholder="<spring:message code="text89"/>" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="4" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text159" /></label>
                                                <input name="password" id="password" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" tabindex="5" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text160" /></label>
                                                <input name="password2" id="password2" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" tabindex="6"/>
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text86" /></label>
                                                <select id="gender" name="gender" class="form-control" tabindex="7">
                                                    <option value="1"><spring:message code="text97" /></option>
                                                    <option value="2"><spring:message code="text98" /></option>
                                                </select>
                                            </div> 
                                        </div>                                                    
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text324"/> </label>
                                                <input name="brand" id="brand" placeholder="la marca puede ser el nombre comercial" maxlength="55" class="form-control" type="text" required="required" tabindex="8" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text172" /></label>
                                                <select id="category" name="category" class="form-control selectpicker" multiple tabindex="9">                                                    
                                                    <c:forEach items="${categories}" var="c">
                                                        <option value="${c.id}">${c.name}</option>
                                                    </c:forEach>                                                    
                                                </select>
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
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

                                </div><!-- end panel-body -->
                            </div> 

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <spring:message code="text326"/>
                                </div>
                                <div class="panel-body">
                                    <div class="alert alert-danger">
                                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                        <spring:message code="text327"/>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text328"/></label>
                                                <input name="taxContactName" id="taxContactName" placeholder="<spring:message code="text85"/>" maxlength="255" class="form-control" type="text" required="required" tabindex="10" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text329"/></label>
                                                <input name="taxContactLastName" id="taxContactLastName" placeholder="<spring:message code="text85"/>" maxlength="255" class="form-control" type="text" required="required" tabindex="11" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text330"/></label>
                                                <input name="taxContactEmail" id="taxContactEmail" placeholder="<spring:message code="text91" />" maxlength="55" class="form-control" type="email" required="required" tabindex="12" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text86" /></label>
                                                <select id="taxContactGender" name="taxContactGender" class="form-control" tabindex="13">
                                                    <option value="1"><spring:message code="text97" /></option>
                                                    <option value="2"><spring:message code="text98" /></option>
                                                </select>
                                            </div> 
                                        </div>                                                    
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text331"/></label>
                                                <input name="taxId" id="taxId" placeholder="RFC" maxlength="13" class="form-control" type="text" required="required" tabindex="14" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text332"/></label>
                                                <input name="taxCompanyName" id="taxCompanyName" placeholder="<spring:message code="text79"/>" maxlength="55" class="form-control" type="text" required="required" tabindex="15" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text333"/></label>
                                                <input name="taxContactPhone" id="taxContactPhone" placeholder="<spring:message code="text89"/>" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="16" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text161" /></label>
                                                <input name="address" id="address" placeholder="<spring:message code="text79"/>" maxlength="512" class="form-control" type="text" required="required" tabindex="17" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text82" /></label>
                                                <input name="country" id="country" placeholder="<spring:message code="text83"/>" maxlength="35" class="form-control" type="text" required="required" tabindex="18" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text121" /></label>
                                                <input name="state" id="state" placeholder="" class="form-control" maxlength="55" type="text" required="required" tabindex="19" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text84" /></label>
                                                <input name="city" id="city" placeholder="<spring:message code="text85"/>" maxlength="55" class="form-control" type="text" required="required" tabindex="20" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text80" /></label>
                                                <input name="zipCode" id="zipCode" placeholder="<spring:message code="text81"/>" min="1" max="99999999" class="form-control" type="number" required="required" tabindex="21" />
                                            </div> 
                                        </div>                                        
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <spring:message code="text335"/>
                                </div>
                                <div class="panel-body">
                                    <div class="alert alert-danger">
                                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                        <spring:message code="text327"/>
                                    </div> 
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text336"/></label>
                                                <input name="ownerAccountBank" id="ownerAccountBank" placeholder="<spring:message code="text79"/>" maxlength="255" class="form-control" type="text" required="required" tabindex="22" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text337"/></label>
                                                <input name="bank" id="bank" placeholder="<spring:message code="text79"/>" maxlength="55" class="form-control" type="text" required="required" tabindex="23" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text338"/></label>
                                                <input name="clabe" id="clabe" placeholder="<spring:message code="text83"/>" maxlength="25" class="form-control" type="text" required="required" tabindex="24" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text339"/></label>
                                                <input name="emailNotifications" id="emailNotifications" placeholder="" class="form-control" maxlength="35" type="email" required="required" tabindex="25" />
                                            </div> 
                                        </div>                                                                
                                    </div>
                                </div>
                            </div>
                            <button id="saveButton" type="submit" class="btn btn-block btn-lg btn-success" tabindex="26">
                                <spring:message code="text156"/>
                            </button>
                            <br/>
                            <br/>
                        </div>
                    </div>       
                </div><!-- /#wrapper -->  
            </form>
        </div>
        <script src="scriptI18N.html" type="text/javascript"></script>
        <jsp:include page="../application/scripts.jsp"/>        
        <script src="<c:url value="/resources/js/bootstrap-select.min.js"/>" type="text/javascript"></script>                                
        <script type="text/javascript">eval("${js}");</script>        
        <script>$(".selectpicker").selectpicker();</script>
    </body>
</html>