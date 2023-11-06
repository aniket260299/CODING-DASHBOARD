create table users(
username varchar_ignorecase(50) not null primary key,
password varchar_ignorecase(500) not null,
enabled boolean not null
);

create table authorities (
username varchar_ignorecase(50) not null,
authority varchar_ignorecase(50) not null,
constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username,authority);

--create TABLE IF NOT EXISTS coding_dashboard (
--    id bigint auto_increment PRIMARY KEY,
--    title TEXT,
--    solution LONGTEXT,
--    hint TEXT,
--    notes TEXT,
--    link TEXT,
--    difficulty INT,
--    tags TEXT,
--    date_created TIMESTAMP,
--    date_updated TIMESTAMP,
--    username varchar(100)
--);

create TABLE IF NOT EXISTS coding_dashboard (
    id bigint auto_increment PRIMARY KEY,
    title varchar(1000),
    solution varchar(1000000000),
    hint varchar(1000000000),
    notes varchar(1000000000),
    link varchar(1000),
    difficulty INT,
    tags varchar(1000),
    date_created TIMESTAMP,
    date_updated TIMESTAMP,
    username varchar(100)
);