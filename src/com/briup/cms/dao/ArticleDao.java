package com.briup.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.common.ConnectionFactory;

public class ArticleDao  {
	/**
	 * 将article对象中的文章信息保存到数据库栏目表中
	 * @param article
	 */
	public void save(Article article){
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try{
				//获取连接
				conn = ConnectionFactory.getConn();
				String sql = "insert into t_article("
						+ "title,author,content,publisurDate,c_id) values(?,?,?,?,?)";
				//预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, article.getTitle());
				pstmt.setString(2, article.getAuthor());
				pstmt.setString(3, article.getContent());
				//  java.sql.Date		java.util.Date
				long time = article.getPublisurDate().getTime();
				pstmt.setDate(4, new Date(time));
				pstmt.setLong(5, article.getC_id());
				//执行sql
				pstmt.executeUpdate();
			}finally{
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有
	 * */
	public List<Article> findAll(){
		List<Article> list = new ArrayList<Article>();
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				//获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_article";
				//预处理sql
				pstmt = conn.prepareStatement(sql);
				//执行
				rs = pstmt.executeQuery();
				//处理接过去
				while(rs.next()){
					long id = rs.getLong("id");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String author = rs.getString("author");
					java.util.Date publisurDate = rs.getDate("publisurDate");
					long c_id = rs.getLong("c_id");
					
					Article article = new Article(id, title, author, content, publisurDate, c_id);
					list.add(article);
				}
			}finally{
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 通过id删除文章
	 */
	public void deleteById(long id){
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try{
				//获取连接
				conn = ConnectionFactory.getConn();
				
				String sql ="delete from t_article where id=?";
				//预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				//执行sql
				pstmt.executeUpdate();
			}finally{
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//通过id查询要修改的栏目信息
	public Article findById(long id) {
		Article article = null;
		try{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				conn = ConnectionFactory.getConn();
				String sql = "select* from t_article where id=?";
				//预处理
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				//执行
				rs = pstmt.executeQuery();
				while(rs.next()){
					String title = rs.getString("title");
					String content = rs.getString("content");
					String author = rs.getString("author");
					long c_id = rs.getLong("c_id");
					article = new Article(id, title, author, content, null, c_id);
				}
			}finally{
				//释放资源
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return article;
	}
	
	//修改文章信息
	public void update(Article article) {
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try{
				//获取连接
				conn = ConnectionFactory.getConn();
				String sql = "update t_article set title=?,author=?,c_id=?,content=? where id=?";
				//预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, article.getTitle());
				pstmt.setString(2, article.getAuthor());
				pstmt.setLong(3, article.getC_id());
				pstmt.setString(4, article.getContent());
				pstmt.setLong(5, article.getId());
				//执行sql
				pstmt.executeUpdate();
			}finally{
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
