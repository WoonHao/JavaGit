package serviceImpl;

import java.util.List;

import dao.UserDao;
import daoImpl.UserDaoImpl;

import bean.User;
import service.UserService;

public class UserServiceImpl implements UserService{
	UserDao ud = new UserDaoImpl();
	/**
	 * ���
	 */
	public boolean add(User user) {
		String sql = "insert into user (user_name,user_password,user_email,user_phone,user_sex,user_birthday) values ('"+
				user.getUser_name()+"','"+user.getUser_password()+"','"+user.getUser_email()+"','"+user.getUser_phone()+"','"
				+user.getUser_sex()+"','"+user.getUser_birthday()+"')";
		return ud.update(sql);
	}
	/**
	 * �޸�
	 */
	public boolean upd(User user) {
		return false;
	}
	/**
	 * ɾ��
	 */
	public boolean del(String name) {
		return false;
	}
	/**
	 * ��ѯ����
	 */
	public List<User> showAll() {
		String sql = "select * from user";
		return ud.queryAll(sql);
	}
	/**
	 * ������ѯ���
	 */
	public List<User> selAll(String name,String value) {
		return null;
	}
	
	public User sel(String name,String value) {
		return null;
	}
	/**
	 * ��ѯ����
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
	 * �ж��û���������
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
