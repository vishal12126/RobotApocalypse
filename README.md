 created 3 API's for add, update survivors and get stats about survivors.
You will find swagger basic documentation on this URL "localhost:9192/swagger-ui.html"
 Also adding the postman json collection to import and run the application.
 To keep it simple i havent added psring cloud or eureka since there is not much asyn calling services. other wise we can add eureka as discovery server, then API-clientgateway, hystrix for circuit breaker and zipkin and slueth for for flow debugging.
 To keep application as light wait used in memory h2 DB.
Also added logging for debugging and all logs will be stored in application.log
 Also to debug asyn microservices calls we can use slf4j's method MDC(mapped data contect) using which we can add unique version ids at start of API call in microservices to track the full flow of all the api calls using the same version ID.
Maven is used to package the project. A war file will be generated once use mvn clean install in target folder that can be deployed in any server tomcat or wildfly.
