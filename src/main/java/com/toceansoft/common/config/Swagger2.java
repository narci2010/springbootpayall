/*  
 * Copyright 2010-2017 Tocean Group.  
 * 版权：商业代码，未经许可，禁止任何形式拷贝、传播及使用
 * 文件名：Swagger2.java
 * 描述：  
 * 修改人： Narci.Lee  
 * 修改时间：2017年11月22日  
 * 跟踪单号：  
 * 修改单号：  
 * 修改内容：  
 */
package com.toceansoft.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
	@Bean
	public Docket webApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("支付后台API接口文档").apiInfo(apiInfo())
				.select().apis(RequestHandlerSelectors.basePackage("com.toceansoft.modules.web"))
				.paths(PathSelectors.any()).build();
	}

	@Bean
	public Docket alipayApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("支付宝API接口文档").apiInfo(apiInfo())
				.select().apis(RequestHandlerSelectors.basePackage("com.toceansoft.modules.alipay"))
				.paths(PathSelectors.any()).build();
	}

	@Bean
	public Docket weixinpayApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("微信API接口文档").apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.toceansoft.modules.weixinpay"))
				.paths(PathSelectors.any()).build();
	}

	@Bean
	public Docket unionpayApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("银联API接口文档").apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.toceansoft.modules.unionpay"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("支付系统").description("微信、支付宝、银联支付服务")
				.termsOfServiceUrl("http://www.toceansoft.com")
				.contact(new Contact("拓胜科技 ", "http://www.toceansoft.com", "admin@toceansoft.com"))
				.version("1.0").build();
	}

}