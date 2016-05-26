package com.briup.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.briup.cms.bean.Admin;
import com.briup.cms.common.ConnectionFactory;

public class AdminDao {
    
	/**
	 * 将食品的信息保存到数据表中
	 * @param admin
	 */
	public void save(Admin admin) {
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try{
				//获取连接
				conn = ConnectionFactory.getConn();
				String sql = "insert into t_admin(name,number,price,c_id) values(?,?,?,?)";
				//预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, admin.getName());
				pstmt.setString(2, admin.getNumber());
				pstmt.setDouble(3, admin.getPrice());
				pstmt.setLong(4,admin.getC_id());
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
	 * 查询所有的食品信息
	 * @return
	 */
	public List<Admin> findAll() {
		List<Admin> list = new ArrayList<Admin>();
		try{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				conn = ConnectionFactory.getConn();
				String sql = "select* from t_admin";
				//预处理
				pstmt = conn.prepareStatement(sql);
				//执行
				rs = pstmt.executeQuery();
				while(rs.next()){
					Admin admin = new Admin();
					long id = rs.getLong("id");
					String name = rs.getString("name");
					String number = rs.getString("number");
					Double price = rs.getDouble("price");
					Long c_id = rs.getLong("c_id");
					admin.setNumber(number);
					admin.setId(id);
					admin.setName(name);
					admin.setPrice(price);
					admin.setC_id(c_id);
					list.add(admin);
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
		return list;
	}
	
	//通过id删除食品的方法
	public void deleteById(long id){
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try{
				//获取连接
				conn = ConnectionFactory.getConn();
				
				String sql ="delete from t_admin where id=?";
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
	
	//通过id找到原有食品的信息
	public Admin findById(long id) {
		Admin admin = null;
		try{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				conn = ConnectionFactory.getConn();
				String sql = "select* from t_admin where id=?";
				//预处理
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				//执行
				rs = pstmt.executeQuery();
				while(rs.next()){
					String name = rs.getString("name");
					String number = rs.getString("number");
					Double price = rs.getDouble("price");
					long c_id = rs.getLong("c_id");
					admin = new Admin(id, name, number, price, c_id);
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
		return admin;
	}
	
	//修改食品信息
	public void update(Admin admin) {
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try{
				//获取连接
				conn = ConnectionFactory.getConn();
				String sql = "update t_admin set name=?,number=?,c_id=?,price=? where id=?";
				//预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, admin.getName());
				pstmt.setString(2, admin.getNumber());
				pstmt.setLong(3, admin.getC_id());
				pstmt.setDouble(4,admin.getPrice());
				pstmt.setLong(5, admin.getId());
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
