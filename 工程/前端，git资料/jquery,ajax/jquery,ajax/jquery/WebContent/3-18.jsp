<%@ page  pageEncoding="UTF-8"%>
<html><head>   
  <script src="js/jquery-1.11.1.js"></script>  
  <script>    
    $(function(){
       $("img").click(function(){      
          $(this).clone(true).appendTo($("span"));         
      });        
   }); 
 </script>
</head>  
 <body> 
 <span><img src="image/pic1.jpg">
 </span>
 </body>
</html>