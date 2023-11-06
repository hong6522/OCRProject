show databases;

create database hongst_db;

select * from user;

create user 'hong'@localhost identified by '1234';

grant all privileges on
hongst_db.*
to 
'hong'@localhost;

