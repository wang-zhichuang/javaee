<%@ page  pageEncoding="UTF-8"%>
<html>
<body>
<h2>从 JSON 对象中创建 JavaScript 对象</h2>
<p id="demo"></p>
<script>
var jsonStr='{"name":"runoob1", "alexa":10000, "site":"www.runoob.com" }';
//var obj = eval("("+jsonStr+")");
  var obj = JSON.parse(jsonStr);
document.getElementById("demo").innerHTML = obj.name + "：" + obj.site;
</script>
</body>
</html>
