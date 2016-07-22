INSERT IGNORE INTO transport  VALUES (1, 'bus');
INSERT IGNORE INTO transport  VALUES (2, 'trolleybus');
INSERT IGNORE INTO transport  VALUES (3, 'train');
INSERT IGNORE INTO transport  VALUES (4, 'tram');
INSERT IGNORE INTO transport  VALUES (5, 'taxi');


INSERT IGNORE INTO station (city, street) VALUES ('Minsk', 'Yesenyna St.');
INSERT IGNORE INTO station (city, street) VALUES ('Minsk', 'Lenina St.');
INSERT IGNORE INTO station (city, street) VALUES ('Minsk', 'Sverdlova St.');
INSERT IGNORE INTO station (city, street) VALUES ('Minsk', 'Pushkina St.');
INSERT IGNORE INTO station (city, street) VALUES ('Minsk', 'Gebbelsa St.');
INSERT IGNORE INTO station (city, street) VALUES ('Minsk', 'Slobodskaya St.');

INSERT IGNORE INTO station (city, street) VALUES ('Gomel', 'Kizshevatova St.');
INSERT IGNORE INTO station (city, street) VALUES ('Gomel', 'Ozernaya St.');
INSERT IGNORE INTO station (city, street) VALUES ('Gomel', 'Cvetochnaya St.');
INSERT IGNORE INTO station (city, street) VALUES ('Gomel', 'Lazurnaya St.');
INSERT IGNORE INTO station (city, street) VALUES ('Gomel', '9 Maya St.');
INSERT IGNORE INTO station (city, street) VALUES ('Gomel', 'Pivnaya St.');

INSERT IGNORE INTO station (city, street) VALUES ('Minsk', 'Tirazhnaya St.');
INSERT IGNORE INTO station (city, street) VALUES ('Minsk', 'Mayakovskogo St.');
INSERT IGNORE INTO station (city, street) VALUES ('Minsk', 'Mira St.');

INSERT IGNORE INTO station (city, street) VALUES ('Gomel', 'Bogdanova St.');
INSERT IGNORE INTO station (city, street) VALUES ('Gomel', 'Dvorkina St.');
INSERT IGNORE INTO station (city, street) VALUES ('Gomel', 'Krasnova St.');



INSERT IGNORE INTO transport_address  VALUES (1, 3);
INSERT IGNORE INTO transport_address  VALUES (1, 4);
INSERT IGNORE INTO transport_address  VALUES (1, 13);
INSERT IGNORE INTO transport_address  VALUES (1, 14);
INSERT IGNORE INTO transport_address  VALUES (2, 1);
INSERT IGNORE INTO transport_address  VALUES (2, 2);
INSERT IGNORE INTO transport_address  VALUES (2, 3);
INSERT IGNORE INTO transport_address  VALUES (2, 4);
INSERT IGNORE INTO transport_address  VALUES (2, 5);
INSERT IGNORE INTO transport_address  VALUES (2, 6);
INSERT IGNORE INTO transport_address  VALUES (4, 7);
INSERT IGNORE INTO transport_address  VALUES (4, 8);
INSERT IGNORE INTO transport_address  VALUES (4, 9);
INSERT IGNORE INTO transport_address  VALUES (4, 10);
INSERT IGNORE INTO transport_address  VALUES (4, 11);
INSERT IGNORE INTO transport_address  VALUES (4, 12);
INSERT IGNORE INTO transport_address  VALUES (2, 13);
INSERT IGNORE INTO transport_address  VALUES (2, 14);
INSERT IGNORE INTO transport_address  VALUES (2, 15);
INSERT IGNORE INTO transport_address  VALUES (4, 17);
INSERT IGNORE INTO transport_address  VALUES (4, 18);
INSERT IGNORE INTO transport_address  VALUES (3, 5);
INSERT IGNORE INTO transport_address  VALUES (3, 7);



INSERT IGNORE INTO connection VALUES (1, 5, 8);
INSERT IGNORE INTO connection VALUES (1, 6, 9);
INSERT IGNORE INTO connection VALUES (2, 3, 6);
INSERT IGNORE INTO connection VALUES (2, 5, 3);
INSERT IGNORE INTO connection VALUES (2, 6, 4);
INSERT IGNORE INTO connection VALUES (3, 2, 6);
INSERT IGNORE INTO connection VALUES (3, 4, 2);
INSERT IGNORE INTO connection VALUES (4, 3, 2);
INSERT IGNORE INTO connection VALUES (4, 6, 11);
INSERT IGNORE INTO connection VALUES (5, 1, 8);
INSERT IGNORE INTO connection VALUES (5, 2, 3);
INSERT IGNORE INTO connection VALUES (5, 7, 270);
INSERT IGNORE INTO connection VALUES (6, 1, 9);
INSERT IGNORE INTO connection VALUES (6, 2, 4);
INSERT IGNORE INTO connection VALUES (6, 4,11);
INSERT IGNORE INTO connection VALUES (7, 5, 270);
INSERT IGNORE INTO connection VALUES (7, 8, 3);
INSERT IGNORE INTO connection VALUES (7, 9, 8);
INSERT IGNORE INTO connection VALUES (7, 10, 6);
INSERT IGNORE INTO connection VALUES (8, 7, 3);
INSERT IGNORE INTO connection VALUES (9, 7, 8);
INSERT IGNORE INTO connection VALUES (9, 12, 2);
INSERT IGNORE INTO connection VALUES (10, 7, 6);
INSERT IGNORE INTO connection VALUES (10, 12, 5);
INSERT IGNORE INTO connection VALUES (11, 12, 11);
INSERT IGNORE INTO connection VALUES (12, 9, 2);
INSERT IGNORE INTO connection VALUES (12, 10, 5);
INSERT IGNORE INTO connection VALUES (13, 14, 9);
INSERT IGNORE INTO connection VALUES (13, 15, 4);
INSERT IGNORE INTO connection VALUES (14, 13, 9);
INSERT IGNORE INTO connection VALUES (14, 15, 4);
INSERT IGNORE INTO connection VALUES (15, 13, 4);
INSERT IGNORE INTO connection VALUES (15, 14, 4);
INSERT IGNORE INTO connection VALUES (16, 17, 3);
INSERT IGNORE INTO connection VALUES (16, 18, 4);
INSERT IGNORE INTO connection VALUES (17, 16, 3);
INSERT IGNORE INTO connection VALUES (17, 18, 8);
INSERT IGNORE INTO connection VALUES (18, 16, 4);
INSERT IGNORE INTO connection VALUES (18, 17, 8);