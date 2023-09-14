RunBook:
Description : It is maven project with TestNG as unit testing framework. 

Folder structure as follows:
src/main/java:=>
Config: It consists of all configuration files.
Config.Drivers : It consists of Browser drivers required to run web tests in particular browser like Chrome, Edge
Utils: It consists of class contains common methods required in framework
web: This package contains classes related to UI testing
api: This package contains classes related to API testing

src/test/java:=>
web: This package contains classes related test Scripts for UI testing
api: This package contains classes related test Scripts for API testing

pom.xml : Contains all dependencies
testng.xml : Runner file to execute the Test Suite
test-output : Stores all test reports for execution
test-output/CSV : Stores CSV files which consits of JSON repsonse

How to Run the Test Suite:
Execute "testng.xml" File

