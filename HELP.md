# Getting Started
### pre-requirement 
    * java 11
    * maven
 
### Reference Documentation
For further reference, please consider the following sections:

    * Clone repo from git OR unzip file if already exist.
    * cd Technical_evaluation_newsAPI
    * for building application=> [ mvn clean install]
    * To run application cd Technical_evaluation_newsAPI\target 
        * run java -jar newsAPI-0.0.1-SNAPSHOT.jar
    
### Testing App
    once application started please open swagger url.
*http://localhost:8080/swagger-ui.html#


###USING DOCKER
    1. cd Technical_evaluation_newsAPI
    2. docker build -t newsAPI .
    3.Run docker using below commnd
        docker run -p 8080:8080 -t newsAPI 
    #####http://localhost:8080/swagger-ui.html#
  

