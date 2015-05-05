<%-- 
    Document   : index
    Created on : Oct 19, 2014, 6:12:09 PM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../application/noCache.jsp"/>
<div class="row">
    <div class="col-lg-12">        
        <div class="row">
            <form action="" role="form" method="post" id="updateEstablishmentForm" name="updateEstablishmentForm" data-toggle="validator">                
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
                                        <input name="name" id="establishment_name" value="${establishment.getName()}" class="form-control" placeholder="<spring:message code="text176"/>" type="text" required="required" tabindex="1"/>
                                    </div>                                            
                                </div>                                        
                                <div class="col-lg-6">
                                    <div class="form-group"> 
                                        <label><spring:message code="text172" /></label>
                                        <select id="category" name="category" class="form-control selectpicker" multiple tabindex="2">                                                    
                                            <c:forEach items="${categories}" var="c">
                                                <option <c:if test="${c.isSelected == true}">selected="selected"</c:if> value="${c.id}">${c.name}</option>
                                            </c:forEach>                                                    
                                        </select>
                                    </div> 
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label><spring:message code="text173"/></label>
                                        <input name="subcategory" id="subcategory" value="${establishment.getSubcategory()}" class="form-control" type="text" required="required" tabindex="3"/>
                                    </div>                                            
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group"> 
                                        <label><spring:message code="text200" /></label>
                                        <input name="address" id="address" value="${establishment.address.getAll()}" placeholder="<spring:message code="text79"/>" class="form-control" type="text" required="required" tabindex="4" />
                                    </div> 
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group"> 
                                        <label><spring:message code="text82" /></label>
                                        <input name="country" id="country" value="${establishment.address.getCountry()}" placeholder="<spring:message code="text83"/>" maxlength="25" class="form-control" type="text" required="required" tabindex="5" />
                                    </div> 
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group"> 
                                        <label><spring:message code="text121" /></label>
                                        <input name="state" id="state" value="${establishment.address.getState()}" placeholder="" class="form-control" maxlength="35" type="text" required="required" tabindex="6" />
                                    </div> 
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group"> 
                                        <label><spring:message code="text84" /></label>
                                        <input name="city" id="city" value="${establishment.address.getCity()}" placeholder="<spring:message code="text85"/>" maxlength="35" class="form-control" type="text" required="required" tabindex="7" />
                                    </div> 
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group"> 
                                        <label><spring:message code="text80" /></label>
                                        <input name="zipCode" id="zipCode" value="${establishment.address.getZipCode()}" placeholder="<spring:message code="text81"/>" min="1" max="99999999" class="form-control" type="number" required="required" tabindex="8" />
                                    </div> 
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group"> 
                                        <label><spring:message code="text320" /></label>
                                        <input name="latitude" id="latitude" value="${establishment.latitude}" class="form-control" type="number" tabindex="8" />
                                    </div> 
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group"> 
                                        <label><spring:message code="text321" /></label>
                                        <input name="longitude" id="longitude" value="${establishment.longitude}" class="form-control" type="number" tabindex="8" />
                                    </div> 
                                </div>
                            </div>                             
                            <button type="submit" id="saveButtonEstablishment" class="btn btn-block btn-success btn-lg" tabindex="23">
                                <spring:message code="text251" />                                
                            </button>     
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <spring:message code="text178"/>
                    </div>    
                    <div class="panel-body">
                        <form action="" method="post" id="updateResponsableForm" name="updateResponsableForm">                            
                            <div class="row">                                    
                                <div class="col-lg-6">
                                    <div class="form-group"> 
                                        <label><spring:message code="text181" /></label>
                                        <input name="responsable_name" id="responsable_name" value="${establishment.responsable.person.getName()}" placeholder="<spring:message code="text179" />" maxlength="60" class="form-control"  type="text" required="required" tabindex="9"/>
                                    </div> 
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group"> 
                                        <label><spring:message code="text182" /></label>
                                        <input name="responsable_lastName" id="responsable_lastName" value="${establishment.responsable.person.getLastName()}" maxlength="60" class="form-control" type="text" required="required" tabindex="10"/>
                                    </div> 
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group"> 
                                        <label><spring:message code="text183" /></label>
                                        <input name="responsable_phone" id="responsable_phone" value="${establishment.responsable.person.getPhone()}" placeholder="<spring:message code="text180"/>" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="11" />
                                    </div> 
                                </div>                                                                                                                                            
                                <div class="col-lg-6">
                                    <div class="form-group"> 
                                        <label><spring:message code="text184" /></label>
                                        <input name="responsable_email" id="responsable_email" value="${establishment.responsable.person.getEmail()}" placeholder="<spring:message code="text91" />" maxlength="50" class="form-control" type="email" required="required" tabindex="12" />
                                    </div> 
                                </div>                                  
                                <div class="col-lg-6">
                                    <div class="form-group"> 
                                        <label><spring:message code="text86" /></label>
                                        <select id="responsable_gender" name="responsable_gender" class="form-control" tabindex="15">
                                            <option value="1" <c:if test="${establishment.responsable.person.gender.getName() == 'male' }" > selected </c:if> > <spring:message code="text97" /></option>
                                            <option value="2" <c:if test="${establishment.responsable.person.gender.getName() == 'female' }" > selected </c:if> > <spring:message code="text98" /></option>
                                            </select>
                                        </div> 
                                    </div>
                                </div>                                
                                <button type="button" class="btn btn-block" data-toggle="modal" data-target="#DetailModalResponsablePassword">
                                <spring:message code="text348" />
                            </button>                    
                            <button type="submit" id="saveButtonResponsable" class="btn btn-block btn-success btn-lg" tabindex="23">
                                <spring:message code="text252" />
                            </button> 
                        </form>
                    </div>
                </div>
            </div>
        </div>            
    </div>    
