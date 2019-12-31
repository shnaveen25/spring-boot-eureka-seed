## **Spring Boot Eureka Server**

Read more about [Eureka](https://github.com/Netflix/eureka/wiki/Eureka-at-a-glance)

## Local Setup.

**core-service** : Project has common classes used in other micro services. (Note : Do not edit existing files.)

    ./gradlew clean jar publishToMavenLocal
    
This will build the core-service project and make it available in a local maven repository which will be used by other micro-service project.

> core-service:core-service:1.0.0 will be added in  build.gradel file of other  micro-service projects.

Import Following Gradel Projects in IDE.

>  - mv-discover-server (Eureka Server)
>  - mv-model-v1 (Eureka Client-1)
>  - mv-model-v2 (Eureka Client-2)

The Gradle Tasks view shows the available Gradle tasks for your projects. Via the context menu you can run a selected Gradle task. Then open [http://localhost:8761/](http://localhost:8761/)

Swagger URL

 1. mv-model-v1 [http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)
 2. mv-model-v2 [http://localhost:8083/swagger-ui.html](http://localhost:8083/swagger-ui.html)

**Build**

     ./gradlew bootjar -Penv=${ENV}
     
     java -jar mv-model-v1.jar


