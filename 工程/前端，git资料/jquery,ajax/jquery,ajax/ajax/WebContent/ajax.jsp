<%@ page pageEncoding="UTF-8"%>
<html>
  <head>
  <script src="js/jquery-1.11.1.js"></script>  
  <script>
    function ajaxF(){
     //执行servlet的post方法
     $.ajax({
     url:"post",
     type:"post",
     data:{"p":"jsp程序设计"},
     success:function(data,status){
       $("#div1").html("数据为："+data+"，状态为"+status);
     }
     });  
   }
</script> 
  </head>  
  <body>
    <input type="button" value="ajax方式请求数据" onclick="ajaxF()">
    <div id="div1"></div>
  </body>
</html>
