## Synopsis

Simple app that shows many points of the Spring Security authorization.

**Authentication**
We ask the user for his credentials. If correct, he enters to the app's dashboard. If wrong, he gets error message.

**Authorization**
We have 2 user roles. Both have  access to the dashboard and object pages. Only admin has access to admin page.
If "USER" tries to access the admin page he will get redirected to the 403 page.
Dashboard and object page are accessible only by authenticated users.


On the object page the admin can create and view objects while the user can only view them.
The access control is implemented both in jsp's(sec tag) and in service layer(method security with annotations).


## Technologies

Spring MVC, Spring Security, Hibernate, MySQL


## Installation

1. Create a DB and run the /database/queries.sql

2. Add your DB info to db.properties file.

3. Build and run.



**Test Credentials**

Username : testUser (role: USER)
Password : 123456

Username : testAdmin (role: ADMIN)
Password : 123456