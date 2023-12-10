 create table customers(
     id serial primary key,
     name varchar(255)
 );
 
 create table orders(
     id serial primary key,
     order_number varchar(255)
 );
 
 create table customers_orders(
     id serial primary key,
     customer_id int references customers(id),
     order_id int references orders(id)
 );