create schema carry;
use carry;

create table user(
    idx int(8) primary key not null auto_increment,
    identity varchar(128) unique NOT NULL,
    password varchar(256) NOT NULL
);
create table image(
    idx int(8) primary key not null auto_increment,
    path varchar(128) not null,
    size int(4)
);
create table club(
    idx int(8) primary key not null auto_increment,
    user_idx int(8) not null,
    logo int(8),
    name varchar(256) NOT NULL,
    FOREIGN KEY (user_idx)
    REFERENCES user(idx) ON UPDATE CASCADE,
    FOREIGN KEY (logo)
    REFERENCES image(idx) ON UPDATE CASCADE
);
create table introduce(
    idx int(8) primary key not null,
    detail varchar(16384) not null,
    leader varchar(64) not null,
    members INT(4) not null default(0),
    last_time datetime not null,
    FOREIGN KEY (idx)
    REFERENCES club(idx) ON UPDATE CASCADE
);
create table post(
    idx int(8) primary key not null,
    club_idx int(8) not null,
    title varchar(128) not null,
    detail varchar(8192) not null,
    create_time datetime not null,
    FOREIGN KEY (club_idx)
    REFERENCES club(idx) ON UPDATE CASCADE
);