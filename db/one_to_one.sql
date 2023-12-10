create table gos_number(
    id serial primary key,
    serial int,
    number int
);

create table car_owner(
    id serial primary key,
    name varchar(255),
    gos_number_id int references gos_number(id) unique
);