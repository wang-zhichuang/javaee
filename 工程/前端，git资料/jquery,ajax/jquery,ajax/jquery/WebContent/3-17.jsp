<%@ page  pageEncoding="UTF-8"%>
<html><head>   
  <script src="js/jquery-1.11.1.js"></script>  
  <script>    
   function f1(){
    var div1=$("<div>div1</div>");
     $("body").append(div1);   
     //或者 div1.appendTo($("body"));
   }
    function f2(){
    var div2=$("<div id='div2'>div2</div>");
      $("body").prepend(div2);   
     //或者 div2.prependTo($("body"));
   }
    function f3(){
    var div3=$("<div id='div3'>div3</div>");
       $("#div2").before(div3);
       //或者div3.insertBefore(div2);
    }
    function f4(){
     var div4=$("<div>div4</div>");
     $("#div3").after(div4);  
     //或者 div4.insertAfter(div3); 
   }   
 </script>
</head>  
 <body> 
 <input type="button" value="在body里追加div1" onclick="f1()">
 <input type="button" value="在body里前置div2" onclick="f2()">
 <input type="button" value="在div2外前置div3" onclick="f3()">
 <input type="button" value="在div3外后置div4" onclick="f4()">
 </body>
</html>
