
create database if not exists guide;

use guide;

create table if not exists transport (
id int(11) not null auto_increment,
transportType varchar(155) not null,
primary key(id));

create table if not exists address (
id int(11) not null auto_increment,
city varchar(155) not null,
street varchar(155) not null,
primary key(id));

create table if not exists transport_address (
transport_id int(11) not null,
address_id int(11) not null,
foreign key (transport_id) references transport(id) on delete cascade,
foreign key (address_id) references address(id) on delete cascade);

create table if not exists connection (
from_address_id int(11) not null,
to_address_id int(11) not null,
distance int(11) not null,
foreign key (from_address_id) references address(id) on delete cascade,
foreign key (to_address_id) references address(id) on delete cascade);






INSERT IGNORE INTO transport (id, transportType) VALUES (1, 'bus');
INSERT IGNORE INTO transport (id, transportType) VALUES (1, 'trolleybus');
INSERT IGNORE INTO transport (id, transportType) VALUES (3, 'train');
INSERT IGNORE INTO transport (id, transportType) VALUES (4, 'tram');
INSERT IGNORE INTO transport (id, transportType) VALUES (5, 'taxi');

INSERT IGNORE INTO address (city, street) VALUES ('Minsk', 'Yesenyna St.');
INSERT IGNORE INTO address (city, street) VALUES ('Minsk', 'Lenina St.');
INSERT IGNORE INTO address (city, street) VALUES ('Minsk', 'Sverdlova St.');
INSERT IGNORE INTO address (city, street) VALUES ('Minsk', 'Pushkina St.');
INSERT IGNORE INTO address (city, street) VALUES ('Minsk', 'Gebbelsa St.');
INSERT IGNORE INTO address (city, street) VALUES ('Minsk', 'Slobodskaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Minsk', 'Tirazhnaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Minsk', 'Mayakovskogo St.');
INSERT IGNORE INTO address (city, street) VALUES ('Minsk', 'Mira St.');
INSERT IGNORE INTO address (city, street) VALUES ('Minsk', 'Ulianovskaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Minsk', 'Glubokaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Minsk', 'Mironova St.');
INSERT IGNORE INTO address (city, street) VALUES ('Minsk', 'Pavlova St.');
INSERT IGNORE INTO address (city, street) VALUES ('Minsk', 'Malaya Arnautskaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Minsk', 'Shirokaya St.');

INSERT IGNORE INTO address (city, street) VALUES ('Brest', 'Smirnova St.');
INSERT IGNORE INTO address (city, street) VALUES ('Brest', 'Kombinatnaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Brest', 'Yuzhnaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Brest', 'Michurina St.');
INSERT IGNORE INTO address (city, street) VALUES ('Brest', 'Yasnaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Brest', 'Letnaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Brest', 'Malinovaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Brest', 'Chistaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Brest', 'Korotkaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Brest', 'Belaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Brest', 'Polskaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Brest', 'Livanova St.');
INSERT IGNORE INTO address (city, street) VALUES ('Brest', 'Griboedova St.');
INSERT IGNORE INTO address (city, street) VALUES ('Brest', 'Cetkin St.');
INSERT IGNORE INTO address (city, street) VALUES ('Brest', 'Lilovaya St.');

INSERT IGNORE INTO address (city, street) VALUES ('Gomel', 'Kizshevatova St.');
INSERT IGNORE INTO address (city, street) VALUES ('Gomel', 'Ozernaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Gomel', 'Cvetochnaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Gomel', 'Lazurnaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Gomel', '9 Maya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Gomel', 'Pivnaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Gomel', 'Bogdanova St.');
INSERT IGNORE INTO address (city, street) VALUES ('Gomel', 'Dvorkina St.');
INSERT IGNORE INTO address (city, street) VALUES ('Gomel', 'Krasnova St.');
INSERT IGNORE INTO address (city, street) VALUES ('Gomel', 'Chapaeva St.');
INSERT IGNORE INTO address (city, street) VALUES ('Gomel', 'Derevenskaya St.');
INSERT IGNORE INTO address (city, street) VALUES ('Gomel', 'Libnehta St.');
INSERT IGNORE INTO address (city, street) VALUES ('Gomel', 'Koroleva St.');
INSERT IGNORE INTO address (city, street) VALUES ('Gomel', 'Gastello St.');
INSERT IGNORE INTO address (city, street) VALUES ('Gomel', 'Krizhanovskogo St.');


