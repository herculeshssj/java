create table trainers
(
    id serial,
    name varchar
    (100) not null,
    level SMALLINT not null DEFAULT 1,
    PRIMARY key
    (id)
);

create table pokemon
(
    id serial,
    name varchar
        (20) not null,
    number SMALLINT not null,
    PRIMARY KEY
        (id)
);

create table wild_pokemon
(
    id serial,
    combat_power SMALLINT not null default 0,
    pokemon_id integer not null,
    trainer_id integer,
    PRIMARY key
            (id)
);

alter table wild_pokemon add constraint fk_wild_pokemon_pokemon foreign key (pokemon_id) REFERENCES pokemon (id) on delete cascade;
alter table wild_pokemon add constraint fk_wild_pokemon_trainers FOREIGN key (trainer_id) REFERENCES trainers (id) on delete set null;