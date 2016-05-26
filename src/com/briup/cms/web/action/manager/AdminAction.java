package com.briup.cms.web.action.manager;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Admin;
import com.briup.cms.bean.Category;
import com.briup.cms.service.IAdminService;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.impl.AdminServiceImpl;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String number;
	private Double price;
	private Long c_id;
	
    private List<Admin> adminList;
    private List<Category> categoryList;
    private Admin admin;
    
	private IAdminService adminService  = new AdminServiceImpl();
	private ICategoryService categoryService= new CategoryServiceImpl();
	/**
	 * 跳转到后台管理中的添加食品页面
	 */
	@Action(value="toAddAdmin",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/addAdmin.jsp")
	})
	public String toAddAdmin(){
		categoryList = categoryService.list();
		return "success";
	}
	
	/**
	 * 添加食品的方法  
	 */
	@Action(value="addAdmin")
	public void addAdmin(){
		Admin admin = new Admin(null,name,number,price,c_id);
		adminService.add(admin);
	}
    
	/**
	 * 跳转到后台管理中的食品管理页面
	 */
	@Action(value="toAdminManager",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/adminManager.jsp")
	})
	public String toAdminManager(){	
		adminList = adminService.list();
		return SUCCESS;		
	}
	
	/**
	 * 通过id删除食品的方法
	 */
	@Action(value="delAdmin")
	public void delArticle(){
		adminService.delete(id);
	}
	
	/**
	 * 跳转到修改食品信息的页面
	 */
	@Action(value="toUpdAdmin",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/updAdmin.jsp")
	})
	public String toUpdAdmin(){	
		categoryList = categoryService.list();
		admin = adminService.findById(id);
		return "success";
	}
	
	/**
	 * 修改食品信息的方法
	 */
	@Action(value="updAdmin")
	public void updAdmin(){
		//将接收到的参数进行分装 分装称 一个对象
		admin = new Admin(id, name, number, price, c_id);
		//调用Service层的服务。完成添加栏目的功能
		adminService.update(admin);
	}
	
	
	
	
	//setter getter
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

	public List<Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	

}
