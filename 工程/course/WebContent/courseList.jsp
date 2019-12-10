<%@ page  pageEncoding="UTF-8" import="dao.CourseDao,entity.Course,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
  body{
      text-align:center;
  }
  th,td{
  border:2px solid gray;
  text-align:center;
  padding:3px 10px;
  }
  table{
  border-collapse:collapse; 
  margin:0 auto;
  }
 </style>
 <script>

 function jump1(pageNo){
   document.getElementById("pageNo").value=pageNo;
   document.getElementById("form11").submit();
 }
 function qc(){
	
	  document.getElementById("kcm").value="";
	  document.getElementById("sksj").value="";
	  document.getElementById("skdd").value="";
	  document.getElementById("rkjs1").value="";
 }
 </script>
 <style>
 .odd{
 background-color:#E0EEEE;
 }
 </style>
</head>

<body>
 <h2>课程表分页查询</h2>
  <%
  int recordCount=(Integer)request.getAttribute("recordCount");
  if (recordCount==0){
     out.print("<br/><br/>无记录");
     return;
  }
   %>
 <form action="courseQuery" method="post" id="form11" >
   课程名<input name="kcm" value="${param.kcm}" id="kcm">
 上课时间<input name="sksj" value="${param.sksj}" id="sksj">
 上课地点<input name="skdd" value="${param.skdd}" id="skdd">
 任课教师<input name="rkjs1" value="${param.rkjs1}" id="rkjs1">
 <input type="hidden" name="pageNo" id="pageNo" value="1"/>
<input type="submit" value="查询"/>
<input type="button" value="清除" onclick="qc()"/>
</form>
  
  <table>
  <tr>
  <th>学院</th><th>课序号</th><th>课程号</th><th>课程名</th><th>任课教师</th>
  <th>上课时间</th><th>上课周次</th><th>上课地点</th><th>班级</th><th>年级</th><th>校区</th></tr>
   <c:forEach items="${courseList}" var="course" varStatus="status">
  <tr <c:if test="${status.index%2==0}">class="odd"</c:if>>
   
   <td>${course.xy}</td>
   <td>${course.kxh}</td>
   <td>${course.kch}</td>
   <td>${course.kcm}</td>
   <td>${course.rkjs1}</td>
   <td>${course.sksj}</td>  
    <td>${course.skzc}</td>
   <td>${course.skdd}</td>
   <td>${course.bj}</td>
   <td>${course.nj}</td>
   <td>${course.xq}</td>  
  </tr>
 </c:forEach>
   </table>
 共有记录${recordCount}条， 第${pageNo}/${pageCount}页，
<c:if test="${pageNo>1}">
 <a href="javascript:jump1('1')">首页</a>
 <a href="javascript:jump1('${pageNo-1}')">上页</a>
</c:if>
<c:if test="${pageNo==1}">
  首页  上页
</c:if>

 <c:if test="${pageNo<pageCount}">
   <a href="javascript:jump1('${pageNo+1}')">下页</a>
   <a href="javascript:jump1('${pageCount}')">末页</a>
</c:if>
 <c:if test="${pageNo==pageCount}">
   下页   末页
</c:if>
 
 <br>

 
 
</body>
</html>
