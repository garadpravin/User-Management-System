# User Management System: Rest APIs
## General Information
This is a maven build tool spring boot application project to implement REST APIs for User Management System. Basically there are general operations like add, update, delete and get user details.
Here there is no password authentication maintained to update, delete and get details of user profile. These are simple APIs which produces and consumes JASON payload.

## Technologies used for implementation:
1. Spring Boot Framework.
2. REST API architectural style.
3. In Mem database: H2.
4. Application Server: Tomcat.


## Project Structure
We have different packages created to keep our implementation modularized.

1. com.de.user.manage --> This is a main application start mark for Spring Boot application.
2. com.de.user.manage.entities --> UserEntity model class (POJO) is implemented to store and retrieve User object to and from database. ResponsePayLoad model class (POJO) is implemented in order to send the response object back in form of JASON.
3. com.de.user.manage.repositories --> It has JPA repository.
4. com.de.user.manage.controller --> It has a UserController java class file which contains REST APIs implementation.

## REST APIs

Media Type: JASON request and response.

1. http://localhost:8080/api/addUser --> API to add new user. ##Input parameter: UserEntity object ##Output parameter: ResponsePayLoad object.
2. http://localhost:8080/api/modifyUser --> API to update information of user. ##Input parameter: UserEntity object ##Output parameter: ResponsePayLoad object.
3. http://localhost:8080/api/deleteUser --> API to delete information of user. ##Input parameter: UserEntity object ##Output parameter: ResponsePayLoad object.
4. http://localhost:8080/api/getUser --> API to get informaion of user. ##Input parameter: String email id ##Output parameter: ResponsePayLoad object.

##Steps to run application

Step 1: Open cmd. Got to the root path of the project.
Step 2: Run command --> mvn clean install.
Step 3: Run commmnad --> mvn spring-boot:run.
Step 4: Open any API testing tool and hit to the above mentioned APIS.