package cn.oneseek.studentspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.oneseek.studentspringboot.dao")
public class StudentSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSpringbootApplication.class, args);
	}

}
