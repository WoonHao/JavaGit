<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
		function flushImg(){
			var yzm = document.getElementById("yzm");
			var src = yzm.src+"?";
			yzm.src = src;
			yzm.focus();
		}
	</script>
	
  </head>
  
  <body>
	<form action="LoginServlet.do" method="post">
		<table align="center">
			<tr>
				<td>用户名：</td>
				<td><input type="text" id="name" name="name"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" id="password" name="password"></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="checkCode"></td>
				<td><img src="web/yzm.jsp" id="yzm" title="看不清" width="70" height="30" onclick="flushImg()" ></td>
			</tr>
			<tr>
				<td><input type="submit" id="login" name="login" value="登陆"></td>
				<td><a href="web/register.jsp"><input type="button" id="register" name="register" value="注册"></a></td>
			</tr>
		</table>
	</form>
	<div align="center">
		<font color="red" size="5">
			<%=request.getAttribute("error")==null?" ":request.getAttribute("error") %>
		</font>
	</div>
  </body>
</html>
