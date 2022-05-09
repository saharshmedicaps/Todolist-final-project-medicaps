<%@page import="java.util.List"%>
<%@page import="com.entity.TodoDtls"%>
<%@page import="com.DAO.TodoDAO"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="component/all_css.jsp" %>
</head>
<body>
	<%@include file="component/navbar.jsp" %>
	
<%--  Check DB connection 	
<%
	Connection conn = DBConnect.getConn();
	out.print(conn);
	%> --%>
	
	
	<h1 class="text-center text-success">TODO APP</h1>
	
	<div class="container">
        <table class="table">
            <thead>
              <tr>

                <th scope="col">Task</th>
                <th scope="col">Status</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
            
            <%
            TodoDAO dao = new TodoDAO(DBConnect.getConn());
            List<TodoDtls> todo = dao.getTodo();
            for(TodoDtls t : todo)
            {%>
             <tr>
                <td><%=t.getTodo() %></td>
                <td><%=t.getStatus() %></td>
                <td>

                  <a href="delete?id=<%=t.getId()%>" class="btn btn-sm btn-suceess">Done</a>
                </td>
              </tr>
            <%}
            
            %>
            </tbody>
          </table>
    </div>
</body>
</html>