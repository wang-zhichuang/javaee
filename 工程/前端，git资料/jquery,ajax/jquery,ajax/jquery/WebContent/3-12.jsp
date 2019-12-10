<%@ page  pageEncoding="UTF-8"%>
<html>
  <head> 
  <script src="js/jquery-1.11.1.js"></script>  
  <script>
    $(function(){
       $("#bt1").click(function(){
       var a=$("#div1").html();
       var b=$("#div1").text();
       alert("div1的html（）值为"+a+"\n"+"div1的text（）值为"+b);
    });
    $("#bt2").click(function(){
       var a=$("#div1").html();
       $("#div1").html("<b>"+a+"</b>");
    });
   });
</script>
  </head>  
  <body>
   <div id="div1">div1<span>span1</span></div>
   <input type="button" value="显示html（）和val（）结果" id="bt1"/>  
   <input type="button" value="div内容加粗" id="bt2"/>  
  </body>
</html>
