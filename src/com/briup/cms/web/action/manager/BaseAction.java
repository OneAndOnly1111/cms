package com.briup.cms.web.action.manager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
/*
 * 后台基础Action
 */
public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	/**
	 * 跳转到后台管理首页
	 * http://localhost:8080/cms/manager/toIndex.action
	 */
	@Action(value="toIndex",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/index.jsp")
	})
	public String toIndex(){
		return SUCCESS;
	}
	
	
	
	
	

}
