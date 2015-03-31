<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="" method="post" id="updateCashierForm" name="updateCashierForm">
    <div class="form-group"> 
        <label><spring:message code="text188" /></label>
        <input name="cashier_name" id="cashier_name" value="${cashier.person.getName()}" placeholder="<spring:message code="text189" />" maxlength="60" class="form-control" type="text" required="required" tabindex="16"/>
    </div>

    <div class="form-group"> 
        <label><spring:message code="text190" /></label>
        <input name="cashier_lastName" id="cashier_lastName" value="${cashier.person.getLastName()}" placeholder="<spring:message code="text77"/>" maxlength="60" class="form-control" type="text" required="required" tabindex="17"/>
    </div> 

    <div class="form-group"> 
        <label><spring:message code="text191" /></label>
        <input name="cashier_phone" id="cashier_phone" value="${cashier.person.getPhone()}" placeholder="<spring:message code="text89"/>" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="18" />
    </div> 

    <div class="form-group"> 
        <label><spring:message code="text192" /></label>
        <input name="cashier_email" id="cashier_email" value="${cashier.person.getEmail()}" maxlength="50" class="form-control" type="email" required="required" tabindex="19" />
    </div> 

    <input type="hidden" name="cashier_id" value="${cashier.getId()}" />

    <div class="form-group"> 
        <label><spring:message code="text86" /></label>
        <select id="cashier_gender" name="cashier_gender" class="form-control" tabindex="22">
            <option value="1" <c:if test="${cashier.person.gender.getName() == 'male' }" > selected </c:if> ><spring:message code="text97" /></option>
            <option value="2" <c:if test="${cashier.person.gender.getName() == 'female' }" > selected </c:if> ><spring:message code="text98" /></option>
            </select>
        </div>
        <button type="submit" id="updateCahierButton" name="updateCahierButton" class="btn btn-block btn-success" onclick="updateCashierInfomation(event);">            
        <spring:message code="text262" />
    </button>                            

</form>
<script>
    $("#updateCashierForm").bind("submit", function (event) {
        updateCashierInfomation(event);
    });
</script>
<script type="text/javascript">eval("${js}");</script> 