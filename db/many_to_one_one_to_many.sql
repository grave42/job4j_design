create table phones(
    id serial primary key,
    name varchar(255)
);

create table models(
    id serial primary key,
    model varchar(255),
    model_id int references phones(id)
);

insert into phones(name) values ('Xiaomi');
insert into models(model, model_id) VALUES ('13PRO', 1);