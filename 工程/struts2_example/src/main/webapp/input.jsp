<%--
  Created by IntelliJ IDEA.
  User: ZC Wang
  Date: 2019/9/10
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="add/add.action" method="post">
    输入num1：<input type="text" name="num1" /><br/>
    输入num2：<input type="text" name="num2"/><br/>
    <input type="submit" value="求和"/>
</form>
<div>${info}</div>
</body>

</html>
