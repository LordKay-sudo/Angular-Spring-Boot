
# crud-app
#Basic Angular10 and Spring Boot crud app with a MySQL backend

#It has added features like filtering and sorting.

#Username: expenseuser password:expensepassword

#I'll add more css and security features in the next few days

# Spring Boot and Angular full stack app with JWT Authentication example with Spring Security & Spring Data JPA

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

4. Angular - 10.x.x

5. Node - 12.x.x

6. Npm - 6.x.x


## backend

## Dependency
```
â€ MySQL:
```xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <scope>runtime</scope>
</dependency>
```
## Configure Spring Datasource, JPA, App properties
Open `src/main/resources/application.properties`

```
- For MySQL
```
spring.datasource.url=jdbc:mysql://localhost:3306/expenseapplication?userSSL=false
spring.datasource.username= expenseapplication
spring.datasource.password= #javaapp#123
/* spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect */


spring.jpa.generate-ddl=true
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration
# App Properties
myapp.expenseapp.jwtSecret= expenseAppSecretKey
myapp.expenseapp.jwtExpirationMs= 86400000
```
## Run Spring Boot application
```
mvn spring-boot:run
```

## Run following SQL insert statements
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

## Frontend - Angular10

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`.
```
