package com.briup.cms.bean;
/*
 * 栏目类JavaBean
 * 用来存储栏目的信息
 */
public class Category {
	//1.私有属性
	private Long id;
	private String name;
	private String code;
	
	//2.构造函数
	public Category() {
		
	}
	public Category(Long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	//3.setter getter方法
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
