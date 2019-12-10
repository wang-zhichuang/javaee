package test;

import util.FreemarkerUtil;
import util.JdbcUtil;
import vo.Book;
import vo.Column;
import vo.Course;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
//       test1();
       test2();
//        testFreeMarkerTest();
    }

    public static void test1() throws Exception {
        List<String> tableList=JdbcUtil.getTables();
        for(String tableName:tableList) {
            System.out.println(tableName);
        }
    }

    public static void test2() throws Exception {
        List<Column> columnList= JdbcUtil.getColumns("course");
        for(Column c:columnList) {
            System.out.println(c);
        }
    }

    public static void testFreeMarkerTest() throws Exception {
        //FreemarkerUtil util = FreemarkerUtil.getInstance("/ftl"); // ftl目录建立在src下,为模板文件目录
        FreemarkerUtil util = FreemarkerUtil.getInstance(new File("d:/template"));//模板文件在d盘template目录下
        Map<String, Object> root = new HashMap<String, Object>();
        String fn = "d:/";//输出路径
        root.put("username", "abc");
        root.put("userpwd", "123");
        Book book=new Book();
        book.setAuthor("张三");
        root.put("book1",book);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("c1", "序号" + i);
            map.put("c2", "内容" + i);
            list.add(map);
        }

        Course course = new Course();
        root.put("alist", list);
        List<Book> bookList=new ArrayList<Book>();
        bookList.add(new Book("bookid1","bookname1","author1"));
        bookList.add(new Book("bookid2","bookname2","author2"));
        root.put("blist", bookList);
        util.sprint(root, "hello.ftl");//输出到console
        util.fprint(root, "hello.ftl", fn + "1.txt");//输出到文件
    }
}
