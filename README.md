# User app with Spring Boot & MSSQL
# Using technologies :
- Spring Boot & MVC
- MS SQL Server
- JPA/Hibernate
- Maven

> This Get request returns all users :
```sh
GET http://localhost:8080/rest/users
```

>This Get request returns the user that matches the id path variable :
```sh
GET http://localhost:8080/rest/users/user/{id}
```

>This Get request returns the users that matches the name request parameter :
```sh
GET http://localhost:8080/rest/users/user/byName/{name}
```

>This Get request returns the users that matches the birthDate request parameter :
```sh
GET http://localhost:8080/rest/users/user/byDate/{birthDate}
```

>This Post request creates a new User object that corresponds to the User context sent in the request body :
```sh
POST http://localhost:8080/rest/users
```

>User content sent by this Put request updates the User object that matches the id value in the Database :
```sh
PUT http://localhost:8080/rest/users/{id}
```

>This Delete request delete the User object that matches the id path variable :
```sh
DELETE  http://localhost:8080/rest/users/{id}
```

# For create database :
```sh
CREATE TABLE users (
    id BIGINT NOT NULL IDENTITY PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    citizen VARCHAR(255),
    region VARCHAR(255),
    birth_date DATE
)
```
