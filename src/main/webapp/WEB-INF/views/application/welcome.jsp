<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../application/noCache.jsp"/>
<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="../application/head.jsp"/>      
        <title><spring:message code="text1" /></title>
        <link href="<c:url value="/resources/css/freelancer.css" />" rel="stylesheet">        
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>        
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container">                
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="welcome.html">                        
                        <spring:message code="text57" />
                    </a>
                </div>                
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="createFreelancer.html">
                                <spring:message code="text61" />
                            </a>
                        </li>
                        <li>
                            <a href="login.html">
                                <spring:message code="text62" />
                            </a>
                        </li>
                        <li>
                            <a href="http://regaloenclave.com">
                                <spring:message code="text63" />
                            </a>
                        </li>                        
                        <li>
                            <a href="?lang=en">
                                <spring:message code="text71" />
                            </a>
                        </li>                        
                        <li>
                            <a href="?lang=es">
                                <spring:message code="text72" />
                            </a>
                        </li>                        
                    </ul>
                </div>                
            </div>            
        </nav>
        <div class="intro-header">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-message">                            
                            <img src="<c:url value="/resources/img/logo2.png"/>" />
                            <h1><spring:message code="text58" /></h1>
                            <h3><spring:message code="text59" /></h3>
                            <h5><spring:message code="text60" /></h5>
                            <hr class="intro-divider">
                            <ul class="list-inline intro-social-buttons">
                                <li>
                                    <a href="createFreelancer.html" class="btn btn-default btn-lg">
                                        <i class="fa fa-user fa-fw"></i>
                                        <span class="network-name">
                                            <spring:message code="text61" />
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="login.html" class="btn btn-default btn-lg">
                                        <i class="fa fa-sign-in fa-fw">
                                        </i> 
                                        <span class="network-name">
                                            <spring:message code="text62" />
                                        </span>
                                    </a>
                                </li>                                
                                <li>
                                    <a href="http://regaloenclave.com" class="btn btn-danger btn-lg">
                                        <i class="fa fa-gift fa-fw">
                                        </i> 
                                        <span class="network-name">
                                            <spring:message code="text63" />
                                        </span>
                                    </a>
                                </li>                                                                
                            </ul>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <div class="content-section-a">

            <div class="container">

                <div class="row">
                    <div class="col-lg-5 col-sm-6">
                        <hr class="section-heading-spacer">
                        <div class="clearfix"></div>
                        <h2 class="section-heading">                            
                            <spring:message code="text68" />
                            <br>
                            <spring:message code="text70" />
                        </h2>
                        <p class="lead">
                            <spring:message code="text69" />
                    </div>
                    <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                        <img class="img-responsive" src="<c:url value="/resources/img/tablet.png"/>" alt="">
                    </div>
                </div>
            </div>            
        </div>   
        <div class="content-section-b">

            <div class="container">

                <div class="row">
                    <div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
                        <hr class="section-heading-spacer">
                        <div class="clearfix"></div>
                        <h2 class="section-heading">                            
                            <spring:message code="text134" />
                        </h2>
                        <p class="lead">
                            <spring:message code="text135" />
                        </p>
                    </div>
                    <div class="col-lg-5 col-sm-pull-6  col-sm-6">
                        <img class="img-responsive" src="<c:url value="/resources/img/tv.png"/>" alt="">
                    </div>
                </div>
            </div>    
        </div>        
        <div class="content-section-a">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5 col-sm-6">
                        <hr class="section-heading-spacer">
                        <div class="clearfix"></div>
                        <h2 class="section-heading">                            
                            <spring:message code="text132" />
                        </h2>
                        <p class="lead">
                            <spring:message code="text133" />
                        </p>
                    </div>
                    <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                        <img class="img-responsive" src="<c:url value="/resources/img/gift.png"/>" alt="">
                    </div>
                </div>
            </div>            
        </div>  
        <div class="banner">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <h2>
                            <img src="<c:url value="/resources/img/logo1.png"/>" />
                            <spring:message code="text130" />
                        </h2>
                    </div>
                    <div class="col-lg-6">
                        <ul class="list-inline banner-social-buttons">
                            <li>
                                <a href="http://contact.regaloenclave.com" class="btn btn-default btn-lg">
                                    <i class="fa fa-phone fa-fw"></i> 
                                    <span class="network-name">
                                        <spring:message code="text128" />
                                    </span>
                                </a>
                            </li>                            
                            <li>
                                <a href="createFreelancer.html" class="btn btn-default btn-lg">
                                    <i class="fa fa-user fa-fw"></i> 
                                    <span class="network-name">
                                        <spring:message code="text129" />
                                    </span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>            
        </div>
        <jsp:include page="applicationFooter.jsp"/>
        <script src="scriptI18N.html" type="text/javascript"></script>
        <jsp:include page="../application/scripts.jsp"/>                
    </body>
</html>