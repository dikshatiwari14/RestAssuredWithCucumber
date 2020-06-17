package resources;

public enum APIResources {
	
	createUserAPI("/api/users"),
	updateUserAPI("/api/users/{login}"),
	getUserAPI("/api/users/{login}"),
	createSessionAPI("/api/session"),
	addQuoteAPI("/api/quotes"),
	getQuoteAPI("/api/quotes/{quote_id}");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource = resource;
	}
	public String getResource() 
	{
		return resource;
	}

}
