# Spring boot implemented tutorial
You can find it via link: https://www.youtube.com/playlist?list=PLqq-6Pq4lTTbx8p2oCgcAQGQyqN8XeA1x
### The main purpose
This tutorial helps to learn the ropes of Spring boot, it shows:
1. Different ways of creating Spring boot application (via Spring Initializr, via adding dependency through)
2. How to send simple requests to embedded Tomcat server
3. Simple implementation the data layer using Spring Data JPA (by CRUD operations)
4. Simple information commands, which might be useful in deploying
5. How to run Spring boot application from console

### How to build it
1. Install gradle on your PC, installation tutorial might be found there https://gradle.org/install/. Be sure to change environment variables. 
2. Execute command line from project directory. Enter command ```build gradle```
3. After building process finish, make sure that the build completed successful.

### How to launch it
1. Execute command line from project directory. Enter command ```gradle bootJar```, wait for results: build must be completed successful.
2. Open root directory of the project.
3. Go to the directory ```gradle/libs/```
4. Double click on Vinnik_sample-0.0.1-SNAPSHOT.jar file - after it application will be executed and Tomcat server will start.
5. * Open browser and in its address bar enter ```localhost:8081/topics```: you will see empty page with "[]" in its start.
    * Open postman (you can download it there: https://www.postman.com/downloads/), choose GET request and enter ```http://localhost:8081/topics```
    
You can find how to write requests for server in tutorial series.