Feature: Validating the Activitiy APIs 

Scenario Outline: Verify the follow activity API to follow a user, tag or author with valid data
Given the "<type>" and "<filter>" to follow
When user calls "followActivityAPI" with "PUT" http request 
Then the API call got success with status code 200 
And verify "status" in response maps to "ok"

Examples:
		| type     | filter                 |
		| user     | diksha1           |
		| author |    diksha          |
		| tag        | motivational |
		
Scenario Outline: Verify the follow activity API to follow a user, tag or author with invalid data
Given the "<type>" and "<filter>" to follow
When user calls "followActivityAPI" with "PUT" http request 
Then the API call got success with status code 404 
And verify "message" in response maps to "<error_message>"
And verify "error_code" in response maps to "<error_code>"

Examples:
		| type     | filter                |error_message      |error_code |
		| user     | dikshatiwari |User not found.     |30                  |
		| author | dikshatiwari |Author not found.|50                  |
		| tag        | zzzz                 |Tag not found.       | 60                 |