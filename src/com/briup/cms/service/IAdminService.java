package com.briup.cms.service;

import java.util.List;

import com.briup.cms.bean.Admin;

public interface IAdminService {

    //添加食品的方法	
	void add(Admin admin);
    
	//查询所有的食品信息
	List<Admin> list();

	//通过id删除食品的方法
	void delete(Long id);
    
	//通过id找到原有食品的信息
	Admin findById(Long id);

	//修改食品信息的方法
	void update(Admin admin);

	
}
