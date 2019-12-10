<%@ page  pageEncoding="UTF-8"%>
<html>
  <head> 
  <script src="js/jquery-1.11.1.js"></script>  
  <script>
    $(function(){
       $("#bt1").click(function(){
        $("#d1 span").css("color","red");             
       });
        $("#bt2").click(function(){
        $("#d1>span").css("color","green");             
       });
        $("#bt3").click(function(){
        $("#d1+div").css("color","blue");             
       });
        $("#bt4").click(function(){
        $("#d1~div").css("color","gray");             
       });
   });
</script>
  </head>  
  <body>
   <div id="d1">d1  
    <span id="s1">s1
      <span id="s2">s2</span>
    </span>    
  </div>
  <div id="d2">d2</div>
  <div id="d3">d3</div>
  <br>
  <input type="button" id="bt1" value="改变#d1 span文字颜色 "/>
  <input type="button" id="bt2" value="改变#d1>span文字颜色 "/>
  <input type="button" id="bt3" value="改变#d1+div文字颜色 "/>
  <input type="button" id="bt4" value="改变#d1~span文字颜色 "/>
</body>
</html>
