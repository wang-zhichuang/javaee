package cn.oneseek.studentspringboot.service;

import cn.oneseek.studentspringboot.vo.Bj;

import java.util.List;

public interface BjService{
    public List<Bj> queryAll();
    public void add(Bj bj);
    public Bj findById(int id);
    public void update(Bj bj);
    public void delete(int id);
}