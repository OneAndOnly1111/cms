package com.briup.cms.service.impl;

import java.util.List;

import com.briup.cms.bean.Category;
import com.briup.cms.dao.CategoryDao;
import com.briup.cms.service.ICategoryService;
/**
 * 业务逻辑实现类
 * 事务管理
 * 复杂业务逻辑处理
 * */
public class CategoryServiceImpl implements ICategoryService {
	//关联Dao对象
	private CategoryDao categoryDao = new CategoryDao();
	/**
	 * 添加栏目
	 * */
	@Override
	public void add(Category category) {
		categoryDao.save(category);
	}
	/*
	 *查询栏目信息
	 */
	@Override
	public List<Category> list() {
		return categoryDao.findAll();
	}
	/*
	 * 通过id删除栏目
	 */
	@Override
	public void delete(long id) {
		categoryDao.deleteById(id);
	}
	
    //通过id获取栏目信息
	@Override
	public Category findById(long id) {
		return categoryDao.findById(id);
	}
	
	//修改栏目信息
	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}
	
	
	
}
