create table tb_patients (
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(11) not null unique,
    street varchar(100) not null,
    number varchar(20) not null ,
    neighborhood varchar(100) not null,
    zip_code varchar(9) not null,
    city varchar(100) not null,
    state varchar(2) not null,
    complement varchar(100) not null,
    active tinyint,

    primary key (id)
);
update tb_patients set active = 1;