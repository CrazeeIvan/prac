DROP TABLE IF EXISTS `customer`;
CREATE TABLE  `customer` (
  `personId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `age` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`personId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


INSERT INTO `customer` (`personId`,`firstName`, `lastName`, `age`) VALUES
 (1,'test','mctest',28),
 (2,'tesy','mctest',28),
 (3,'ytest', 'tsetcm', 28);
