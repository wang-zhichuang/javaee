<%@ page  pageEncoding="UTF-8"%>
<html><head>
<script src="js/jquery-1.11.1.js"></script>  
<script type="text/javascript">
	 $(function(){
	   $("#bt1").click(function(){
       $("#div1").html("性别选择结果为:"+$(":radio:checked").val());   
       $("#div2").html("爱好选择结果为:"); 
       $.each($(":checkbox:checked"),function(){
           $("#div2").html($("#div2").html()+$(this).val()+" ");
       }
       );     
       $("#div3").html("专业选择结果为:"+$(":selected").text());      
       });
                 
   });
</script></head>
<body>
	<form id="form1">
	 性别：男<input type="radio" value="男" name="sex" checked/>
	 女<input type="radio" value="女" name="sex"/><br>
	 爱好：音乐<input type="checkbox" name="aihao" value="音乐"/>
	 读书<input type="checkbox" name="aihao" value="读书"/>
	 运动<input type="checkbox" name="aihao" value="运动"/><br>
	 专业：<select>
	  <option>计算机</option>
	  <option>网络工程</option>
	  <option>物联网</option>
	 </select>
	</form>
	<input type="button" id="bt1" value="获取选择结果"/>
    <div id="div1"></div>
    <div id="div2"></div>
    <div id="div3"></div>
</body>
</html>
