drop database guide;

create database if not exists guide;
use guide;


create table  if not exists cities (
id int primary key auto_increment,
cityName varchar(100) not null
);


create table  if not exists passangers(
id int primary key auto_increment,
name varchar(200) not null,
gender varchar(45) not null check (gender ='male'or gender ='female'),
age int not null
);

create table if not exists transports(
id int primary key auto_increment,
typeTransport varchar(45) not null
);

 

create table if not exists stations(
id int primary key auto_increment,
street varchar(45) not null,
id_City int not null,
foreign key(id_City) references cities(id) on delete cascade 
);


create table if not exists transportsRoute(
id int primary key auto_increment,
numberOfRoute int not null,
id_transports int not null,
foreign key(id_transports) references transports(id) on delete cascade
);

create table if not exists passengers_station(
id int not null auto_increment,
address_from int not null,
address_to int not null,
id_passenger int not null,
primary key(id),
foreign key (address_from) references stations(id) on delete cascade,
foreign key (address_to) references stations(id) on delete cascade,
foreign key (id_passenger) references passangers(id) on delete cascade
);


create table transportRoute_station(
id_station int not null,
idTransport int not null,
foreign key (id_station) references stations(id) on delete cascade,
foreign key (idTransport) references transportsRoute(id) on delete cascade
);


create table route(
station_from int not null,
station_to int not null,
distance int not null,
foreign key(station_from) references stations(id) on delete cascade,
foreign key(station_to) references stations(id) on delete cascade
);
