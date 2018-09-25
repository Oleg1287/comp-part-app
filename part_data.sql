set names utf8;

drop table if exists `part`;

CREATE TABLE `part` (
  `part_id` int(11) NOT NULL AUTO_INCREMENT,
  `description_ru` varchar(31) NOT NULL DEFAULT "" COLLATE utf8_bin,
  `required` tinyint(1)  NOT NULL DEFAULT 0,
  `count` int(7)  NOT NULL DEFAULT 0,
  PRIMARY KEY (`part_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into part (description_ru, required, count) VALUES
	("компьютерная мышь", 0, 5),
	("материнская плата", 1, 3),
	("Переходник hdmi -> dvi", 0, 10),
	("блок питания", 1, 31),
	("беспроводная компьютерная мышь", 0, 11),

	("беспроводная клавиатура", 0, 31),
	("Память USB flash 64 Гб", 0, 6),
	("dvi кабель", 0, 91),
	("оперативная память", 1, 7),
	("Память USB flash 8 Гб", 0, 12),
	("vga кабель", 0, 71),

	("hdmi разветвитель", 0, 11),
	("клавиатура", 0, 7),
	("Память USB flash 32 Гб", 0, 8),
	("ssd диск", 1, 31),
	("процессор", 1, 5),
	("Переходник dvi -> hdmi", 0, 10),

	("Память USB flash 16 Гб", 0, 10),
	("hdmi кабель", 0, 81),
	("жесткий диск", 1, 31),

	("Память USB flash 128 Гб", 0, 31);
