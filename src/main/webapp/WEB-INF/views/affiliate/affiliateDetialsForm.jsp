<%-- 
    Document   : index
    Created on : Mar 01, 2014, 6:12:09 PM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../application/noCache.jsp"/>

<div class="row">
    <div class="col-lg-12">        
        <div class="panel panel-default">
            <div class="panel-heading"> 
                <spring:message code="text322"/>                
            </div>
            <div class="panel-body">                                                                                                             
                <form action="" role="form" method="post" id="updateAffiliateBasicInformationForm" name="updateAffiliateBasicInformationForm">
                    <div class="alert alert-success">
                        <strong><spring:message code="text323"/></strong>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text158" /></label>
                                <input name="name" id="name" placeholder="<spring:message code="text75" />" maxlength="60" value="${affiliate.person.getName()}" class="form-control" type="text" required="required" tabindex="1"/>
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text76" /></label>
                                <input name="lastName" id="lastName" placeholder="<spring:message code="text77"/>" maxlength="60" value="${affiliate.person.getLastName()}" class="form-control" type="text" required="required" tabindex="2"/>
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text90" /></label>
                                <input name="email" id="email" placeholder="<spring:message code="text91" />" maxlength="55" value="${affiliate.person.getEmail()}" class="form-control" type="email" required="required" tabindex="3" />
                            </div> 
                        </div>  
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text162" /></label>
                                <input name="phone" id="phone" placeholder="<spring:message code="text89"/>" value="${affiliate.person.getPhone()}" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="4" />
                            </div> 
                        </div>                        
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text86" /></label>
                                <select id="gender" name="gender" class="form-control" tabindex="7">
                                    <option value="1" <c:if test="${affiliate.person.gender.getName() == 'male' }" > selected </c:if> ><spring:message code="text97" /></option>
                                    <option value="2" <c:if test="${affiliate.person.gender.getName() == 'female' }" > selected </c:if> ><spring:message code="text98" /></option>
                                    </select>
                                </div> 
                            </div>                                                    
                            <div class="col-lg-6">
                                <div class="form-group"> 
                                    <label><spring:message code="text324"/></label>
                                <input name="brand" id="brand" placeholder="la marca puede ser el nombre comercial" maxlength="55" value="${affiliate.getBrand()}" class="form-control" type="text" required="required" tabindex="8" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text172" /></label>
                                <select id="category" name="category" class="form-control selectpicker" multiple tabindex="9">                                                    
                                    <c:forEach items="${categories}" var="c">
                                        <option <c:if test="${c.isSelected == true}">selected="selected"</c:if> value="${c.id}">${c.name}</option>
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
                                <textarea id="description" name="description" class="form-control" cols="1" rows="6" placeholder="<spring:message code="text343" />">${affiliate.getDescription()}</textarea>
                            </div>
                        </div>
                    </div> 
                    <button type="button" class="btn btn-block" data-toggle="modal" data-target="#DetailModal">
                        <spring:message code="text348" />
                    </button>        
                    <button type="submit" id="buttonSaveAffiliate" class="btn btn-success btn-block btn-lg">
                        <spring:message code="text325"/>
                    </button> 
                </form>
            </div><!-- end panel-body -->        
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <spring:message code="text326"/>
            </div>
            <div class="panel-body">
                <form action="" name="updateAffiliateTaxForm" id="updateAffiliateTaxForm">
                    <div class="alert alert-danger">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <spring:message code="text327"/>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text328"/></label>
                                <input name="taxContactName" id="taxContactName" placeholder="<spring:message code="text85"/>" maxlength="255" value="${affiliate.contact.person.getName()}" class="form-control" type="text" required="required" tabindex="10" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text329"/></label>
                                <input name="taxContactLastName" id="taxContactLastName" placeholder="<spring:message code="text85"/>" maxlength="255" value="${affiliate.contact.person.getLastName()}" class="form-control" type="text" required="required" tabindex="11" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text330"/></label>
                                <input name="taxContactEmail" id="taxContactEmail" placeholder="<spring:message code="text91" />" maxlength="55" value="${affiliate.contact.person.getEmail()}" class="form-control" type="email" required="required" tabindex="12" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text86" /></label>
                                <select id="taxContactGender" name="taxContactGender" class="form-control" tabindex="13">
                                    <option value="1" <c:if test="${affiliate.contact.person.gender.getName() == 'male' }" > selected </c:if> > <spring:message code="text97" /></option>
                                    <option value="2" <c:if test="${affiliate.contact.person.gender.getName() == 'female' }" > selected </c:if> > <spring:message code="text98" /></option>
                                    </select>
                                </div> 
                            </div>                                                    
                            <div class="col-lg-6">
                                <div class="form-group"> 
                                    <label><spring:message code="text331"/></label>
                                <input name="taxId" id="taxId" placeholder="RFC" maxlength="13" value="${affiliate.getTaxId()}" class="form-control" type="text" required="required" tabindex="14" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text331"/></label>
                                <input name="taxCompanyName" id="taxCompanyName" placeholder="<spring:message code="text79"/>" maxlength="55" value="${affiliate.getTaxCompanyName()}" class="form-control" type="text" required="required" tabindex="15" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text332"/></label>
                                <input name="taxContactPhone" id="taxContactPhone" placeholder="<spring:message code="text89"/>" value="${affiliate.contact.person.getPhone()}"  min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="16" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text161" /></label>
                                <input name="address" id="address" placeholder="<spring:message code="text79"/>" maxlength="512" value="${affiliate.address.getAll()}" class="form-control" type="text" required="required" tabindex="17" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text82" /></label>
                                <input name="country" id="country" placeholder="<spring:message code="text83"/>" maxlength="35" value="${affiliate.address.getCountry()}" class="form-control" type="text" required="required" tabindex="18" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text121" /></label>
                                <input name="state" id="state" placeholder="" class="form-control" maxlength="55" value="${affiliate.address.getState()}" type="text" required="required" tabindex="19" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text84" /></label>
                                <input name="city" id="city" placeholder="<spring:message code="text85"/>" maxlength="55" value="${affiliate.address.getCity()}" class="form-control" type="text" required="required" tabindex="20" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text80" /></label>
                                <input name="zipCode" id="zipCode" placeholder="<spring:message code="text81"/>" value="${affiliate.address.getZipCode()}" min="1" max="99999999" class="form-control" type="number" required="required" tabindex="21" />
                            </div> 
                        </div>
                    </div>
                    <button id="buttonSaveTaxInformation" type="submit" class="btn btn-success btn-block btn-lg">
                        <spring:message code="text334"/>
                    </button>  
                </form>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <spring:message code="text335"/>
            </div>
            <div class="panel-body">
                <form action="" id="updateAffiliateBankForm" name="updateAffiliateBankForm">
                    <div class="alert alert-danger">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <spring:message code="text327"/>
                    </div> 
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text336"/></label>
                                <input name="ownerAccountBank" id="ownerAccountBank" placeholder="<spring:message code="text79"/>" maxlength="255" value="${affiliate.getOwnerAccountBank()}" class="form-control" type="text" required="required" tabindex="23" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text337"/></label>
                                <input name="bank" id="bank" placeholder="<spring:message code="text79"/>" maxlength="55" value="${affiliate.getBank()}" class="form-control" type="text" required="required" tabindex="24" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text338"/></label>
                                <input name="clabe" id="clabe" placeholder="<spring:message code="text83"/>" maxlength="25" value="${affiliate.getClabe()}" class="form-control" type="text" required="required" tabindex="25" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text339"/></label>
                                <input name="emailNotifications" id="emailNotifications" placeholder="" class="form-control" maxlength="35" value="${affiliate.getEmailNotifications()}" type="email" required="required" tabindex="26" />
                            </div> 
                        </div>                                                                
                    </div>
                    <button id="saveButtonBank" type="submit" class="btn btn-block btn-lg btn-success" tabindex="27">
                        <spring:message code="text340"/>
                    </button>
                </form>
            </div>
        </div>


        <br/>
        <div class="panel panel-default">
            <div class="panel-heading">
                Establishments
            </div>
            <div class="panel-body">
                <c:choose>
                    <c:when test="${fn:length(affiliate.getEstablishment()) <= 0}">
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
                                <c:forEach var="e" items="${affiliate.getEstablishment()}">
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
                <form id="updateAffiliatePasswordForm" name="updateAffiliatePasswordForm" method="post" action="">
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
