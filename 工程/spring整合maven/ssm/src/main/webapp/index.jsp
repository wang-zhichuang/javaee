<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/bank/transfer.do"method="post">
账户<input type="text" name="account1">向账户
<input type="text" name="account2">转账<input type="text" name="count">元
<input type="submit" value="提交"/>
</form>
${msg}
</body>
</html>