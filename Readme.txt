Using postgresql.
Create DATABASE favoritefilms.
Execute query from schema.sql
run App.

RestClient - postman;
reqests:
GET localhost:8080/user - show all user from database users;
GET localhost:8080/user/1 - show user from database users by id;
DEL localhost:8080/user/1 - delete user from database users by id;
PUT localhost:8080/user/2 - update user from database users by id
body JSON (application/json)
 {

   "login" : "user3",

   "pass" : "1111",

   "role" : "2"

  }


POST localhost:8080/user/ - create user from database users by id;
body JSON (application/json)
 {

   "login" : "user3",

   "pass" : "1111",

   "role" : "2"

  }
