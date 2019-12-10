package service.impl;

import dao.BjDao;
import org.springframework.stereotype.Service;
import service.BjService;
import vo.Bj;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "bjService")
public class BjServiceImpl implements BjService {
    @Resource
    private BjDao bjDao;

    @Override
    public List<Bj> queryAll() {
        return bjDao.queryAll();
    }

    @Override
    public void add(Bj bj) {
        bjDao.add(bj);
    }

    @Override
    public Bj findById(int id) {
        return bjDao.findById(id);
    }

    @Override
    public void update(Bj bj) {
        bjDao.update(bj);
    }

    @Override
    public void delete(int id) {
        bjDao.delete(id);
    }
}
