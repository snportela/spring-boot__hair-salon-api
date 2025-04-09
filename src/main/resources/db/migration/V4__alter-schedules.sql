ALTER TABLE schedules
    ADD COLUMN employee_id uuid,
    ADD CONSTRAINT schedule_employee_fk
    FOREIGN KEY (employee_id) REFERENCES employees (employee_id)