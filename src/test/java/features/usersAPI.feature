Feature: Validating the Users APIs 

Scenario Outline: Verify if user is successfully added using CreateUser API 
	Given Create User Payload with "<login>" "<email>" "<password>" 
	When user calls "createUserAPI" with "POST" http request 
	Then the API call got success with status code 200 
	And verify login generated maps to "<login>" using "getUserAPI" 
	
	Examples: 
		| login            | email                          | password  |
		| diksha1      | diksha7@rest.com| Pass@123 |
		
Scenario Outline: Verify if user is added with invalid data using CreateUser API 
	Given Create User Payload with "<login>" "<email>" "<password>" 
	When user calls "createUserAPI" with "POST" http request 
	Then the API call got success with status code 200 
	And "message" in response body is "Email is not a valid email; Password is too short (minimum is 5 characters)"
	
	Examples: 
		| login                | email              | password  |
		| diksha12345| diksha@rest | Pas              |
		
		
Scenario Outline: Verify if user is successfully updated using UpdateUser API 
	Given Update User Payload with "<login>" "<email>" "<password>" "<facebook_username>" 
	When user calls "updateUserAPI" with "PUT" http request 
	Then the API call got success with status code 200 
	And "message" in response body is "User successfully updated." 
	
	Examples: 
		| login       | email                          | password   | facebook_username |
		| diksha7 | _diksha@rest.com| Pass@123  | diksha@fb1                 |