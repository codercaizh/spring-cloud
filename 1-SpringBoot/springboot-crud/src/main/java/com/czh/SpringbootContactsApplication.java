package com.czh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 入口类
 * @author caizh
 *
 */
@SpringBootApplication
@EnableCaching
public class SpringbootContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootContactsApplication.class, args);
	}
}
