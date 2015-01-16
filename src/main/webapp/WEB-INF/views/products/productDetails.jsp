<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="text-center">
    <img src="<c:url value="/resources/img/product.png"/>"><br/>
    <br/>
</div>
<dl class="dl-horizontal well">
    <dt>Product Name:</dt>
    <dd class="text-primary">
        <strong>${product.name}</strong>        
    </dd>
    <dt>Category:</dt>
    <dd>${product.category.name}</dd>
    <dt>SKU:</dt>
    <dd>${product.sku}</dd>
    <dt>Price per unit:</dt>
    <dd>${product.price}</dd>
    <dt>Model:</dt>
    <dd>${product.model}</dd>
    <dt>Units in Stock:</dt>
    <dd>${product.units}</dd>
    <dt>Manufacturer:</dt>
    <dd>${product.manufacturer}</dd>
    <dt>Active:</dt>
    <dd>
        <span class="label label-success">${product.active}</span>
    </dd>
    <dt>Discount:</dt>
    <dd>${product.discount}</dd>
    <dt>Description:</dt>
    <dd>${product.description}</dd>
</dl>

<script type="text/javascript">eval("${js}");</script>        