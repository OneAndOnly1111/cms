package com.briup.cms.web.action.manager;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/*
 * 栏目的处理类
 */
public class CategoryAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String name;
	private String code;
	private Long id;
	private List<Category> categoryList;
	private Category category; 
	private ICategoryService categoryService = new CategoryServiceImpl();
	
	
	/**
	 * 跳转到后台管理中的添加栏目页面
	 * http://localhost:8080/cms/manager/toAddCategory.action
	 */
	@Action(value="toAddCategory",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/addCategory.jsp")
	})
	public String toAddCategory(){
		return SUCCESS;
	}
	
	/**
	 * 处理添加栏目信息的方法
	 */
	@Action(value="addCategory")
	public void addCategory(){
		Category category = new Category(null,name,code);
		categoryService.add(category);
	}
	
	/**
	 * 跳转到后台管理中的栏目管理页面
	 * http://localhost:8080/cms/manager/toCategoryManager.action
	 */
	@Action(value="toCategoryManager",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/categoryManager.jsp")
	})
	public String toCategoryManager(){	
		categoryList=categoryService.list();
		return SUCCESS;		
	}
	
	/**
	 * 跳转到修改栏目页面
	 */
	@Action(value="toUpdCategory",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/updCategory.jsp")
	})
	public String toUpdCategory(){	
		//调用service层的方法通过id查询要修改的栏目信息
		category = categoryService.findById(id); 
		return SUCCESS;		
	}
		
	/**
	 * 修改栏目信息的方法
	 */
	@Action(value="updCategory")
	public void updCategory(){
		//将接收到的参数进行分装 分装称 一个对象
		category = new Category(id,name,code);
		//调用Service层的服务。完成添加栏目的功能
		categoryService.update(category);
	}
	
	
	/**
	 * 删除栏目信息的方法
	 */
	@Action(value="delCategory")
	public void delCategory(){
		categoryService.delete(id);
	}
	
	
	//setter getter
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
	
	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

}
