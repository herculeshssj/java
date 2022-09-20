create table hero
(
    id serial,
    name varchar(100),
    primary key(id)
);

create table ability
(
    id serial,
    name varchar(100),
    primary key(id)
);

create table hero_abilities
(
    hero_id bigint not null,
    ability_id bigint not null,
    primary key(hero_id, ability_id)
);

alter table hero_abilities add constraint fk_hero_abilities_hero foreign key(hero_id) references hero(id);
alter table hero_abilities add constraint fk_hero_abilities_ability foreign key(ability_id) references ability(id);

create table disaster
(
    id serial,
    title varchar(100),
    location varchar(100),
    time timestamp,
    is_resolved boolean,
    primary key(id)
);

create table disaster_hero
(
    disaster_id bigint not null,
    hero_id bigint not null
);

alter table disaster_hero add constraint fk_disaster_hero_disaster foreign key(disaster_id) references disaster(id);
alter table disaster_hero add constraint fk_disaster_hero_hero foreign key(hero_id) references hero(id);