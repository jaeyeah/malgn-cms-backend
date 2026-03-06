create table contents (
    id bigint primary key,
    title varchar(100) not null,
    description text,
    view_count bigint not null default 0,
    created_date timestamp,
    created_by varchar(50) not null,
    last_modified_date timestamp,
    last_modified_by varchar(50)
);