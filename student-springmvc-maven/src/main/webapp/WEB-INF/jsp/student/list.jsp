
<%@ page  pageEncoding="UTF-8"%>
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
    table,tr,td,th{
     border:1px solid gray;
    }
    td{
      padding:10px;
    }
       
      
    </style>  
<body>  
<table>
<tr><th>学号</th><th>姓名</th><th>性别</th><th>班级</th><th>修改</th><th>删除</th><tr>
 <c:forEach var="student" items="${studentList}">
   <tr>
   <td>${student.sno}</td>
    <td>${student.sname}</td>
     <td>${student.sex}</td>
      <td>${student.bj.bjname}</td>
   <td><a href="${basePath}/student/edit.do?id=${student.id}">修改</a></td>
   <td><a href="${basePath}/student/delete.do?id=${student.id}" onclick="return confirm('确实要删除该记录吗?')">删除</a></td>
   <tr>
 </c:forEach>
</table>
 <a href="${basePath}/student/preadd.do">添加学生</a>
</body>  
</html>  