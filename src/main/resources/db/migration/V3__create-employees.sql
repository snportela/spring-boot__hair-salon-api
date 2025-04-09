CREATE TABLE employees (
    employee_id uuid DEFAULT gen_random_uuid() NOT NULL,
    name varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    phone varchar(20) NOT NULL,
    role varchar(100) NOT NULL,

   CONSTRAINT employees_pk PRIMARY KEY (employee_id),
   CONSTRAINT employees_unique UNIQUE (email)
);