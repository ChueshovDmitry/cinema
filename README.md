Application to store history about cinema.
The system stores information on the subject:

Director- id, first name, last name, birth date;
Film - id,name,realese date,genre,foreign key on director 

The web application enables communication through the REST API. 

Implemented functionality:
- Director and Film registration in the system
- Editing data about Director and Film .
- Getting information about all director and film by ID.
- Find edirector by name
- Find film by start date and end date
- Ability to add / remove / edit director and film

The application complies with the principles of the MVC and has a modular structure. 
There is a database initialization script (mydb.sql) and JUnit-tests that cover the main functionality. 

Technologies used:
- Java 8
- Spring Boot 2
- Spring Data
- Maven 3
- REST API
- PostgreSql
- Junit 5     


Installing the app:
- Postgre is required.
- Create a database:
 If necessary, generate a Database filled with test data, for you need
      open the application.properties file in the controller \src\main\resources folder,
      and specify the value "create" in the line "spring.jpa.hibernate.ddl-auto = create".
- To create an empty database and tables in PostgreSQL, run the SQL\createDB.bat file, which will create the database "mydb" with all the necessary tables.
- In the web\src\main\resources folder open the application.properties file,
   change the username and password for accessing the database by changing the value in the lines
   "spring.datasource.username" and "spring.datasource.password".
- To package and run the project, you need Tomcat version 9.0 or higher and Maven 3.*
- Run the mvn_package.bat file
- After successful packaging, you need to copy(install the web-0.0.1.war file located in the web/target/web-0.0.1.war to folder on the Tomcat server in path:: Tomcat 8.5\webapps