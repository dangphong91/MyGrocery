<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.83.1">
  <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/headers/">
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <title>Product Management Application</title>
  <style>
    a {
      text-decoration: none;
    }
  </style>
</head>
<body style="width: 85vw; margin: auto">
<%@include file="include/header.jsp" %>
<center>
  <h1 style="margin-top: 90px">Product Management</h1>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
        <h2>
          Edit Product
        </h2>
      <c:if test="${product != null}">
        <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
      </c:if>
      <tr>
        <th>Product Name:</th>
        <td>
          <input type="text" name="name" size="45"
                 value="<c:out value='${product.name}' />"
          required>
        </td>
      </tr>
      <tr>
        <th>Product Type:</th>
        <td>
          <input type="text" name="type" size="45"
                 value="<c:out value='${product.type}' />"
          required>
        </td>
      </tr>
      <tr>
        <th>Product Price:</th>
        <td>
          <input type="text" name="price" size="45"
                 value="<c:out value='${product.price}' />"
          required>
        </td>
      </tr>
      <tr>
        <th>Product Inventory:</th>
        <td>
          <input type="text" name="inventory" size="45"
                 value="<c:out value='${product.inventory}' />"
          required>
        </td>
      </tr>
      <tr>
        <th>Product Image:</th>
        <td>
          <input type="text" name="img" size="45"
                 value="<c:out value='${product.img}' />"
          required>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="Save"/>
        </td>
      </tr>
    </table>
  </form>
</div>
<%@include file="include/footer.jsp" %>
</body>
</html>