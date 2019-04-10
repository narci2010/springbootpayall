/*  
 * Copyright 2010-2017 Tocean Group.  
 * 版权：商业代码，未经许可，禁止任何形式拷贝、传播及使用
 * 文件名：PayController.java
 * 描述：  
 * 修改人： Narci.Lee  
 * 修改时间：2017年11月22日  
 * 跟踪单号：  
 * 修改单号：  
 * 修改内容：  
 */
package com.toceansoft.modules.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toceansoft.common.utils.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "支付后台")
@Controller
@RequestMapping(value = "pay")
public class PayController {
	private static final Logger logger = LoggerFactory.getLogger(PayController.class);

	@ApiOperation(value = "登陆首页")
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		logger.info("登陆首页");
		return "web/index";
	}

	@ApiOperation(value = "登陆")
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public @ResponseBody String login(HttpServletRequest request, HttpServletResponse response,
			String account, String password) throws Exception {
		logger.info("登陆");
		String param = "false";
		if ("admin".equals(account) && "111111".equals(password)) {
			param = "true";
		}
		return param;
	}

	@ApiOperation(value = "后台展示")
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		model.addAttribute("ip", "192.168.1.66");
		model.addAttribute("address", "青岛");
		model.addAttribute("time", DateUtil.getTime());
		return "web/main";
	}
}
