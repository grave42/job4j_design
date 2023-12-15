CREATE TABLE departments (
    department_id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO departments (name) VALUES
('HR'),
('Finance'),
('Marketing'),
('IT');

CREATE TABLE employees (
    employee_id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

INSERT INTO employees (name, department_id) VALUES
('Barkov', 1),
('Makienko', 1),
('Kapitonov', 2),
('Shaiterov', 4),
('Kucherov', 4);

SELECT * from employees e left join departments d on e.department_id = d.department_id

SELECT * from employees e right join departments d on e.department_id = d.department_id

SELECT * from employees e full join departments d on e.department_id = d.department_id

SELECT * from employees e cross join departments d

SELECT d.name from departments d left join employees e on d.department_id = e.department_id
WHERE e.employee_id is null;

SELECT e.name, d.name from employees e left join departments d on e.department_id = d.department_id

SELECT e.name, d.name from departments d right join employees e on d.department_id = e.department_id

CREATE TABLE teens (
    name VARCHAR(255) NOT NULL,
    gender VARCHAR(10) NOT NULL
);

INSERT INTO teens (name, gender) VALUES
('Ira', 'female'),
('Vova', 'male'),
('Gena', 'male'),
('Diana', 'female');

SELECT t1.name, t1.gender, t2.name, t2.gender
FROM teens t1
CROSS JOIN teens t2
WHERE t1.gender <> t2.gender;