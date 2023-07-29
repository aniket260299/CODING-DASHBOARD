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

create TABLE IF NOT EXISTS coding_dashboard (
    id bigint auto_increment PRIMARY KEY,
    title VARCHAR(1000),
    solution VARCHAR(500000),
    hint VARCHAR(5000),
    revision_notes VARCHAR(5000),
    link VARCHAR(1000),
    difficulty INT,
    tags VARCHAR(1000),
    date_created TIMESTAMP,
    date_updated TIMESTAMP
);