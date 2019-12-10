package com.sdau.example.springboot1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement //支持事务，可以不写
@SpringBootApplication
public class Springboot1Application {
	@Bean   //查看事务管理器类
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }
	public static void main(String[] args) {
		//SpringApplication.run(Springboot1Application.class, args);
	}
}
