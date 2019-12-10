<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<c:forEach items="${books}" var="book">
		${book}<br/>
</c:forEach>

</body>
</html>