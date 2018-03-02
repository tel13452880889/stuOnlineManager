package com.hq.student.stuManager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//这里是扫描dao接口的包用于识别mybatis
//mapper 加载
@MapperScan(basePackages="com.hq.student.stuManager.domain.mapper")
public class StuOnlineManApplication {
	public static void main(String[] args) {
		SpringApplication.run(StuOnlineManApplication.class, args);
	}
}
