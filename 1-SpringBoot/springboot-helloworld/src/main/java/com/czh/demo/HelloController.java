package com.czh.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * helloworld控制器
 * @author caizh
 *
 */
//RestController注解表明该控制器是一个Rest风格控制器，方法返回的对象会序列化成JSON
@RestController
public class HelloController {
	
	//GetMapping注解表明该方法只处理来自路径为"/hello"的GET请求
	@GetMapping("/hello")
	public Map helloWorld() {
		Map hello = new HashMap(1);
		hello.put("SpringBoot", "HelloWorld");
		return hello;
	}
}
