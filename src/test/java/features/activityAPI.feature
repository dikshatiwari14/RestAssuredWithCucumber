Feature: Validating the Activitiy APIs 

Scenario Outline: Verify the follow activity API to follow a user, tag or author with valid data 
	Given the "<type>" and "<filter>" for request 
	When user calls "followActivityAPI" with "PUT" http request 
	Then the API call got success with status code 200 
	And verify "status" in response maps to "ok" 
	
	Examples: 
		| type     | filter                 |
		| user     | diksha1           |
		| author |    diksha          |
		| tag        | motivational |
		
Scenario Outline: Verify the follow activity API to follow a user, tag or author with invalid data 
	Given the "<type>" and "<filter>" for request 
	When user calls "followActivityAPI" with "PUT" http request 
	Then the API call got success with status code 404 
	And verify "message" in response maps to "<error_message>" 
	And verify "error_code" in response maps to "<error_code>" 
	
	Examples: 
		| type     | filter                |error_message      |error_code |
		| user     | dikshatiwari |User not found.     |30                  |
		| author | dikshatiwari |Author not found.|50                  |
		| tag        | zzzz                 |Tag not found.       | 60                 |
		
Scenario Outline: Verify the get activity API to get the activities of a user, tag or author with invalid data 
	Given the "<type>" and "<filter>" for request 
	When user calls "getActivityAPI" with "GET" http request 
	Then the API call got success with status code 404 
	And verify "message" in response maps to "<error_message>" 
	And verify "error_code" in response maps to "<error_code>" 
	
	Examples: 
		| type     | filter|error_message      |error_code |
		| user     | zzzz |User not found.     |30                  |
		| author | zzzz |Author not found.|50                  |
		| tag        | zzzz |Tag not found.       | 60                 |
		
Scenario Outline: Verify the get activity API to get the activities of a user, tag or author with valid data 
	Given the "<type>" and "<filter>" for request 
	When user calls "getActivityAPI" with "GET" http request 
	Then the API call got success with status code 200 
	
	Examples: 
		| type     | filter|
		| tag     | motivational |
		| author | diksha |
		| user       | dikshatiwari |
		
Scenario: Verify the delete activity API to delete any activity with valid activity id
	Given the activityID of any activity 
	When user calls "deleteActivityAPI" with "DELETE" http request 
	Then the API call got success with status code 200 
	And verify "status" in response maps to "ok" 
	
Scenario Outline: Verify the delete activity API to delete any activity with invalid activity id
	Given the activityID of any activity 
	When user calls "deleteActivityAPI" with "DELETE" http request 
	Then the API call got success with status code 404 
	And verify "message" in response maps to "<error_message>" 
	And verify "error_code" in response maps to "<error_code>" 
	
	Examples: 
		|error_message        |error_code |
	    |Activity not found. |70                  |