/*Транспорт ,который ходит в адреса */
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 2);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 3);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 4);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 7);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 9);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 11);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 15);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 18);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 19);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 11);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 14);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 17);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 19);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 33);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 37);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 38);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 40);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 41);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (1, 45);


INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 2);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 5);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 6);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 8);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 10);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 12);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 14);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 17);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 19);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 13);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 15);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 20);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 22);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 25);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 27);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 29);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 30);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 32);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (2, 43);


INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (3, 10);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (3, 25);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (3, 40);

INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (4, 1);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (4, 4);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (4, 7);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (4, 8);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (4, 11);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (4, 13);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (4, 16);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (4, 17);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (4, 18);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (4, 22);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (4, 28);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (4, 30);
INSERT IGNORE INTO transport_address (transport_id, address_id) VALUES (4, 45);

/*Расстояние между вокзалами разных городов*/

INSERT IGNORE INTO connection VALUES (10, 25, 270);
INSERT IGNORE INTO connection VALUES (25, 40, 250);
INSERT IGNORE INTO connection VALUES (10, 40, 300);

/*Расстояние между адресами 1-го города*/
INSERT IGNORE INTO connection VALUES (1,1,0 );
INSERT IGNORE INTO connection VALUES (1,2,3 );
INSERT IGNORE INTO connection VALUES (1,3, 3);
INSERT IGNORE INTO connection VALUES (1,4 , 5);
INSERT IGNORE INTO connection VALUES (1, 5, 7);
INSERT IGNORE INTO connection VALUES (1, 6, 5);
INSERT IGNORE INTO connection VALUES (1, 7, 10);
INSERT IGNORE INTO connection VALUES (1, 8, 15);
INSERT IGNORE INTO connection VALUES (1, 9, 12);
INSERT IGNORE INTO connection VALUES (1, 10,11 );
INSERT IGNORE INTO connection VALUES (1, 11, 2);
INSERT IGNORE INTO connection VALUES (1, 12, 1);
INSERT IGNORE INTO connection VALUES (1, 13, 16);
INSERT IGNORE INTO connection VALUES (1, 14, 18);
INSERT IGNORE INTO connection VALUES (1, 15, 6);

INSERT IGNORE INTO connection VALUES (2,2,0 );
INSERT IGNORE INTO connection VALUES (2,3, 3);
INSERT IGNORE INTO connection VALUES (2,4 , 5);
INSERT IGNORE INTO connection VALUES (2, 5, 7);
INSERT IGNORE INTO connection VALUES (2, 6, 5);
INSERT IGNORE INTO connection VALUES (2, 7, 10);
INSERT IGNORE INTO connection VALUES (2, 8, 15);
INSERT IGNORE INTO connection VALUES (2, 9, 12);
INSERT IGNORE INTO connection VALUES (2, 10,11 );
INSERT IGNORE INTO connection VALUES (2, 11, 2);
INSERT IGNORE INTO connection VALUES (2, 12, 1);
INSERT IGNORE INTO connection VALUES (2, 13, 16);
INSERT IGNORE INTO connection VALUES (2, 14, 18);
INSERT IGNORE INTO connection VALUES (2, 15, 6);

