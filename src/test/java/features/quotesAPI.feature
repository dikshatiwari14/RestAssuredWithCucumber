Feature: Validating the Quotes APIs 
#Add Quote API
Scenario Outline: Verify if quote is successfully added using AddQuote API 
	Given Add Quote Payload with "<author>" "<body>"
	When user calls "addQuoteAPI" with "POST" http request 
	Then the API call got success with status code 200 
	And verify "author" in response maps to "<author>" using "getQuoteAPI" 
	
	Examples: 
		| author | body                                                                                                |
		| Diksha  | Never let your schooling interfere with your education.|
		
Scenario: Verify if the added quote is hidden using hideQuote API
Given quoteID of existing quote 
When user calls "hideQuoteAPI" with "PUT" http request 
Then the API call got success with status code 200 
And verify "user_details.hidden" in response maps to "true" using "getQuoteAPI" 

Scenario: Verify if the added quote is hidden using hideQuote API
Given quoteID of existing quote 
When user calls "favQuoteAPI" with "PUT" http request 
Then the API call got success with status code 200 
And verify "user_details.favorite" in response maps to "true" using "getQuoteAPI" 
		
		
		