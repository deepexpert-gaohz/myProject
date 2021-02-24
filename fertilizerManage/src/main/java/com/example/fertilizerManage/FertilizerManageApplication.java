package com.example.fertilizerManage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.fertilizerManage.mapper")
public class FertilizerManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(FertilizerManageApplication.class, args);
	}

}