</div>

<div class="row">
    <div class="col-lg-12">  
        <div class="panel panel-default">
            <div class="panel-heading">
                <spring:message code="text253"/>
            </div>
            <div class="panel-body">
                <c:choose>
                    <c:when test="${fn:length(establishment.getCashier()) <= 0}">
                        <spring:message code="text224"/>
                    </c:when>
                    <c:otherwise>
                        <table class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>                                        
                                        <spring:message code="text242" />
                                    </th>
                                    <th>                                        
                                        <spring:message code="text243" />
                                    </th>
                                    <th>                                        
                                        <spring:message code="text244" />
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="c" items="${establishment.getCashier()}">
                                    <tr>
                                        <td>
                                            ${c.person.getName()}
                                        </td>
                                        <td>
                                            ${c.person.getRegistrationDate()}
                                        </td>
                                        <td>                                            
                                            <button type="button" class="btn btn-primary" onclick="javascript:cashierUpdatePassword(${c.getId()})" data-toggle="modal" data-target="#updatePasswordCashierModal">                                                
                                                <spring:message code="text245" />
                                            </button>
                                            <button type="button" class="btn btn-primary" onclick="javascript:cashierDetails(${c.getId()})" data-toggle="modal" data-target="#DetailModal">                                                
                                                <spring:message code="text246" />
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <button type="button" class="btn btn-block btn-success btn-lg" onclick="createCashier(${establishment.getId()})" data-toggle="modal" data-target="#DetailModal">
                            <spring:message code="text254" /> 
                        </button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="DetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">                    
                    <spring:message code="text247" />
                </h4>
            </div>
            <div class="modal-body" id="outputDetail">

            </div>
            <div class="modal-footer">                
                <button type="button" class="btn btn-primary" data-dismiss="modal">                    
                    <spring:message code="text248" />
                </button>
            </div>
        </div>
    </div>                
</div>
<div class="modal fade" id="updatePasswordCashierModal" tabindex="-1" role="dialog" aria-labelledby="updatePasswordCashier" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">
                    <spring:message code="text249" />                    
                </h4>
            </div>
            <div class="modal-body" id="outputUpdatePassword">                
            </div>
            <div class="modal-footer">                
                <button type="button" class="btn btn-primary" data-dismiss="modal">
                    <spring:message code="text250" />                    
                </button>
            </div>
        </div>
    </div>                
</div>
<div class="modal fade" id="DetailModalResponsablePassword" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">                    
                    <spring:message code="text348" />
                </h4>
            </div>
            <div class="modal-body" id="outputDetail">
                <form id="updateResponsablePasswordForm" name="updateResponsablePasswordForm" method="post" action="">
                    <div class="form-group"> 
                        <label><spring:message code="text159" /></label>
                        <input name="password" id="password" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required"/>
                    </div> 
                    <div class="form-group"> 
                        <label><spring:message code="text160" /></label>
                        <input name="password2" id="password2" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required"/>
                    </div> 
                    <button class="btn btn-block btn-primary">
                        <spring:message code="text348" />
                    </button>
                </form>
            </div>
            <div class="modal-footer">                
                <button type="button" class="btn btn-primary" data-dismiss="modal">                    
                    <spring:message code="text248" />
                </button>
            </div>
        </div>
    </div>                
</div>
<script type="text/javascript">eval("${js}");</script>        
<!--<script>$(".selectpicker").selectpicker("refresh");</script>-->