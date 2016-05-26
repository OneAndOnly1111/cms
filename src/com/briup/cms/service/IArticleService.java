package com.briup.cms.service;

import java.util.List;

import com.briup.cms.bean.Article;

public interface IArticleService {
	/**
	 * 添加文章
	 * @param article
	 */
	void add(Article article);
    /**
     * 查询所有
     * @return
     */
	List<Article> list();
	
	/**
	 * 通过id删除文章
	 * @param id
	 */
	void delete(long id);
	
	//通过id查询要修改的栏目的信息
	Article findById(long id);
	
	//修改信息
	void update(Article article);
}
