package com.briup.cms.service.impl;

import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.dao.ArticleDao;
import com.briup.cms.service.IArticleService;

public class ArticleServiceImpl implements IArticleService {

	private ArticleDao articleDao = new ArticleDao();
	
	/**
	 * 添加文章
	 */
	@Override
	public void add(Article article) {
		articleDao.save(article);
		
	}
	
	/**
	 * 查询所有的文章信息
	 */
	@Override
	public List<Article> list() {
		return articleDao.findAll();
	}
    
	/**
	 * 通过id删除文章
	 */
	@Override
	public void delete(long id) {
		articleDao.deleteById(id);
		
	}
    
	//通过id获取要修改的栏目的信息
	@Override
	public Article findById(long id) {
		return articleDao.findById(id);
	}
   
	//修改信息
	@Override
	public void update(Article article) {
		articleDao.update(article);
	}
	

}
