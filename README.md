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
   
##------------Service end points------------------

#### CREATE USER
##### post request
##### http://localhost:8585/user/data/create
##### request body > 
    {
        "name": "sahan",
        "email": "sahan@mail.com",
        "phoneNumber": "121212"
    }
 
#####-----------------------------------------------
#### GET USER
##### get request
##### http://localhost:8585/user/data/get/1
#####-----------------------------------------------
#### UPDATE USER
##### put request
##### http://localhost:8585/user/data/update
##### request body > 
    {
	    "userId": 1,
	    "name": "sahan devaka",
	    "age": 38,
	    "email": "sahan@mail.com",
	    "phoneNumber": "121212"
    }
#####-----------------------------------------------
#### GET ALL USERS
##### get request
##### http://localhost:8585/user/data/getAll
#####-----------------------------------------------
#### DELETE USER
##### delete request
##### http://localhost:8585/user/data/delete?userId=1
#####-----------------------------------------------

 ##Requirements

Java 8

