# Demo-simple-API

This is a small API for demonstration purposes that implements:
- CRUD
- managed/transactionl state for PUTs
- local postgres DB
- JPA

It's real simple.  I didn't even use lombok

### Dependencies

[Open JDK 17](https://adoptopenjdk.net/releases.html) or
[JDK 17](https://www.oracle.com/java/technologies/java-se-glance.html)  
[postgres](https://www.postgresql.org/download/) This can only be run locally; there is no deployed server.
- running on port 5432(default) using the coffeepot DB(you may need to create this DB unles you have a coffeepot DB you're not using anymore *see bellow*)
- username: postgres
- password: root

## Getting Started

run $`mvn spring-boot:run` if your path is set, or navigate to 
src/main/java/io.ex.../DemoCoffeePotServiceRestApplication.main()  

[GET all coffee pots endpoint](http://localhost:8080/api/v1/coffeepot)  
[Swagger]()  
**Postman**  
**Testing**  
Linted using Google style guid `ctrl+alt+L` ~~if you import the scheme, or `ctrl+shift+A` if you use
the plugin.~~

####  How to set up the coffee_pot DB in postgres
1. download [postgres](https://www.postgresql.org/download/)
2. $ `psql -U postgres`
3. if there's no coffeepot DB 
   1. postgres=#`\l` 
   2. then postgres=#`CREATE DATABASE coffeepot;` 
   3. NOTE: if you ever forget the semicolon, just type the semicolon and press enter to run the command
4. postgres=# `GRANT ALL PRIVILEGES ON DATABASE "coffeepot" TO postgres;`
5. ensure the DB was created
   1. postgres=# `\c coffeepot`
   2. coffeepot=# `\d`
6. run DemoCoffeePotServiceRestApplication.main() to start this API
7. coffeepot=# `SELECT * FROM coffee_pot;`
8. Verify that you see many coffeepots

## Requirments:

1. -[x] Given a GET request is made to "/coffeepot", then all coffee pots are returned in a JSON
   array, and the status code is 200.
2. -[ ] Given a GET request is made to "/coffeepot?<some-query-here>", then all users that
   meet the query criteria are returned in a JSON array, and the status code is 200.
   Queryable fields include:
   1. -[ ] brand
   2. -[ ] sku
   3. -[ ] releaseDate
   4. -[ ] age
3. -[ ] Given a GET request is made to "/users", and given no users exist, then an empty
          JSON array is returned, and the status code is 200.
4. -[ ] Given a user exists, when a GET request is made to "/users/<that-user-id>", then
   that user is returned, with a status code of 200.
5. -[ ] Given a GET request is made to "/users/<non-existent-id>", then an error
   response is returned with a status code of 404
6. -[ ] Given a valid user has been provided in a JSON request body, when a POST
   request is made to "/users", then a user entity is stored in a database, and a
   JSON representation of the newly created user is returned, with a status code of 201.
7. -[ ] Given a valid user has been provided in a JSON request body, and given that
   user's email address has been used already, when a POST request is made to
   "/users", then an error response is returned with a status code of 409.
8. -[ ] iven an invalid user has been provided in a JSON request body, when a POST
   request is made to "/users", then an error response is returned with a status code
   of 400.
9. -[ ] Given a user exists, and given that user's JSON representation has been altered
    and provided in a request body, when a PUT request is made to
    "/users/<that-user-id>", then the user is updated in the database, and a JSON
    representation of the newly updated user is returned, with a status code of 200.
10. -[ ] Given a PUT request is made to "/users/<non-existent-id>", then an error
    response is returned with a status code of 404.
11. -[ ] Given JSON of an existing user, and given the email field has been updated to a
    different user's email, when a PUT request is made to "/users/<that-user-id>",
    then an error response is returned with a status code of 409.
12. -[ ] Given JSON of an existing user, and given updates have caused any field to
    become invalid, when a PUT request is made to "/users/<that-user-id>", an error
    response is returned with a status code of 400.
13. -[ ] Given a user exists, when a DELETE request is made to "/users/<that-user-id>",
    then that user is deleted, and a status code of 204 is returned.
14. -[ ] Given a DELETE request is made to "/users/<non-existent-id>", then a status code
    of 404 is returned.
15. Validation Requirements *All of the following fields are required, and have additional validation
    needs as specified*
    1. -[ ] id must match id of path parameter (PUT only)
    2. -[ ] brand 
    3. -[ ] sku must be in format XXXX-XXXXXXXX alpha numeric
    4. -[ ] releaseDate
16. **Non Functional Requirements:**  
17. -[ ] Given the database is not running, when a request is made to a registered
    endpoint, then an error response is returned with a status code of 503.
18. -[ ] Given a request is made to a registered endpoint, when an unexpected server
    error occurs, then an error response is returned with a status code of 500.
19. -[ ] Postman collection is created and provided as a link in the README. The
    postman collection demonstrates all of the 2XX and 4XX functional
    requirements.  
20. -[ ] README includes a minimum of description, pre-requisites, usage, and testing
    sections.
21. -[ ] A valid .gitignore file is used, and ignored files do not exist in the remote
    repository.
22. -[ ] Google's Java coding standards are met and instructions on how to lint the
    project are included in the README.
23. -[ ] Java Docs style code comments are present on all public classes and methods.
24. -[ ] Unit tests cover at least 75% of any services (e.g. validation). Instructions for how
    to run the unit tests with code coverage are included in the README.
25. -[ ] Layered architecture is used for proper separation of concerns.
26. -[ ] Integration Testing covers payload, content type, and status code tests of all 2XX
    scenarios.
27. -[ ] Application logs any error scenarios to a file.
28. -[ ] Accurate swagger documentation is in place for all endpoints.













- [ ] white label fallback
- [x] return a response entity





