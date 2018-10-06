CREATE DATABASE `spring_transaction` DEFAULT CHARACTER SET utf8mb4;


CREATE TABLE `user` ( `id` int(11) not null auto_increment,
`name` varchar(255) default null,
`age` int(11) default null,
`gender` varchar(255) default null,
primary key(`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
