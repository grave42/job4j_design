create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('karasikfish', 100, '2000-12-11');
insert into fauna(name, avg_age, discovery_date) values ('piskarikfish', 100, '2000-12-11');
insert into fauna(name, avg_age, discovery_date) values ('dinosaur', 10001, '1940-12-11');
insert into fauna(name, avg_age, discovery_date) values ('elephant', 10001, null);

select * from fauna where name like '%fish';

select * from fauna where avg_age > 10000 and avg_age < 21000;

select * from fauna where discovery_date is null;

select * from fauna where discovery_date < '1950-01-01'