INSERT IGNORE INTO connection VALUES (3,3,0 );
INSERT IGNORE INTO connection VALUES (3,4 , 5);
INSERT IGNORE INTO connection VALUES (3, 5, 7);
INSERT IGNORE INTO connection VALUES (3, 6, 5);
INSERT IGNORE INTO connection VALUES (3, 7, 10);
INSERT IGNORE INTO connection VALUES (3, 8, 15);
INSERT IGNORE INTO connection VALUES (3, 9, 12);
INSERT IGNORE INTO connection VALUES (3, 10,11 );
INSERT IGNORE INTO connection VALUES (3, 11, 2);
INSERT IGNORE INTO connection VALUES (3, 12, 1);
INSERT IGNORE INTO connection VALUES (3, 13, 16);
INSERT IGNORE INTO connection VALUES (3, 14, 18);
INSERT IGNORE INTO connection VALUES (3, 15, 6);

INSERT IGNORE INTO connection VALUES (4, 5, 7);
INSERT IGNORE INTO connection VALUES (4, 6, 5);
INSERT IGNORE INTO connection VALUES (4, 7, 10);
INSERT IGNORE INTO connection VALUES (4, 8, 15);
INSERT IGNORE INTO connection VALUES (4, 9, 12);
INSERT IGNORE INTO connection VALUES (4, 10,11 );
INSERT IGNORE INTO connection VALUES (4, 11, 2);
INSERT IGNORE INTO connection VALUES (4, 12, 1);
INSERT IGNORE INTO connection VALUES (4, 13, 16);
INSERT IGNORE INTO connection VALUES (4, 14, 18);
INSERT IGNORE INTO connection VALUES (4, 15, 6);

INSERT IGNORE INTO connection VALUES (5, 5, 0);
INSERT IGNORE INTO connection VALUES (5, 6, 5);
INSERT IGNORE INTO connection VALUES (5, 7, 10);
INSERT IGNORE INTO connection VALUES (5, 8, 15);
INSERT IGNORE INTO connection VALUES (5, 9, 12);
INSERT IGNORE INTO connection VALUES (5, 10,11 );
INSERT IGNORE INTO connection VALUES (5, 11, 2);
INSERT IGNORE INTO connection VALUES (5, 12, 1);
INSERT IGNORE INTO connection VALUES (5, 13, 16);
INSERT IGNORE INTO connection VALUES (5, 14, 18);
INSERT IGNORE INTO connection VALUES (5, 15, 6);


INSERT IGNORE INTO connection VALUES (6, 6, 0);
INSERT IGNORE INTO connection VALUES (6, 7, 10);
INSERT IGNORE INTO connection VALUES (6, 8, 15);
INSERT IGNORE INTO connection VALUES (6, 9, 12);
INSERT IGNORE INTO connection VALUES (6, 10,11 );
INSERT IGNORE INTO connection VALUES (6, 11, 2);
INSERT IGNORE INTO connection VALUES (6, 12, 1);
INSERT IGNORE INTO connection VALUES (6, 13, 16);
INSERT IGNORE INTO connection VALUES (6, 14, 18);
INSERT IGNORE INTO connection VALUES (6, 15, 6);

INSERT IGNORE INTO connection VALUES (7, 7, 0);
INSERT IGNORE INTO connection VALUES (7, 8, 15);
INSERT IGNORE INTO connection VALUES (7, 9, 12);
INSERT IGNORE INTO connection VALUES (7, 10,11 );
INSERT IGNORE INTO connection VALUES (7, 11, 2);
INSERT IGNORE INTO connection VALUES (7, 12, 1);
INSERT IGNORE INTO connection VALUES (7, 13, 16);
INSERT IGNORE INTO connection VALUES (7, 14, 18);
INSERT IGNORE INTO connection VALUES (7, 15, 6);


