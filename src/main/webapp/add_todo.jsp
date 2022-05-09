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
<div class="container">
      <div class="row p-5">
        <div class="col-md-6 offset-md-3">
          <div class="card">
            <div class="card-body">
            <h3 class="text-center text-success">Add Task</h3>
            
              <form action="add_todo" method="post">
              
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label" >Task</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="todo">
                </div>
                
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label" >Status</label>
                  <select id="inputState" class="form-control" name="status">
                    <option selected>--Select--</option>
                    <option value="Pending">Pending</option>
                    <option value="Completed">Completed</option>
                  </select>
                </div>
                
                <button type="submit" class="btn btn-primary">Submit</button>
              </form>
              
            </div>
          </div>
        </div>
      </div>
    </div>
</body>
</html>