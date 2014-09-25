<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyBank</title>
</head>
<body>
<%@ include file="menu.html" %>
<table class="table1">
<thead>
    <tr>
        <th scope="col">Firstname</th>
        <th scope="col">Lastname</th>
        <th scope="col">IPN</th>
        <th scope="col">Address</th>
        <th scope="col">Phone</th>
        <th scope="col">Email</th>
    </tr>
</thead>

<tbody>
  <c:forEach items="${list}" var="items">
    <tr>
    <c:forTokens items="${items}" delims="|" var="item">
 		 <td class="green"><c:out value="${item}" /></td> 
	</c:forTokens>
      
    </tr>
  </c:forEach>
  </tbody>
</table>


</body>
</html>