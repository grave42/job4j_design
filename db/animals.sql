create table animals
(
    id    serial primary key,
    name  varchar(50),
    age integer default 0
);

insert into animals(name, age) values ('Cat', 20);
insert into animals(name, age) values ('Dog', 6);
insert into animals(name, age) values ('Cow', 3);
insert into animals(name, age) values ('Pig', 2);