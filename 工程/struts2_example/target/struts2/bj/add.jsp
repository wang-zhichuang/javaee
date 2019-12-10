
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
      
    </style>  
<body>  
<form action="${basePath}/bj/add.action" method="post">
输入班级名称:<input type="text" name="bjname"/>
<input type="submit" value="添加"/>
</form>
${info}
</body>  
</html>  