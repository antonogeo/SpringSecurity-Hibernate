## Synopsis

Simple app that shows Spring Security authorization.

We ask the user for his credentials. If correct, he enters to the app's dashboard. If wrong, he gets error message.

We have 2 user roles. "USER" who can access only the dashboard, and "ADMIN" who can access the dashboard and the admin page.
If "USER" tries to access the admin page he will get redirected to the 403 page.

Dashboard is accessible only by authenticated users.

## Technologies

Spring MVC, Spring Security, Hibernate, MySQL


## Installation

1. Create a DB and run the /database/queries.sql

2. Go to /src/main/webapp/WEB-INF/spring-database.xml and replace the TODO_typeYourDBUrl, TODO_typeYourDBUsername, TODO_typeYourDBPassword with your info.

3. Build and run.



**Test Credentials**

Username : testUser (role: USER)
Password : 123456

Username : testAdmin (role: ADMIN)
Password : 123456