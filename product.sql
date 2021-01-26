create database `productdb`;
use productdb;

create table products (
	id int NOT NULL AUTO_INCREMENT,
    name varchar(120) NOT NULL,
    size int NOT NULL,
    primary key(id)
);