create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into people(name) values('Viktor');
insert into people(name) values('Filipp');
insert into people(name) values('Kate');

insert into devices(name, price) values('MacBook', 2000.0);
insert into devices(name, price) values('PC', 7000.0);
insert into devices(name, price) values('SmartWatch', 500.0);
insert into devices(name, price) values('Phone', 450.0);

insert into devices_people(device_id, people_id) values(1, 3);
insert into devices_people(device_id, people_id) values(2, 1);
insert into devices_people(device_id, people_id) values(2, 2);
insert into devices_people(device_id, people_id) values(2, 3);
insert into devices_people(device_id, people_id) values(3, 3);
insert into devices_people(device_id, people_id) values(3, 2);

select avg(price) from devices;

select p.name, avg(d.price) from devices_people dp
join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price) from devices_people dp
join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id
group by p.name;
having avg(d.price) > 5000;