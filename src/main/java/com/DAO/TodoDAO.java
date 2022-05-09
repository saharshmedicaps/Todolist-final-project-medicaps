package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.TodoDtls;

public class TodoDAO {
	private Connection conn;
	
	public TodoDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addTodo(String todo,String status) {
		boolean f = false;
		try {
			String sql = "insert into todo_app(todo,status) values(?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, todo);
			ps.setString(2, status);
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<TodoDtls> getTodo(){
		List<TodoDtls> list = new ArrayList<TodoDtls>();
		TodoDtls t = null;
		
		try {
			String sql = "select * from todo_app";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				t = new TodoDtls();
				t.setId(rs.getInt(1));
				t.setTodo(rs.getString(2));
				t.setStatus(rs.getString(3));
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean deleteTodo(int id) {
		boolean f = false;
		
		try {
			String sql = "delete from todo_app where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			int i = ps.executeUpdate();
			
			if (i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	

}
