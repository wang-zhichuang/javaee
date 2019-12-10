<%@ page  pageEncoding="UTF-8"%>
<html><head>
<script src="js/jquery-1.11.1.js"></script>  
<script type="text/javascript">
	 $(function(){
       $("#bt1").click(function(){
        $("div:hidden").show();             
       });
       $("#bt2").click(function(){
        $("div:visible").hide();             
       });      
   });
</script></head>
<body>
	<div style="display:none">div1</div>
	<div>div2</div>	
	<input type="button" id="bt1" value="显示隐藏元素"/>
    <input type="button" id="bt2" value="隐藏可见元素 "/>    
</body>
</html>
