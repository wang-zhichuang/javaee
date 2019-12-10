<%@ page pageEncoding="UTF-8"%>
<html>
  <head>
  <script src="js/jquery-1.11.1.js"></script>  
  <script>
   function getF(){
   //执行servlet的get方法
     $.get("get",{"p":"abc"},function(data,status){
      $("#div1").html("数据为："+data+"，状态为"+status);
     });  
   }
</script> 
  </head>  
  <body>
    <input type="button" value="get方式请求数据" onclick="getF()">
    <div id="div1"></div>
  </body>
</html>
