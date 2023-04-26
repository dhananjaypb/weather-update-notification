# weather-update-notification
API to create and fetch notification details.

It have below endpoints.

1. Create new Notification Details
	endpoint: /create
	eg.: http://localhost:8081/weather-update-notification/create
	method: POST
	request payload: 
	
	{
    "name":"User-3",
    "city":"Mumbai",
    "temp":"23",
    "channel":"Slack"
	}
		
	Response status code:
	for successful execution : 200 OK
	If Invalid Payload provided like values not provided : 400 BAD REQUEST
	If fail while creating details : 500 INTERNAL SERVER ERROR
	
2. Fetch All Notification Details
	endpoint: /getAllNotificationDetails
	eg.: http://localhost:8081/weather-update-notification/getAllNotificationDetails
	method: GET
	response payload: 
	[
    {
        "name": "User-3",
        "city": "Mumbai",
        "temp": "23",
        "channel": "Slack"
    }]
		
	Response status code:
	for successful execution : 200 OK
	If Invalid Payload provided like values not provided : 204 NO CONTENT
	If fail while creating details : 500 INTERNAL SERVER ERROR
