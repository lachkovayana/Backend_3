create table manufacturer
(
    id   varchar(255) not null
        primary key,
    name varchar(255)
);

alter table manufacturer
    owner to test_java_22_1;

create table cars
(
    id              varchar(255) not null
        primary key,
    car_model       varchar(255),
    release_year    integer,
    manufacturer_id varchar(255)
        constraint manufacturer_id_constraint
            references manufacturer
);

alter table cars
    owner to test_java_22_1;

