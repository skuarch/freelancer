<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../application/noCache.jsp"/>
<form action="" method="post" id="updatePasswordCashierForm" name="updatePasswordCashierForm">
    <input type="hidden" id="cashier_id" value="${cashierId}" />
    <div class="form-group"> 
        <label><spring:message code="text202" /></label>
        <input name="cashier_password" id="cashier_password" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" />
    </div> 
    <div class="form-group"> 
        <label><spring:message code="text186" /></label>
        <input name="cashier_password2" id="cashier_password2" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" />                
    </div> 
    <button type="submit" class="btn btn-success btn-block" id="updatePasswordCashierButton">                    
        <spring:message code="text256" />
    </button>
</form>