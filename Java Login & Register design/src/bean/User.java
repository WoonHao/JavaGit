package bean;

import java.util.Date;

public class User {
	private int user_id;			//id
	private String user_name;		//用户名
	private String user_password;	//密码
	private String user_email;		//邮箱
	private String user_phone;		//手机号
	private String user_sex;		//性别
	private String user_birthday;	//生日
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_birthday() {
		return user_birthday;
	}
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name
				+ ", user_password=" + user_password + ", user_email="
				+ user_email + ", user_phone=" + user_phone + ", user_sex="
				+ user_sex + ", user_birthday=" + user_birthday + "]";
	}
}
