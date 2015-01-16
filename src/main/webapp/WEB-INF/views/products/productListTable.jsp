<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                All Products List
            </div>            
            <div class="panel-body">
                <div class="table-responsive">
                    <table id="tableProductList" name="tableProductList" class="table table-bordered table-hover">
                        <thead>
                            <tr class="warning">
                                <th>
                                    ID 
                                </th>
                                <th>
                                    Name 
                                </th>                                
                                <th>
                                    Price
                                </th>  
                                <th>
                                    Discount
                                </th>
                                <th>
                                    units
                                </th>                                
                                <th>
                                    active
                                </th>

                                <th>
                                    details
                                </th>
                            </tr>
                        </thead>
                        <tbody>  
                            <c:forEach var="p" items="${productList}">
                                <tr>
                                    <td>
                                        ${p.id}
                                    </td>
                                    <td>
                                        ${p.name}
                                    </td>                                    
                                    <td>
                                        $${p.price}
                                    </td>                                            
                                    <td>
                                        ${p.discount}%
                                    </td>
                                    <td>
                                        ${p.units}
                                    </td>                                    
                                    <td>
                                        <c:if test="${p.active} == 1">
                                            yes
                                        </c:if>                    
                                    </td>                                    
                                    <td>
                                        <button class="btn btn-primary btn-block" data-toggle="modal" data-target="#productDetailModal" onclick="productDetail(${p.id})">
                                            details
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
</div>
<script type="text/javascript">eval("${js}");</script>        
