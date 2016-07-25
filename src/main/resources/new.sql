create database if not exists guide;
use guide;


create table  if not exists cities (
id int primary key auto_increment,
cityName varchar(100) not null
);


create table  if not exists passangers(
id int primary key auto_increment,
namePassanger varchar(200) not null,
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
city_id int not null,
foreign key(city_id) references cities(id) on delete cascade
);


create table if not exists transportsRoute(
id int primary key auto_increment,
numberOfRoute int not null,
transport_id int not null,
foreign key(transport_id) references transports(id) on delete cascade
);

create table if not exists passengers_station(
id int not null auto_increment,
address_from int not null,
address_to int not null,
passenger_id int not null,
primary key(id),
foreign key (address_from) references stations(id) on delete cascade,
foreign key (address_to) references stations(id) on delete cascade,
foreign key (passenger_id) references passangers(id) on delete cascade
);

create table transportRoute_station(
station_id int not null,
transport_id int not null,
foreign key (station_id) references stations(id) on delete cascade,
foreign key (transport_id) references transportsRoute(id) on delete cascade
);


create table route(
station_from int not null,
station_to int not null,
distance int not null,
foreign key(station_from) references stations(id) on delete cascade,
foreign key(station_to) references stations(id) on delete cascade
);


create table if not exists orders(
id int primary key auto_increment,
orderId int not null,
route text not null,
foreign key(orderId) references passengers_station(id) on delete cascade
);