package Model;


public class Admin  {
	String login;
	String password;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
