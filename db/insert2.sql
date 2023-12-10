insert into users(name) values ('Ivanov');
insert into users(name) values ('Petrov');
insert into users(name) values ('Sidorov');

insert into roles(name) values ('Admin');
insert into roles(name) values ('Operator');
insert into roles(name) values ('Assistant');

insert into rules(name) values ('Packing');
insert into rules(name) values ('Selling');
insert into rules(name) values ('Close item');

insert into roles_rules(role_id, rule_id) values (1, 1);
insert into roles_rules(role_id, rule_id) values (1, 2);
insert into roles_rules(role_id, rule_id) values (1, 3);
insert into roles_rules(role_id, rule_id) values (2, 1);
insert into roles_rules(role_id, rule_id) values (2, 2);
insert into roles_rules(role_id, rule_id) values (3, 3);