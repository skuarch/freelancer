<%@page contentType="text/javascript" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:forEach items="${arrayList}" var="i18n">${i18n}="<spring:message code="${i18n}" />";</c:forEach>