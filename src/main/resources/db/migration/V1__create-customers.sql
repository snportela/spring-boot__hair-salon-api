CREATE TABLE customers (
   customer_id uuid DEFAULT gen_random_uuid() NOT NULL,
   name varchar(100) NOT NULL,
   email varchar(100) NOT NULL,
   phone varchar(20) NOT NULL,

   CONSTRAINT customers_pk PRIMARY KEY (customer_id),
   CONSTRAINT customers_unique UNIQUE (email)
);