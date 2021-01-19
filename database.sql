
CREATE TABLE IF NOT EXISTS `books` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(200) NOT NULL,
	`descr` varchar(200) NOT NULL,
	`price` int(11) NOT NULL,
	`quantity` int(11) NOT NULL,
	`img` varchar(2048) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `books` (`id`, `name`, `descr`, `price`, `quantity`, `img`) VALUES
(1, 'Harry 1', 'First book ', '29.99', 10, 'https://tse1.explicit.bing.net/th?id=OIP.3cACEgHek_R_FuknYTcSswHaJ4&pid=Api'),
(2, 'Harry 2', '', '14.99', 34, 'https://kaiserem.files.wordpress.com/2010/10/hp6_poster_2.jpg'),
(4, 'Harry 3', '', '69.99',  7, 'https://mypostercollection.com/wp-content/uploads/2018/09/Harry-Potter-Poster-2004-MyPosterCollection.com-23.jpg?x49793');

UPDATE user SET Password=PASSWORD('toor2021') WHERE User='root';
ALTER USER 'root'@'localhost' IDENTIFIED BY 'toor2021';

UPDATE books
SET quantity= 20.1 WHERE id=1;