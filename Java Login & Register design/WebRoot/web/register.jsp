<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="jquery/jquery-1.8.0.min.js"></script>
	<script type="text/javascript">
		
		function sexf(){
			var rad = document.getElementsByName("sex");
			for(var a = 0;a<rad.length;a++){
				if(rad[a].checked){
					return rad[a].value;
				}
			}
		}
		
		 //用户名发生改变
		function nameGo(){
			var str = /[a-zA-Z][a-zA-Z0-9]{5,15}/;
			var name = $("#name").val();
			if(!str.exec(name)){
				alert("用户名不符合规范！");
			}else{
				$.ajax({
					type:"post",				//指定请求类型  post  / get
					url:"RegisterServlet.do?opt=pdname&name="+name,	//指定请求的URL
					async:false,			//指定异步或者同步		true : 异步 			false : 同步
					contentType:"application/x-www-form-urlencoded charset=utf-8",	//设置编码格式
					success:function(re){	//指定后台处理成功后的回调函数			re:返回值（随意写）
						//var td = document.getElementById("ts_name");
						if(re==1){
							alert("用户名已存在！");
							//ts_name.innerHTML="<font color="red" size="2">用户名已存在！</font>";
						}else{
							alert("用户名可用！");
							//ts_name.innerHTML="<font color="blue" size="2">用户名可用！</font>";
						}
					}
				});
			}
		}
		
		function pwdGo(){
			var password = $("#password").val();
			var pwd = $("#pwd").val();
			if(password!=pwd){
				alert("两次输入的密码不一致");
			}
		}
		
		//邮箱发生改变
		function emailGo(){
			var email = $("#email").val();
			var str_email = /(\w-*\.*)+@(\w-?)+(\.\w{2,})/;
			if(!str_email.exec(email)){
				alert("邮箱输入错误！");
			}else{
				$.ajax({
				type:"post",				//指定请求类型  post  / get
				url:"RegisterServlet.do?opt=pdemail&email="+email,	//指定请求的URL
				async:false,			//指定异步或者同步		true : 异步 			false : 同步
				contentType:"application/x-www-form-urlencoded charset=utf-8",	//设置编码格式
				success:function(re){	//指定后台处理成功后的回调函数			re:返回值（随意写）
					if(re==1){
						alert("邮箱已存在！");
						//td.innerHTML="<font color="red" size="2">邮箱已存在！</font>";
					}else{
						alert("邮箱可用!");
						//td.innerHTML="<font color="blue" size="2">邮箱可用！</font>";
					}
				}
			});
			}
		}
		
		//手机号发生改变
		function phoneGo(){
			var str = /1[34578]\d{9}/;
			var phone = $("#phone").val();
			if(!str.exec(phone)){
				alert("手机号输入错误！");
			}else{
				$.ajax({
					type:"post",				//指定请求类型  post  / get
					url:"RegisterServlet.do?opt=pdphone&phone="+phone,	//指定请求的URL
					async:false,			//指定异步或者同步		true : 异步 			false : 同步
					contentType:"application/x-www-form-urlencoded charset=utf-8",	//设置编码格式
					success:function(re){	//指定后台处理成功后的回调函数			re:返回值（随意写）
						if(re==1){
							alert("手机号已存在！");
							//td.innerHTML="<font color="red" size="2">手机号已存在！</font>";
						}else{
							alert("手机号可用！");
							//td.innerHTML="<font color="blue" size="2">手机号可用！</font>";
						}
					}
				});
			}
		}
		
		//提交
		function tijiao(){
			var str_name = /[a-zA-Z][a-zA-Z0-9]{5,15}/;
			var str_phone = /1[34578]\d{9}/;
			var str_email = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
			var name = $("#name").val();
			var password = $("#password").val();
			var pwd = $("#pwd").val();
			var phone = $("#phone").val();
			var email = $("#email").val();
			var birthday = $("#birthday").val();
			var sex = sexf();
			if(!str_name.exec(name)){
				alert("用户名不符合规范！");
			}else if(!str_email.exec(email)){
				alert("邮箱输入错误！");
			}else if(!str_phone.exec(phone)){
				alert("手机号输入错误！");
			}else if(password!=pwd){
				alert("两次输入的密码不一致");
			}else{
				$.ajax({
					type:"post",				//指定请求类型  post  / get
					url:"RegisterServlet.do?opt=submit&name="+name+"&password="+password+"&phone="+phone+"&email="+email+"&birthday="+birthday+"&sex="+sex+"",	//指定请求的URL
					async:false,			//指定异步或者同步		true : 异步 			false : 同步
					contentType:"application/x-www-form-urlencoded charset=utf-8",	//设置编码格式
					success:function(re){	//指定后台处理成功后的回调函数			re:返回值（随意写）
						if(re==1){
							alert("注册成功！");
							response.sendRedirect("login.jsp");
						}else{
							alert("注册失败！");
						}
					}
				});
			}
		}
		
	</script>
	
  </head>
  
  <body>
    <form action="" method="post">
    	<table align="center">
    		<tr>
    			<td>用户名:</td>
    			<td><input type="text" id="name" name="name" onchange="nameGo();"></td>
    			<td id="ts_name"></td>
    		</tr>
    		<tr>
    			<td>密码:</td>
    			<td><input type="password" id="password" name="password"></td>
    			<td id="ts_password"></td>
    		</tr>
    		<tr>
    			<td>再次输入密码:</td>
    			<td><input type="password" id="pwd" name="pwd" onchange="pwdGo();"></td>
    			<td id="ts_pwd"></td>
    		</tr>
    		<tr>
    			<td>邮箱:</td>
    			<td><input type="text" id="email" name="email" onchange="emailGo();"></td>
    			<td id="ts_email"></td>
    		</tr>
    		<tr>
    			<td>手机号:</td>
    			<td><input type="text" id="phone" name="phone" onchange="phoneGo();"></td>
    			<td id="ts_phone"></td>
    		</tr>
    		<tr>
    			<td>性别:</td>
    			<td>
    				<input type="radio" name="sex" value="男">男
    				<input type="radio" name="sex" value="女">女
    			</td>
    		</tr>
    		<tr>
    			<td>生日:</td>
    			<td><input type="date" id="birthday" name="birthday"></td>
    		</tr>
    	</table>
    	<div align="center">
    		<input type="button" value="提交" onclick="tijiao();">
    	</div>
    </form>
  </body>
</html>
