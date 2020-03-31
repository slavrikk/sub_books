
--Create table Readers.
CREATE TABLE `readers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--Create table Editions
CREATE TABLE `edition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--Create table Subscriptions.
CREATE TABLE `subscriptions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_reader` int(11) NOT NULL,
  `id_edition` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_reader_idx` (`id_reader`),
  KEY `id_edition_idx` (`id_edition`),
  CONSTRAINT `id_edition` FOREIGN KEY (`id_edition`) REFERENCES `edition` (`id`),
  CONSTRAINT `id_reader` FOREIGN KEY (`id_reader`) REFERENCES `readers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

