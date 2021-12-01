insert into Department_TBL (DEPARTMENT_ID,DEPARTMENT_HEAD,DEPARTMENT_NAME) values (1,"TESTING","IT");



Hibernate: create table department_tbl (department_id integer not null auto_increment, department_head varchar(255), department_name varchar(255), primary key (department_id)) engine=InnoDB
Hibernate: create table employee_tbl (employee_id integer not null auto_increment, address varchar(255), date_of_birth date, employee_name varchar(255), pan_number varchar(255), department_id integer not null, primary key (employee_id)) engine=InnoDB
Hibernate: alter table employee_tbl add constraint FK61jgqboiybhg5qdjbxepyo5p7 foreign key (department_id) references department_tbl (department_id)