INSERT IGNORE INTO connection VALUES (8, 8, 0);
INSERT IGNORE INTO connection VALUES (8, 9, 12);
INSERT IGNORE INTO connection VALUES (8, 10,11 );
INSERT IGNORE INTO connection VALUES (8, 11, 2);
INSERT IGNORE INTO connection VALUES (8, 12, 1);
INSERT IGNORE INTO connection VALUES (8, 13, 16);
INSERT IGNORE INTO connection VALUES (8, 14, 18);
INSERT IGNORE INTO connection VALUES (8, 15, 6);


INSERT IGNORE INTO connection VALUES (9, 9, 0);
INSERT IGNORE INTO connection VALUES (9, 10,11 );
INSERT IGNORE INTO connection VALUES (9, 11, 2);
INSERT IGNORE INTO connection VALUES (9, 12, 1);
INSERT IGNORE INTO connection VALUES (9, 13, 16);
INSERT IGNORE INTO connection VALUES (9, 14, 18);
INSERT IGNORE INTO connection VALUES (9, 15, 6);

INSERT IGNORE INTO connection VALUES (10, 10,0 );
INSERT IGNORE INTO connection VALUES (10, 11, 2);
INSERT IGNORE INTO connection VALUES (10, 12, 1);
INSERT IGNORE INTO connection VALUES (10, 13, 16);
INSERT IGNORE INTO connection VALUES (10, 14, 18);
INSERT IGNORE INTO connection VALUES (10, 15, 6);

INSERT IGNORE INTO connection VALUES (11, 11, 0);
INSERT IGNORE INTO connection VALUES (11, 12, 1);
INSERT IGNORE INTO connection VALUES (11, 13, 16);
INSERT IGNORE INTO connection VALUES (11, 14, 18);
INSERT IGNORE INTO connection VALUES (11, 15, 6);

INSERT IGNORE INTO connection VALUES (12, 12, 0);
INSERT IGNORE INTO connection VALUES (12, 13, 16);
INSERT IGNORE INTO connection VALUES (12, 14, 18);
INSERT IGNORE INTO connection VALUES (12, 15, 6);
INSERT IGNORE INTO connection VALUES (13, 13, 0);
INSERT IGNORE INTO connection VALUES (13, 14, 18);
INSERT IGNORE INTO connection VALUES (13, 15, 6);
INSERT IGNORE INTO connection VALUES (14, 14, 0);
INSERT IGNORE INTO connection VALUES (14, 15, 6);




/*Расстояние между адресами 2-го города*/
INSERT IGNORE INTO connection VALUES (16,16,0 );
INSERT IGNORE INTO connection VALUES (16,17,3 );
INSERT IGNORE INTO connection VALUES (16,18, 3);
INSERT IGNORE INTO connection VALUES (16,19 , 5);
INSERT IGNORE INTO connection VALUES (16, 20, 7);
INSERT IGNORE INTO connection VALUES (16, 21, 5);
INSERT IGNORE INTO connection VALUES (16, 22, 10);
INSERT IGNORE INTO connection VALUES (16, 23, 15);
INSERT IGNORE INTO connection VALUES (16, 24, 12);
INSERT IGNORE INTO connection VALUES (16, 25,11 );
INSERT IGNORE INTO connection VALUES (16, 26, 2);
INSERT IGNORE INTO connection VALUES (16, 27, 1);
INSERT IGNORE INTO connection VALUES (16, 28, 16);
INSERT IGNORE INTO connection VALUES (16, 29, 18);
INSERT IGNORE INTO connection VALUES (16, 30, 6);

INSERT IGNORE INTO connection VALUES (17,17,0 );
INSERT IGNORE INTO connection VALUES (17,18, 3);
INSERT IGNORE INTO connection VALUES (17,19 , 5);
INSERT IGNORE INTO connection VALUES (17,20, 7);
INSERT IGNORE INTO connection VALUES (17,21, 5);
INSERT IGNORE INTO connection VALUES (17,22, 10);
INSERT IGNORE INTO connection VALUES (17,23, 15);
INSERT IGNORE INTO connection VALUES (17,24, 12);
INSERT IGNORE INTO connection VALUES (17,25,11 );
INSERT IGNORE INTO connection VALUES (17,26, 2);
INSERT IGNORE INTO connection VALUES (17,27, 1);
INSERT IGNORE INTO connection VALUES (17,28, 16);
INSERT IGNORE INTO connection VALUES (17,29, 18);
INSERT IGNORE INTO connection VALUES (17,30, 6);

