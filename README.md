# Discounts Calculator for Retail
Discount Calculators based on the customer type and discount profile

Follow the steps below to get started:

1. [Prerequisites](#1-prerequisites)
2. [Prerequisites](#2-build-and-run-spring-boot-application)
3. [Prerequisites](#3-api-documentaion)
4. [Prerequisites](#4-test-the-application)

## 1. Prerequisites
	Please make sure that below the Software/Tools are already installed in your machine.	
	1. JDK 8
	2. Maven build tool
	3. Spring Tool Suite (Optional)

##2.  Build and Run Spring Boot Application
	1. Go to any folder in your machine and clone this repo
		https://github.com/abdulhaqshaik/retaildiscounts.git
	2. Go to retailsdiscounts app folder
	3. run this command to build
		mvn clean install
	4. You can see Junit test running in the console.
	5. Once built is done successfully, the Code Coverage report is generated inside target/surefire-reports
	6. run this command to run the application 
	7. Open the browser and go to below the URL to check the application running.
		http://localhost:8080/

##3.  API Documentaion
	Check the Swagger UI in below the URL
		http://localhost:8080/swagger-ui.html

##4.  Test the Application
	1. Use Postman to test the application
	2. Type the url http://localhost:8080/amount/net
	3. Select POST Method and Body->raw->JSON
	4. Pass input JSON like below
		{
			"txn_id" : "123",
			"txn_date":"25-01-2019",
			"customer_id":"1",
			"list":[
			{"id":1,"name":"Towel","desc":"towel","price":600.00,"grocery":false},
			{"id":2,"name":"Rice","desc":"Rice","price":200.00,"grocery":true},
			{"id":3,"name":"Milk","desc":"Milk","price":200.00,"grocery":true}
		   	]
		}
	5. Submit the request by clicking on Send Button
	6. Check the Output JSON 
		{
 			"status_code": "SUCCESS",
    			"status_desc": "Net Amount generated successfully after discounts",
    			"txn_id": 123,
    			"net_payable": 770
		}











