package resources;

import pojo.UserDetails;
import pojo.Quote;
import pojo.QuoteDetails;
import pojo.User;

public class RequestPayloads {
	
	UserDetails userDetailsdata;
	User user;
	QuoteDetails quoteDetailsData;
	Quote quote;
	
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
	
	public UserDetails forgotPasswordPayload(String email) 
	{
		userDetailsdata = new UserDetails();
		user = new User();
		user.setEmail(email);
		userDetailsdata.setUser(user);
		return userDetailsdata;
	}
	
	public UserDetails resetPasswordPayload(String email, String reset_password_token) 
	{
		userDetailsdata = new UserDetails();
		user = new User();
		user.setEmail(email);
		user.setReset_password_token(reset_password_token);
		userDetailsdata.setUser(user);
		return userDetailsdata;
	}
	
	public UserDetails createSessionPayload(String login, String password) 
	{
		userDetailsdata = new UserDetails();
		user = new User();
		user.setLogin(login);
		user.setPassword(password);
		userDetailsdata.setUser(user);
		return userDetailsdata;
	}
	
	public QuoteDetails addQuotePayload(String author, String body) 
	{
		quote = new Quote();
		quoteDetailsData = new QuoteDetails();
		quote.setAuthor(author);
		quote.setBody(body);
		quoteDetailsData.setQuote(quote);
		return quoteDetailsData;
	}

}