INSERT IGNORE INTO connection VALUES (18,18, 3);
INSERT IGNORE INTO connection VALUES (18,19 , 5);
INSERT IGNORE INTO connection VALUES (18,20, 7);
INSERT IGNORE INTO connection VALUES (18,21, 5);
INSERT IGNORE INTO connection VALUES (18,22, 10);
INSERT IGNORE INTO connection VALUES (18,23, 15);
INSERT IGNORE INTO connection VALUES (18,24, 12);
INSERT IGNORE INTO connection VALUES (18,25,11 );
INSERT IGNORE INTO connection VALUES (18,26, 2);
INSERT IGNORE INTO connection VALUES (18,27, 1);
INSERT IGNORE INTO connection VALUES (18,28, 16);
INSERT IGNORE INTO connection VALUES (18,29, 18);
INSERT IGNORE INTO connection VALUES (18,30, 6);

INSERT IGNORE INTO connection VALUES (19,19 , 0);
INSERT IGNORE INTO connection VALUES (19,20, 7);
INSERT IGNORE INTO connection VALUES (19,21, 5);
INSERT IGNORE INTO connection VALUES (19,22, 10);
INSERT IGNORE INTO connection VALUES (19,23, 15);
INSERT IGNORE INTO connection VALUES (19,24, 12);
INSERT IGNORE INTO connection VALUES (19,25,11 );
INSERT IGNORE INTO connection VALUES (19,26, 2);
INSERT IGNORE INTO connection VALUES (19,27, 1);
INSERT IGNORE INTO connection VALUES (19,28, 16);
INSERT IGNORE INTO connection VALUES (19,29, 18);
INSERT IGNORE INTO connection VALUES (19,30, 6);

INSERT IGNORE INTO connection VALUES (20,20, 0);
INSERT IGNORE INTO connection VALUES (20,21, 5);
INSERT IGNORE INTO connection VALUES (20,22, 10);
INSERT IGNORE INTO connection VALUES (20,23, 15);
INSERT IGNORE INTO connection VALUES (20,24, 12);
INSERT IGNORE INTO connection VALUES (20,25,11 );
INSERT IGNORE INTO connection VALUES (20,26, 2);
INSERT IGNORE INTO connection VALUES (20,27, 1);
INSERT IGNORE INTO connection VALUES (20,28, 16);
INSERT IGNORE INTO connection VALUES (20,29, 18);
INSERT IGNORE INTO connection VALUES (20,30, 6);


INSERT IGNORE INTO connection VALUES (21,21, 0);
INSERT IGNORE INTO connection VALUES (21,22, 10);
INSERT IGNORE INTO connection VALUES (21,23, 15);
INSERT IGNORE INTO connection VALUES (21,24, 12);
INSERT IGNORE INTO connection VALUES (21,25,11 );
INSERT IGNORE INTO connection VALUES (21,26, 2);
INSERT IGNORE INTO connection VALUES (21,27, 1);
INSERT IGNORE INTO connection VALUES (21,28, 16);
INSERT IGNORE INTO connection VALUES (21,29, 18);
INSERT IGNORE INTO connection VALUES (21,30, 6);

INSERT IGNORE INTO connection VALUES (22,22, 0);
INSERT IGNORE INTO connection VALUES (22,23, 15);
INSERT IGNORE INTO connection VALUES (22,24, 12);
INSERT IGNORE INTO connection VALUES (22,25,11 );
INSERT IGNORE INTO connection VALUES (22,26, 2);
INSERT IGNORE INTO connection VALUES (22,27, 1);
INSERT IGNORE INTO connection VALUES (22,28, 16);
INSERT IGNORE INTO connection VALUES (22,29, 18);
INSERT IGNORE INTO connection VALUES (22,30, 6);


