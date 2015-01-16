<%-- 
    Document   : newProductForm
    Created on : Nov 24, 2014, 12:46:59 PM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <spring:message code="text26" />
            </div>
            <div class="panel-body">
                <div id="message" class="alert alert-danger display-none"></div>                                        
                <form action="createNewWarehouseProcess.html" role="form" method="post" id="createWarehouse" name="createWarehouse">
                    <div class="row">                                        
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label><spring:message code="text27"/></label>
                                <input name="name" id="name" class="form-control" type="text" required="required"/>
                            </div>                                            
                        </div>
                        <div class="col-lg-6">                                            
                            <div class="form-group">
                                <label><spring:message code="text33"/></label>
                                <select id="category.id" name="category.id" class="form-control">                                    
                                    <c:forEach var="c" items="${categories}">
                                        <option value="${c.id}">
                                            ${c.name}
                                        </option>
                                    </c:forEach>                                    
                                </select>                                                                                
                            </div>                                            
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label><spring:message code="text31" /></label>
                                <input name="sku" id="sku" class="form-control" type="text"/>
                            </div>
                        </div>
                        <div class="col-lg-6">                                            
                            <div class="form-group">
                                <label><spring:message code="text32"/></label>
                                <input name="price" id="price" value="0.00" class="form-control" type="number" name="currency" min="0" step="0.01"/>
                            </div>
                        </div>
                        <div class="col-lg-6">                                            
                            <div class="form-group">
                                <label><spring:message code="text38"/></label>
                                <input name="model" id="model" class="form-control" type="text"/>
                            </div>
                        </div>
                        <div class="col-lg-6">                                            
                            <div class="form-group">
                                <label><spring:message code="text39"/></label>
                                <input name="units" id="units" value="0" class="form-control" type="number"/>
                            </div>
                        </div>
                        <div class="col-lg-6">                                            
                            <div class="form-group">
                                <label><spring:message code="text40"/></label>
                                <input name="manufacturer" id="manufacturer" class="form-control" type="text"/>
                            </div>
                        </div>
                        <div class="col-lg-6">                                            
                            <div class="form-group">
                                <label><spring:message code="text34"/></label>
                                <select id="active" name="active" class="form-control">                                                    
                                    <option value="1">yes</option>
                                    <option value="0">no</option>
                                </select>                                                
                            </div>
                        </div>
                        <div class="col-lg-6">                                            
                            <div class="form-group">
                                <label><spring:message code="text37"/></label>
                                <input name="discount" id="discount" type="number" value="0" class="form-control" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label><spring:message code="text35"/></label>
                                <textarea name="description" id="description" class="form-control"></textarea>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label><spring:message code="text36"/></label>
                                <input type="file" class="form-control" />
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <button type="reset" class="btn btn-default btn-block btn-xs">
                                <spring:message code="text29" />
                            </button>
                            <button type="submit" class="btn btn-success btn-block btn-lg">
                                <spring:message code="text28" />
                            </button>
                        </div>                                        
                    </div>
                </form>
            </div>                            
        </div>
    </div>    
</div>

