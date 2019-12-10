<%@ page  pageEncoding="UTF-8"%>
<html>
  <head> 
  <script src="js/jquery-1.11.1.js"></script>  
  <script>
    $(function(){
       $("#bt1").click(function(){
       var temp=$("img:eq(0)").attr("src");
       $("img:eq(0)").attr("src",$("img:eq(1)").attr("src"));
       $("img:eq(1)").attr("src",temp);
    });
   });
</script>
  </head>  
  <body>
   <img src="image/pic1.jpg"/>
   <img src="image/pic2.jpg"/>
   <input type="button" value="交换" id="bt1"/>  
  </body>
</html>
