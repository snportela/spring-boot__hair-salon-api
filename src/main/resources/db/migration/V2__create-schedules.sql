CREATE TABLE schedules (
    schedule_id uuid DEFAULT gen_random_uuid() NOT NULL,
    start_at TIMESTAMP NOT NULL,
    end_at TIMESTAMP NOT NULL,
    customer_id uuid NOT NULL,

    CONSTRAINT schedule_pk PRIMARY KEY (schedule_id),
    CONSTRAINT schedule_fk FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);