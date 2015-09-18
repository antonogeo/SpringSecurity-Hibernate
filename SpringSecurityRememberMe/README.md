## Synopsis

Simple app that shows Spring Security remember me authentication.

We ask the user for his credentials. If correct, he enters to the app's dashboard. If wrong, he gets error message.

We have 2 user roles. "USER" who can access only the dashboard, and "ADMIN" who can access the dashboard and the admin page.
If "USER" tries to access the admin page he will get redirected to the 403 page.

Dashboard is accessible only by authenticated users.

If user checks the remember me checkbox on the login form, the app will store a cookie to the browser. As long as the cookie is
active, the user can enter to the app without login.

The user has restricted authorization when he is authenticated using Remember me, for security purposes.
This can be tested at the profile page where the remember-me authenticated user cannot change his password.

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