package resources;

public enum APIResources {
	
	createUserAPI("/api/users"),
	updateUserAPI("/api/users/{login}"),
	getUserAPI("/api/users/{login}"),
	createSessionAPI("/api/session"),
	addQuoteAPI("/api/quotes"),
	getQuoteAPI("/api/quotes/{quote_id}"),
	hideQuoteAPI("/api/quotes/{quote_id}/hide"),
	favQuoteAPI("/api/quotes/{quote_id}/fav"),
	followActivityAPI("/api/activities/follow/"),
	deleteActivityAPI("/api/activities/{activity_id}"),
	getActivityAPI("/api/activities/"),
	forgotPasswordAPI("/api/users/forgot_password"),
	resetPasswordAPI("/api/users/reset_password");
	

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
