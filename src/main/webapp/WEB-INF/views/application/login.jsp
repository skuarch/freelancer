<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../application/noCache.jsp"/>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html class="ie6"> <![endif]-->
<!--[if IE 7 ]>    <html class="ie7"> <![endif]-->
<!--[if IE 8 ]>    <html class="ie8"> <![endif]-->
<!--[if IE 9 ]>    <html class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html class=""> <!--<![endif]-->    
    <head>
        <jsp:include page="head.jsp"/>
    </head>
    <body>
        <spring:htmlEscape defaultHtmlEscape="true"/>
        <noscript>
            <meta http-equiv="refresh" content="0;url=noscript.html">
        </noscript>
        <div class="container" id="container">            
            <div class="row">
                <div class="col-md-4 col-md-offset-4">                    
                    <div class="login-panel panel panel-default">                        
                        <div class="panel-heading">
                            <h3 class="panel-title"><spring:message code="text2" /></h3>
                        </div>
                        <div class="panel-body" id="mainForm">                            
                            <div id="message" class="alert alert-danger display-none"></div>                            
                            <form role="form" method="post" id="loginForm" action=""> 
                                <fieldset>                                    
                                    <div class="form-group">
                                        <input class="form-control" placeholder="<spring:message code="text3" />" id="email" name="email" type="email" autofocus required="required">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="<spring:message code="text4" />" id="password" name="password" type="password" value="" required="required">
                                    </div>                                    
                                    <button id="loginButton" class="btn btn-lg btn-success btn-block" type="submit">
                                        <spring:message code="text6" />                                        
                                    </button>
                                </fieldset>
                            </form>                            
                        </div>                        
                    </div>
                    <div id="languagues" class="panel">
                        <div class="panel-body text-center">
                            <a href="login.html?lang=es">
                                <spring:message code="text7" />
                            </a>
                            |
                            <a href="login.html?lang=en">
                                <spring:message code="text8" />
                            </a>
                            <br/>
                            <div class="small">
                                <spring:message code="text9" />
                            </div>
                        </div>
                    </div>
                </div>                
            </div>            
        </div>        
        <script src="scriptI18N.html" type="text/javascript"></script>
        <jsp:include page="scripts.jsp" />
        <script>
            (function ($) {
                "use strict";
                if ($('html').is('.ie6, .ie7, .ie8, .ie9')) {
                    window.location.href = "oldBrowser.html";
                }
            }(jQuery));
        </script>           
    </body>
</html>
