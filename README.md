# serenitybddrestinspanishtraining
Curso de serenity Rest en español. La lista de reproduccion del curso es: https://www.youtube.com/playlist?list=PLeo6Q1inqlOeti5rRcCvKbB_WDymxcAXO


## Requirements
- Node
- JDK 1.8
- Maven

## Download req/res
- Clone repo ->  git clone https://github.com/jdmesalosada/reqres.git

Start the application:
- Navigate to the cloned folder
- Install dependencies: npm install
- Start the app: node app.js

## Run the all the tests
- mvn clean verify

## Run tests by tag
- mvn clean verify -Dcucumber.filter.tags="@signup"
- mvn clean verify -Dcucumber.filter.tags="@update"

## Run tests in a specific environment
- mvn verify -Pdev -Dcucumber.filter.tags="@signup"
- mvn verify -Pprod -Dcucumber.filter.tags="@update"

or

- mvn verify -Drestapi.baseurl=http://localhost:5000/api


