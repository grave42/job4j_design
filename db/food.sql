create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
	expired_date date,
	price float
);

insert into type (name) values ('СЫР');
insert into type (name) values ('МОЛОКО');
insert into type (name) values ('МОРОЖЕНОЕ');
insert into type (name) values ('ГАЗИРОВКА');

insert into product (name, type_id, expired_date, price) values ('Сыр плавленный', 1, '2023-12-16', 100.0);
insert into product (name, type_id, expired_date, price) values ('Сыр моцарелла', 1, '2023-12-13', 150.0);
insert into product (name, type_id, expired_date, price) values ('Капитошка', 3, '2023-12-16', 50.0);
insert into product (name, type_id, expired_date, price) values ('Веселый молочник', 2, '2023-12-13', 100.0);
insert into product (name, type_id, expired_date, price) values ('Буратино', 4, '2023-12-16', 100.0);
insert into product (name, type_id, expired_date, price) values ('Мороженое "Забава"', 3, '2023-12-16', 50.0)

select * 
from product p 
join type t
on t.id = p.type_id
where t.name = 'СЫР';

select * 
from product
where name like 'Мороженое%';

select * 
from product
where expired_date < now();

select *
from product
where price = (select MAX(price) from product);

select type.name AS имя_типа, COUNT(product.id) AS количество
from type
join product ON type.id = product.type_id
group by type.name;

select * 
from product p 
join type t
on t.id = p.type_id
where t.name = 'СЫР' or t.name = 'МОЛОКО';

select type.name AS имя_типа, COUNT(product.id) AS общее_количество
from type
join product on type.id = product.type_id
group by type.name
having count(product.id) < 10;

select product.id AS продукт_id, product.name AS продукт, type.name AS тип
from product
join type ON product.type_id = type.id;
