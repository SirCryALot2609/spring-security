create table _user (
                       id integer not null,
                       email varchar(255),
                       firstname varchar(255),
                       lastname varchar(255),
                       password varchar(255),
                       role varchar(255) check (role in ('USER','ADMIN','MANAGER')),
                       primary key (id)
);

create table token (
                       expired boolean not null,
                       id integer not null,
                       revoked boolean not null,
                       user_id integer,
                       token varchar(255) unique,
                       token_type varchar(255) check (token_type in ('BEARER')),
                       primary key (id)
);
