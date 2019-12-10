<%@ page  pageEncoding="UTF-8"%>
<html><head>   
  <script src="js/jquery-1.11.1.js"></script>  
  <script>    
    $(function(){
       $("#bt1").click(function(){      
         $("li").remove();
      });   
       $("#bt2").click(function(){      
         $("li").empty();
      });   
   }); 
</script>
</head>  
 <body>
 <ul>
 <li>item1</li><li>item2</li><li>item3</li>
 <li>item4</li><li>item5</li><li>item6</li>
 </ul>
 <input type="button" id="bt1" value="移除li元素"/>
 <input type="button" id="bt2" value="清空li元素"/>
 </body>
</html>
