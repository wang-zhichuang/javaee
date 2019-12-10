<%@ page  pageEncoding="UTF-8"%>
<html>
<head>
<script src="js/jquery-1.11.1.js"></script>  
<script type="text/javascript">
	 $(function(){
       $("#bt1").click(function(){
        $("div:contains('A')").css("color","red");             
       });
       $("#bt2").click(function(){
        $("div:empty").html("div4");             
       });
       $("#bt3").click(function(){
        $("div:has(span)").html("div2");             
       });
       $("#bt4").click(function(){
        $("div:parent").css("color","blue");             
       });
   });
</script>
</head>
<body>
	<div>ABCD</div>
	<div><span></span></div>
	<div>EFaH</div>
	<div></div>
	<input type="button" id="bt1" value="设置div:contains('A')字体颜色"/>
    <input type="button" id="bt2" value="设置div:empty标签体内容 "/>
    <input type="button" id="bt3" value="设置div:has(span)标签体内容 "/>
    <input type="button" id="bt4" value="设置div:parent文字颜色 "/>
</body>
</html>
