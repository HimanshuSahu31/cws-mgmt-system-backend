# CWS Management System - REST API

This is an academic project for courses IT618 - Enterprise Computing and IT619 - Design of Software Systems offered at [DA-IICT](http://www.daiict.ac.in/daiict/index.html).


## About CWS Management System

This project offers the REST API to be consumed by the web platform and an android application. The applications work as a workspace solution which will provide renting of a co-working space for the entrepreneurial and freelancing community as and when needed.


## Deployment

#### Pre-requisites

* Maven Wrapper

#### Steps to install and run

* Clone this repository

`$ git clone https://github.com/archieran/cws-mgmt-system-backend`

* Navigate to the project root folder in Terminal

* Run the maven install command

    * For Windows users
        
        `$ ./mvnw.cmd clean install`

    * For other OS users
    
        `$ ./mvnw clean install`

* Run the Spring Boot Application
    
    `$ ./mvnw spring-boot:run`

* Access the application at URL: [localhost:8080](localhost:8080)


## API Documentation

Once the application is deployed, the API documentation can be accessed at [base url]/swagger-ui.html

In our case, the url should be [localhost:8080/swagger-ui.html](localhost:8080/swagger-ui.html)


## Dependencies

* Java 1.8


## License

CWS Management System is a free software, and may be redistributed under the terms specified in the [LICENSE](/LICENSE) file.