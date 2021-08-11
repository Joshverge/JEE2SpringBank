# JEESPB

## Build Services
Run command
```shell
mvn clean install
```

## How To Run
Need to start the services one by one to make sure it works correctly.

### Start Eureka Server
Run command
```shell
java -jar ./eurekaserver/target/eurekaserver-1.0.0.jar
```

Eureka Server is running at port 8761 <br/>
To access eureka dashboard: http://localhost:8761

### Start Database Service
Run command
```shell
java -jar ./databaseservice/target/databaseservice-1.0.0.jar
```

Database Service is running at port 8080 <br/>
To access swagger: http://localhost:8080/swagger-ui.html

Database Server is using H2 as data storage <br/>
To access H2 console: http://localhost:8080/h2-console
```
Driver class: org.h2.Driver
JDBS url: jdbc:h2:mem:jeespb
User name: sa
Password: pw
```

Generated one user for login testing
```
Username: abc@xyz.com
Password: asdf123
Name: Name 1
Type: tier-1
```

### Start Login Service
Run command
```shell
java -jar ./loginservice/target/loginservice-1.0.0.jar
```

Login Service is running at port 8081 <br/>
To access swagger: http://localhost:8081/swagger-ui.html

### Start Logoff Service
Run command
```shell
java -jar ./logoffservice/target/logoffservice-1.0.0.jar
```

Logoff Service is running at port 8082 <br/>
To access swagger: http://localhost:8082/swagger-ui.html

