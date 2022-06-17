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

## Gettig Started

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

## Requirments:

- [x] asdf
- [ ] white label fallback
- [ ] return a response entity





