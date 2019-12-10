<%@ page  pageEncoding="UTF-8"%>
<html>
  <head> 
  <script src="js/jquery-1.11.1.js"></script>  
  <script>
    $(function(){
       $("#xz").click(function(){
        $(".c1").attr("checked",this.checked);             
    });
   });
</script>
  </head>  
  <body>
  <table border="1">
  <tr><td><input type="checkbox" id="xz"/></td><td>列标题</td></tr>
  <tr><td><input type="checkbox" class="c1"/></td><td>记录1</td></tr>
  <tr><td><input type="checkbox" class="c1"/></td><td>记录2</td></tr>
  <tr><td><input type="checkbox" class="c1"/></td><td>记录3</td></tr>
  </table>
</body>
</html>
