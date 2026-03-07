create table contents (
    id bigint primary key,
    title varchar(100) not null,
    description text,
    view_count bigint not null default 0,
    created_date timestamp default current_timestamp,
    created_by varchar(50) not null,
    last_modified_date timestamp,
    last_modified_by varchar(50)
);

create table users (
	user_id bigint auto_increment primary key,
	user_name varchar(30) not null unique,
	user_password varchar(100) not null,
	user_role varchar(20) not null
)