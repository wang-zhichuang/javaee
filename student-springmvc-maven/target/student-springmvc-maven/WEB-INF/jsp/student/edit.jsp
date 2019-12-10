<%@ page  pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>  
    <meta charset="utf-8" />  
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />  
    <title>编辑学生</title>  
    <style>   
      
    </style>  
<body>  

<form action="${basePath}/student/update.do" method="post">
学号:<input type="text" name="sno" value="${student.sno}"/><br>
姓名：<input type="text" name="sname" value="${student.sname}"/><br>
性别：<input type="radio" name="sex" value="男" <c:if test="${student.sex=='男'}">checked</c:if>>男
<input type="radio" name="sex" value="女" <c:if test="${student.sex=='女'}">checked</c:if>/>女
<br>
班级:
<select name="bj.id">
<c:forEach items="${bjList}" var="bj">
<option value="${bj.id}" <c:if test="${student.bj.id==bj.id}">selected</c:if>>${bj.bjname}</option>
</c:forEach>
</select>
<br>
<input type="hidden" name="id" value="${student.id}"/>
<input type="submit" value="修改"/>
</form>
${info}
</body>  
</html>  