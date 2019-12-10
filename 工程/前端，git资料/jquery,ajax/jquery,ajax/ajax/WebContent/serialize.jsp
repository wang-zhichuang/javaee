<%@ page pageEncoding="UTF-8"%>
<html>
  <head>
  <script src="js/jquery-1.11.1.js"></script>  
  <script>
  function f1(){
   $("#result1").text($("#form1").serialize());
  }
  function f2(){
  $("#result2").text(JSON.stringify($("#form1").serializeArray()));
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
 <input type="button" value="serialize序列化表单值" onclick="f1()">
 <input type="button" value="serializeArray序列化表单值" onclick="f2()">
 <div id="result1"></div>
 <div id="result2"></div>
 </body>
</html>


<!--   $.post("serialize",$("#form1").serialize(),function(data){
      $("#result1").html(data);
    }
    ); -->
