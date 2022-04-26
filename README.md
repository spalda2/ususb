# usu_sb

This Simple Spring Boot projekt needs:
- DB server -> MySQL version 8.0.22 since higher versions need Mac OS 11.x for which I would need a new Mac:)
    - on mac os I had to alter root user password manually from console to be able to login even though I entered the same root password during the installation
- Spring Boot -> Spring Tool Suite 4, version 4.14.0 Release
- both DB server and the Spring app are configured to use plain http
- I haven't discovered how to make Spring Boot to honour @Column(name="xxx") attribute when generating json result set. Maybe more digging needed. None of the two method I found did the trick.

Build:
- Start DB server on its default port
- create schema usu_schema and table employees
    - CREATE TABLE `usu_schema`.`employees` (
          `pk` INT NOT NULL AUTO_INCREMENT,
          `Name` VARCHAR(45) NOT NULL,
          `Age` INT NOT NULL,
          `Position` VARCHAR(45) NOT NULL,
          PRIMARY KEY (`pk`),
          INDEX `Position_Idx` (`Position` ASC) VISIBLE,
          INDEX `Age_Idx` (`Age` ASC) VISIBLE);
- import the project
- Run Debug as UsuSbApplication
- load the test.html to a browser and run the test cases from 1.
- load the usu.html for a slightly better UI
