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
                Affiliate Information
            </div>            
            <div class="panel-body">
                <form action="updateAffiliateSubmit()" role="form" method="post" id="updateAffiliate" name="updateAffiliate">
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
                                <input name="lastName" id="lastName" placeholder="<spring:message code="text77"/>" value="${affiliate.person.getLastName()}" maxlength="60" class="form-control" type="text" required="required" tabindex="2"/>
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text90" /></label>
                                <input name="email" id="email" placeholder="<spring:message code="text91" />" value="${affiliate.person.getEmail()}" maxlength="50" class="form-control" type="email" required="required" tabindex="3" />
                            </div> 
                        </div>                                        
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text159" /></label>
                                <input name="password" id="password" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" tabindex="4" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text160" /></label>
                                <input name="password2" id="password2" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" tabindex="5"/>
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text161" /></label>
                                <input name="address" id="address" placeholder="<spring:message code="text79"/>" value="${affiliate.address.getAll()}" class="form-control" type="text" required="required" tabindex="6" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text82" /></label>
                                <input name="country" id="country" placeholder="<spring:message code="text83"/>" value="${affiliate.address.getCountry()}" maxlength="25" class="form-control" type="text" required="required" tabindex="7" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text121" /></label>
                                <input name="state" id="state" placeholder="" value="${affiliate.address.getState()}" class="form-control" maxlength="35" type="text" required="required" tabindex="8" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text84" /></label>
                                <input name="city" id="city" placeholder="<spring:message code="text85"/>" value="${affiliate.address.getCity()}" maxlength="35" class="form-control" type="text" required="required" tabindex="9" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text80" /></label>
                                <input name="zipCode" id="zipCode" placeholder="<spring:message code="text81"/>" value="${affiliate.address.getZipCode()}" min="1" max="99999999" class="form-control" type="number" required="required" tabindex="10" />
                            </div> 
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group"> 
                                <label><spring:message code="text86" /></label>
                                <select id="gender" name="gender" class="form-control" tabindex="11">
                                    <option value="1" <c:if test="${affiliate.person.gender.getName() == 'male' }" > selected </c:if> > <spring:message code="text97" /></option>
                                    <option value="2" <c:if test="${affiliate.person.gender.getName() == 'female' }" > selected </c:if> > <spring:message code="text98" /></option>
                                    </select>
                                </div> 
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group"> 
                                    <label><spring:message code="text162" /></label>
                                <input name="phone" id="phone" placeholder="<spring:message code="text89"/>" value="${affiliate.person.getPhone()}" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="12" />
                            </div> 
                        </div>  
                            <input type="hidden" id="id" name="id" value="${id}" />
                        <div class="col-lg-12">
                            <button id="saveButton" type="submit" class="btn btn-block btn-lg btn-success">
                                <spring:message code="text223"/>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
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
                                    <button type="button" class="btn btn-primary btn-block" onclick="javascript:redirectData('establishmentDetails.html', {id:${e.getId()}})">                                        
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
<script type="text/javascript">eval("${js}");</script>        