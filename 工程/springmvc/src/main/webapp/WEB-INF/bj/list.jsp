<%@page  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>  
    <meta charset="utf-8" />  
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />  
    <title>班级列表</title>  
    <style> 
    body{
     text-align:center;
    } 
    table{
     border-collapse:collapse;
     margin:0 auto;
    }
    table,tr,td{
     border:1px solid gray;
    }
    td{
      padding:10px;
    }
       
      
    </style>  
<body>  
<table>
<tr><th>班级名称</th><th>修改</th><th>删除</th><tr>
 <c:forEach var="bj" items="${bjList}">
   <tr>
   <td>${bj.bjname}</td>
   <td><a href="${basePath}/bj/edit.do?id=${bj.id}">修改</a></td>
   <td><a href="${basePath}/bj/delete.do?id=${bj.id}" onclick="return confirm('确实要删除该记录吗?')">删除</a></td>
   <tr>
 </c:forEach>
</table>
 <a href="${basePath}/bj/add_jsp.do">添加班级</a>
</body>  
</html>  