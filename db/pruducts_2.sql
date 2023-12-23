insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 3, 100);
insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 3, 500);
insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 3, 1000);

select * from products;

create or replace procedure delete_data(d_price integer)
language 'plpgsql'
as $$
    BEGIN
    delete from products
	where price > d_price;
    END
$$;

call delete_data(100);

create or replace function del_data(d_price integer)
returns void
language 'plpgsql'
as $$
BEGIN
		DELETE FROM products
		WHERE price > d_price;
	END;
$$;

select del_data(500)