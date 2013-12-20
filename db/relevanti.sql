grant all privileges on *.* to 'root'@'%' identified by 'mysql' with grant option; 
grant replication slave on *.* to 'replicant'@'localhost' identified by 'replicant'; 
grant replication slave on *.* to 'replicant'@'%' identified by 'replicant'; 
 
set global sql_mode=STRICT_ALL_TABLES; 
set names UTF8; 
 
drop database if exists relevanti; 
 
create database relevanti default character set utf8; 
use relevanti; 
 
create table Users ( 
Id int(8) unsigned not null auto_increment, 
UserName varchar(10) not null, 
PassWord varchar(10) not null, 
unique (Username), 
primary key (Id)) engine = InnoDB;

insert into Users(UserName,PassWord) values('fbratu','manowar')
insert into Users(UserName,PassWord) values('admin','h4ck3r')