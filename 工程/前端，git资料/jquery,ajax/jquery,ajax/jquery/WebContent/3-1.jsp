<%@ page  pageEncoding="UTF-8"%>
<html>
  <head> 
  <script src="js/jquery-1.11.1.js"></script>  
  <script>
    $(function(){
       $("p").click(function(){
       $(this).hide();
    });
   });
</script>
  </head>  
  <body>
   <p>如果你点我，我就会消失。</p>    
  </body>
</html>
