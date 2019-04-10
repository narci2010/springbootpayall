/*  
 * Copyright 2010-2017 Tocean Group.  
 * 版权：商业代码，未经许可，禁止任何形式拷贝、传播及使用
 * 文件名：Application.java
 * 描述：  
 * 修改人： Narci.Lee  
 * 修改时间：2017年11月22日  
 * 跟踪单号：  
 * 修改单号：  
 * 修改内容：  
 */
package com.toceansoft;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Narci.Lee
 * 
 *         支付主控 可以作为一个支付的微服务，也可以作为一个中间件在项目中直接引入
 */
// @EnableDubboConfiguration
@SpringBootApplication
// @ImportResource({"classpath:spring-context-dubbo.xml"})
@Controller
public class Application extends WebMvcConfigurerAdapter {
	private static final Logger logger = Logger.getLogger(Application.class);

	@RequestMapping("/")
	public String greeting() {
		return "index";
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/cert/**").addResourceLocations("classpath:/cert/");
		super.addResourceHandlers(registry);
		logger.info("自定义静态资源目录,这只是个Demo,生产肯定不会暴露");
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		SpringApplication.run(Application.class, args);
		logger.info("支付项目启动 ");
	}

}