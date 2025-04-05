-- db/init.sql

create table public.tasks (
  id bigserial not null,
  title character varying(256) not null,
  content character varying(256),
  comp_f integer default 0 not null,
  pin_f integer default 0 not null,
  primary key (id)
);

insert into tasks(title, content) values ('テスト', 'テスト内容');