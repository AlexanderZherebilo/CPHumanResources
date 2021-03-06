create sequence hibernate_sequence start 1 increment 1;

create table user_role (
    user_id int8 not null,
    roles varchar(255)
);

create table usr (
    id int8 not null,
    activation_code varchar(255),
    active boolean not null,
    email varchar(255),
    password varchar(255) not null,
    username varchar(255) not null,
    employee_id int8 not null,
    primary key (id)
);

alter table if exists user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr;

create table employee (
    id int8 not null,
    personnel_number int8 not null,
    retirement_code int8 not null,
    education varchar(255) not null,
    marital_status varchar (255) not null,
    address varchar(255) not null,
    telephone varchar (255) not null,
    photo varchar (255),
    primary key (id)
);

alter table if exists usr
    add constraint usr_employee_fk
    foreign key (employee_id) references employee;

create table vacation (
    number int8,
    employee_id int8 not null,
    type varchar (255),
    start date,
    finish date,
    primary key (number)
);

alter table if exists vacation
    add constraint vacation_employee_fk
    foreign key (employee_id) references employee;

create table passport (
    id int8 not null,
    surname varchar(255) not null,
    realname varchar(255) not null,
    lastname varchar(255) not null,
    gender varchar(255) not null,
    birthday date not null,
    employee_id int8 not null,
    series varchar (2) not null,
    number int8 not null,
    issued_by varchar (255) not null,
    date_of_issue date not null,
    primary key (id)
);

alter table if exists passport
    add constraint passport_employee_fk
    foreign key (employee_id) references employee;

create table salary (
    salary_id int8 not null,
    employee_id int8 not null,
    type varchar (255) not null,
    currency varchar (3) not null,
    value decimal (10, 2) not null,
    start date not null,
    order_number int8 not null,
    date_of_order date not null,
    primary key (salary_id)
);

alter table if exists salary
    add constraint salary_employee_fk
    foreign key (employee_id) references employee;

create table learning (
    id int8 not null,
    employee_id int8 not null,
    institution varchar (255) not null,
    faculty varchar (255) not null,
    form varchar (255) not null,
    speciality varchar(255),
    qualification varchar(255),
    start date not null,
    finish date not null,
    primary key (id)
);

alter table if exists learning
    add constraint learning_employee_fk
    foreign key (employee_id) references employee;

create table family (
    person_id int8 not null,
    employee_id int8 not null,
    relation varchar (255) not null,
    address varchar (255) not null,
    work_place varchar (255) not null,
    surname varchar (255) not null,
    realname varchar (255) not null,
    lastname varchar (255) not null,
    birthday date not null,
    primary key (person_id)
);

alter table if exists family
    add constraint family_employee_fk
    foreign key (employee_id) references employee;

create table department (
    department_id int8 not null,
    realname varchar(255) not null,
    description text not null,
    primary key(department_id)
);

create table position (
    position_id int8 not null,
    realname varchar(255) not null,
    description text not null,
    primary key(position_id)
);