<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, sec01.ex01.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

	<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page" />
	<jsp:setProperty name="m" property="*"/> <!-- 전체 한번에 가능 -->
	<%-- <jsp:setProperty name="m" property="id" value='<%=request.getParameter("id") %>' />
	<jsp:setProperty name="m" property="pwd" value='<%=request.getParameter("pwd") %>' />
	<jsp:setProperty name="m" property="name" value='<%=request.getParameter("name") %>' />
	<jsp:setProperty name="m" property="email" value='<%=request.getParameter("email") %>' /> --%>

<%
	/* String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email"); */
	
	//MemberBean m = new MemberBean(id, pwd, name, email); 위 useBean있으면 불필요
	
	/* m.setId(id);
	m.setPwd(pwd);
	m.setName(name);
	m.setEmail(email); */
	
	MemberDAO memberDAO = new MemberDAO();
	memberDAO.addMember(m);
	List<MemberBean> membersList = memberDAO.listMember();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록창</title>
</head>
<body>
	<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">이메일</td>
		</tr>
		<tr align="center">
			<td>
				<jsp:getProperty property="id" name="m"/>
			</td>
			<td>
				<jsp:getProperty property="pwd" name="m"/>
			</td>
			<td>
				<jsp:getProperty property="name" name="m"/>
			</td>
			<td>
				<jsp:getProperty property="email" name="m"/>
			</td>
		</tr>
		<tr height="1" bgcolor="#99ccff">
			<td colspan="5"></td>
		</tr>
	</table>
</body>
</html>