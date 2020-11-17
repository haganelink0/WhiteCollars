INSERT INTO `botiga`.`shops`
(`id`,`created_at`,`updated_at`,`max_capacity`,`shop_name`) VALUES (1,'2020-10-19 11:39:22', '2020-10-19 11:39:22', 10, 'Vicentes Paints');

INSERT INTO `botiga`.`shops` (`id`,`created_at`,`updated_at`,`max_capacity`,`shop_name`) VALUES (2,'2019-10-09 08:39:22', '2020-10-09 12:39:22', 15, 'Art Attack');

INSERT INTO `botiga`.`paints` (`id`,`created_at`,`updated_at`,`author`,`price`,`title`,`shop_id`) VALUES (1,'2020-10-19 11:38:22','2020-10-10 11:38:22','DaVinci',648984684,'La virgen y el hijo con Santa Ana',1);

INSERT INTO `botiga`.`paints` (`id`,`created_at`,`updated_at`,`author`,`price`,`title`,`shop_id`) VALUES (2,'2020-10-20 10:00:00','2020-10-21 12:48:52','Raphael',13548762,'La resurrección de cristo',1);

INSERT INTO `botiga`.`paints` (`id`,`created_at`,`updated_at`,`author`,`price`,`title`,`shop_id`) VALUES (3,'2020-10-09 08:48:12','2020-10-09 08:48:12','Sandro Botticeli',987465134,'La primavera',2);

INSERT INTO `botiga`.`paints` (`id`,`created_at`,`updated_at`,`author`,`price`,`title`,`shop_id`) VALUES (4,'2020-10-11 17:38:42','2020-10-11 18:00:00','Michelangelo',35798420,'El arca de Noé',2);