package pojo;

public class User {
	
	private String login;
	private String email;
	private String password;
	private String facebook_username;
	private String reset_password_token;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFacebook_username() {
		return facebook_username;
	}
	public void setFacebook_username(String facebook_username) {
		this.facebook_username = facebook_username;
	}
	public String getReset_password_token() {
		return reset_password_token;
	}
	public void setReset_password_token(String reset_password_token) {
		this.reset_password_token = reset_password_token;
	}

}
