<%@ page  pageEncoding="UTF-8"%>
<html><head>   
  <script src="js/jquery-1.11.1.js"></script>  
  <script>     
   function f1(){
     var a=$("#t1").val();
     alert(a);
   }
 </script>
</head>  
 <body> 
 <input type="text" id="t1"/>
 <input type="submit" value="提交" onclick="f1()">
 </body>
</html>