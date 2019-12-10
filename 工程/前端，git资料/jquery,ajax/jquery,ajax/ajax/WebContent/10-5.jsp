<%@ page pageEncoding="UTF-8"%>
<html>
  <head>
  <script src="js/jquery-1.11.1.js"></script>  
  <script>
  function add(){
   $.post("add",$("#form1").serialize(),function(data){
      $("#result").text(data);
    }
    );
  }
  
</script> 
  </head>  
  <body>
  <form id="form1">
    学号: <input type="text" name="sno"  /><br>
    姓名: <input type="text" name="sname"  /><br>
    性别: 男<input type="radio" name="sex" value="男" checked />
    女<input type="radio" name="sex" value="女" />
    <br>
 </form>
 <input type="button" value="添加记录" onclick="add()"> 
 <div id="result"></div> 
 </body>
</html>



