package com.briup.cms.service.impl;

import java.util.List;

import com.briup.cms.bean.Admin;
import com.briup.cms.dao.AdminDao;
import com.briup.cms.service.IAdminService;

public class AdminServiceImpl implements IAdminService {
	private AdminDao adminDao = new AdminDao();
  
	
	//添加食品的方法
	@Override
	public void add(Admin admin) {
		adminDao.save(admin);
	}

    //查询所有的食品信息
	@Override
	public List<Admin> list() {
		return adminDao.findAll();
	}

	//通过id删除食品的方法
	@Override
	public void delete(Long id) {
       adminDao.deleteById(id);		
	}
    
	//通过id找到原有食品的信息
	@Override
	public Admin findById(Long id) {
		return adminDao.findById(id);
	}

	@Override
	public void update(Admin admin) {
        adminDao.update(admin);	
	}
	
	
}
