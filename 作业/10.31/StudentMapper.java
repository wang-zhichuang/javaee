package cn.oneseek.student.dao;

import cn.oneseek.student.entity.Student;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> queryAll();

    List<Student> queryAllWithBj();

    void add(Student student);
}