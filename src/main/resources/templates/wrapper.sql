----db schema---
create database springBootCrudApplication;

--create table----
CREATE TABLE `marvel_movies` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sequal_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


---insert----

insert into marvel_movies values (1, 'Avenger', '1');
insert into marvel_movies values (2, 'Avenger', 'age of ultron');
insert into marvel_movies values (3, 'Avenger', 'infinity war');
insert into marvel_movies values (4, 'Avenger', 'end game');