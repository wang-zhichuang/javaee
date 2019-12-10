<%@ page pageEncoding="UTF-8"%>
<html>
  <head>
  <script src="js/jquery-1.11.1.js"></script>  
  <script>
   function jiazai(){
     $("#div1").load("load",{"p":"jsp程序设计"});  
   }
</script> 
  </head>  
  <body>
    <input type="button" value="加载数据" onclick="jiazai()">
    <div id="div1"></div>
  </body>
</html>