INSERT IGNORE INTO connection VALUES (23,23, 0);
INSERT IGNORE INTO connection VALUES (23,24, 12);
INSERT IGNORE INTO connection VALUES (23,25,11 );
INSERT IGNORE INTO connection VALUES (23,26, 2);
INSERT IGNORE INTO connection VALUES (23,27, 1);
INSERT IGNORE INTO connection VALUES (23,28, 16);
INSERT IGNORE INTO connection VALUES (23,29, 18);
INSERT IGNORE INTO connection VALUES (23,30, 6);


INSERT IGNORE INTO connection VALUES (24,24, 0);
INSERT IGNORE INTO connection VALUES (24,25,11 );
INSERT IGNORE INTO connection VALUES (24,26, 2);
INSERT IGNORE INTO connection VALUES (24,27, 1);
INSERT IGNORE INTO connection VALUES (24,28, 16);
INSERT IGNORE INTO connection VALUES (24,29, 18);
INSERT IGNORE INTO connection VALUES (24,30, 6);

INSERT IGNORE INTO connection VALUES (25,25,0 );
INSERT IGNORE INTO connection VALUES (25,26, 2);
INSERT IGNORE INTO connection VALUES (25,27, 1);
INSERT IGNORE INTO connection VALUES (25,28, 16);
INSERT IGNORE INTO connection VALUES (25,29, 18);
INSERT IGNORE INTO connection VALUES (25,30, 6);

INSERT IGNORE INTO connection VALUES (26,26, 0);
INSERT IGNORE INTO connection VALUES (26,27, 1);
INSERT IGNORE INTO connection VALUES (26,28, 16);
INSERT IGNORE INTO connection VALUES (26,29, 18);
INSERT IGNORE INTO connection VALUES (26,30, 6);

INSERT IGNORE INTO connection VALUES (27,27, 0);
INSERT IGNORE INTO connection VALUES (27,28, 16);
INSERT IGNORE INTO connection VALUES (27,29, 18);
INSERT IGNORE INTO connection VALUES (27,30, 6);

INSERT IGNORE INTO connection VALUES (28,28, 0);
INSERT IGNORE INTO connection VALUES (28,29, 18);
INSERT IGNORE INTO connection VALUES (28,30, 6);

INSERT IGNORE INTO connection VALUES (29,29, 0);
INSERT IGNORE INTO connection VALUES (29,30, 6);
INSERT IGNORE INTO connection VALUES (30,30, 0);


/*Расстояние между адресами 3-го города*/

INSERT IGNORE INTO connection VALUES (31,31,0 );
INSERT IGNORE INTO connection VALUES (31,32,3 );
INSERT IGNORE INTO connection VALUES (31,33, 3);
INSERT IGNORE INTO connection VALUES (31,34 , 5);
INSERT IGNORE INTO connection VALUES (31, 35, 7);
INSERT IGNORE INTO connection VALUES (31, 36, 5);
INSERT IGNORE INTO connection VALUES (31, 37, 10);
INSERT IGNORE INTO connection VALUES (31, 38, 15);
INSERT IGNORE INTO connection VALUES (31, 39, 12);
INSERT IGNORE INTO connection VALUES (31, 40,11 );
INSERT IGNORE INTO connection VALUES (31, 41, 2);
INSERT IGNORE INTO connection VALUES (31, 42, 1);
INSERT IGNORE INTO connection VALUES (31, 43, 16);
INSERT IGNORE INTO connection VALUES (31, 44, 18);
INSERT IGNORE INTO connection VALUES (31, 45, 6);

