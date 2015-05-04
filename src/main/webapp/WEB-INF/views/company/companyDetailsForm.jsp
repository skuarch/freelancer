<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../application/noCache.jsp"/>

<div class="panel panel-default">
    <div class="panel-heading">
        <spring:message code="text157" />
    </div>
    <div class="panel-body"> 
        <form action="someWhere" name="updateCompanyBasicInformationForm" id="updateCompanyBasicInformationForm" method="post">
            <div class="alert alert-info">
                <spring:message code="text295"/> <strong><spring:message code="text296"/></strong>
            </div> 
            <div class="row">
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text297"/></label>
                        <input name="name" id="name" placeholder="<spring:message code="text75" />" maxlength="60" value="${company.getName()}" class="form-control" type="text" required="required" tabindex="1"/>
                    </div> 
                </div>
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text298"/></label>
                        <input name="brand" id="brand" placeholder="<spring:message code="text77"/>" maxlength="60" value="${company.getBrand()}" class="form-control" type="text" required="required" tabindex="2"/>
                    </div> 
                </div>
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text299"/></label>
                        <input name="contactName" id="contactName" maxlength="50" value="${company.person.getName()}" class="form-control" type="text" required="required" tabindex="3" />
                    </div> 
                </div>    
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text300"/></label>
                        <input name="contactLastName" id="contactLastName" maxlength="50" value="${company.person.getLastName()}" class="form-control" type="text" required="required" tabindex="4" />
                    </div> 
                </div>    
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text86" /></label>
                        <select id="contactGender" name="contactGender" class="form-control" tabindex="5">
                            <option value="1" <c:if test="${company.person.gender.getName() == 'male' }" > selected </c:if> ><spring:message code="text97" /></option>
                            <option value="2" <c:if test="${company.person.gender.getName() == 'female' }" > selected </c:if> ><spring:message code="text98" /></option>
                            </select>
                        </div> 
                    </div>                                                    
                    <div class="col-lg-6">
                        <div class="form-group"> 
                            <label><spring:message code="text301" /></label>
                        <input name="contactPhone" id="contactPhone" placeholder="<spring:message code="text89"/>" value="${company.person.getPhone()}" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="6" />
                    </div> 
                </div>                                                    

                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text302" /></label>
                        <input name="contactEmail" id="contactEmail" value="${company.person.getEmail()}" maxlength="50" class="form-control" type="email" required="required" tabindex="7" />
                    </div> 
                </div>  
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text172" /></label>
                        <select id="category" name="category" class="form-control selectpicker" multiple="multiple" tabindex="8">
                            <c:forEach items="${categories}" var="c">
                                <option <c:if test="${c.isSelected == true}">selected="selected"</c:if> value="${c.id}">${c.name}</option>
                            </c:forEach>                                                    
                        </select>
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
                        <textarea id="description" name="description" class="form-control" cols="1" rows="6" placeholder="<spring:message code="text343" />">${company.description}</textarea>
                    </div>
                </div>
            </div>
            <button type="button" class="btn btn-block" data-toggle="modal" data-target="#DetailModal">
                <spring:message code="text348" />
            </button>
            <button id="buttonSaveBasicInformation" type="submit" class="btn btn-success btn-block btn-lg">
                <spring:message code="text341" />
            </button>        
        </form>       

    </div>
</div>

