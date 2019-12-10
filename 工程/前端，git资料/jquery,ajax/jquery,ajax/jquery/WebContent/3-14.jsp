<%@ page  pageEncoding="UTF-8"%>
<html><head> 
  <style>
  .b{
  font-weight:bold;
  }
  .bgcolor{
  background-color:blue;
  }
  .frontcolor{
    color:red;
  }
  .fontsize{
    font-size:40px;
  }
  </style>
  <script src="js/jquery-1.11.1.js"></script>  
  <script>
    $(function(){
       $("p").click(function(){      
         $(this).toggleClass("b");
       }); 
       $("#div1").click(function(){      
         $(this).addClass("bgcolor frontcolor");
       });  
        $("#div2").click(function(){      
         $(this).removeClass("fontsize");
       }); 
   });
</script>
  </head>  
  <body>
 <p>点击我实现加粗与否的切换</p>
 <div id="div1">点击我加蓝色背景颜色，文字颜色为红色</div>
  <div id="div2" class="fontsize">点击我去除字体40px的设置</div>
 </body>
</html>