INSERT IGNORE INTO connection VALUES (32,32,0 );
INSERT IGNORE INTO connection VALUES (32,33, 3);
INSERT IGNORE INTO connection VALUES (32,34 , 5);
INSERT IGNORE INTO connection VALUES (32, 35, 7);
INSERT IGNORE INTO connection VALUES (32, 36, 5);
INSERT IGNORE INTO connection VALUES (32, 37, 10);
INSERT IGNORE INTO connection VALUES (32, 38, 15);
INSERT IGNORE INTO connection VALUES (32, 39, 12);
INSERT IGNORE INTO connection VALUES (32, 40,11 );
INSERT IGNORE INTO connection VALUES (32, 41, 2);
INSERT IGNORE INTO connection VALUES (32, 42, 1);
INSERT IGNORE INTO connection VALUES (32, 43, 16);
INSERT IGNORE INTO connection VALUES (32, 44, 18);
INSERT IGNORE INTO connection VALUES (32, 45, 6);

INSERT IGNORE INTO connection VALUES (33,33, 0);
INSERT IGNORE INTO connection VALUES (33,34 , 5);
INSERT IGNORE INTO connection VALUES (33, 35, 7);
INSERT IGNORE INTO connection VALUES (33, 36, 5);
INSERT IGNORE INTO connection VALUES (33, 37, 10);
INSERT IGNORE INTO connection VALUES (33, 38, 15);
INSERT IGNORE INTO connection VALUES (33, 39, 12);
INSERT IGNORE INTO connection VALUES (33, 40,11 );
INSERT IGNORE INTO connection VALUES (33, 41, 2);
INSERT IGNORE INTO connection VALUES (33, 42, 1);
INSERT IGNORE INTO connection VALUES (33, 43, 16);
INSERT IGNORE INTO connection VALUES (33, 44, 18);
INSERT IGNORE INTO connection VALUES (33, 45, 6);

INSERT IGNORE INTO connection VALUES (34,34 , 0);
INSERT IGNORE INTO connection VALUES (34, 35, 7);
INSERT IGNORE INTO connection VALUES (34, 36, 5);
INSERT IGNORE INTO connection VALUES (34, 37, 10);
INSERT IGNORE INTO connection VALUES (34, 38, 15);
INSERT IGNORE INTO connection VALUES (34, 39, 12);
INSERT IGNORE INTO connection VALUES (34, 40,11 );
INSERT IGNORE INTO connection VALUES (34, 41, 2);
INSERT IGNORE INTO connection VALUES (34, 42, 1);
INSERT IGNORE INTO connection VALUES (34, 43, 16);
INSERT IGNORE INTO connection VALUES (34, 44, 18);
INSERT IGNORE INTO connection VALUES (34, 45, 6);

INSERT IGNORE INTO connection VALUES (35, 35, 0);
INSERT IGNORE INTO connection VALUES (35, 36, 5);
INSERT IGNORE INTO connection VALUES (35, 37, 10);
INSERT IGNORE INTO connection VALUES (35, 38, 15);
INSERT IGNORE INTO connection VALUES (35, 39, 12);
INSERT IGNORE INTO connection VALUES (35, 40,11 );
INSERT IGNORE INTO connection VALUES (35, 41, 2);
INSERT IGNORE INTO connection VALUES (35, 42, 1);
INSERT IGNORE INTO connection VALUES (35, 43, 16);
INSERT IGNORE INTO connection VALUES (35, 44, 18);
INSERT IGNORE INTO connection VALUES (35, 45, 6);


INSERT IGNORE INTO connection VALUES (36, 36, 0);
INSERT IGNORE INTO connection VALUES (36, 37, 10);
INSERT IGNORE INTO connection VALUES (36, 38, 15);
INSERT IGNORE INTO connection VALUES (36, 39, 12);
INSERT IGNORE INTO connection VALUES (36, 40,11 );
INSERT IGNORE INTO connection VALUES (36, 41, 2);
INSERT IGNORE INTO connection VALUES (36, 42, 1);
INSERT IGNORE INTO connection VALUES (36, 43, 16);
INSERT IGNORE INTO connection VALUES (36, 44, 18);
INSERT IGNORE INTO connection VALUES (36, 45, 6);


