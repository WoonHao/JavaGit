package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utils.DBUtil;
import bean.User;
import dao.UserDao;

public class UserDaoImpl implements UserDao{
	private DBUtil dbUtil = new DBUtil();
	private Connection con;
	private Statement st;
	private ResultSet rs;

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 增删改操作
	 */
	public boolean update(String sql) {
		boolean flag = false;
		con = dbUtil.getConnection();
		try {
			st = con.createStatement();
			int re = st.executeUpdate(sql);
			if(re>0){
				flag = true;
			}else{
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbUtil.colseAll(con, st, rs);
		}
		return flag;
	}
	/**
	 * 查询多个user
	 */
	public List<User> queryAll(String sql) {
		List<User> lsit = null;
		con = dbUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			lsit = rsToList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbUtil.colseAll(con, st, rs);
		}
		return lsit;
	}

	/**
	 * 查询单个user
	 */
	public User query(String sql) {
		User user = null;
		con = dbUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			user = rsToUser(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbUtil.colseAll(con, st, rs);
		}
		return user;
	}
	
	public User rsToUser(ResultSet rs){
		User user = null;
		try {
			while (rs.next()) {
				user = new User();
				int id = rs.getInt("user_id");
				String name = rs.getString("user_name");
				String password = rs.getString("user_password");
				String email = rs.getString("user_email");
				String phone = rs.getString("user_phone");
				String sex = rs.getString("user_sex");
				Date birth = rs.getDate("user_birthday");
				String birthday = dateFormat.format(birth);
				user.setUser_id(id);
				user.setUser_name(name);
				user.setUser_password(password);
				user.setUser_email(email);
				user.setUser_phone(phone);
				user.setUser_birthday(birthday);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	/**
	 * ResultSet  ---->  list
	 * @param rs
	 * @return
	 */
	public List<User> rsToList(ResultSet rs){
		List<User> list = new ArrayList<User>();
		try {
			User user = null;
			while (rs.next()) {
				user = new User();
				int id = rs.getInt("user_id");
				String name = rs.getString("user_name");
				String password = rs.getString("user_password");
				String email = rs.getString("user_email");
				String phone = rs.getString("user_phone");
				String sex = rs.getString("user_sex");
				Date birth = rs.getDate("user_birthday");
				String birthday = dateFormat.format(birth);
				user.setUser_id(id);
				user.setUser_name(name);
				user.setUser_password(password);
				user.setUser_email(email);
				user.setUser_phone(phone);
				user.setUser_birthday(birthday);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
