<%@ page  pageEncoding="UTF-8"%>
<html><head>
<script src="js/jquery-1.11.1.js"></script>  
<script type="text/javascript">
	 $(function(){
	      $(":text").attr("value","abc");     //给文本框添加文本
          $(":password").attr("value","123"); //给密码框添加文本
          $(":radio:eq(1)").attr("checked","true");    //将第2个单选按钮设置为选中
          $(":checkbox").attr("checked","true");       //将复选框全部选中
          $(":image").attr("src","image/submit.jpg"); //给图像指定路径
          $(":file").css("width","300px");            //给文件域设置宽度                    
          $("select").css("background","#FCF");          //给下拉列表设置背景色                             
          $("textarea").val("文本区域");      //给文本区域设置值                
   });    
</script></head>
<body>
	文本框<input type="text"/><br>
	密码框<input type="password"/><br>
	单选按钮<input type="radio" name="habbit" value="是"/>是
          <input type="radio" name="habbit" value="否"/>否<br>  
     复选框<input type="checkbox" name="hate" value="水果"/>水果
          <input type="checkbox" name="hate" value="蔬菜"/>蔬菜<br>    
     文件域<input type="file"/><br>       
     下拉菜单<select name="selectlist">
             <option value="选项一">选项一</option>
             <option value="选项二" >选项二</option>
             <option value="选项三">选项三</option>
           </select><br>
    多行文本框<textarea cols="70" rows="3"></textarea><br> 
    图片提交按钮<input type="image"/>
</body>
</html>
