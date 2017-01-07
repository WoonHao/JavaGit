package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.commons.beanutils.ConvertUtils;
import com.sun.org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import bean.User;

import serviceImpl.UserServiceImpl;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		
		String opt = request.getParameter("opt");
		
		UserServiceImpl usi = new UserServiceImpl();
		int re = 0;
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		
		if("submit".equals(opt)){
			sex = new String(sex.getBytes("iso-8859-1"), "utf-8");
			
			//Date birthday = StringToDate(birth);
			
			User user = new User();
			user.setUser_name(name);
			user.setUser_password(password);
			user.setUser_email(email);
			user.setUser_phone(phone);
			user.setUser_birthday(birthday);
			user.setUser_sex(sex);
			System.out.println(user);
			
			
			boolean flag = usi.add(user);
			if(flag){
				re = 1;
			}else{
				re = 0;
			}
			pw.write(re+"");
			return;
		}
		
		
		//用户是否存在
		if("pdname".equals(opt)){
			boolean flag = usi.selw("user_name", name);
			if(flag){
				re = 1;
			}else{
				re = 0;
			}
			pw.write(re+"");
			return;
		}
		
		if("pdemail".equals(opt)){
			boolean flag = usi.selw("user_email", email);
			if(flag){
				re = 1;
			}else{
				re = 0;
			}
			pw.write(re+"");
			return;
		}
		
		if("pdphone".equals(opt)){
			boolean flag = usi.selw("user_phone", phone);
			if(flag){
				re = 1;
			}else{
				re = 0;
			}
			pw.write(re+"");
			return;
		}
		
	}
	
	public static Date StringToDate(String birth){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		try {
			birthday = dateFormat.parse(birth);
		    
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return birthday;
	}
	
}
