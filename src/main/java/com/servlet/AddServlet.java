package com.servlet;

import java.io.IOException;

import com.DAO.TodoDAO;
import com.DB.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add_todo")
public class AddServlet extends jakarta.servlet.http.HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String todo = req.getParameter("todo");
		String status = req.getParameter("status");

//		System.out.println(todo+" "+status); ---> test if data is being retrived from jsp
		
		TodoDAO dao = new TodoDAO(DBConnect.getConn());
		boolean f = dao.addTodo(todo,status);
		
		HttpSession session = req.getSession();
		
		if (f) {
//			System.out.println("Data inserted sucessfully");
			session.setAttribute("sucMsg","Task added sucessfully");
			resp.sendRedirect("index.jsp");
		}
		else {
//			System.out.println("Data not inserted");
			session.setAttribute("errorMsg","Error occured in adding task");
			resp.sendRedirect("index.jsp");
		}
		

	}
	
	

	private static final long serialVersionUID = 1L;
	
}
