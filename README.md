# Kuehne_Nagel
Assignment

##Start
    Go to Kuehne_Nagel\user-service folder
    open CMD
    execute "mvn spring-boot:run"
    or build the jar file using "mvn install"
	jar file will generate inside \target folder
    then run jar file using "java -jar user-service-0.0.1-SNAPSHOT.jar"
    *Since using H2 inmemory DB, if service is restarted previos data will be cleaned.
    *Service will start with port 8585
##Test
    Execute test cases using "mvn test"
   
##Service end points

#### CREATE
##### http://localhost:8585/user/data/create
##### post request
##### request body > 
    {
        "name": "sahan",
        "email": "sahan@mail.com",
        "phoneNumber": "121212"
    }
 

#### GET
##### http://localhost:8585/user/data/get/1
##### get request

 
#### UPDATE
##### http://localhost:8585/user/data/update
##### put request
##### request body > 
    {
	    "userId": 1,
	    "name": "sahan devaka",
	    "age": 38,
	    "email": "sahan@mail.com",
	    "phoneNumber": "121212"
    }
 
#### GET ALL
##### http://localhost:8585/user/data/getAll
##### get request

 
#### DELETE
##### http://localhost:8585/user/data/delete?userId=1
##### delete request


#Requirements
####Java 8
