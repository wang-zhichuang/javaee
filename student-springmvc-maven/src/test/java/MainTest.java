import cn.oneseek.student.dao.BjMapper;
import cn.oneseek.student.entity.Bj;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MainTest {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        List<Bj> bjList = session.selectList("cn.oneseek.student.dao.BjMapper.queryAll");
        System.out.println(bjList);
        session.close();
    }
}
