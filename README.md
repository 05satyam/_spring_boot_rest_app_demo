# _spring_boot_rest_app_demo

Building an spring boot application just to check the rest api implementation.
It is working on local-host, you just have to fork the repo and run the main class.

API's POSTMAN collection: https://www.getpostman.com/collections/64882b145a546ee2f532

------------------------------PROJECT STRUCTURE---------------------------------
src/
├── main/
│   └── java/
|       ├── com.example/
|       |   └── controller/
|       |           └──MarvelController.java, SpringBootDemoApplication
|       ├── com.example.dao_repo/
|       |   └── CustomRepository.java
|       ├── com.example.entity/
|       |   └── MarvelMovies.java
|       └── com.example.pojo/
|           └── MarvelPojo.java
|       └── com.example.service/
|           └── MarvelMovieService.java
|           └── com.example.service.impl/
|               └── MarvelMovieService.java
└── resources/
    └── application.properties
    └── use case and postman_collection
    └── resources.templates/
