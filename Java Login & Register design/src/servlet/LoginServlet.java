package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serviceImpl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	UserServiceImpl usi = new UserServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("checkCode");
		//图片验证码
		String cc = (String) session.getAttribute("checkCode");
		
		if(cc.equalsIgnoreCase(checkCode)){
			if(usi.dr(name, password)){
				session.setAttribute("name", name);
				response.sendRedirect(request.getContextPath()+"/web/system/home.jsp");
			}else{
				request.setAttribute("error", "用户名或密码错误");
				request.getRequestDispatcher("/web/login.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("error", "验证码不匹配");
			request.getRequestDispatcher("/web/login.jsp").forward(request, response);
			return;
		}
	}

}
