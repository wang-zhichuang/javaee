<%@ page  pageEncoding="UTF-8"%>
<html><head>
<script src="js/jquery-1.11.1.js"></script>  
<script type="text/javascript">
	 $(function(){
       $("#bt1").click(function(){
        $("div[id]").css("color","red");             
       });
       $("#bt2").click(function(){
        $("div[title='div2']").css("color","blue");              
       });  
        $("#bt3").click(function(){
        $("div[title!='div2']").css("color","green");              
       });   
         $("#bt4").click(function(){
        $("div[title^='div']").css("color","#00ffff");              
       });     
   });
</script></head>
<body>
	<div id="div1">div1</div>
	<div title="div2">div2 </div>
	<div id="div3" title="div3">div3 </div>
	<input type="button" id="bt1" value="设置包含属性id的元素的颜色"/>
    <input type="button" id="bt2" value="设置title属性值=div2的元素的颜色 "/>   
    <input type="button" id="bt3" value="设置title属性值!=div2的元素的颜色 "/> 
     <input type="button" id="bt4" value="设置title属性值以div开头的元素的颜色 "/>     
</body>
</html>
