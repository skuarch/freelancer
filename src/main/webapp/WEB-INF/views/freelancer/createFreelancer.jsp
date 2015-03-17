<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../application/noCache.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <title><spring:message code="text1" /></title>
        <jsp:include page="../application/head.jsp"/>      
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
        <div class="intro-header2">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-message">
                            <h1>
                                <spring:message code="text93" />
                                <br>
                                <spring:message code="text99" />
                            </h1>
                        </div>
                    </div>
                </div>
            </div>            
        </div>        
        <br/>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <spring:message code="text73" />
                        </div>
                        <div class="panel-body">
                            <div id="message" class="alert alert-warning">
                                <spring:message code="text100" />
                            </div> 
                            <div id="message" class="alert alert-danger display-none"></div> 
                            <form action="createNewFreelancer.html" role="form" method="post" id="createFreelancer" name="createFreelancer">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="form-group"> 
                                            <label><spring:message code="text90" /></label>
                                            <input name="email" id="email" placeholder="<spring:message code="text91" />" maxlength="50" class="form-control" type="email" required="required" tabindex="1" />
                                        </div> 
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group"> 
                                            <label><spring:message code="text74" /></label>
                                            <input name="name" id="name" placeholder="<spring:message code="text75" />" maxlength="60" class="form-control" type="text" required="required" tabindex="2"/>
                                        </div> 
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group"> 
                                            <label><spring:message code="text76" /></label>
                                            <input name="lastName" id="lastName" placeholder="<spring:message code="text77"/>" maxlength="60" class="form-control" type="text" required="required" tabindex="3"/>
                                        </div> 
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group"> 
                                            <label><spring:message code="text94" /></label>
                                            <input name="password" id="password" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" tabindex="4" />
                                        </div> 
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group"> 
                                            <label><spring:message code="text96" /></label>
                                            <input name="password2" id="password2" placeholder="<spring:message code="text95"/>" maxlength="8" class="form-control" type="password" required="required" tabindex="5"/>
                                        </div> 
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group"> 
                                            <label><spring:message code="text78" /></label>
                                            <input name="address" id="address" placeholder="<spring:message code="text79"/>" class="form-control" type="text" required="required" tabindex="6" />
                                        </div> 
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group"> 
                                            <label><spring:message code="text82" /></label>
                                            <input name="country" id="country" placeholder="<spring:message code="text83"/>" maxlength="25" class="form-control" type="text" required="required" tabindex="7" />
                                        </div> 
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group"> 
                                            <label><spring:message code="text121" /></label>
                                            <input name="state" id="state" placeholder="" class="form-control" maxlength="35" type="text" required="required" tabindex="8" />
                                        </div> 
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group"> 
                                            <label><spring:message code="text84" /></label>
                                            <input name="city" id="city" placeholder="<spring:message code="text85"/>" maxlength="35" class="form-control" type="text" required="required" tabindex="9" />
                                        </div> 
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group"> 
                                            <label><spring:message code="text80" /></label>
                                            <input name="zipCode" id="zipCode" placeholder="<spring:message code="text81"/>" min="1" max="99999999" class="form-control" type="number" required="required" tabindex="10" />
                                        </div> 
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group"> 
                                            <label><spring:message code="text86" /></label>
                                            <select id="gender" name="gender" class="form-control" tabindex="11">
                                                <option value="1"><spring:message code="text97" /></option>
                                                <option value="2"><spring:message code="text98" /></option>
                                            </select>
                                        </div> 
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group"> 
                                            <label><spring:message code="text88" /></label>
                                            <input name="phone" id="phone" placeholder="<spring:message code="text89"/>" min="1" max="999999999999" class="form-control" type="number" required="required" tabindex="12" />
                                        </div> 
                                    </div>                                                                                                            
                                    <div class="col-lg-12">
                                        <button id="saveButton" class="btn btn-block btn-lg btn-success">
                                            <spring:message code="text92"/>
                                        </button>
                                    </div>
                                </div>
                            </form>                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../application/applicationFooter.jsp"/>
        <script src="scriptI18N.html" type="text/javascript"></script>
        <jsp:include page="../application/scripts.jsp"/>           
        <script type="text/javascript">eval("${js}");</script>        
    </body>
</html>