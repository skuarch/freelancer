<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:choose>
    <c:when test="${fn:length(affiliates) <= 0}">
        <div class="alert alert-warning">
            <spring:message code="text226"/>
        </div>
    </c:when>
    <c:otherwise>
        <div class="row">
            <div class="col-lg-12">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped">
                        <thead>
                            <tr>
                                <th>
                                    <spring:message code="text230" />
                                </th>
                                <th>
                                    <spring:message code="text231" />
                                </th>                                
                                <th>
                                    <spring:message code="text232" />
                                </th>
                                <th>
                                    <spring:message code="text233" />
                                </th>
                            </tr>
                        </thead>
                        <tbody>  
                            <c:forEach var="a" items="${affiliates}">
                                <tr>
                                    <td>
                                        ${a.person.getName()}
                                    </td>
                                    <td>
                                        ${a.person.getLastName()}
                                    </td>                                    
                                    <td>
                                        ${a.person.getRegistrationDate()}
                                    </td>        
                                    <td>
                                        <button class="btn btn-primary" onclick="javascript:redirectData('createEstablishment.html', {id:${a.getId()}})">
                                            <spring:message code="text234" />
                                        </button>
                                        <button class="btn btn-success" onclick="javascript:redirectData('affiliateDetails.html', {id:${a.getId()}})">
                                            <spring:message code="text235" />
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>
<script type="text/javascript">eval("${js}");</script>        
