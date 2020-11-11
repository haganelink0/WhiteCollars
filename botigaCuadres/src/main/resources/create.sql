creaTE database if not exists `botiga`;
use `botiga`;

CREATE TABLE `shops` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `max_capacity` int(11) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `paints` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `shop_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgtpm1k6sntnvv9munqkme0j8y` (`shop_id`),
  CONSTRAINT `FKgtpm1k6sntnvv9munqkme0j8y` FOREIGN KEY (`shop_id`) REFERENCES `shops` (`id`)
)

