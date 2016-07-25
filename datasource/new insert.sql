use guide;

/*Cities*/
insert ignore into cities(cityName) values('Minsk');
insert ignore into cities(cityName) values('Gomel');

/* Passangers*/
insert ignore into passangers(Name,gender,Age) values('Ivan  Ivanov','male',25);
insert ignore into passangers(Name,gender,Age) values('Elena  Ivanova','female',24);
insert ignore into passangers(Name,gender,Age) values('Petr Petrov','male',26);
insert ignore into passangers(Name,gender,Age) values('Sidr  Sidorov','male',46);
insert ignore into passangers(Name,gender,Age) values('Olga  Karaseva','female',25);
insert ignore into passangers(Name,gender,Age) values('Vladimir  Ershov','male',85);
insert ignore into passangers(Name,gender,Age) values('Vasilisa  Vaskina','female',25);
insert ignore into passangers(Name,gender,Age) values('Vasya  Vasev','male',34);
insert ignore into passangers(Name,gender,Age) values('Artur  Pirozhkov','male',125);
insert ignore into passangers(Name,gender,Age) values('Anna  Lukashenko','female',45);

/*Stations */

INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Lenina str.', 1);
INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Mayakovskogo str.', 1);
INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Esenina str.', 1);
INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Nezavisimosti str.', 1);
INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Mogilevskaya str.', 1);
INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Kirova str.', 1);

INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Frunze str.', 2);
INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Gagarina str.', 2);
INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Pobedy str.', 2);
INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Lazo str.', 2);
INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Chapaeva str.', 2);
INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Chkalova str.', 2);

INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Filimonova str.', 1);
INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Kalinovskogo str.', 1);
INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Nekrasova str.', 1);

INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Stroiteley str.', 2);
INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Lenina str.', 2);
INSERT INTO `guide`.`stations`(Street,id_City)  VALUES ('Pushkina str.', 2);


/* Passengers_stations */

insert into `guide`.`passengers_station`(address_from, address_to, id_passenger) values(1,5,1);
insert into `guide`.`passengers_station`(address_from, address_to, id_passenger) values(12,15,2);
insert into `guide`.`passengers_station`(address_from, address_to, id_passenger) values(13,5,3);
insert into `guide`.`passengers_station`(address_from, address_to, id_passenger) values(3,6,4);
insert into `guide`.`passengers_station`(address_from, address_to, id_passenger) values(10,5,5);
insert into `guide`.`passengers_station`(address_from, address_to, id_passenger) values(2,6,6);
insert into `guide`.`passengers_station`(address_from, address_to, id_passenger) values(11,8,7);
insert into `guide`.`passengers_station`(address_from, address_to, id_passenger) values(14,2,8);
insert into `guide`.`passengers_station`(address_from, address_to, id_passenger) values(2,4,9);
insert into `guide`.`passengers_station`(address_from, address_to, id_passenger) values(12,5,10);


/*transports */

insert into transports(typeTransport) values('Bus');
insert into transports(typeTransport) values('TrolleyBus');
insert into transports(typeTransport) values('Train');
insert into transports(typeTransport) values('Tram');
insert into transports(typeTransport) values('Taxi');


/*transportsroute*/

insert into transportsRoute(numberOfRoute,id_transports) values(10,1);
insert into transportsRoute(numberOfRoute,id_transports) values(15,1);
insert into transportsRoute(numberOfRoute,id_transports) values(23,1);
insert into transportsRoute(numberOfRoute,id_transports) values(50,1);
insert into transportsRoute(numberOfRoute,id_transports) values(45,1);

insert into transportsRoute(numberOfRoute,id_transports) values(1,2);
insert into transportsRoute(numberOfRoute,id_transports) values(2,2);
insert into transportsRoute(numberOfRoute,id_transports) values(3,2);
insert into transportsRoute(numberOfRoute,id_transports) values(4,2);
insert into transportsRoute(numberOfRoute,id_transports) values(5,2);

insert into transportsRoute(numberOfRoute,id_transports) values(1,3);

insert into transportsRoute(numberOfRoute,id_transports) values(10,4);
insert into transportsRoute(numberOfRoute,id_transports) values(20,4);
insert into transportsRoute(numberOfRoute,id_transports) values(30,4);
insert into transportsRoute(numberOfRoute,id_transports) values(40,4);
insert into transportsRoute(numberOfRoute,id_transports) values(50,4);



/* route*/

insert into route values(1,5,8);
insert into route values(1,6,9);
insert into route values(2,5,3);
insert into route values(2,6,4);
insert into route values(2,3,6);
insert into route values(3,2,6);
insert into route values(3,4,2);
insert into route values(4,3,2);
insert into route values(4,6,11);
insert into route values(5,1,8);
insert into route values(5,2,3);
insert into route values(5,7,270);
insert into route values(6,1,9);
insert into route values(6,2,4);
insert into route values(6,4,11);
insert into route values(7,5,270);
insert into route values(7,8,3);
insert into route values(7,9,8);
insert into route values(7,10,6);
insert into route values(8,7,3);
insert into route values(9,7,8);
insert into route values(9,12,2);
insert into route values(10,7,6);
insert into route values(10,12,5);
insert into route values(11,12,11);
insert into route values(12,9,2);
insert into route values(12,10,5);
insert into route values(13,14,9);
insert into route values(13,15,4);
insert into route values(14,13,9);
insert into route values(14,15,4);
insert into route values(15,14,4);
insert into route values(15,13,4);
insert into route values(16,17,3);
insert into route values(16,18,4);
insert into route values(17,16,3);
insert into route values(17,18,8);
insert into route values(18,16,4);
insert into route values(18,17,8);



/* transportRoute_station */

insert into transportRoute_station values(5,11);
insert into transportRoute_station values(7,11);

insert into transportRoute_station values(1,1);
insert into transportRoute_station values(1,6);

insert into transportRoute_station values(2,7);
insert into transportRoute_station values(2,12);
insert into transportRoute_station values(2,2);
insert into transportRoute_station values(3,2);
insert into transportRoute_station values(3,13);
insert into transportRoute_station values(3,14);

insert into transportRoute_station values(4,1);
insert into transportRoute_station values(4,13);

insert into transportRoute_station values(5,6);
insert into transportRoute_station values(5,12);
insert into transportRoute_station values(6,1);
insert into transportRoute_station values(6,6);

insert into transportRoute_station values(7,3);
insert into transportRoute_station values(7,8);
insert into transportRoute_station values(8,3);

insert into transportRoute_station values(9,10);
insert into transportRoute_station values(9,16);
insert into transportRoute_station values(10,8);
insert into transportRoute_station values(10,3);
insert into transportRoute_station values(11,15);
insert into transportRoute_station values(11,16);
insert into transportRoute_station values(12,15);
insert into transportRoute_station values(12,16);
insert into transportRoute_station values(13,4);
insert into transportRoute_station values(14,4);
insert into transportRoute_station values(15,4);
insert into transportRoute_station values(16,5);
insert into transportRoute_station values(17,5);
insert into transportRoute_station values(18,5);

