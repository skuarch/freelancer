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
                            <spring:message code="text167" />
                        </h1>
                    </div>
                </div>
                <form action="" role="form" method="post" id="createEstablishmentForm" name="createEstablishmentForm" data-toggle="validator">
                    <input type="hidden" name="id" id="id" value="${id}"/>
                    <input type="hidden" name="type" id="type" value="${type}"/>
                    <div class="row">
                        <div class="col-lg-12">
                            <div id="message" class="alert alert-warning">
                                <spring:message code="text100" />
                            </div>                          
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <spring:message code="text175"/>
                                </div>    
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="form-group">
                                                <label><spring:message code="text170"/></label>
                                                <input name="establishment_name" id="establishment_name" class="form-control" placeholder="<spring:message code="text176"/>" type="text" required="required" tabindex="1"/>
                                            </div>                                            
                                        </div>                                        
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text172" /></label>
                                                <select id="category" name="category" class="form-control selectpicker" multiple tabindex="2">                                                    
                                                    <c:forEach items="${categories}" var="c">
                                                        <option value="${c.id}">${c.name}</option>
                                                    </c:forEach>                                                    
                                                </select>
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group">
                                                <label><spring:message code="text173"/></label>
                                                <input name="subcategory" id="subcategory" class="form-control" type="text" required="required" tabindex="3"/>
                                            </div>                                            
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text200" /></label>
                                                <input name="establishment_address" id="establishment_address" placeholder="<spring:message code="text79"/>" class="form-control" type="text" required="required" tabindex="4" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text82" /></label>
                                                <input name="country" id="country" placeholder="<spring:message code="text83"/>" maxlength="25" class="form-control" type="text" required="required" tabindex="5" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text121" /></label>
                                                <input name="state" id="state" placeholder="" class="form-control" maxlength="35" type="text" required="required" tabindex="6" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text84" /></label>
                                                <input name="city" id="city" placeholder="<spring:message code="text85"/>" maxlength="35" class="form-control" type="text" required="required" tabindex="7" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text80" /></label>
                                                <input name="zipCode" id="zipCode" placeholder="<spring:message code="text81"/>" min="1" max="99999999" class="form-control" type="number" required="required" tabindex="8" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label>Latitude</label>
                                                <input name="latitude" id="latitude" class="form-control" type="number" tabindex="8" />
                                            </div> 
                                        </div>
                                            <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label>Longitude</label>
                                                <input name="longitude" id="longitude" class="form-control" type="number" tabindex="8" />
                                            </div> 
                                        </div>
                                    </div>                                
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-success">
                                <div class="panel-heading">
                                    <spring:message code="text178"/>
                                </div>    
                                <div class="panel-body">
                                    <div class="row">                                    
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text181" /></label>
                                                <input name="responsable_name" id="responsable_name" placeholder="<spring:message code="text179" />" maxlength="60" class="form-control"  type="text" required="required" tabindex="9"/>
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text182" /></label>
                                                <input name="responsable_lastName" id="responsable_lastName" maxlength="60" class="form-control" type="text" required="required" tabindex="10"/>
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text183" /></label>
                                                <input name="responsable_phone" id="responsable_phone" placeholder="<spring:message code="text180"/>" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="11" />
                                            </div> 
                                        </div>                                                                                                                                            
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text184" /></label>
                                                <input name="responsable_email" id="responsable_email" placeholder="<spring:message code="text91" />" maxlength="50" class="form-control" type="email" required="required" tabindex="12" />
                                            </div> 
                                        </div>  
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text185" /></label>
                                                <input name="responsable_password" id="responsable_password" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" tabindex="13" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text186" /></label>
                                                <input name="responsable_password2" id="responsable_password2" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" tabindex="14"/>
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text86" /></label>
                                                <select id="responsable_gender" name="responsable_gender" class="form-control" tabindex="15">
                                                    <option value="1"><spring:message code="text97" /></option>
                                                    <option value="2"><spring:message code="text98" /></option>
                                                </select>
                                            </div> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-warning">
                                <div class="panel-heading">
                                    <spring:message code="text187" />
                                </div>    
                                <div class="panel-body">
                                    <div class="row">                                    
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text188" /></label>
                                                <input name="cashier_name" id="cashier_name" placeholder="<spring:message code="text189" />" maxlength="60" class="form-control" type="text" required="required" tabindex="16"/>
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text190" /></label>
                                                <input name="cashier_lastName" id="cashier_lastName" placeholder="<spring:message code="text77"/>" maxlength="60" class="form-control" type="text" required="required" tabindex="17"/>
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text191" /></label>
                                                <input name="cashier_phone" id="cashier_phone" placeholder="<spring:message code="text89"/>" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="18" />
                                            </div> 
                                        </div>                                                                                                                                            
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text192" /></label>
                                                <input name="cashier_email" id="cashier_email" maxlength="50" class="form-control" type="email" required="required" tabindex="19" />
                                            </div> 
                                        </div> 
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text202" /></label>
                                                <input name="cashier_password" id="cashier_password" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" tabindex="20" />
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text186" /></label>
                                                <input name="cashier_password2" id="cashier_password2" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" tabindex="21"/>
                                            </div> 
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="form-group"> 
                                                <label><spring:message code="text86" /></label>
                                                <select id="cashier_gender" name="cashier_gender" class="form-control" tabindex="22">
                                                    <option value="1"><spring:message code="text97" /></option>
                                                    <option value="2"><spring:message code="text98" /></option>
                                                </select>
                                            </div> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button type="submit" id="saveButton" class="btn btn-block btn-success btn-lg" tabindex="23">
                        create establishment
                    </button>
                    <br><br>
                </form>
            </div>
        </div><!-- /#page-wrapper -->            
        <script src="scriptI18N.html" type="text/javascript"></script>
        <jsp:include page="../application/scripts.jsp"/>  
        <script src="<c:url value="/resources/js/bootstrap-select.min.js"/>" type="text/javascript"></script>            
        <script>$(".selectpicker").selectpicker();</script>
        <script type="text/javascript">eval("${js}");</script>        
    </body>
</html>