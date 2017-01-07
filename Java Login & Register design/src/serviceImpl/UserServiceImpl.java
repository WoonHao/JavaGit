package serviceImpl;

import java.util.List;

import dao.UserDao;
import daoImpl.UserDaoImpl;

import bean.User;
import service.UserService;

public class UserServiceImpl implements UserService{
	UserDao ud = new UserDaoImpl();
	/**
	 * 添加
	 */
	public boolean add(User user) {
		String sql = "insert into user (user_name,user_password,user_email,user_phone,user_sex,user_birthday) values ('"+
				user.getUser_name()+"','"+user.getUser_password()+"','"+user.getUser_email()+"','"+user.getUser_phone()+"','"
				+user.getUser_sex()+"','"+user.getUser_birthday()+"')";
		return ud.update(sql);
	}
	/**
	 * 修改
	 */
	public boolean upd(User user) {
		return false;
	}
	/**
	 * 删除
	 */
	public boolean del(String name) {
		return false;
	}
	/**
	 * 查询所有
	 */
	public List<User> showAll() {
		String sql = "select * from user";
		return ud.queryAll(sql);
	}
	/**
	 * 条件查询多个
	 */
	public List<User> selAll(String name,String value) {
		return null;
	}
	
	public User sel(String name,String value) {
		return null;
	}
	/**
	 * 查询单个
	 */
	public boolean selw(String name,String value) {
		String sql = "select * from user where "+name+"='"+value+"'";
		System.out.println(sql);
		List<User> list = ud.queryAll(sql);
		if(list!=null && list.size()>0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 判断用户名和密码
	 */
	public boolean dr(String name, String password) {
		String sql = "select * from user where user_name='"+name+"' and user_password='"+password+"'";
		List<User> list = ud.queryAll(sql);
		if(list!=null && list.size()>0){
			return true;
		}else{
			return false;
		}
	}

}
