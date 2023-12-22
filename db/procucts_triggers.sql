create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace function tax()
    returns trigger as
$$
BEGIN
update products
set price = price + 13.0;
return new;
END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 3, 100);

select * from products

create or replace function tax2()
    returns trigger as
$$
BEGIN
new.price = new.price + 13.0;
return new;
END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger2
    before insert
    on products
    for each row
    execute procedure tax2();
	
insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 3, 20);

create or replace function history()
    returns trigger as
$$
    BEGIN
    	insert into history_of_price (name, price, date)
    	values (NEW.name, NEW.price, CURRENT_TIMESTAMP);
    	return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger history_trigger
    after insert
    on products
    for each row
    execute procedure history();

insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 3, 200);

select * from history_of_price
