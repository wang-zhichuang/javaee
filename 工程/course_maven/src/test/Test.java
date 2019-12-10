import dao.CourseMapper;
import entity.Course;
import org.apache.ibatis.session.SqlSession;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import util.SqlSessionFactoryUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        SqlSession session= SqlSessionFactoryUtil.openSession();

        CourseMapper courseDao = session.getMapper(CourseMapper.class);

        Map map = new HashMap<>();


        int recordCount=courseDao.recordCount(map);

        System.out.println(recordCount);
        map.put("startPage",0);
        map.put("pageSize",10);
        List<Course> courses = courseDao.queryByPageNo(map);

        System.out.println(courses);
    }
}
