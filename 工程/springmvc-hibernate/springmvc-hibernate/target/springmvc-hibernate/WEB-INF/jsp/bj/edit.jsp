
<%@ page  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>  
    <meta charset="utf-8" />  
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />  
    <title>编辑班级</title>  
    <style>   
      
    </style>  
<body>  
<form action="${basePath}/bj/update.do" method="post">
班级名称:<input  name="bjname" value="${bj.bjname}"/>
<input type="hidden" name="id" value="${bj.id}"/>
<input type="submit" value="修改"/>
</form>
${info}
</body>  
</html>  