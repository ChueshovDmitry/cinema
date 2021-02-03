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
- Spring Boot 2
- Spring Data
- Maven 3
- Java 8
- REST API
- PostgreSql
- Junit 5     

Installing the app:
- Postgre is required.
- Create a database:
 If necessary, generate a Database filled with test data, for you need
      open the application.properties file in the controller \src\main\resources folder,
      and specify the value "create" in the line "spring.jpa.hibernate.ddl-auto = create".
      In this case, when starting the application, the database "mydb" will be created, filled with
      test data from file dao\src\main\resources\populateDB.sql
 - To create an empty database and tables in PostgreSQL, run the SQL\createDB.bat file, which will create the database "mydb" with all the necessary tables.
3) In the web\src\main\resources folder open the application.properties file,
   change the username and password for accessing the database by changing the value in the lines
   "spring.datasource.username" and "spring.datasource.password".
4) To package and run the project, you need Tomcat version 9.0 or higher and Maven 3.*
5) Run the mvn_package.bat file
6) After successful packaging, you need to install the web-0.0.1.war file located in the controller\target\scooter_rental.war to folder on the Tomcat server.