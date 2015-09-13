## Synopsis

Simple app that shows Spring Security form-based authentication.

We ask the user for his credentials. If correct, he enters to the app's dashboard. If wrong, he gets error message.
Dashboard is accessible only by authenticated users.

## Technologies

Spring MVC, Spring Security, Hibernate, MySQL


## Installation

1. Create a DB and run the /database/springSecuritySimpleAuthenticationDDL.sql

2. Go to /src/main/webapp/WEB-INF/spring-database.xml and replace the TODO_typeYourDBUrl, TODO_typeYourDBUsername, TODO_typeYourDBPassword with your info.

3. Build and run.



**Test Credentials**

Username: testUser
Password : 123456
