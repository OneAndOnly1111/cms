package com.briup.cms.service;

import java.util.List;

import com.briup.cms.bean.Category;

/*
 *栏目管理的接口
 *定义系统功能 
 */
public interface ICategoryService {
	/*
	 * 添加栏目
	 */
	void add(Category category);
	
	/*
	 * 查询所有的栏目信息
	 */
	List<Category> list();
	
	/**
	 * 通过id删除栏目
	 */
	void delete(long id);

   /**
    * 通过id获取栏目信息
    */
	Category findById(long id);
	/**
	 * 修改栏目信息
	 */
	void update (Category category);

	

	

	
}