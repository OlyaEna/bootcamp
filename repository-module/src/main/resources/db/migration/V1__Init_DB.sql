create table roles
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine = InnoDB;

create table users
(
    id         bigint not null auto_increment,
    email      varchar(50),
    name       varchar(20),
    patronymic varchar(40),
    surname    varchar(40),
    role_id    bigint,
    primary key (id)
) engine = InnoDB;

alter table users
    add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles (id);

insert into roles values (1, 'Administrator' );

insert into roles values (2, 'Sale User' );

insert into roles values (3, 'Customer User' );

insert into roles values (4, 'Secure API User' );

insert into users values (1, 'olya@mail.ru', 'Olga', 'Nikolaevna', 'Ena', 1 );

insert into users values (2, 'inna@mail.ru', 'Inna', 'Vladimirovna', 'Borisenko', 2 );

insert into users values (3, 'vitaly@mail.ru', 'Vitaly', 'Tadeushevich', 'Rodevich', 3 );

insert into users values (4, 'katya@mail.ru', 'Katherine', 'Nikolaevna', 'Pierce', 4 );