<div class="panel panel-default">
    <div class="panel-heading">
        <spring:message code="text303" />
    </div>
    <div class="panel-body">
        <form action="" method="post" id="updateCompanyTaxForm" name="updateCompanyTaxForm">
            <div class="alert alert-danger">
                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                <spring:message code="text304" />
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text305" /></label>
                        <input name="taxContactName" id="taxContactName" value="${company.contact.person.getName()}" maxlength="255" class="form-control" type="text" required="required" tabindex="11" />
                    </div> 
                </div>
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text306" /></label>
                        <input name="taxContactLastName" id="taxContactLastName" value="${company.contact.person.getLastName()}" maxlength="255" class="form-control" type="text" required="required" tabindex="12" />
                    </div> 
                </div>
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text307" /></label>
                        <input name="taxContactEmail" id="taxContactEmail" value="${company.contact.person.getEmail()}" placeholder="<spring:message code="text91" />" maxlength="55" class="form-control" type="email" required="required" tabindex="13" />
                    </div> 
                </div>
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text86" /></label>
                        <select id="taxContactGender" name="taxContactGender" class="form-control" tabindex="14">
                            <option value="1" <c:if test="${company.contact.person.gender.getName() == 'male' }" > selected </c:if> ><spring:message code="text97" /></option>
                            <option value="2" <c:if test="${company.contact.person.gender.getName() == 'female' }" > selected </c:if> ><spring:message code="text98" /></option>
                            </select>
                        </div> 
                    </div>                                                    
                    <div class="col-lg-6">
                        <div class="form-group"> 
                            <label><spring:message code="text308" /></label>
                        <input name="taxId" id="taxId" placeholder="<spring:message code="text316" />" value="${company.getTaxId()}" maxlength="13" class="form-control" type="text" required="required" tabindex="15" />
                    </div> 
                </div>
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text309" /></label>
                        <input name="taxCompanyName" id="taxCompanyName" value="${company.getTaxCompanyName()}" maxlength="55" class="form-control" type="text" required="required" tabindex="16" />
                    </div> 
                </div>
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text310" /></label>
                        <input name="taxContactPhone" id="taxContactPhone" value="${company.contact.person.getPhone()}" placeholder="<spring:message code="text89"/>" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="17" />
                    </div> 
                </div>
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text161" /></label>
                        <input name="address" id="address" value="${company.address.getAll()}" placeholder="<spring:message code="text79"/>" maxlength="512" class="form-control" type="text" required="required" tabindex="18" />
                    </div> 
                </div>
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text82" /></label>
                        <input name="country" id="country" value="${company.address.getCountry()}" placeholder="<spring:message code="text83"/>" maxlength="35" class="form-control" type="text" required="required" tabindex="19" />
                    </div> 
                </div>
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text121" /></label>
                        <input name="state" id="state" placeholder="" value="${company.address.getState()}" class="form-control" maxlength="55" type="text" required="required" tabindex="20" />
                    </div> 
                </div>
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text84" /></label>
                        <input name="city" id="city" value="${company.address.getCity()}" placeholder="<spring:message code="text85"/>" maxlength="55" class="form-control" type="text" required="required" tabindex="21" />
                    </div> 
                </div>
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text80" /></label>
                        <input name="zipCode" id="zipCode" value="${company.address.getZipCode()}" placeholder="<spring:message code="text81"/>" min="1" max="99999999" class="form-control" type="number" required="required" tabindex="22" />
                    </div> 
                </div>
            </div>
            <button type="submit" class="btn btn-success btn-block btn-lg">
                <spring:message code="text334" />
            </button>
        </form>
    </div>
</div>
<div class="panel panel-default">
    <div class="panel-heading">
        <spring:message code="text311" />
    </div>
    <div class="panel-body">
        <form action="" method="post" id="updateCompanyBankForm" name="updateCompanyBankForm">
            <div class="alert alert-danger">
                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                <spring:message code="text304" />
            </div> 
            <div class="row">
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text312" /></label>
                        <input name="ownerAccountBank" id="ownerAccountBank" value="${company.getOwnerAccountBank()}" maxlength="255" class="form-control" type="text" required="required" tabindex="23" />
                    </div> 
                </div>
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text313" /></label>
                        <input name="bank" id="bank" value="${company.getBank()}" maxlength="55" class="form-control" type="text" required="required" tabindex="24" />
                    </div> 
                </div>
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text314" /></label>
                        <input name="clabe" id="clabe" value="${company.getClabe()}" maxlength="25" class="form-control" type="text" required="required" tabindex="25" />
                    </div> 
                </div>
                <div class="col-lg-6">
                    <div class="form-group"> 
                        <label><spring:message code="text315" /></label>
                        <input name="emailNotifications" id="emailNotifications" value="${company.getEmailNotifications()}"  class="form-control" maxlength="35" type="email" required="required" tabindex="26" />
                    </div> 
                </div>                                                                
            </div>
            <button id="saveButton" type="submit" class="btn btn-block btn-lg btn-success" tabindex="27">
                <spring:message code="text340" />
            </button>
        </form>
    </div>
</div>

<div class="panel panel-default">
    <div class="panel-heading">
        Establishments
    </div>
    <div class="panel-body">
        <c:choose>
            <c:when test="${fn:length(company.getEstablishment()) <= 0}">
                <spring:message code="text224"/>
            </c:when>
            <c:otherwise>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>                                
                                <spring:message code="text237" />
                            </th>
                            <th>                                
                                <spring:message code="text238" />
                            </th>
                            <th>                                
                                <spring:message code="text239" />
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="e" items="${company.getEstablishment()}">
                            <tr>
                                <td>
                                    ${e.getName()}
                                </td>
                                <td>
                                    ${e.getRegistrationDate()}
                                </td>
                                <td>
                                    <button type="button" class="btn btn-primary btn-block" onclick="javascript:redirectData('redirector.html', {url: 'establishmentDetails.html', establishmentId:${e.getId()}})">                                        
                                        <spring:message code="text240" />
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div class="modal fade" id="DetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">                    
                    <spring:message code="text348" />
                </h4>
            </div>
            <div class="modal-body" id="outputDetail">
                <form id="updateCompanyPasswordForm" name="updateCompanyPasswordForm" method="post" action="">
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