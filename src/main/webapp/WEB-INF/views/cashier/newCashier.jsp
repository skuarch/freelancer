<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="createCashierProcess.html" method="post" id="createCashierForm" name="createCashierForm">
    <div class="form-group"> 
        <label><spring:message code="text188" /></label>
        <input name="cashier_name" id="cashier_name" placeholder="<spring:message code="text189" />" maxlength="60" class="form-control" type="text" required="required" tabindex="16"/>
    </div>

    <div class="form-group"> 
        <label><spring:message code="text190" /></label>
        <input name="cashier_lastName" id="cashier_lastName" placeholder="<spring:message code="text77"/>" maxlength="60" class="form-control" type="text" required="required" tabindex="17"/>
    </div> 

    <div class="form-group"> 
        <label><spring:message code="text191" /></label>
        <input name="cashier_phone" id="cashier_phone" placeholder="<spring:message code="text89"/>" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="18" />
    </div> 

    <div class="form-group"> 
        <label><spring:message code="text192" /></label>
        <input name="cashier_email" id="cashier_email" maxlength="50" class="form-control" type="email" required="required" tabindex="19" />
    </div> 

    <div class="form-group"> 
        <label><spring:message code="text202" /></label>
        <input name="cashier_password" id="cashier_password" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" tabindex="20" />
    </div> 

    <div class="form-group"> 
        <label><spring:message code="text186" /></label>
        <input name="cashier_password2" id="cashier_password2" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" tabindex="21"/>
    </div> 

    <input type="hidden" id="establishmentId" value="${establishmentId}"/>
    <div class="form-group"> 
        <label><spring:message code="text86" /></label>
        <select id="cashier_gender" name="cashier_gender" class="form-control" tabindex="22">
            <option value="1"><spring:message code="text97" /></option>
            <option value="2"><spring:message code="text98" /></option>
        </select>
    </div>
    <button type="submit" id="createCashierButton" class="btn btn-success btn-block">
        create cashier
    </button>
</form>
<script type="text/javascript">eval("${js}");</script>        