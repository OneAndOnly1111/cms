package com.briup.cms.web.action.manager;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Category;
import com.briup.cms.service.IArticleService;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.impl.ArticleServiceImpl;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<Category> categoryList;
	private List<Article> articleList;
	private Article article;
	
	private ICategoryService categoryService= new CategoryServiceImpl();
	private IArticleService articleService = new ArticleServiceImpl();
	
	private String title;
	private String author;
	private String content;
	private Long c_id;
	private Long id;
	

	/**
	 * 跳转到后台管理中的信息发布页面
	 */
	@Action(value="toAddArticle",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/addArticle.jsp")
	})
	public String toAddArticle(){
		categoryList = categoryService.list();
		return "success";
	}
	
	/**
	 * 添加文章信息的方法
	 */
	@Action(value="addArticle")
	public void addArticle(){
	   Article article = new Article(null, title, author, content, new Date(), c_id);
	   articleService.add(article);
	}
    
	/**
	 * 跳转到后台中的信息管理页面
	 */
	@Action(value="toArticleManager",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/articleManager.jsp")
	})
	public String toArticleManager(){	
		articleList = articleService.list();
		return "success";
	}
	
	/**
	 * 跳转到修改信息的页面
	 * @return
	 */
	@Action(value="toUpdArticle",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/updArticle.jsp")
	})
	public String toUpdArticle(){	
		categoryList = categoryService.list();
		article = articleService.findById(id);
		return "success";
	}
	
	/**
	 * 修改信息的方法
	 */
	@Action(value="updArticle")
	public void updArticle(){
		//将接收到的参数进行分装 分装称 一个对象
		article = new Article(id, title, author, content,null, c_id);
		//调用Service层的服务。完成添加栏目的功能
		articleService.update(article);
	}
	
	/**
	 * 删除信息文章的方法
	 * @return
	 */
	@Action(value="delArticle")
	public void delArticle(){
		articleService.delete(id);
		
	}
	
	
	//setter getter
	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	
}
