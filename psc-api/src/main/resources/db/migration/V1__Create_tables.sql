CREATE TABLE `member` (
  `id` binary(16) NOT NULL,
  `createdDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deletedDateTime` timestamp NULL DEFAULT NULL,
  `lastModifiedDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint(20) DEFAULT NULL,
  `emailAddress` varchar(100) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_UNIQUE_member_emailAddress` (`emailAddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `court` (
  `id` binary(16) NOT NULL,
  `createdDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deletedDateTime` timestamp NULL DEFAULT NULL,
  `lastModifiedDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint(20) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `number` tinyint(3) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_UNIQUE_court_number` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'loginAttempt'
CREATE TABLE `reservation` (
  `id` binary(16) NOT NULL,
  `createdDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deletedDateTime` timestamp NULL DEFAULT NULL,
  `lastModifiedDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` bigint(20) DEFAULT NULL,
  `member_id` binary(16) NOT NULL,
  `court_id` binary(16) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_reservation_member_member` (`member_id`),
  CONSTRAINT `FK_reservation_member_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`),
  KEY `FK_reservation_court_court` (`court_id`),
  CONSTRAINT `FK_reservation_court_court` FOREIGN KEY (`court_id`) REFERENCES `court` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;