package service;

import java.util.List;

import bean.User;

public interface UserService {
	public boolean add(User user);
	public boolean upd(User user);
	public boolean del(String name);
	public List<User> showAll();
	public List<User> selAll(String name,String value);
	public User sel(String name,String value);
	public boolean selw(String name,String value);
	public boolean dr(String name,String password);
}
