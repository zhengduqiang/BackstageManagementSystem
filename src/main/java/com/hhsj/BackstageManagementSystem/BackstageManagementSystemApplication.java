package com.hhsj.BackstageManagementSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hhsj.BackstageManagementSystem.dao")
@SpringBootApplication
public class BackstageManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackstageManagementSystemApplication.class, args);
	}

}
