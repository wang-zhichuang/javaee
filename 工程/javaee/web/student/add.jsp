
<%@ page  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>  
    <meta charset="utf-8" />  
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />  
    <title>学生列表</title>
    <style>   
      
    </style>  
<body>  
<form action="${basePath}/studentServlet?action=add" method="post">

    学号:<input  name="student_no" value=""/><br>
    学生名称:<input  name="student_name" value=""/><br>
    性别:<input  name="student_sex" type="radio" value="男"/>男
    <input  name="student_sex" type="radio" value="女"/>女
    <br>
    班级:<select name="student_bj_id">
    <option value="1">网络工程16-1</option>
    <option value="2">计开发16-1</option>
    <option value="3">计测试16-1</option>
    <option value="4">空间16-1</option>
</select>
    <br>
    <input type="submit" value="添加"/>
</form>
${info}
</body>  
</html>  