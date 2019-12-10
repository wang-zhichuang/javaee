
<%@ page  pageEncoding="UTF-8" import="cn.oneseek.struts2.dao.BjDao,java.util.List,cn.oneseek.struts2.vo.Bj"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>  
    <meta charset="utf-8" />  
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />  
    <title>添加学生</title>  
    <style>   
      
    </style>  
<body> 

<form action="${basePath}/student/add.action" method="post">
输入学号:<input type="text" name="sno"/><br>
姓名：<input type="text" name="sname"/><br>
性别：<input type="radio" name="sex" value="男" checked/>男
<input type="radio" name="sex" value="女"/>女
<br>
班级:
<select name="bjid">
<c:forEach items="${bjList}" var="bj">
<option value="${bj.id}">${bj.bjname}</option>
</c:forEach>
</select>
<br>
<input type="submit" value="添加"/>
</form>
${info}
</body>  
</html>  