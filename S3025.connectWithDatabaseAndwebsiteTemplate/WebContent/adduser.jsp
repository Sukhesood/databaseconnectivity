<%@include file="include/header.jsp" %>
	<%@ page import="java.util.List"%>
	<%@ page import="org.studyEasy.entity.User" %>
	


<div class="container mtb">
<div class="row">
<div class="col-lg-12">
<form action="${pageContext.request.contextPath}/operation" method="post">
Username:<input type="text" name="username" required="required" /><br/>

Email:<input type="email" name="email" required="required" /><br/>
<input type="hidden" name="form" value="addUseroperation">

<input type="submit" value="AddUser">
</form>
</div>
</div>

</div>
<%@include file="include/footer.jsp" %>
