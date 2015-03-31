<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">            
            <li>
                <a href="systemWelcome.html">
                    <i class="fa fa-star fa-fw">                        
                    </i>
                    <spring:message code="text23" />
                </a>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-user">                        
                    </i> 
                    <spring:message code="text24" />
                    <span class="fa arrow">                        
                    </span>
                </a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="profile.html">
                            <spring:message code="text146" />
                        </a>
                    </li>
                    <li>
                        <a href="updateFreelancerPassword.html">
                            <spring:message code="text25" />
                        </a>
                    </li>                    
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-group"></i> 
                    <spring:message code="text140" />
                    <span class="fa arrow"></span>
                </a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="createNewAffiliate.html">
                            <spring:message code="text147" />
                        </a>
                    </li>
                    <li>
                        <a href="createNewCompanyAffiliate.html">
                            <spring:message code="text163" />
                        </a>
                    </li>
                    <li>
                        <a href="affiliatesList.html">
                            <spring:message code="text155" />
                        </a>
                    </li>
                    <li>
                        <a href="companiesList.html">
                            <spring:message code="text285" />
                        </a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <!-- <li>
                <a href="forms.html">
                    <i class="fa fa-edit fa-fw"></i> 
                    <spring:message code="text141" />
                </a>                
            </li>
        </ul> -->
    </div>
    <!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->