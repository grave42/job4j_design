CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

BEGIN;
INSERT INTO company (id, name) VALUES (1, 'Company A');
INSERT INTO company (id, name) VALUES (2, 'Company B');
COMMIT;

BEGIN;
INSERT INTO person (id, name, company_id) VALUES (1, 'Alice', 1);
INSERT INTO person (id, name, company_id) VALUES (2, 'Bob', 2);
INSERT INTO person (id, name, company_id) VALUES (3, 'Charlie', 1);
INSERT INTO person (id, name, company_id) VALUES (4, 'David', 2);
INSERT INTO person (id, name, company_id) VALUES (5, 'Eve', 1);
INSERT INTO person (id, name, company_id) VALUES (6, 'Frank', 2);
INSERT INTO person (id, name, company_id) VALUES (7, 'Grace', 1);
INSERT INTO person (id, name, company_id) VALUES (8, 'Harry', 2);
INSERT INTO person (id, name, company_id) VALUES (9, 'Ivy', 1);
INSERT INTO person (id, name, company_id) VALUES (10, 'Jack', 2);
INSERT INTO person (id, name, company_id) VALUES (11, 'Ivan', 2);
INSERT INTO person (id, name, company_id) VALUES (12, 'Kate', 2);
COMMIT;

SELECT p.name, c.name
FROM person p
JOIN company c ON p.company_id = c.id;

SELECT c.name AS company_name, COUNT(*) AS people_count
FROM company c
JOIN person p ON c.id = p.company_id
GROUP BY c.id, c.name
HAVING COUNT(*) = (
    SELECT COUNT(*)
    FROM person
    GROUP BY company_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
);