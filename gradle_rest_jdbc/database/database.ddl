DROP TABLE IF EXISTS `trn_person`;
CREATE TABLE  `trn_person` (
  `person_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `Last_name` varchar(100) NOT NULL,
  `age` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


INSERT INTO `trn_person` (`person_id`,`first_name`, `Last_name`, `age`) VALUES
 (1,'test','mctest',28),
 (2,'tesy','mctest',28),
 (3,'ytest', 'tsetcm', 28);