INSERT IGNORE INTO connection VALUES (37, 37, 0);
INSERT IGNORE INTO connection VALUES (37, 38, 15);
INSERT IGNORE INTO connection VALUES (37, 39, 12);
INSERT IGNORE INTO connection VALUES (37, 40,11 );
INSERT IGNORE INTO connection VALUES (37, 41, 2);
INSERT IGNORE INTO connection VALUES (37, 42, 1);
INSERT IGNORE INTO connection VALUES (37, 43, 16);
INSERT IGNORE INTO connection VALUES (37, 44, 18);
INSERT IGNORE INTO connection VALUES (37, 45, 6);


INSERT IGNORE INTO connection VALUES (38, 38, 0);
INSERT IGNORE INTO connection VALUES (38, 39, 12);
INSERT IGNORE INTO connection VALUES (38, 40,11 );
INSERT IGNORE INTO connection VALUES (38, 41, 2);
INSERT IGNORE INTO connection VALUES (38, 42, 1);
INSERT IGNORE INTO connection VALUES (38, 43, 16);
INSERT IGNORE INTO connection VALUES (38, 44, 18);
INSERT IGNORE INTO connection VALUES (38, 45, 6);

INSERT IGNORE INTO connection VALUES (39, 39, 0);
INSERT IGNORE INTO connection VALUES (39, 40,11 );
INSERT IGNORE INTO connection VALUES (39, 41, 2);
INSERT IGNORE INTO connection VALUES (39, 42, 1);
INSERT IGNORE INTO connection VALUES (39, 43, 16);
INSERT IGNORE INTO connection VALUES (39, 44, 18);
INSERT IGNORE INTO connection VALUES (39, 45, 6);



INSERT IGNORE INTO connection VALUES (40, 40,0 );
INSERT IGNORE INTO connection VALUES (40, 41, 2);
INSERT IGNORE INTO connection VALUES (40, 42, 1);
INSERT IGNORE INTO connection VALUES (40, 43, 16);
INSERT IGNORE INTO connection VALUES (40, 44, 18);
INSERT IGNORE INTO connection VALUES (40, 45, 6);


INSERT IGNORE INTO connection VALUES (41, 41, 0);
INSERT IGNORE INTO connection VALUES (41, 42, 1);
INSERT IGNORE INTO connection VALUES (41, 43, 16);
INSERT IGNORE INTO connection VALUES (41, 44, 18);
INSERT IGNORE INTO connection VALUES (41, 45, 6);


INSERT IGNORE INTO connection VALUES (41, 41, 0);
INSERT IGNORE INTO connection VALUES (41, 42, 1);
INSERT IGNORE INTO connection VALUES (41, 43, 16);
INSERT IGNORE INTO connection VALUES (41, 44, 18);
INSERT IGNORE INTO connection VALUES (41, 45, 6);

INSERT IGNORE INTO connection VALUES (42, 42, 0);
INSERT IGNORE INTO connection VALUES (42, 43, 16);
INSERT IGNORE INTO connection VALUES (42, 44, 18);
INSERT IGNORE INTO connection VALUES (42, 45, 6);

INSERT IGNORE INTO connection VALUES (43, 43, 0);
INSERT IGNORE INTO connection VALUES (43, 44, 18);
INSERT IGNORE INTO connection VALUES (43, 45, 6);

INSERT IGNORE INTO connection VALUES (44, 44, 0);
INSERT IGNORE INTO connection VALUES (44, 45, 6);

INSERT IGNORE INTO connection VALUES (45, 45, 0);




