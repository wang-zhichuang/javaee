<%@ page  pageEncoding="UTF-8"%>
<html> 
<head>
<script type="text/javascript" src="js/ajax.js"></script>
<script>
function query(){
 sendRequest("query",null,'POST',show);
}
 function show(){        
   if (httpRequest.readyState == 4) { 
      if (httpRequest.status == 200) {
           var tBody=document.getElementById("tBody");
           tBody.innerHTML="";
            var studentList=JSON.parse(httpRequest.responseText);           
            for(var index in studentList){               
               var newTr=tBody.insertRow();
               var newTd1=newTr.insertCell();newTd1.innerHTML=studentList[index].sno;
               var newTd2=newTr.insertCell();newTd2.innerHTML=studentList[index].sname;
               var newTd3=newTr.insertCell();newTd3.innerHTML=studentList[index].sex;
             }
            }
       }
   }
</script>
<style>
table,th,td{
border:1px solid red;
padding:10px;
}
table{
border-collapse:collapse;
margin:0 auto;
}
body{
text-align:center;
}
</style>
</head>
 <body>
  <a href="javascript:query()">获取表格数据</a>
  <br/><br/>
  <table id="studentTable">
   <tr><th>学号</th><th>姓名</th><th>性别</th></tr>
   <tbody id="tBody">
   </tbody>
  </table>
 </body>
</html>
