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
	
	public User createSessionPayload(String login, String password) 
	{
		user = new User();
		user.setLogin(login);
		user.setPassword(password);
		return user;
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
