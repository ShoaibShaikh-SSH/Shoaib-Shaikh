# Home Challenge

This test automation project for a sample REST API implementation Swagger Petstore - OpenAPI 3.0. The tests are implemented using Rest Assured.
	
Instructions to run Swagger Petstore - OpenAPI 3.0 locally:
----------------------
- Clone this project (https://github.com/swagger-api/swagger-petstore)
- Follow instructions from the project's readme file

Proposed Test cases for Automation:
----------------------
**Pet Endpoint**
- Creating a new pet
- Fetch all pets by statuses
- Finding pet by given id
- updating pet by given id
- updating pet by form data

**Store Endpoint**
- Fetch the inventory status
- Place a new order
- Fetch the given order by ID
- Delete an newly created order

**User Endpoint**
- Fetch user details by username
- Create a new user
- Log the user into the system
- Log out the current active session

Solution information
----------------------

Setup Instructions (Macbook)
----------------------

1. Download and install intelliJ (https://www.jetbrains.com/idea/download/#section=mac)
2. Clone this repo (Make sure you are on Master branch):
```
https://github.com/ShoaibShaikh-SSH/Shoaib-Shaikh.git
```
3. Import cloned repo in step 3 as Java project in Eclipse:
	- File->Import->Project from existing sources 
	- Choose `FirstIteration->PetStore-RestAssured` folder
4. Install Maven. Run following command in terminal -> ```brew install maven``` (Pre requisite: brew should be present in the system)
5. Install Allure. Run following command in terminal -> ```brew install allure```
	
Run Automated Tests from IntelliJ / Terminal
----------------------
1. Navigate to 'PetStore-RestAssured' folder from terminal window
2. Run following command -> ``` mvn clean test```

Reporting - Allure reports
----------------------
1. From 'PetStore-RestAssured' folder, navigate to 'target' folder from terminal
2. Run following command -> ```allure serve allure-results```
3. An Allure report will open in browser with the last run report.

Tools/Tech stack
----------------------
- REST-assured
- Maven
- Junit5
- Allure Reports
- Java
- IntelliJ
- Git