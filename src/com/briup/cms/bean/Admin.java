package com.briup.cms.bean;

/**
 * 食品类
 * @author Mine
 */
public class Admin {
	
	
	//私有属性
	private Long id;
	private String name;
	private String number;
	private Double price;
	private Long c_id;
	
	//构造函数
	public Admin() {
		
	}
	
	public Admin(Long id,String name,String number,Double price,Long c_id){
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.price = price;
		this.c_id = c_id;
	}
	
	
	//getter setter
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

}
