<%@ page  pageEncoding="UTF-8"%>
<html><head>   
  <script src="js/jquery-1.11.1.js"></script>  
  <script>    
   function f1(){
    $("#div1").replaceWith("<div>new div1</div>");
   }
    function f2(){
    $("<div>new div2</div>").replaceAll($("#div2"));
   }    
 </script></head>  
 <body> 
 <div id="div1">div1</div>
 <div id="div2">div2</div>
 <input type="button" value="用replaceWith替换div1" onclick="f1()">
 <input type="button" value="用replaceAll替换div2" onclick="f2()">
 
 </body>
</html>
