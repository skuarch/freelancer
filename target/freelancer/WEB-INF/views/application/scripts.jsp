<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript">
    ctxr = '<c:url value="/resources/"/>';
    ctx = '<c:url value="/"/>';
    serverDomain = document.domain;
    serverContext = location.pathname.split('/')[1];
    serverPort = location.port;
    wsUrlNotifications = "ws://" + serverDomain + ":" + serverPort + "/" + serverContext + "/notification";    
</script>
<script src="<c:url value="/resources/js/app.js"/>" type="text/javascript"></script>