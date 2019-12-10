<%@ page  pageEncoding="UTF-8"%>
<html>
<head>
<script src="js/jquery-1.11.1.js"></script>  
<script type="text/javascript">
	$(function(){	
	$("tr:even").css("background","gray");
	$("tr:odd").css("background","white");
	$("tr").first().css("background","red");
	});
</script>
</head>
<body>
	<table>
		<tr>
			<th>Product</th>
			<th>Description</th>
			<th>Price</th>
		</tr>
		<tr>
			<td>Paper Towels</td>
			<td>The most absorbent paper towels.</td>
			<td>$18.99</td>
		</tr>
		<tr>
			<td>Paper Napkins</td>
			<td>Perfect for your outdoor gathering.</td>
			<td>$16.99</td>
		</tr>
		<tr>
			<td>Paper Plates</td>
			<td>The best value.</td>
			<td>$5.99</td>
		</tr>
		<tr>
			<td>Plastic Forks</td>
			<td>The essential picnic accessory.</td>
			<td>$2.99</td>
		</tr>
	</table>
</body>
</html>
