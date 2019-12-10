import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vo.Student;
public class JsonlibTest {
public static void main(String[] args){
	Student student1=new Student("20181234","张三","男");
	System.out.print("将student1对象转换成json字符串:");
	JSONObject jso1=JSONObject.fromObject(student1);
	System.out.println(jso1.toString());
	
	System.out.print("将studentList1对象转换成json字符串:");
	Student student2=new Student("20185678","李四","女");
	List<Student> studentList1=new ArrayList<Student>();
	studentList1.add(student1);studentList1.add(student2);
	JSONArray jsa1=JSONArray.fromObject(studentList1);	
	System.out.println(jsa1.toString());
	
	System.out.print("将Map转换为json字符串:");
	Map<String,String> map1=new HashMap<String,String>();
	map1.put("sno", "20181111");
	map1.put("sname","王五");
	map1.put("sex","男");
	JSONObject jso2=JSONObject.fromObject(map1);	
	System.out.println(jso2.toString());
	
	System.out.print("将json字符串转换成student3对象:");
	String jsonStr1="{'sex':'男','sname':'张三','sno':'20181234'}";
	JSONObject jso3=JSONObject.fromObject(jsonStr1);
	Student student3=(Student)JSONObject.toBean(jso3,Student.class);
	System.out.println(student3);
	
	System.out.print("将json字符串转换成studentList2对象:");
	String jsonStr2="[{'sex':'男','sname':'张三','sno':'20181234'},{'sex':'女','sname':'李四','sno':'20185678'}]";
	JSONArray jsa2=JSONArray.fromObject(jsonStr2);
	List<Student> studentList2=(List<Student>)JSONArray.toCollection(jsa2,Student.class);
	for(Student student:studentList2){
		System.out.print(student+";");			
	}
	
}
}
