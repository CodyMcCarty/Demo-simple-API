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

- [x] 52:47 http://localhost:8080/api/v1/coffeepot and update 
- [ ] white label fallback
- [ ] return a response entity





