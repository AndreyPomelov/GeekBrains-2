create schema if not exists `cinema`;

# Таблица, содержащая фильмы
create table `cinema`.`movie` (
`movie_id` int not null auto_increment,
`title` varchar(50) not null,
`duration` int not null,
primary key (`movie_id`));

/* Таблица, содержащая информацию о времени
начала показов (но не о конкретных показах) */
create table `cinema`.`time_slot` (
`time_slot_id` int not null auto_increment,
`start_time` time not null,
`price` decimal(6,2) not null,
primary key(`time_slot_id`),
unique index `start_time_uniq` (`start_time` asc));

# Таблица, содержащая информацию о конкретных показах
create table `cinema`.`session` (
`session_id` int not null auto_increment,
`movie_id` int not null,
`time_slot_id` int not null,
`session_date` date not null,
primary key (`session_id`),

index `session_to_movie_fk_idx` (`movie_id` ASC),
index `session_to_time_slot_fk_idx` (`time_slot_id` ASC),

constraint `session_to_movie_fk`
foreign key (`movie_id`)
references `cinema`.`movie` (`movie_id`),

constraint `session_to_time_slot_fk`
foreign key (`time_slot_id`)
references `cinema`.`time_slot` (`time_slot_id`));

# Таблица, содержащая информацию о проданных билетах
create table `cinema`.`ticket` (
`session_id` int not null,
`row_number` int not null,
`seat_number` int not null,
primary key (`session_id`, `row_number`, `seat_number`),

index `ticket_to_session_fk_idx` (`session_id` ASC),

constraint `ticket_to_session_fk`
foreign key (`session_id`)
references `cinema`.`session` (`session_id`));

# Заполняем БД данными
insert into `cinema`.`movie` (`title`, `duration`) values ('Movie 1', '60');
insert into `cinema`.`movie` (`title`, `duration`) values ('Movie 2', '90');
insert into `cinema`.`movie` (`title`, `duration`) values ('Movie 3', '120');
insert into `cinema`.`movie` (`title`, `duration`) values ('Movie 4', '120');
insert into `cinema`.`movie` (`title`, `duration`) values ('Movie 5', '90');

insert into `cinema`.`time_slot` (`start_time`, `price`) values ('16:30:00', '100');
insert into `cinema`.`time_slot` (`start_time`, `price`) values ('17:40:00', '150');
insert into `cinema`.`time_slot` (`start_time`, `price`) values ('20:00:00', '200');
insert into `cinema`.`time_slot` (`start_time`, `price`) values ('21:50:00', '250');
insert into `cinema`.`time_slot` (`start_time`, `price`) values ('23:00:00', '200');

insert into `cinema`.`session` (`movie_id`, `time_slot_id`, `session_date`) values ('1', '1', '2021-10-21');
insert into `cinema`.`session` (`movie_id`, `time_slot_id`, `session_date`) values ('3', '2', '2021-10-21');
insert into `cinema`.`session` (`movie_id`, `time_slot_id`, `session_date`) values ('2', '3', '2021-10-21');
insert into `cinema`.`session` (`movie_id`, `time_slot_id`, `session_date`) values ('1', '4', '2021-10-21');
insert into `cinema`.`session` (`movie_id`, `time_slot_id`, `session_date`) values ('4', '5', '2021-10-21');

insert into `cinema`.`session` (`movie_id`, `time_slot_id`, `session_date`) values ('1', '1', '2021-10-22');
insert into `cinema`.`session` (`movie_id`, `time_slot_id`, `session_date`) values ('5', '2', '2021-10-22');
insert into `cinema`.`session` (`movie_id`, `time_slot_id`, `session_date`) values ('1', '3', '2021-10-22');
insert into `cinema`.`session` (`movie_id`, `time_slot_id`, `session_date`) values ('1', '4', '2021-10-22');
insert into `cinema`.`session` (`movie_id`, `time_slot_id`, `session_date`) values ('3', '5', '2021-10-22');

insert into `cinema`.`session` (`movie_id`, `time_slot_id`, `session_date`) values ('2', '1', '2021-10-23');
insert into `cinema`.`session` (`movie_id`, `time_slot_id`, `session_date`) values ('4', '2', '2021-10-23');
insert into `cinema`.`session` (`movie_id`, `time_slot_id`, `session_date`) values ('3', '3', '2021-10-23');
insert into `cinema`.`session` (`movie_id`, `time_slot_id`, `session_date`) values ('5', '4', '2021-10-23');
insert into `cinema`.`session` (`movie_id`, `time_slot_id`, `session_date`) values ('1', '5', '2021-10-23');

insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('1', '1', '1');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('2', '1', '2');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('2', '1', '3');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('3', '1', '4');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('3', '1', '5');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('3', '2', '1');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('4', '2', '2');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('4', '2', '3');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('4', '2', '4');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('4', '2', '5');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('5', '3', '1');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('5', '3', '2');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('5', '3', '3');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('5', '3', '4');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('5', '3', '5');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('6', '4', '1');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('6', '4', '2');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('7', '4', '3');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('7', '4', '4');
insert into `cinema`.`ticket` (`session_id`, `row_number`, `seat_number`) values ('7', '4', '5');

# Выбираем текущую БД
use cinema;

# Функция, возвращающая название следующего фильма по расписанию
delimiter $$
create function nextTitle(ts_id int, on_date date)
returns varchar(45)
begin
return
(select title from movie as m
join session as s on s.movie_id = m.movie_id
where s.time_slot_id = ts_id + 1
and session_date like on_date);
end $$

# Функция, возвращающая время начала следующего фильма по расписанию
delimiter $$
create function nextStartTime(ts_id int)
returns time
begin
return
(select start_time from time_slot
where time_slot_id = ts_id + 1);
end $$

# Функция, возвращающая длительность следующего фильма по расписанию
delimiter $$
create function nextDuration(ts_id int, on_date date)
returns int
begin
return
(select duration from movie as m
join session as s on s.movie_id = m.movie_id
where s.time_slot_id = ts_id + 1
and session_date like on_date);
end $$

# Функция, возвращающая время окончания фильма в числовом представлении
delimiter $$
create function getEndTime(t time, minutes int)
returns int
begin
declare hours, rem int;
set hours = truncate(minutes / 60, 0);
set rem = mod(minutes, 60);
return (extract(hour_minute from t) + hours * 100 + rem);
end $$

# Представление, отображающее накладки в расписании,
# когда фильм заканчивается позже, чем начинается следующий
# Недостаток данного представления в том, что он отображает
# ошибки в расписании только на определённую дату, и чтобы
# посмотреть ошибки на другую дату, её нужно перебивать руками.
# Не успел доработать представление, чтобы оно было универсальным.
create or replace view schedule_error as
select 
m.title as 'Фильм 1',
t.start_time as 'Время начала 1',
m.duration as 'Длительность 1',
nextTitle(t.time_slot_id, '2021-10-23') as 'Фильм 2',
nextStartTime(t.time_slot_id) as 'Время начала 2',
nextDuration(t.time_slot_id, '2021-10-23') as 'Длительность 2'
from session as s
join movie as m on s.movie_id = m.movie_id
join time_slot as t on s.time_slot_id = t.time_slot_id
where s.session_date like '2021-10-23'
and getEndTime(t.start_time, m.duration) > extract(hour_minute from nextStartTime(t.time_slot_id))
order by 'Время начала 1';