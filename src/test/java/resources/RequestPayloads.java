package resources;

import pojo.UserDetails;
import pojo.User;

public class RequestPayloads {
	
	UserDetails userDetailsdata;
	User user;
	
	public UserDetails createUserPayload(String login, String email, String password) 
	{
		userDetailsdata = new UserDetails();
		user = new User();
		user.setLogin(login);
		user.setEmail(email);
		user.setPassword(password);
		userDetailsdata.setUser(user);
		return userDetailsdata;
	}
	
	public UserDetails updateUserPayload(String login, String email, String password, String facebook_username) 
	{
		userDetailsdata = new UserDetails();
		user = new User();
		user.setLogin(login);
		user.setEmail(email);
		user.setPassword(password);
		user.setFacebook_username(facebook_username);
		userDetailsdata.setUser(user);
		return userDetailsdata;
	}
	
	

}
