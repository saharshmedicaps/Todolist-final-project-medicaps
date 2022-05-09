package com.servlet;

import java.io.IOException;

import com.DAO.TodoDAO;
import com.DB.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));		
		TodoDAO dao = new TodoDAO(DBConnect.getConn());
		boolean f = dao.deleteTodo(id);
		HttpSession session = req.getSession();

		if (f) {
//			System.out.println("Data deleted sucessfully");
			session.setAttribute("sucMsg","Task deleted sucessfully");
			resp.sendRedirect("index.jsp");
		}
		else {
//			System.out.println("Data not deleted");
			session.setAttribute("errorMsg","Error occured in deleting task");
			resp.sendRedirect("index.jsp");
		}
	}
	

}
