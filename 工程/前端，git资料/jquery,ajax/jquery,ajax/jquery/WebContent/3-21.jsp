<%@ page  pageEncoding="UTF-8"%>
<html><head>
<script src="js/jquery-1.11.1.js"></script>  
  <script>  
    var n=Math.floor(Math.random()*201);
    var count=0;
   $(function(){
    $("#num").focus();
    $("#num").keyup(function(event){
      if(event.keyCode ==13){
         var a=$("#num").val();
         count++;
         if (a<n)
           {$("#info").html(a+"too small");$("#num").val("");$("#num").focus();}
         else if(a>n)
            {$("#info").html(a+"too large");$("#num").val("");$("#num").focus();}
        else
           {$("#info").html("right,猜了"+count+"次.<a href='3-21.jsp'>再来一次</a>");}
      }
    });
   }
);
 </script>
</head>
<body>
<input type="text"  id="num"/>
<div id="info">程序随机产生了一个0-200间的整数，请猜一猜,键入数值后敲回车</div>
</body>

</html>
