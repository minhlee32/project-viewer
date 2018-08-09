<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    #content {
        width: 500px;
        margin: 100px auto;
    }

    #content h1 {
        color: cornflowerblue;
        font-family: "DejaVu Sans Condensed", serif;
    }

    #content tr ,td{
        border: 1px solid #ddd;
        padding: 8px;
    }
    #customers tr:hover {background-color: #ddd;}

    #customers tr {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: #4CAF50;
        color: white;
    }

</style>
<head>
    <title>Products</title>
</head>
<body>
<div id="content">

<h1>Customers</h1>

<table border="1">
    <tr>
        <td style="font-color:red">Id</td>
        <td style="font-color:red">Code</td>
        <td style="font-color:red">Name</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getCode()}</td>
            <td>${product.getName()}</td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>