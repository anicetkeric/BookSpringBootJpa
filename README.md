# BookSpringBootJpa
Spring Boot via Spring Data JPA and Hibernate with MySQL

REST APIs using Spring Data JPA and Spring Boot with Mysql.

## Tools & technologies used 
1.	Java 1.8
2.	Maven > 3.0
3.	Postman to test our API: https://www.getpostman.com/apps
4.	Mysql 5
5.	Eclipse

In Eclipse, create your project spring boot( Spring Starter project) and add  dependencies for this project like WEB, SPRING DATA JPA, and MYSQL.

####	Dependencies (POM.xml)

```xml
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```
#### Configuration application.properties file

```src/main/resources/application.properties```
