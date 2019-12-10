<%@ page  pageEncoding="UTF-8"%>
<html><head>   
  <script src="js/jquery-1.11.1.js"></script>  
  <script>
    $(function(){
      $("li").each(function(index){
        if(index%2==1){
          $(this).css("color","red");
        }
      });
   });
</script>
</head>  
 <body>
 <ul>
 <li>item1</li><li>item2</li><li>item3</li>
 <li>item4</li><li>item5</li><li>item6</li>
 </ul>
 </body>
</html>
