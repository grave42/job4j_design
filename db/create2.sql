create table users(
    id serial primary key,
    name varchar(255)
);

create table roles(
    id serial primary key,
    name varchar(255),
    user_id int references users(id)
);

create table rules(
 	id serial primary key,
 	name varchar(255)
);

create table roles_rules(
 	id serial primary key,
	role_id int references roles(id),
	rule_id int references rules(id)
);

create table items(
    id serial primary key,
	serial int,
    name int,
    user_id int references users(id)
);

create table comments(
    id serial primary key,
    name varchar(255),
    item_id int references items(id) unique
);

create table attachs(
    id serial primary key,
    name varchar(255),
    item_id int references items(id) unique
);

create table categories(
    id serial primary key,
    name varchar(255),
    item_id int references items(id)
);

create table states(
    id serial primary key,
    name varchar(255),
    item_id int references items(id)
);