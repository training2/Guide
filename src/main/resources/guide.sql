drop database guide;

create database if not exists guide;

use guide;

create table if not exists transport (
id int(11) not null auto_increment,
transportType varchar(255) not null,
primary key(id));

create table if not exists station (
id int(11) not null auto_increment,
city varchar(255) not null,
street varchar(255) not null,
primary key(id));

create table if not exists transport_address (
transport_id int(11) not null,
address_id int(11) not null,
foreign key (transport_id) references transport(id) on delete cascade,
foreign key (address_id) references station(id) on delete cascade);

create table if not exists connection (
from_address_id int(11) not null,
to_address_id int(11) not null,
distance int(11) not null,
foreign key (from_address_id) references station(id) on delete cascade,
foreign key (to_address_id) references station(id) on delete cascade);