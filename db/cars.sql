create table car_bodies(
                           id serial primary key,
                           name varchar(255)
);

create table car_engines(
                            id serial primary key,
                            name varchar(255)
);

create table car_transmissions(
                                  id serial primary key,
                                  name varchar(255)
);

create table cars(
                     id serial primary key,
                     name varchar(255),
                     body_id int references car_bodies(id),
                     engine_id int references car_engines(id),
                     transmission_id int references car_transmissions(id)
);

insert into car_bodies (name) values ('седан');
insert into car_bodies (name) values ('хетчебек');
insert into car_bodies (name) values ('универсал');

insert into car_engines (name) values ('G4FG');
insert into car_engines (name) values ('2JZ FE');
insert into car_engines (name) values ('CZDA');

insert into car_transmissions (name) values ('MT');
insert into car_transmissions (name) values ('AT');
insert into car_transmissions (name) values ('DSG');

insert into cars (name, body_id, engine_id, transmission_id) values ('Volkswagen Passat', 3, 3, 3);
insert into cars (name, body_id, engine_id, transmission_id) values ('Skoda Octavia', 1, 3, 3);
insert into cars (name, body_id, engine_id, transmission_id) values ('Kia K5', 1, 1 ,2);
insert into cars (name) values ('Toyota Mark2');

select c.id, c.name as car_name, cb.name as body_name,
       ce.name as engine_name, ct.name as transmission_name
from cars c
         left join car_bodies cb on c.body_id = cb.id
         left join car_engines ce on c.engine_id = ce.id
         left join car_transmissions ct on c.engine_id = ct.id

select cb.*
from car_bodies cb
         left join cars c on cb.id=c.body_id
where c.body_id is null

select ce.*
from car_engines ce
         left join cars c on ce.id = c.engine_id
where c.engine_id is null

select ct.*
from car_transmissions ct
         left join cars c on ct.id = c.transmission_id
where c.transmission_id is null