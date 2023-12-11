create table model(
    id serial primary key,
    manufacturer varchar(255),
    model varchar(255)
);

create table os(
    id serial primary key,
    version int,
    model_id int references model(id) unique
);

insert into model(manufacturer, model) values ('Xiaomi', 'Mi9T');
insert into model(manufacturer, model) values ('Google', '4a5g');
insert into model(manufacturer, model) values ('Huawei', '30Pro');
insert into model(manufacturer, model) values ('Redmi', '10T');

insert into os(version, model_id) values (11, 1);
insert into os(version, model_id) values (13, 2);
insert into os(version, model_id) values (13, 3);
insert into os(version) values (10);

select * from model m join os s on m.id = s.model_id;

select m.manufacturer from model m join os s on m.id = s.model_id and m.manufacturer = 'Xiaomi'

select m.manufacturer, m.model, s.version from model m join os s on m.id = s.model_id and s.version > 11;


