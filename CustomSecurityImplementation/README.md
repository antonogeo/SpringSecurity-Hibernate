## Synopsis

Simple app that shows a custom security implementation. We perform authentication, authorization, validation and encryption without the use of
a security framework.

We ask the user for his credentials. If correct, he enters to the app's dashboard. If wrong, he gets error message.
We also validate the form, using both Spring Validator and Hibernate Validator. We check for empty fields and for
username length.(5 char < username < 15 char).

We have 2 user roles. "USER" who can access only the dashboard, and "ADMIN" who can access the dashboard and the admin page.
If "USER" tries to access the admin page he will get redirected to dashboard.

Dashboard is accessible only by authenticated users.

The password is stored and handled encrypted using bcrypt.

## Technologies

Spring MVC, Hibernate, MySQL


## Installation

1. Create a DB and run the /database/queries.sql

2. Go to /src/main/webapp/WEB-INF/spring-database.xml and replace the TODO_typeYourDBUrl, TODO_typeYourDBUsername, TODO_typeYourDBPassword with your info.

3. Build and run.



**Test Credentials**

Username : testUser (role: USER)
Password : 123456

Username : testAdmin (role: ADMIN)
Password : 123456