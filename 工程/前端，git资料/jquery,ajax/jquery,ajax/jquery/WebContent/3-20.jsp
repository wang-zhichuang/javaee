<%@ page  pageEncoding="UTF-8"%>
<html><head>   
  <script src="js/jquery-1.11.1.js"></script>  
  <script>    
   function f1(){
      $("#li1").wrap("<strong></strong>");    
    }
    function f2(){
      $(".li2").wrapAll("<strong></strong>");
    
    }
    function f3(){
     $("#li4").wrapInner("<strong></strong>");
    
    }   
 </script>
</head>  
 <body> 
 <ul>
 <li id="li1">Item1</li>
 <li class="li2">Item2</li>
 <li class="li2">Item3</li>
 <li id="li4">Item4</li>
 </ul>
 <input type="button" value="wrap item1" onclick="f1()"/>
 <input type="button" value="wrapAll类别为li2的元素" onclick="f2()"/>
 <input type="button" value="wrapInner item4" onclick="f3()"/> 
 </body>
</html>
