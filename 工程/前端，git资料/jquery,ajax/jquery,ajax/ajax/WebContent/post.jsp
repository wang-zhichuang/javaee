<%@ page pageEncoding="UTF-8"%>
<html>
  <head>
  <script src="js/jquery-1.11.1.js"></script>  
  <script>
   function postF(){
   //执行servlet的post方法
     $.post("post",{"p":"呵呵"},function(data,status){
      $("#div1").html("数据为："+data+"，状态为"+status);
     });  
   }
</script> 
  </head>  
  <body>
    <input type="button" value="post方式请求数据" onclick="postF()">
    <div id="div1"></div>
  </body>
</html>
