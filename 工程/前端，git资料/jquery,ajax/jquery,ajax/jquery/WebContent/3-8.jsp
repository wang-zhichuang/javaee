<%@ page  pageEncoding="UTF-8"%>
<html><head>
<script src="js/jquery-1.11.1.js"></script>  
<script type="text/javascript">
	 $(function(){
	   $("#bt1").click(function(){
        $("li:nth-child(1)").css("color","red");             
       });
       $("#bt2").click(function(){
        $("li:eq(1)").css("color","blue");             
       });
        $("#bt3").click(function(){
        $("li:nth-child(even)").css("color","green");             
       });
       $("#bt4").click(function(){
        $("li:nth-child(3n+1)").css("color","#00ffff");              
       });  
        $("#bt5").click(function(){
        $("li:last-child").css("color","#ff00ff");              
       });   
         
   });
</script></head>
<body>
	<ul>
	 <li>Item1</li><li>Item2</li><li>Item3</li><li>Item4</li><li>Item5</li>
	</ul>
	<input type="button" id="bt1" value="设置li:nth-child(1)元素的颜色"/>
    <input type="button" id="bt2" value="设置li:eq(1)元素的颜色 "/>   
    <input type="button" id="bt3" value="设置li:nth-child(even)元素的颜色 "/> 
    <input type="button" id="bt4" value="设置li:nth-child(3n+1)元素的颜色 "/>  
    <input type="button" id="bt5" value="设置li:last-child元素的颜色 "/>     
</body>
</html>
