CREATE TABLE `code` (
`name` varchar(100) DEFAULT ''  NOT NULL,
`value` varchar(40) DEFAULT ''  ,
`code` varchar(40) DEFAULT ''  NOT NULL,
`status` TINYINT(1) DEFAULT 0  , `parent_uuid` varchar(40) DEFAULT ''  NOT NULL,
`remark` TEXT  ,
`order_no`   ,
PRIMARY KEY (`uuid`) varchar(40) not nul NOT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=utf8;