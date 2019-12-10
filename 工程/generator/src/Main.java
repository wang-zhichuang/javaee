import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.FreemarkerUtil;
import util.JdbcUtil;
import util.PropertyUtil;
import vo.Book;
import vo.Column;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
/* FreeMarker基本思想：模板+数据=输出
 * generator.properties为生成器参数
 * FreemarkerUtil是处理模板文件产生输出的工具类，JdbcUtil是读取数据库表数据的工具类
 * test包下是对上面两个工具类的测试实例
 * step1:编写实体类的模板文件（vo.ftl）。（放在d:/template下）
 * step2：调用JdbcUtil获得表信息，为模板准备好数据（Map）。
 * step3:调用FreemarkerUtil输出vo类源代码到指定位置。（d:/output）
 */
	String tableName=PropertyUtil.get("tableName");
	String pk=PropertyUtil.get("package");	
	String templateDir=PropertyUtil.get("templateDir");
	String outputDir=PropertyUtil.get("outputDir");
	FreemarkerUtil util = FreemarkerUtil.getInstance(new File(templateDir));//模板文件在d盘template目录下
	List<String> tableList;
	if("*".equals(tableName)) {//数据库下所有表都生成实体类
		tableList=JdbcUtil.getTables();
	}
	else {//逗号隔开的表生成实体类
		tableList=new ArrayList<String>();
		String[] tableNames=tableName.split(",");
		for(String tn:tableNames) {

			tableList.add(tn);
		}

	}

	for(String tn:tableList) {//对要求的每个表生成实体类，tn为表名
		
		Map<String, Object> root = new HashMap<String, Object>();
		//准备数据


		List<Column> properties = JdbcUtil.getColumns(tn);
		for(Column c:properties) {
			System.out.println(c);
		}

		String fn = "d:/";//输出路径 generator.properties已配置 outputDir
		root.put("package", pk); // 包名
		root.put("className", tn); // 类名 表名
		root.put("properties", properties); // 属性
		tn = tn.substring(0, 1).toUpperCase()+tn.substring(1);// 文件名首字母大写
		util.fprint(root, "vo.ftl", outputDir+"/"+tn+".java");//输出到文件，tn为类名
	}
	
}

}
