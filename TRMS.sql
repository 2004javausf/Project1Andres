truncate table login;

drop table form_employee;

insert into form_employee(form_id, emp_name, emp_last_name, cost_ammount) values(1, 'Andres', 'Aparicio', 450.00);
commit;
create table form_employee(
form_id number (20),
emp_name varchar2(20),
emp_last_name varchar2(20),
location varchar(20),
cost_ammount float(20),
dStart date,
dEnd date,
type_course varchar2(20),
grade number(3),
status varchar(20));

ALTER TABLE form_employee
  ADD (
    CONSTRAINT form_employee_pk PRIMARY KEY (form_id)
  );

CREATE SEQUENCE form_employee_sequence;

CREATE OR REPLACE TRIGGER form_employee_on_insert
  BEFORE INSERT ON form_employee
  FOR EACH ROW
BEGIN
  SELECT form_employee_sequence.nextval
  INTO :new.form_id
  FROM dual;
END;

create table login(
login_id number (20),
username varchar2(20),
pass_word varchar2(20),
role_name varchar2(20));

ALTER TABLE login
  ADD (
    CONSTRAINT login_pk PRIMARY KEY (login_id)
  );

CREATE SEQUENCE login_sequence;

CREATE OR REPLACE TRIGGER login_on_insert
  BEFORE INSERT ON login
  FOR EACH ROW
BEGIN
  SELECT login_sequence.nextval
  INTO :new.login_id
  FROM dual;
END;

insert into login(username, pass_word) values('user', 'user');
commit;

create table reimbursement(
reimbursement_id number (20),
status varchar2(20),
amount number(20));

ALTER TABLE reimbursement
  ADD (
    CONSTRAINT reimbursement_pk PRIMARY KEY (reimbursement_id)
  );

CREATE SEQUENCE reimbursement_sequence;

CREATE OR REPLACE TRIGGER reimbursement_on_insert
  BEFORE INSERT ON reimbursement
  FOR EACH ROW
BEGIN
  SELECT reimbursement_sequence.nextval
  INTO :new.reimbursement_id
  FROM dual;
END;