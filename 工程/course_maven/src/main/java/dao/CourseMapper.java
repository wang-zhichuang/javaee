package dao;

import entity.Course;

import java.util.List;
import java.util.Map;

public interface CourseMapper {

    List<Course> queryByPageNo(Map map);

    int recordCount(Map map);
}