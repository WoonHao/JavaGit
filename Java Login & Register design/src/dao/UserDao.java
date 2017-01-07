package dao;

import java.util.List;

import bean.User;

public interface UserDao {
	public boolean update(String sql);
	public List<User> queryAll(String sql);
	public User query(String sql);
}
