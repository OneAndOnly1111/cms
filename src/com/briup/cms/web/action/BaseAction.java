package com.briup.cms.web.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
/*
 * 前台基础Action
 */
public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	//声明私有属性
	private List<Category> categoryList;
	//关联关系
	private ICategoryService categoryService = new CategoryServiceImpl();  
	/**
	 * 跳转到前台首页
	 * http://localhost:8080/cms/toIndex.action
	 * 当返回值为SUCCESS的时候页面跳转到/WEB-INF/jsp/index.jsp
	 */
	@Action(value="toIndex",results={
			@Result(name="success",location="/WEB-INF/jsp/index.jsp")})
	public String toIndex(){
		//调用service层方法查询栏目的信息 并且将查询到的数值赋值给categoryList
		categoryList = categoryService.list();
		return SUCCESS;
	}
	
	/**
	 * 跳转到列表页面
	 * @return
	 */
	@Action(value="toList",results={
			@Result(name="success",location="/WEB-INF/jsp/list.jsp")})
	public String toList(){
		//调用service层方法查询栏目的信息 并且将查询到的数值赋值给categoryList
		//categoryList = categoryService.list();
		return SUCCESS;
	}
	
	/**
	 * 跳转到内容页面
	 * @return
	 */
	@Action(value="toContent",results={
			@Result(name="success",location="/WEB-INF/jsp/content.jsp")})
	public String toContent(){
		//调用service层方法查询栏目的信息 并且将查询到的数值赋值给categoryList
		//categoryList = categoryService.list();
		return SUCCESS;
	}
	
	/**
	 * 跳转到header页面
	 * @return
	 */
	@Action(value="toHeader",results={
			@Result(name="success",location="/WEB-INF/jsp/header.jsp")})
	public String toHeader(){
		//调用service层方法查询栏目的信息 并且将查询到的数值赋值给categoryList
		categoryList = categoryService.list();
		return SUCCESS;
	}
	
	
	
	//getter setter
	public List<Category> getCategoryList() {
		return categoryList;
	}
	
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
	
	
	
}
