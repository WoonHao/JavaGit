<%@page import="java.awt.Font"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'yzm.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	Random rd = new Random();
    	String date = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    	
    	int width = 70;
    	int height = 30;
    	//定义画布
    	BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    	//获取一张画布
    	Graphics gs = bi.getGraphics();
    	//设置颜色
    	gs.setColor(Color.black);
    	//填充矩形
    	gs.fillRect(0, 0, width, height);
    	gs.setColor(Color.white);
    	gs.fillRect(1, 1, width-2, height-2);
    	//刷新
    	bi.flush();
    	//设置字体
    	gs.setFont(new Font("宋体",Font.BOLD,25));
    	//定义验证码字符
    	String sc = "";
    	for(int i = 0;i<4;i++){
    		int num = rd.nextInt(date.length());
    		//产生随机的字符
    		String ch = date.substring(num, num+1);
    		sc += ch;
    		////产生随机的颜色，并设置
    		gs.setColor(new Color(rd.nextInt(256),rd.nextInt(256),rd.nextInt(256)));
    		//将字符绘制到图片上
    		gs.drawString(ch, i*15+9, 20);
    	}
    	//加入干扰线
    	for(int i = 0;i<5;i++){
    		//设置干扰线的随机色
    		gs.setColor(new Color(rd.nextInt(256),rd.nextInt(256),rd.nextInt(256)));
    		//绘制干扰线
    		gs.drawLine(rd.nextInt(width), rd.nextInt(height), rd.nextInt(width), rd.nextInt(height));
    	}
    	//将验证码放在session 中
    	session.setAttribute("checkCode", sc);
    	//设置响应的格式
    	response.setContentType("image/jpg");
    	ImageIO.write(bi, "jpg", response.getOutputStream());
    	
    	out.clear();
    	out = pageContext.pushBody();
    %>
  </body>
</html>
