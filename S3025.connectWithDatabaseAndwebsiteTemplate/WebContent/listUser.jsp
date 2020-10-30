<%@include file="include/header.jsp" %>
	<%@ page import="java.util.List"%>
	<%@ page import="org.studyEasy.entity.User" %>
	   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	

	<div class="container mtb">
	<div class="row">
	<div class="col-lg-12">
	<strong>Listing users</strong>
	<hr/>
	<table border="1">
	<thead>
	<th>
	User Id
	</th>
	<th> 
	User Name
	</th>
	<th>
	Email
	</th>
	<th>
	Operation
	</th>
	
	</thead>
	<c:forEach items="${listUsers}" var="user">
	<c:url var="tempURL" value="operation">
	<c:param name="page" value="updateUser"></c:param>
	<c:param name="usersId" value="${user.user_id}"></c:param>
	<c:param name="username" value="${user.username}"></c:param>
	<c:param name="email" value="${user.email}"></c:param>
	</c:url>
	<c:url var="tempURL2" value="operation">
	<c:param name="page" value="deleteUser">
	</c:param>
	<c:param name="usersId" value="${user.user_id}"></c:param>
	</c:url>
	<tr>
	<td>${user.user_id}</td>
	<td>${user.username}</td>
	<td>${user.email}</td>
	<td>
	<a href="${tempURL}">Update</a>|
	<a href="${tempURL2}"
	onclick="if(!confirm('Are you sure to delete the user?'))return false" >Delete</a></td>
	
	</tr>
	
	
	</c:forEach>
	
	
	
	
	
	
	
	
	<%--<%! String tempURL2;
	<% 
	List<User> listUsers=(List)request.getAttribute("listUsers");
	String tempURL;
	for(int i=0; i<listUsers.size();i++){
		out.print("<tr>");
		out.print("<td>"+listUsers.get(i).getUser_id()+"</td>");
		out.print("<td>"+listUsers.get(i).getUsername()+"</td>");
		out.print("<td>"+listUsers.get(i).getEmail()+"</td>");
		tempURL=request.getContextPath()+"/operation?page=updateUser"+
		"&usersId="+listUsers.get(i).getUser_id()+
		"&username="+listUsers.get(i).getUsername()+
		"&email="+listUsers.get(i).getEmail();
		tempURL2=request.getContextPath()+"/operation?page=deleteUser"+
				"&usersId="+listUsers.get(i).getUser_id();
		out.print("<td><a href="+tempURL+">Update</a>|");
		

	

		%>
		<a href="<%=tempURL2 %>" onclick="if(!confirm('Are you sure to delete the user?'))return false" >Delete</a></td>
		</tr>
		<%}%>   --%>
	</table></div>
	</div></div>
<%@include file="include/footer.jsp" %>

	