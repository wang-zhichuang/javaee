<%@ page  pageEncoding="UTF-8"%>
<html>
<head> 
<title>图片预览与数据删除应用</title>
<script src="js/jquery-1.11.1.js"></script> 
<style type="text/css">
  table{width:360px;border-collapse:collapse; text-align:center;font-size:12px;}
  table th,td{border:solid 1px #666;}
  table span{float:left;padding-left:12px;}
  table th{background-color:#ccc;height:32px}
  table img{border:solid 1px #ccc;padding:3px;width:42px;height:60px;}
  .clsImg{position:absolute;border:solid 1px #ccc;padding:3px;width:85px;height:120px;display:none}
</style>
<script type="text/javascript" >
$(function() {
$("table tr:nth-child(odd)").css("background-color", "#eee"); //隔行变色
  /**全选复选框单击事件**/
  $("#chkAll").click(function() {	
	  $("table tr td input[type=checkbox]").attr("checked", this.checked);	
  })
  /**删除按钮单击事件**/
  $("#btnDel").click(function() {
	var intL = $("table tr td input:checked:not('#chkAll')").length; //获取除全选复选框外的所有选中项
	if (intL != 0) {//如果有选中项
	  $("table tr td input[type=checkbox]:not('#chkAll')").each(function(index) {//遍历除全选复选框外的行
		if (this.checked) {//如果选中
		  $("table tr[id=" + this.value + "]").remove(); //获取选中的值，并删除该值所在的行
		}
	  })
	}
  })
  /**小图片鼠标移动事件**/
  var x = 5; var y = 15;//初始化提示图片位置
  $("table tr td img").mousemove(function(e) {
	$("#imgTip")
	.attr("src", this.src)//设置提示图片scr属性
	.css({ "top": (e.pageY + y) + "px", "left": (e.pageX + x) + "px" })//设置提示图片的位置
	.show(2000);//显示图片
  })
  /**小图片鼠标移出事件**/
  $("table tr td img").mouseout(function() {
	$("#imgTip").hide();//隐藏图片
  })
})
</script>
</head>
<body>
<table>
  <tr>
    <th>选项</th>
    <th>编号</th>
    <th>封面</th>
    <th>购书人</th>
    <th>性别</th>
    <th>购书价</th>
  </tr>
  <tr id="0">
    <td><input id="Checkbox1" type="checkbox" value="0"/></td>
    <td>1001</td>
    <td><img src="image/img01.jpg" alt="" /></td>
    <td>张三</td>
    <td>男</td>
    <td>35.60 元</td>
  </tr>
  <tr id="1">
    <td><input id="Checkbox2" type="checkbox" value="1"/></td>
    <td>1002</td>
    <td><img src="image/img02.jpg" alt="" /></td>
    <td>李四</td>
    <td>女</td>
    <td>37.80 元</td>
  </tr>
  <tr id="2">
    <td><input id="Checkbox3" type="checkbox" value="2"/></td>
    <td>1003</td>
    <td><img src="image/img03.jpg" alt="" /></td>
    <td>王五</td>
    <td>女</td>
    <td>45.60 元</td>
  </tr>
</table>
<table>
  <tr>
    <td style="text-align:left;height:28px">
      <span><input id="chkAll" type="checkbox" />全选</span>
      <span><input id="btnDel" type="button" value="删除" class="btn" /></span>
    </td>
  </tr>
</table>
<img id="imgTip" class="clsImg"/>
</body>
</html>