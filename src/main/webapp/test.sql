create table member(
  email     varchar(255) not null,
  auth     int default 0,
  pwd       varchar(20)
);


create table content(
  cno       int not null,
  title     varchar(255) not null,
  comment   text,
  views     int default 0,
  cre_dt    datetime not null default now(),
  afile     varchar(255) not null
);