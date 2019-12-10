package test;

import java.util.List;

import org.junit.Test;

import util.JdbcUtil;
import vo.Column;

public class MetaDataTest {
@Test
//获取数据库下所有的表名
	public void test1() throws Exception {		

		List<String> tableList=JdbcUtil.getTables();
		for(String tableName:tableList) {
			System.out.println(tableName);
		}
	}
@Test
//获取指定表的所有字段名及类型
public void test2() throws Exception {		

	List<Column>  columnList=JdbcUtil.getColumns("student");
	for(Column c:columnList) {
		System.out.println(c);
	}
}
}
