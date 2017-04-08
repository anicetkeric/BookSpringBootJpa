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

```xml
 # DataSource settings: set here your own configurations for the database 
    # connection. In this example we have "dojsb" as database name and 
    # "root" as username and password.
    spring.datasource.url = jdbc:mysql://localhost:3306/<you_database>
    spring.datasource.username = root
    spring.datasource.password = 

    # Keep the connection alive if idle for a long time (needed in production)
    spring.datasource.testWhileIdle = true
    spring.datasource.validationQuery = SELECT 1

    # Show or not log for each sql query
    spring.jpa.show-sql = true

    # Hibernate ddl auto (create, create-drop, update)
    spring.jpa.hibernate.ddl-auto=create

    # Naming strategy
    spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy

    # Use spring.jpa.properties.* for Hibernate native properties (the prefix is
    # stripped before adding them to the entity manager)

    # The SQL dialect makes Hibernate generate better SQL for the chosen database
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

    server.port = 8089

```

### Create an entity class representing a table in your db
```java

@Entity
@Table(name="BOOK")
public class Book implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	
	private String author;
	private double price;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

	
	
	
}

```
### The Data Access Object (Repository): BookRepository.java
```java
@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {

}
```
### Rest Controller BookController.java
```java
@RestController
@RequestMapping("/bookRest")
public class BookController {

	 @Autowired
	 private BookRepository bookRepository;
	

	 @RequestMapping(value="/create", method=RequestMethod.POST)
	 public Book create(@RequestBody Book book) {		
	     try {
	    	 book = bookRepository.save(book);
	       }
	       catch (Exception ex) {
	         return null;
	       }
	     return book;
	 }
	 
	 
	 @RequestMapping(value="/getOne", method=RequestMethod.GET)	
	 public Book read(@RequestParam int id) {
		 Book book = bookRepository.findOne(id);
	     
	     if(book==null) return null;
		return book;
	 }
	 
}
```
