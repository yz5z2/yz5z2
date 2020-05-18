CREATE DATABASE order_system charset='utf8';
USE order_system;

drop table if exists seller;
drop table if exists buyer;
drop table if exists food;
drop table if exists order_detail;
drop table if exists order_master;

create table seller
(
   sno                  varchar(100) primary key,
   name                 varchar(100) not null,
   password             varchar(100) not null
)engine=InnoDB;
insert into seller values('1111','admin','admin');

create table buyer
(
   bno                  varchar(100) primary key,
   name                 varchar(100) not null,
   password             varchar(100) not null,
   phone                varchar(100) not null,
   address              varchar(255) not null,
   regdate              datetime 
)engine=InnoDB;


create table food
(
   fid                  varchar(100) primary key,
   name                 varchar(255) not null,
   category             varchar(100) not null,
   price                double,
   amount               int,
   status               int,
   createdate           datetime,
   updatedate           datetime 
)engine=InnoDB;


create table order_detail 
(
   did                  varchar(20) primary key,
   oid                  varchar(20),
   fid                  varchar(100),
   name                 varchar(255) not null,
   price                double,
   quantity             int,
   createdate           datetime,
   updatedate           datetime,
   key `idx_oid` (`oid`)
)engine=InnoDB;


create table order_master
( 
    oid                  varchar(20) primary key,
    bno                  varchar(100),
    name                 varchar(100) not null,
    phone                varchar(100) not null,
    address              varchar(255) not null,
    orderamount          double,
    status               int,
    createdate           datetime,
    updatedate           datetime, 
    key `idx_bno` (`bno`)
)engine=InnoDB;
