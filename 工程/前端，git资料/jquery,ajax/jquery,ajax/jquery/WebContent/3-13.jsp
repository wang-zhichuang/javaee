<%@ page  pageEncoding="UTF-8"%>
<html>
  <head> 
  <script src="js/jquery-1.11.1.js"></script>  
  <script>
    $(function(){
       $("#bt1").click(function(){      
       alert($("select").val().join("."));
    });   
   });
</script>
  </head>  
  <body>
  <select size="5" multiple>
   <option>option1</option>
   <option>option2</option>
   <option>option3</option>
   <option>option4</option>
   <option>option5</option>
 </select>
 <input type="button" value="获取列表框中选择的多个值" id="bt1"/>     
 </body>
</html>
