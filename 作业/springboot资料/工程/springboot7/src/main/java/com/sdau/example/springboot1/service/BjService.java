package com.sdau.example.springboot1.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdau.example.springboot1.dao.BjDao;
@Service
@Transactional
public class BjService implements IBjService {
	@Resource
	BjDao bjDao;
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

         bjDao.deleteById(3);
         int a=10/0;
	}

}
