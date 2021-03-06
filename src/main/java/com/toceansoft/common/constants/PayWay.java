/*  
 * Copyright 2010-2017 Tocean Group.  
 * 版权：商业代码，未经许可，禁止任何形式拷贝、传播及使用
 * 文件名：PayWay.java
 * 描述：  
 * 修改人： Narci.Lee  
 * 修改时间：2017年11月22日  
 * 跟踪单号：  
 * 修改单号：  
 * 修改内容：  
 */
package com.toceansoft.common.constants;

/**
 * 支付途径 创建者 拓胜科技 创建时间 2017年7月27日
 *
 */
public enum PayWay {
	PC("PC,平板", (short) 1), MOBILE("手机", (short) 2);

	private Short code;
	private String name;

	private PayWay(String name, Short code) {
		this.name = name;
		this.code = code;
	}

	public static String getName(Short code, String name) {
		for (PayWay c : PayWay.values()) {
			if (c.getCode() == code) {
				return c.name;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getCode() {
		return code;
	}

	public void setCode(short code) {
		this.code = code;
	}

}
