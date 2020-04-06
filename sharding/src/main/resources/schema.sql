CREATE TABLE t_user
(
	user_id BIGINT(20) PRIMARY KEY COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱'
);

create table t_order0
(
  order_id BIGINT(20) not null primary key,
  user_id BIGINT(20) not null,
  name varchar(100)
);

create table t_order1
(
  order_id BIGINT(20) not null primary key,
  user_id BIGINT(20) not null,
  name varchar(100)
);

CREATE TABLE `t_order_item0` (
  `id` BIGINT(20) PRIMARY KEY auto_increment COMMENT '主键ID',
  `order_id` BIGINT(20) NOT NULL,
  `item` varchar(100) DEFAULT NULL,
  `user_id` BIGINT(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_item1` (
  `id` BIGINT(20) PRIMARY KEY auto_increment COMMENT '主键ID',
  `order_id` BIGINT(20) NOT NULL,
  `item` varchar(100) DEFAULT NULL,
  `user_id` BIGINT(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;