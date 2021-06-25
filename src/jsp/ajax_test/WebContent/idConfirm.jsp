<%@page import="com.lec.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<style>
	#red {color:red;}
</style>
</head>
<body>
	<%
		String id = request.getParameter("id");
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.idConfirm(id);
		if(result == MemberDAO.EXISTENT) { %>
			<b id="red">중복된 ID 입니다</b>
		<%}else {   %>
			<b>사용 가능한 ID 입니다</b>
	<%	} %>
	
	
</body>
</html>