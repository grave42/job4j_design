CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

insert into customers (first_name, last_name, age, country) values ('Alex', 'Petersson', 18, 'USA');
insert into customers (first_name, last_name, age, country) values ('Vova', 'Petrov', 18, 'Russia');
insert into customers (first_name, last_name, age, country) values ('Dima', 'Zozikov', 20, 'Kazakhstan');
insert into customers (first_name, last_name, age, country) values ('Viltord', 'Jacobs', 21, 'Germany');

select * from customers where age = (select min(age) from customers);

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

insert into orders(amount, customer_id) values (100, 1);
insert into orders(amount, customer_id) values (500, 3);
insert into orders(amount, customer_id) values (200, 4);

select * from customers where id not in (select customer_id from orders);