package cn.oneseek.student.dao;

import cn.oneseek.student.entity.Bj;

import java.util.List;

public interface BjMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bj record);

    int insertSelective(Bj record);

    Bj selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bj record);

    int updateByPrimaryKey(Bj record);

    public Bj findById(int id);

    List<Bj> queryAll();
}