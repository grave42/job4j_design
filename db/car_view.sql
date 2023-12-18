select c.id, c.name as car_name, cb.name as body_name, 
ce.name as engine_name, ct.name as transmission_name
from cars c
left join car_bodies cb on c.body_id = cb.id
left join car_engines ce on c.engine_id = ce.id
left join car_transmissions ct on c.engine_id = ct.id
where c.name like 'Kia%' or c.name like 'Toyota%'
and cb.name = 'седан'

create view kia_toyota_filter 
	as select c.id, c.name as car_name, cb.name as body_name, 
ce.name as engine_name, ct.name as transmission_name
from cars c
left join car_bodies cb on c.body_id = cb.id
left join car_engines ce on c.engine_id = ce.id
left join car_transmissions ct on c.engine_id = ct.id
where c.name like 'Kia%' or c.name like 'Toyota%'
and cb.name = 'седан'

select * from kia_toyota_filter

